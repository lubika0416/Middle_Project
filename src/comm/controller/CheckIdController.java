package comm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import member.service.MemberServiceImpl;
import producer.service.ProducerServiceImpl;

@WebServlet("/checkid.do")
public class CheckIdController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		boolean checkMem = MemberServiceImpl.getInstance().checkMember(id);
		boolean checkPro = ProducerServiceImpl.getInstance().checkProducer(id);
		
		String result = checkMem == false && checkPro == false ? "true" : "false";
		
		JSONObject jObj = new JSONObject();
		
		jObj.put("result", result);
		
		resp.getWriter().print(jObj);
		
	}
	
}
