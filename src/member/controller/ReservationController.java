package member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import classes.service.IScheduleService;
import classes.service.ScheduleServiceImpl;
import comm.service.CouponServiceImpl;
import comm.service.ICouponService;
import member.service.IReservationService;
import member.service.ReservationServiceImpl;
import vo.ClassesVO;
import vo.CouponVO;
import vo.MemberVO;
import vo.ReservationVO;


@WebServlet("/reservation.do")
public class ReservationController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String resDate = req.getParameter("resDate");
		String resTime = req.getParameter("resTime");
		int pCnt = Integer.parseInt(req.getParameter("pCnt").trim());
		String resPrice = req.getParameter("resPrice");
		String clsId = req.getParameter("clsId");
		String cssId = req.getParameter("cssId");
		
		IClassesService clsService = ClassesServiceImpl.getInstance();
		
		ClassesVO cv = clsService.getProId(clsId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pCnt", pCnt);
		map.put("resTime", resTime);
		map.put("resDate", resDate);
		map.put("resPrice", resPrice);
		map.put("cssId", cssId);
		
		ICouponService cpService = CouponServiceImpl.getInstance();
		MemberVO mv = (MemberVO)req.getSession().getAttribute("loginInfo");
		
		mv.setFormBirth(mv.getMemBirth());
		mv.getFormBirth();
		
		List<CouponVO> cpList = cpService.getCouponList(mv.getMemId());
		
		req.setAttribute("map", map);
		
		req.setAttribute("cv", cv);
		
		req.setAttribute("cpList", cpList);
		
		req.getRequestDispatcher("/WEB-INF/views/common/payment.jsp").forward(req, resp);
		
	}

	
}
