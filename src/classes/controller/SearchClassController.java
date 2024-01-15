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

@WebServlet("/classSearch.do")
public class SearchClassController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/common/mainheader.jsp").forward(req, resp);;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String clsName = req.getParameter("clsName");
		IClassesService clsService = ClassesServiceImpl.getInstance();
		IFileService fileService = FileServiceImpl.getInstance();
		List<ClassesVO> clsSearchList = clsService.getClassList(clsName);
		
		List<List<FileVO>> fileListt = new ArrayList<List<FileVO>>();
		for(int i = 0; i < clsSearchList.size(); i++) {
			List<FileVO> clsfilevo = fileService.getClassFileList(clsSearchList.get(i).getClsId());
			fileListt.add(clsfilevo);
		}
		req.setAttribute("fileListt", fileListt);
		System.out.println(fileListt);
		req.setAttribute("clsSearchList", clsSearchList);
		System.out.println(clsSearchList);
		
	
		req.getRequestDispatcher("/WEB-INF/views/common/searchClassTest.jsp").forward(req, resp);
		
	}
}

