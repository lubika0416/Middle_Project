package aqna.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import aqna.dao.AQNADaoImpl;
import aqna.dao.IAQNADao;
import aqna.service.AQNAServiceImpl;
import aqna.service.IAQNAService;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import vo.AQNAVO;
import vo.NoticeVO;

@WebServlet("/admin/QNABoard.do")
public class AQNABoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IAQNAService service = AQNAServiceImpl.getInstance();
		
		List<AQNAVO> list = service.selectAllQna();
		
		for(AQNAVO aqvo : list) {
			aqvo.setFormAqnaRegdt(aqvo.getAqnaRegdt());
		}

		req.setAttribute("list", list);
		
		req.getRequestDispatcher
		("/WEB-INF/views/admin/AQNA/AQNAAdmin.jsp").forward(req, resp);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}