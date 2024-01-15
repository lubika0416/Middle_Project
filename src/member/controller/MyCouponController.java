package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coupon.dao.CouponDao;
import vo.CouponVO;
import vo.MemberVO;

@WebServlet("/member/myCoupon.do")
public class MyCouponController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberVO mv = (MemberVO)req.getSession().getAttribute("loginInfo");
		
		String memId = mv.getMemId();
		
		CouponDao dao = new CouponDao();
		
		List<CouponVO> cplist = null;
		
		cplist = dao.getCouponList(memId);
		
		req.setAttribute("cplist", cplist);
		
		req.getRequestDispatcher("/WEB-INF/views/member/myCoupon.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
