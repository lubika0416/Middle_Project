package classes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import comm.service.FileServiceImpl;
import comm.service.IFileService;
import vo.ClassesVO;
import vo.FileVO;
import vo.ProducerVO;

@WebServlet("/producer/classmanagement.do")
public class ManagementController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String proId = ((ProducerVO)req.getSession().getAttribute("loginInfo")).getProId();
		
		IClassesService clsService = ClassesServiceImpl.getInstance();
		
		IFileService fileService = FileServiceImpl.getInstance();
		
		List<ClassesVO> clsList = clsService.getClassesList(proId);
		
		List<List<FileVO>> clsFileList = new ArrayList<List<FileVO>>(); 
		
		for (int i = 0; i < clsList.size(); i++) {
			clsFileList.add(fileService.getClassFileList(clsList.get(i).getClsId()));
		}
		
		req.getSession().setAttribute("clsFileList", clsFileList);
		
		req.getSession().setAttribute("clsList", clsList);
		
		req.getRequestDispatcher("/WEB-INF/views/producer/classManagement.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}