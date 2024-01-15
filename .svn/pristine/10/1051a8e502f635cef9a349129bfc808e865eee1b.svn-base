package producer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import classes.service.IScheduleService;
import classes.service.ScheduleServiceImpl;
import member.service.IReservationService;
import member.service.MemberServiceImpl;
import member.service.ReservationServiceImpl;
import vo.ClassScheduleVO;
import vo.ReservationVO;


@WebServlet("/producer/reservation.do")
public class ReservationController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/x-json; charset=UTF-8");
		
		String proId = req.getParameter("proId");
		
		System.out.println(proId);
		
		IReservationService resService = ReservationServiceImpl.getInstance();
		// 사업자의 예약리스트
		List<ReservationVO> resList = resService.getResList(proId);
		
		IScheduleService scdService = ScheduleServiceImpl.getInstance();
		
		List<ClassScheduleVO> scdList = new ArrayList<ClassScheduleVO>();
		
		for (int i = 0; i < resList.size(); i++) {
			ReservationVO res = resList.get(i);
			
			ClassScheduleVO scd = scdService.getSchedule(res.getCssId());
			scd.setFormatDate(scd.formatDate2(scd.getCssDate()));
			res.setMemName(MemberServiceImpl.getInstance().getName(res.getMemId()));
			
			IClassesService clsService = ClassesServiceImpl.getInstance();
			
			res.setClsName(clsService.getClasses(scd.getClsId()).getClsName());
			scdList.add(scd);
			resList.set(i, res);
		}
		
		
		JSONObject jObj = new JSONObject();
		
		ObjectMapper mapper = new ObjectMapper();
		
		jObj.put("scdList", mapper.writeValueAsString(scdList));
		jObj.put("resList", mapper.writeValueAsString(resList));
		
		resp.getWriter().print(jObj);
		
	}
	
}
