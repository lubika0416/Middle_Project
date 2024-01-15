package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.json.JsonMapper;

import comm.service.FileServiceImpl;
import comm.service.IFileService;
import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import vo.FileVO;
import vo.ReviewVO;

@WebServlet("/member/detailreview.do")
public class DetailReviewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/x-json; charset=UTF-8");
		
		int reviewNo = Integer.parseInt(req.getParameter("reviewNo"));
		
		IReviewService revService = ReviewServiceImpl.getInstance();
		
		ReviewVO reviewVO = revService.getReview(reviewNo);
		
		reviewVO.setFormDt(reviewVO.getReviewRegdt());
		
		JSONObject jObj = new JSONObject();
		
		JsonMapper mapper = new JsonMapper();
		
		IFileService fileService = FileServiceImpl.getInstance();
		
		List<FileVO> fileList = fileService.getFiles(reviewVO.getFileId());
		
		jObj.put("rv", mapper.writeValueAsString(reviewVO));
		jObj.put("flist", mapper.writeValueAsString(fileList));
		
		resp.getWriter().print(jObj);
	}
	
}
