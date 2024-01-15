package classes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import vo.ClassesVO;
import vo.ProducerVO;

@WebServlet("/producer/deleteclass.do")
public class DeleteClassController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String clsId = req.getParameter("clsId");
		
		System.out.println(clsId);
		
		IClassesService clsService = ClassesServiceImpl.getInstance();
		
		int cnt = clsService.removeClasses(clsId);
		
		if (cnt > 0) {
			
			req.setAttribute("deleteResult", true);
			// 세션의 clsList 초기화
			List<ClassesVO> clsList = clsService.getClassesList(((ProducerVO)req.getSession().getAttribute("loginInfo")).getProId());
			req.getSession().setAttribute("clsList", clsList);
		}
		
		else req.setAttribute("deleteResult", false);
		
		req.getRequestDispatcher("classmanagement.do").forward(req, resp);
		
	}
	
}
