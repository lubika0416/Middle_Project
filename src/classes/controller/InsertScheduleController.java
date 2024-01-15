package classes.controller;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import classes.service.IScheduleService;
import classes.service.ScheduleServiceImpl;
import vo.ClassScheduleVO;
import vo.TimeVO;

@WebServlet("/class/insertschedule.do")
public class InsertScheduleController extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/x-json; charset=UTF-8");
		
		String startDay = req.getParameter("startDay");
		String endDay = req.getParameter("endDay");
		String checkedDay = req.getParameter("checkedDay");
		String dateValues = req.getParameter("dateValues");
		System.out.println(dateValues);
		int mxPs = Integer.parseInt(req.getParameter("maxPerson"));
		String clsId = req.getParameter("clsId");
		
		// [a,b,c,d] String 을 list로 변환
		JSONParser parser = new JSONParser();
		List<String> dayList = new ArrayList<String>();
		try {
			dayList = (JSONArray)parser.parse(checkedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// [{a:a,b:b},{a:a,b:b}] String을 list로 변환
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String>[] parsedData = mapper.readValue(dateValues, Map[].class);
		
		List<TimeVO> timeList = new ArrayList<TimeVO>();
		
		for (Map<String,String> map : parsedData) {
			System.out.println(map.get("startTime"));
			System.out.println(map.get("endTime"));
		}
		
		for (Map<String,String> map : parsedData) {
			// 9:00 PM 자르기
			String[] st = map.get("startTime").split(" ");
			if (st[1].equals("AM")) {
				String[] split = st[0].split(":");
				if (split[0].length() < 2) { // 9:00 시간이 1자리 수라면
					map.put("startTime", "0"+st[0]);
				} else {
					map.put("startTime", st[0]);
				}
			} else {
				// 9:00 자르기
				String[] split = st[0].split(":");
				String start = "";
				if (split[0].equals("12")) {
					map.put("startTime", st[0]);
				} else {
					int sT = Integer.parseInt(split[0]) + 12;
					start = sT + ":" + split[1];
					map.put("startTime", start);
				}
			}
			
			String[] et = map.get("endTime").split(" ");
			if (et[1].equals("AM")) {
				String[] split = et[0].split(":");
				if (split[0].length() < 2) {
					map.put("endTime", "0"+et[0]);
				} else {
					map.put("endTime", et[0]);
				}
			} else {
				// 9:00 자르기
				String[] split = et[0].split(":");
				String start = "";
				if (split[0].equals("12")) {
					map.put("endTime", et[0]);
				} else {
					int eT = Integer.parseInt(split[0]) + 12;
					start = eT + ":" + split[1];
					map.put("endTime", start);
				}
			}
			
			
			timeList.add(new TimeVO(map.get("startTime"), map.get("endTime")));
		}
		
		// 요일을 날짜로 변환
		LocalDate startDate = LocalDate.parse(startDay);
		LocalDate endDate = LocalDate.parse(endDay);
		
		List<DayOfWeek> targetDayofWeek = new ArrayList<DayOfWeek>();
		
		for (String day : dayList) {
			if (day.equals("월")) targetDayofWeek.add(DayOfWeek.MONDAY);
			else if (day.equals("화")) targetDayofWeek.add(DayOfWeek.TUESDAY);
			else if (day.equals("수")) targetDayofWeek.add(DayOfWeek.WEDNESDAY);
			else if (day.equals("목")) targetDayofWeek.add(DayOfWeek.THURSDAY);
			else if (day.equals("금")) targetDayofWeek.add(DayOfWeek.FRIDAY);
			else if (day.equals("토")) targetDayofWeek.add(DayOfWeek.SATURDAY);
			else if (day.equals("일")) targetDayofWeek.add(DayOfWeek.SUNDAY);
		}
		
		
		// 해당 날짜를 담은 list
		Set<Date> datesOnTargetDays = new HashSet<Date>();
		
		LocalDate currentDate = startDate;
		
		while(!currentDate.isAfter(endDate)) {
			if (targetDayofWeek.contains(currentDate.getDayOfWeek())) {
				datesOnTargetDays.add(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			}
			currentDate = currentDate.plusDays(1);
		}
		
		List<Date> datesList = new ArrayList<Date>(datesOnTargetDays);
		// insert 할 schedule 들을 담은 list
		List<ClassScheduleVO> scdList = new ArrayList<ClassScheduleVO>();
		
		for (TimeVO tv : timeList) {
			System.out.println(tv);
		}
		
		for (Date d : datesList) {
			for (TimeVO tv : timeList) {
				scdList.add(new ClassScheduleVO(d, tv.getStartTime(), tv.getEndTime(), mxPs, clsId));
			}
		}
		
		for (ClassScheduleVO classScheduleVO : scdList) {
			System.out.println(classScheduleVO);
		}
		
		
		IScheduleService scdService = ScheduleServiceImpl.getInstance();
		
		int cnt = scdService.insertSchedule(scdList);
		
		JSONObject jObj = new JSONObject();
		
		if (cnt > 0) jObj.put("result", true);
		else jObj.put("result", false);
		
		resp.getWriter().print(jObj);
		
		
	}
}
