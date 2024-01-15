package reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IReservationService;
import member.service.ReservationServiceImpl;
import vo.ReservationVO;

public class ProducerReservationBoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IReservationService reserService = ReservationServiceImpl.getInstance();
		String cssId = req.getParameter("cssId");
	}
}
