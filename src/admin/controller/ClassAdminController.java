package admin.controller;

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


@WebServlet("/admin/classAdmin.do")
public class ClassAdminController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IClassesService clsService = ClassesServiceImpl.getInstance();
		
		List<ClassesVO> clsList = clsService.selectAll();
		
		req.setAttribute("clsList", clsList);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/Class/classAdmin.jsp").forward(req, resp);
		
	}
}
