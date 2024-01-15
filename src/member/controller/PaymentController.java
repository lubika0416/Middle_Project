package member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import classes.service.IScheduleService;
import classes.service.ScheduleServiceImpl;
import comm.service.CouponServiceImpl;
import comm.service.ICouponService;
import member.service.IPaymentService;
import member.service.IReservationService;
import member.service.PaymentServiceImpl;
import member.service.ReservationServiceImpl;
import vo.MemberVO;
import vo.PaymentVO;
import vo.ReservationVO;

@WebServlet("/payment.do")
public class PaymentController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/x-json; charset=UTF-8");
		
		int pCnt = Integer.parseInt(req.getParameter("pCnt").trim());
		
		String cssId = req.getParameter("cssId");
		
		String payPrice_ = req.getParameter("price");
		
		String finalPrice_ = req.getParameter("fPrice");
		
		String couponNo_ = req.getParameter("cpNo");
		
		int couponNo = 0;
		
		if (couponNo_ != null && !couponNo_.equals("")) {
			
			couponNo = Integer.parseInt(req.getParameter("cpNo"));
		}
		
		
		String clsId = req.getParameter("clsId");
		System.out.println(clsId);
		int payPrice = Integer.parseInt(payPrice_.substring(1).replace(",", ""));
		
		int finalPrice = Integer.parseInt(finalPrice_.substring(1).replace(",", ""));
		
		MemberVO mv = (MemberVO)req.getSession().getAttribute("loginInfo");
		
		IReservationService resService = ReservationServiceImpl.getInstance();
		
		// 예약하기
		int cnt = resService.insertReservation(new ReservationVO(pCnt, cssId, mv.getMemId()));
		
		// 예약 성공시
		if (cnt > 0) {
			IScheduleService scdService = ScheduleServiceImpl.getInstance();
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("resCnt", pCnt);
			map.put("cssId", cssId);
			
			// 해당 일정 예약인원 업데이트
			cnt = scdService.updateCnt(map);
			
			// 업데이트 성공시
			if (cnt > 0) {
				
				int resNo = resService.getReservationNo(mv.getMemId(), cssId);
				
				PaymentVO pv = new PaymentVO(payPrice, finalPrice, resNo);
				
				if (payPrice != finalPrice) pv.setCouponNo(couponNo); 
				
				IPaymentService payService = PaymentServiceImpl.getInstance();
				
				cnt = payService.insertPay(pv);
				boolean resResult = false;
				// 결제 성공시
				if (cnt > 0) {
					ICouponService cpService = CouponServiceImpl.getInstance();
					resResult = cpService.usedCoupon(couponNo);
				}
				
				JSONObject jObj = new JSONObject();
				jObj.put("resResult", resResult);
				
				resp.getWriter().print(jObj);
			}
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
}
