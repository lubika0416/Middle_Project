package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import producer.service.IProducerService;
import producer.service.ProducerServiceImpl;
import vo.ProducerVO;

@WebServlet("/admin/producerAdmin.do")
public class ProducerAdminController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IProducerService service = ProducerServiceImpl.getInstance();
		
		List<ProducerVO> list = service.selectAll();
		
		for (ProducerVO pv : list) {
			pv.setFormRegdt(pv.getProRegdt());
		}
		
		req.setAttribute("list", list);
		System.out.println(list);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/producerAdmin.jsp").forward(req, resp);
	}
}
