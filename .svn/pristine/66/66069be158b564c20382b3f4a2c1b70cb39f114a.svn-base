package review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import comm.service.FileServiceImpl;
import comm.service.IFileService;
import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import vo.ClassesVO;
import vo.FileVO;
import vo.ReviewVO;

@WebServlet("/admin/reviewAdmin.do")
public class AdminReviewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
	
		
		IReviewService reviewService = ReviewServiceImpl.getInstance();
		
		List<ReviewVO> rlist = reviewService.selectAll(); 
		IFileService fileService = FileServiceImpl.getInstance();
		List<List<FileVO>> fileList = new ArrayList<List<FileVO>>();
		for(ReviewVO rv : rlist) {
			rv.setFormDt(rv.getReviewRegdt());
			rv.setClsName(reviewService.getClsName(rv.getClsId()));
			List<FileVO> file = fileService.getFiles(rv.getFileId());
			fileList.add(file);
		}

		IClassesService classesService = ClassesServiceImpl.getInstance();
		
		List<ClassesVO> clist = classesService.selectAll();

		req.setAttribute("rFileList", fileList);
		req.setAttribute("rlist", rlist);
		req.setAttribute("clist", clist);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/reviewAdmin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}