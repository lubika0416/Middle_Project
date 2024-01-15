package classes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import comm.service.FileServiceImpl;
import comm.service.IFileService;
import oracle.net.aso.l;
import producer.service.IProducerService;
import producer.service.ProducerServiceImpl;
import vo.CategoryVO;
import vo.ClassesVO;
import vo.FileVO;
import vo.ProducerVO;

@MultipartConfig
@WebServlet("/producer/updateclass.do")
public class UpdateClassesController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String clsId = req.getParameter("clsId");
		
		IClassesService clsService = ClassesServiceImpl.getInstance();
		
		ClassesVO cVo = clsService.getClasses(clsId);
		
		req.setAttribute("cVo", cVo);
		
		req.getRequestDispatcher("/WEB-INF/views/producer/classUpdate.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String clsId = req.getParameter("clsId");
		String clsName = req.getParameter("clsTitle");
		int clsPrice = Integer.parseInt(req.getParameter("clsPrice")); //
		String clsDesc = req.getParameter("clsDesc");
		int clsTime = Integer.parseInt(req.getParameter("clsTime")); //
		int clsMxps = Integer.parseInt(req.getParameter("clsMxPs")); //
		
		IFileService fileService = FileServiceImpl.getInstance();
		
		FileVO fv = null;
		
		try {
			fv = fileService.saveAtchFileList(req.getParts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		IClassesService clsService = ClassesServiceImpl.getInstance();
		ClassesVO cVo = new ClassesVO(clsName, clsPrice, clsDesc, clsTime, clsMxps);
		cVo.setClsId(clsId);
		
		if(fv == null) {
			int fileId = clsService.getFileId(clsId);
			cVo.setFileId(fileId);
		}else {
			cVo.setFileId(fv.getFileId());
		}
		int cnt = clsService.modifyClasses(cVo);
		
		HttpSession session = req.getSession();
		
		
		//resp.sendRedirect(req.getContextPath() + "/producer/classmanagement.do");
		resp.sendRedirect("classmanagement.do?clsId=");
	}
}



























