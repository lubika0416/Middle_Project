package comm.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import admin.service.AdminServiceImpl;
import admin.service.IAdminService;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import producer.service.IProducerService;
import producer.service.ProducerServiceImpl;
import vo.AdminVO;
import vo.MemberVO;
import vo.ProducerVO;


@WebServlet("/login.do")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/common/login.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/x-json; charset=UTF-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		IMemberService memService = MemberServiceImpl.getInstance();
		IProducerService proService = ProducerServiceImpl.getInstance();
		IAdminService adService = AdminServiceImpl.getInstance();
		
		boolean result = false;
		// 1 => 회원	       2 => 사업자             3 => 관리자
		int type = 0;
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jObj = new JSONObject();
		
		if (memService.checkMember(id, pw)) {
			result = true;
			MemberVO mv = memService.getMember(id);
			// 세션에 객체 담기
			req.getSession().setAttribute("loginInfo", mv);
			// 비동기에서 vo접근을 위한 mapper
			jObj.put("mv", mapper.writeValueAsString(mv));
			type = 1;
			
		} else if (proService.checkProducer(id, pw)) {
			result = true;
			ProducerVO pv = proService.getProducer(id);
			req.getSession().setAttribute("loginInfo", pv);
			jObj.put("pv", mapper.writeValueAsString(pv));
			type = 2;
			
		} else if (adService.checkAdmin(id, pw)) {
			result = true;
			AdminVO av = adService.getAdmin(id);
			req.getSession().setAttribute("loginInfo", av);
			jObj.put("av", mapper.writeValueAsString(av));
			type = 3;
		}
		
		jObj.put("result", result);
		jObj.put("type", type);
		
		resp.getWriter().print(jObj);
		
		
	
	}
	
	
}
