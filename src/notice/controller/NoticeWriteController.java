package notice.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.service.FileServiceImpl;
import comm.service.IFileService;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import vo.FileVO;
import vo.NoticeVO;

@MultipartConfig
@WebServlet("/admin/noticeWrite.do")
public class NoticeWriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher
		("/WEB-INF/views/admin/noticeWriteAdmin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String noticeTitle = req.getParameter("noticeTitle");
		String noticeContent = req.getParameter("noticeContent");
		
	
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		
		//파일을 위한 코드
		IFileService fileService = FileServiceImpl.getInstance();
		FileVO fileVO = null;
		
		try {
			fileVO = fileService.saveAtchFileList(req.getParts());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		NoticeVO nv = new NoticeVO(noticeTitle, noticeContent);
		
		//파일이 첨부되었으면 파일넣기
		if(fileVO != null) {
			nv.setFileId(fileVO.getFileId());
		}
		int cnt = noticeService.addNotice(nv);
		
		//결과값 세팅
		if (cnt > 0) req.setAttribute("result", true);
		else req.setAttribute("result", false);
		
//		req.getRequestDispatcher
//		("/WEB-INF/views/admin/noticeBoard.jsp").forward(req, resp);
		
		resp.sendRedirect("noticeBoard.do");
	}
}
