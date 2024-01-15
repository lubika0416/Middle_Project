package comm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import comm.service.FileServiceImpl;
import comm.service.IFileService;
import producer.service.FeedServiceImpl;
import producer.service.IFeedService;
import producer.service.IProducerService;
import producer.service.ProducerServiceImpl;
import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import vo.ClassesVO;
import vo.FeedVO;
import vo.FileVO;
import vo.ProducerVO;


@WebServlet("/main.do")
public class MainController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext application = req.getServletContext();
		
		List<String> categoryName = new ArrayList<String>();
		categoryName.add("공예"); // 0
		categoryName.add("요리"); // 1
		categoryName.add("미술"); // 2
		categoryName.add("플라워"); // 3
		categoryName.add("뷰티"); // 4
		categoryName.add("체험 및 기타"); // 5
		
		application.setAttribute("categoryName", categoryName);  
		
		
		
		
		IFeedService feedService = FeedServiceImpl.getInstance();
		IClassesService classService = ClassesServiceImpl.getInstance();
		IFileService fileService = FileServiceImpl.getInstance();
		IProducerService proService = ProducerServiceImpl.getInstance();
		
		
		List<FeedVO> feedList = feedService.selectFeed();  //보여질 피드 리스트(랜덤 4개)
		
		List<List<FileVO>> feedFileList = new ArrayList<List<FileVO>>();
		List<ProducerVO> proList = new ArrayList<ProducerVO>();		
		
		List<ClassesVO> hotClassList = new ArrayList<ClassesVO>();
		List<ClassesVO> tempList = classService.descClassList();
		List<List<FileVO>> hotFileList = new ArrayList<List<FileVO>>();
		
		for (int i = 0; i < 4; i++) {
			ClassesVO cv = tempList.get(i);
			
			List<FileVO> clsFileVO = fileService.getClassFileList(cv.getClsId());
			hotFileList.add(clsFileVO);
			
			// 해당 클래스의 리뷰 숫자와 평점 평균을 가져오기
			IReviewService reviewService = ReviewServiceImpl.getInstance();
			System.out.println(cv.getClsId());
			Map<String, Object> map = reviewService.getClassRating(cv.getClsId());
			
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			
			// 클래스객체에 담아주기
			cv.setReviewCnt(Integer.parseInt(String.valueOf(map.get("CNT"))));
			cv.setRatingAvg(Double.parseDouble(String.valueOf(map.get("AVG"))));
			
			System.out.println(cv);
			hotClassList.add(cv);
		}
		
		
		
		List<ClassesVO> classList = classService.selectAll();  //전체 클래스 조회
		List<List<FileVO>> clsFileList = new ArrayList<List<FileVO>>();
		 
		
		for(int i=0; i<feedList.size(); i++) {
			FeedVO fv = feedList.get(i);
			
			List<FileVO> filevo = fileService.getFeedFileList(fv.getFeedNo());
			ProducerVO pvo = proService.getProducer(fv.getProId());
			fv.setFormDate(fv.getFeedRegdt());
			
			feedFileList.add(filevo);
			proList.add(pvo);
		}
		
		for(int i=0; i<classList.size(); i++) {
			ClassesVO cv = classList.get(i);
			
			List<FileVO> clsfilevo = fileService.getClassFileList(cv.getClsId());
			clsFileList.add(clsfilevo);
			
			// 해당 클래스의 리뷰 숫자와 평점 평균을 가져오기
			IReviewService reviewService = ReviewServiceImpl.getInstance();
			System.out.println(cv.getClsId());
			Map<String, Object> map = reviewService.getClassRating(cv.getClsId());
			
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			
			// 클래스객체에 담아주기
			cv.setReviewCnt(Integer.parseInt(String.valueOf(map.get("CNT"))));
			cv.setRatingAvg(Double.parseDouble(String.valueOf(map.get("AVG"))));
			
			System.out.println(cv);
			// 업데이트 한 클래스 객체를 업데이트
			classList.set(i, cv);
			
		}
		
		
		req.setAttribute("feedList", feedList);
		req.setAttribute("feedFileList", feedFileList);
		req.setAttribute("proList", proList);
		
		req.setAttribute("classList", classList);
		req.setAttribute("clsFileList", clsFileList);
		
		req.setAttribute("hotClassList", hotClassList);
		req.setAttribute("hotFileList", hotFileList);
		
		req.getRequestDispatcher("/WEB-INF/views/common/main.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
