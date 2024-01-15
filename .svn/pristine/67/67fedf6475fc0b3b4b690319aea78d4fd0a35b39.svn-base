package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.json.JsonMapper;

import classes.service.ClassesServiceImpl;
import classes.service.IScheduleService;
import classes.service.ScheduleServiceImpl;
import member.service.IReservationService;
import member.service.PaymentServiceImpl;
import member.service.ReservationServiceImpl;
import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import vo.ClassScheduleVO;
import vo.PaymentVO;
import vo.ReservationVO;

@WebServlet("/myReservation.do")
public class MyReservationDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int resNo = Integer.parseInt(req.getParameter("resNo"));
		
		IReservationService resService = ReservationServiceImpl.getInstance();
		
		ReservationVO rv = resService.getReservation(resNo);
		
		IScheduleService scdService = ScheduleServiceImpl.getInstance();
		
		ClassScheduleVO sv = scdService.getSchedule(rv.getCssId());
		
		rv.setClsName(ClassesServiceImpl.getInstance().getClasses(sv.getClsId()).getClsName());
		
		PaymentVO pv = PaymentServiceImpl.getInstance().getPay(rv.getResNo());
		
		IReviewService reviewService = ReviewServiceImpl.getInstance();
		
		boolean isExist = reviewService.checkReview(resNo);
		
		JSONObject jObj = new JSONObject();
		
		JsonMapper mapper = new JsonMapper();
		
		jObj.put("rv", mapper.writeValueAsString(rv));
		jObj.put("sv", mapper.writeValueAsString(sv));
		jObj.put("pv", mapper.writeValueAsString(pv));
		jObj.put("isExist", isExist);
		
		resp.getWriter().print(jObj);
		
	}
	
	
}
