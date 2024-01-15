package producer.controller;

import java.io.IOException;
import java.util.Date;
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
import pqna.service.IPQNAService;
import pqna.service.PQNAServiceImpl;
import producer.service.IProducerService;
import producer.service.ProducerServiceImpl;
import vo.ClassesVO;
import vo.FavoriteVO;
import vo.FileVO;
import vo.PQNAVO;
import vo.ProducerVO;

@WebServlet("/producer/mypage.do")
public class MypageController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		IFileService fileService = FileServiceImpl.getInstance();
		
		Object obj = req.getSession().getAttribute("loginInfo");
		
		String proId = "";
		
		ProducerVO pv = null;
		
		if (obj != null) {
			
			pv = (ProducerVO) obj;
			
			proId = pv.getProId();
			
		}
		
		List<FileVO> fileList = fileService.getProFileList(proId);
		
		req.getSession().setAttribute("proFileList", fileList);
		
		IClassesService clsService = ClassesServiceImpl.getInstance();
		
		List<ClassesVO> clsList = clsService.getClassesList(proId);
		
		IPQNAService pqnaService = PQNAServiceImpl.getInstance();
		List<PQNAVO> pqList = pqnaService.selectAllPQNA(proId);
		List<FavoriteVO> favoriteList = clsService.getFavoriteList(proId);
		if(pqList.size() > 0) {
			for (int i = 0; i < pqList.size(); i++) {
				Date beforeDate = pqList.get(i).getPqnaRegdt();
				pqList.get(i).setDateFormat(beforeDate);
				
			}
		}
		
		IProducerService proService = ProducerServiceImpl.getInstance();
		
		Map<String, Object> map = proService.getUsedInfo(pv.getProId());
		
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		pv.setFavNo(Integer.parseInt(String.valueOf(map.get("FAVCNT"))));
		pv.setReviewNo(Integer.parseInt(String.valueOf(map.get("REVCNT"))));
		pv.setClsNo(Integer.parseInt(String.valueOf(map.get("CLSCNT"))));
		System.out.println(pv.getFavNo() + " : " + pv.getReviewNo() + " : " + pv.getClsNo());
		
		req.getSession().setAttribute("loginInfo", pv);
		
		req.setAttribute("pqList", pqList);
		
		req.getSession().setAttribute("clsList", clsList);
		
		req.getSession().setAttribute("favoriteList", favoriteList);
		
		
		req.getRequestDispatcher("/WEB-INF/views/producer/mypage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
