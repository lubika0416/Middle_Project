package comm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import producer.service.IProducerService;
import producer.service.ProducerServiceImpl;
import util.EmailUtil;
import vo.MemberVO;
import vo.ProducerVO;

@WebServlet("/findaccount.do")
public class FindAccountController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/common/findAccount.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/x-json; charset=UTF-8");
		
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String id = req.getParameter("id");
		IMemberService memService = MemberServiceImpl.getInstance();
		
		IProducerService proService = ProducerServiceImpl.getInstance();
		
		JSONObject jObj = new JSONObject();
		
		MemberVO mv = null;
		ProducerVO pv = null;
		// 아이디 찾기 시
		if (id == null || id == "") {
			
			mv = memService.getMember(name, mail);
			pv = proService.getProducer(name, mail);
			
			if (mv != null) {
				jObj.put("result", mv.getMemId());
			} else if (pv != null) {
				jObj.put("result", pv.getProId());
			} else {
				jObj.put("result", "false");
			}
		// 비밀번호 찾기
		} else {
			
			mv = memService.getMember(name, mail, id);
			pv = proService.getProducer(name, mail, id);
			
			if (mv != null) {
				
				// 임시 비밀번호 전송
				String tempPw = EmailUtil.sendEmail(mv.getMemMail());
				// 임시 비밀번호로 비밀번호 변경
				int cnt = memService.updatePw(mv.getMemId(), tempPw);
				if (cnt > 0) jObj.put("result", "true");
				
			} else if (pv != null) {
				
				String tempPw = EmailUtil.sendEmail(pv.getProEmail());
				
				int cnt = proService.updatePw(pv.getProId(), tempPw);
				if (cnt > 0) jObj.put("result", "true");
			} else {
				jObj.put("result", "false");
			}
			
			
			
		}
		resp.getWriter().print(jObj);
		
	}
	
}
