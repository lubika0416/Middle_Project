package admin.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import producer.service.IProducerService;
import producer.service.ProducerServiceImpl;
import vo.ProducerVO;

@WebServlet("/admin/producerAdminUpdate.do")
public class ProducerAdminUpdateController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//매개변수 설정
		String proId = req.getParameter("proId");//
		String proPw = req.getParameter("proPw");//
		String proName = req.getParameter("proName");//
		String proEmail = req.getParameter("proEmail");//
		String proTel = req.getParameter("proTel");//
		String proStore = req.getParameter("proStore");//
		String proAddr = req.getParameter("proAddr");//
		String proStrTel = req.getParameter("proStrTel");//
		String proRegNo = req.getParameter("proRegNo");//
		String proRegdt = req.getParameter("proRegdt");//
		String proDesc = req.getParameter("proDesc");
		String proPro = req.getParameter("proPro");
		String fileId = req.getParameter("fileId");
		
		//객체생성
		IProducerService service = ProducerServiceImpl.getInstance();
		
		ProducerVO pv = new ProducerVO(proId, proPw, proName, proEmail, proTel, proStore, proAddr, proStrTel, proRegNo, proDesc, proPro);
		
		int cnt = service.modifyProducer(pv);
		
		req.setAttribute("pv", pv);
		
		//결과 반영
		if(cnt > 0) {
			System.out.println("완료");
		}else {
			System.out.println("실패");
		}
		
		resp.sendRedirect(req.getContextPath()+"/admin/producerAdmin.do");
				
		
	}
}
