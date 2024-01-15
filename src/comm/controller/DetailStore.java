package comm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import comm.service.FileServiceImpl;
import comm.service.IFileService;
import pqna.service.IPQNAService;
import pqna.service.PQNAServiceImpl;
import producer.service.FeedServiceImpl;
import producer.service.IFeedService;
import producer.service.IProducerService;
import producer.service.ProducerServiceImpl;
import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import vo.ClassesVO;
import vo.FavoriteVO;
import vo.FeedVO;
import vo.FileVO;
import vo.MemberVO;
import vo.PQNAVO;
import vo.ProducerVO;
import vo.ReviewVO;

@WebServlet("/detailstore.do")
public class DetailStore extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String proId = req.getParameter("proId");
		
		IProducerService producerService = ProducerServiceImpl.getInstance();
		IFileService fileService = FileServiceImpl.getInstance();
		IFeedService feedService = FeedServiceImpl.getInstance();
		IClassesService classService = ClassesServiceImpl.getInstance();
		IReviewService reviewService = ReviewServiceImpl.getInstance();
		

		List<FileVO> storeFileList = fileService.getProFileList(proId);
		ProducerVO pvo = producerService.getProducer(proId);

		List<FeedVO> feedList = feedService.getFeedList(proId);
		List<List<FileVO>> feedFileList = new ArrayList<List<FileVO>>();

		List<ClassesVO> classList = classService.getClassesList(proId);
		List<List<FileVO>> clsFileList = new ArrayList<List<FileVO>>();
	
		List<FavoriteVO> favoriteList = classService.getFavoriteList(pvo.getProId());
		
		
		List<ReviewVO> reviewList = reviewService.getReviewList(pvo.getProId());
		
		List<List<FileVO>> reviewFileList = new ArrayList<>();
		for (int i = 0; i < reviewList.size(); i++) {
			ReviewVO rv = reviewList.get(i);
			rv.setWriter(reviewService.getMemName(rv.getReviewNo()));
			List<FileVO> files = null;
			if (rv.getFileId() != -1) {
				files = fileService.getFiles(rv.getFileId());
			}
			reviewFileList.add(files);
			rv.setClsName(reviewService.getClsName(rv.getClsId()));
			rv.setFormDt(rv.getReviewRegdt());
		}

		for (int i = 0; i < feedList.size(); i++) {
			FeedVO fv = feedList.get(i);
			List<FileVO> feedFilevo = fileService.getFeedFileList(fv.getFeedNo());
			fv.setFormDate(fv.getFeedRegdt());

			feedFileList.add(feedFilevo);
			feedList.set(i, fv);
		}

		for (int i = 0; i < classList.size(); i++) {
			ClassesVO cvo = classList.get(i);
			List<FileVO> clsFilevo = fileService.getClassFileList(classList.get(i).getClsId());
			Map<String, Object> map = reviewService.getClassRating(cvo.getClsId());
			cvo.setReviewCnt(Integer.parseInt(String.valueOf(map.get("CNT"))));
			cvo.setRatingAvg(Double.parseDouble(String.valueOf(map.get("AVG"))));
			
			clsFileList.add(clsFilevo);
			classList.set(i, cvo);
		}
		
		Map<String, Object> map = producerService.getUsedInfo(proId);
		
		pvo.setFavNo(Integer.parseInt(String.valueOf(map.get("FAVCNT"))));
		pvo.setReviewNo(Integer.parseInt(String.valueOf(map.get("REVCNT"))));
		pvo.setClsNo(Integer.parseInt(String.valueOf(map.get("CLSCNT"))));
		System.out.println(pvo.getFavNo() + " : " + pvo.getReviewNo() + " : " + pvo.getClsNo());
		
		
		
		req.setAttribute("addr", pvo.getProAddr().split("/")[1]);
		req.setAttribute("storeFileList", storeFileList);
		req.setAttribute("pvo", pvo);
		req.setAttribute("feedFileList", feedFileList);
		req.setAttribute("feedList", feedList);
		req.setAttribute("classList", classList);
		req.setAttribute("clsFileList", clsFileList);
		req.setAttribute("favoriteList", favoriteList);
		req.setAttribute("reviewList", reviewList);
		req.setAttribute("reviewFileList", reviewFileList);

		req.getRequestDispatcher("/WEB-INF/views/common/storePage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pqnaTitle = req.getParameter("pqnaTitle");
		// String clsId = req.getParameter("clsId");
		String pqnaContent = req.getParameter("pqnaContent");
		MemberVO mv = (MemberVO) req.getSession().getAttribute("loginInfo");
		String memId = mv.getMemId();
		String proId = req.getParameter("proId");
		
		IPQNAService pqnaService = PQNAServiceImpl.getInstance();
		PQNAVO pqVO = new PQNAVO(pqnaTitle, pqnaContent);
		pqVO.setMemId(memId);
		pqVO.setProId(proId);
		
		int cnt = pqnaService.createPQNA(pqVO);
		boolean result = false;
		if (cnt > 0) result  = true;
		
		JSONObject jObj = new JSONObject();
		jObj.put("rst", result);
		
		resp.getWriter().print(jObj);
	}
}
