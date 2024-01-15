package member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.service.CouponServiceImpl;
import comm.service.ICouponService;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.CouponVO;
import vo.MemberVO;

@WebServlet("/member/signup.do")
public class SignUpController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/signup.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memId = req.getParameter("memId");
		String memPw = req.getParameter("memPw");
		String memName = req.getParameter("memName");
		String memMail = req.getParameter("memMail");
		String memGender = req.getParameter("memGender");
		String memTel = req.getParameter("memTel");
		Date memBirth = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			memBirth = sdf.parse(req.getParameter("memBirth"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String memAddr = zip + " " + addr1 + " " + addr2;

		MemberVO mv = new MemberVO(memId, memPw, memName, memMail, memAddr, memBirth, memGender, memTel);

		IMemberService memService = MemberServiceImpl.getInstance();

		int cnt = memService.insertMember(mv);
		
		if (cnt > 0) {
			
			req.setAttribute("result", true);
			// 쿠폰 발급
			ICouponService cpService = CouponServiceImpl.getInstance();
			cpService.issuedCoupon(new CouponVO("회원가입 축하 선물 10% 할인 쿠폰", 10, memId));
		}
		else req.setAttribute("result", false);
		
		req.getRequestDispatcher("/WEB-INF/views/common/login.jsp").forward(req, resp);
		
	}


}
