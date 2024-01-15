package pqna.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pqna.service.IPQNAService;
import pqna.service.PQNAServiceImpl;
import vo.PQNAVO;
import vo.ProducerVO;

@WebServlet("/producer/pqnaBoard.do")
public class PQNABoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProducerVO pv = (ProducerVO) req.getSession().getAttribute("loginInfo");
		String proId = pv.getProId();
		
		IPQNAService pqnaService = PQNAServiceImpl.getInstance();
		List<PQNAVO> list = pqnaService.selectAllPQNA(proId);
		
		if(list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Date beforeDate = list.get(i).getPqnaRegdt();
				list.get(i).setDateFormat(beforeDate);
				
			}
		}
		
		req.setAttribute("list", list);

		
		
		
		req.getRequestDispatcher("/WEB-INF/views/producer/PQNAProducer.jsp").forward(req,resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);;
	}

}
