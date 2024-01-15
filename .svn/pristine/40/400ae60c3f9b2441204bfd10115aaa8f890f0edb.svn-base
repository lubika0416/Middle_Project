package comm.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import classes.service.IScheduleService;
import classes.service.ScheduleServiceImpl;
import comm.service.FileServiceImpl;
import comm.service.IFileService;
import member.service.MemberServiceImpl;
import producer.service.IProducerService;
import producer.service.ProducerServiceImpl;
import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import vo.ClassScheduleVO;
import vo.ClassesVO;
import vo.FavoriteVO;
import vo.FileVO;
import vo.MemberVO;
import vo.ProducerVO;
import vo.ReviewVO;

@WebServlet("/detailclass.do")
public class DetailClass extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String clsId = req.getParameter("clsId");
		
		IClassesService clsService = ClassesServiceImpl.getInstance();
		
		// 해당 클래스 정보
		ClassesVO cv = clsService.getClasses(clsId);
		
		IFileService fileService = FileServiceImpl.getInstance();
		
		// 해당 클래스 사진 정보
		List<FileVO> clsFileList = fileService.getClassFileList(clsId);
		
		IProducerService proService = ProducerServiceImpl.getInstance();
		
		// 해당 클래스의 공방 정보
		ProducerVO pv = proService.getClsPro(clsId);
		
		IScheduleService scdService = ScheduleServiceImpl.getInstance();
		
		// 클래스의 상세 일정이 존재하는 날짜를 담은 리스트
		List<Date> dateList = scdService.getScdDate(clsId);
		
		// 날짜 순 정렬
		Collections.sort(dateList, new Comparator<Date>() {
			@Override
			public int compare(Date o1, Date o2) {
				return o1.compareTo(o2);
			}
		});
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		
		List<String> sDateList = new ArrayList<String>();
		// 날짜를 포맷해서 스트링으로 변환
		for (Date date : dateList) {
			sDateList.add(sdf.format(date));
		}
		
		IReviewService reviewService = ReviewServiceImpl.getInstance();
		// 해당 클래스의 리뷰 리스트 가져오기
		List<ReviewVO> reviewList = reviewService.getClassReviews(clsId);
		List<List<FileVO>> rvFileList = new ArrayList<List<FileVO>>();
		for (int i = 0; i < reviewList.size(); i++) {
			
			ReviewVO rv = reviewList.get(i);
			
			// 리뷰의 파일정보 가져오기
			List<FileVO> fileList = fileService.getFiles(rv.getFileId());
			rvFileList.add(fileList);
			
			// date formant
			rv.setFormDt(rv.getReviewRegdt());
			
			// 작성자 이름 가져오기
			rv.setWriter(reviewService.getMemName(rv.getReviewNo()));
			reviewList.set(i, rv);
		}
		
		
		
		// 해당 클래스의 리뷰 갯수와 별점평균 가져오기
		Map<String, Object> map = reviewService.getClassRating(clsId);
		cv.setReviewCnt(Integer.parseInt(String.valueOf(map.get("CNT"))));
		cv.setRatingAvg(Double.parseDouble(String.valueOf(map.get("AVG"))));
		
		// 해당 클래스의 모든 일정을 담은 리스트
		List<ClassScheduleVO> scdList = scdService.getClsScd(clsId);
		// sDateList 와 비교를 위해서 새로운 필드에 변환값 저장
		if (scdList != null) {
			for (ClassScheduleVO scdVO : scdList) {
				scdVO.setFormatDate(scdVO.formatDate(scdVO.getCssDate()));
			}
		}
		
		int minMonth = 12;
		
		for (String s : sDateList) {
			int temp = Integer.parseInt(s.substring(0,2).trim());
			if (minMonth > temp) minMonth = temp;
		}
		
		Object obj = req.getSession().getAttribute("loginInfo");
		boolean checked = false;
		if (obj != null && obj instanceof MemberVO) {
			MemberVO mv = (MemberVO) obj;
			FavoriteVO fav = new FavoriteVO(cv.getClsId(), mv.getMemId());
			
			checked = MemberServiceImpl.getInstance().checkFavorite(fav);
		}
		
		req.setAttribute("checked", checked);
		
		req.setAttribute("minMonth", minMonth);
		
		req.setAttribute("cv", cv);
		
		req.setAttribute("clsFileList", clsFileList);
		
		req.setAttribute("pv", pv);
		// 우편번호를 제외한 주소
		req.setAttribute("addr", pv.getProAddr().split("/")[1]);
		
		req.setAttribute("dateList", sDateList);
		
		req.setAttribute("scdList", scdList);
		
		req.setAttribute("reviewList", reviewList);
		
		req.setAttribute("rvFileList", rvFileList);
		
		req.getRequestDispatcher("/WEB-INF/views/common/classdetail.jsp").forward(req, resp);
		
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
