package classes.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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

@MultipartConfig
@WebServlet("/producer/create.do")
public class CreateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/producer/classCreate.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String clsName = req.getParameter("clsTitle");
		int clsPrice = Integer.parseInt(req.getParameter("clsPrice"));
		String clsDesc = req.getParameter("clsDesc");
		int clsTime = Integer.parseInt(req.getParameter("clsTime"));
		int cateNo = Integer.parseInt(req.getParameter("cateNo"));
		int maxPerson = Integer.parseInt(req.getParameter("clsMxPs").trim());
		ProducerVO pv = (ProducerVO)req.getSession().getAttribute("loginInfo");
		String proId = pv.getProId();
		
		IFileService fileService = FileServiceImpl.getInstance();
		FileVO fileVO = null;
		
		try {
			fileVO = fileService.saveAtchFileList(req.getParts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		IClassesService clsService = ClassesServiceImpl.getInstance();
		ClassesVO cv = new ClassesVO(clsName, clsPrice, clsDesc, clsTime, cateNo, maxPerson);
		cv.setProId(proId);
		
		if (fileVO != null) cv.setFileId(fileVO.getFileId());
		
		int cnt = clsService.registClasses(cv);
		
		if (cnt > 0) {
			req.setAttribute("createclassresult", true);
		} else {
			req.setAttribute("createclassresult", false);
		}
		
		req.getRequestDispatcher("mypage.do").forward(req, resp);
		
	}
}
























