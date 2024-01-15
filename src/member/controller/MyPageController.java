package member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import comm.service.FileServiceImpl;
import comm.service.IFileService;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import review.service.ReviewServiceImpl;
import vo.ClassesVO;
import vo.FavoriteVO;
import vo.FileVO;
import vo.MemberVO;

@WebServlet("/mypage.do")
public class MyPageController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("loginInfo");
		
		if (obj != null) {
			
			if (obj instanceof MemberVO) {
				
				IMemberService memberService = MemberServiceImpl.getInstance();
				
				MemberVO mv = (MemberVO)obj;
				
				List<FavoriteVO> faList = memberService.selectFavorite(mv.getMemId());
				
				List<ClassesVO> clsList  = new ArrayList<ClassesVO>();
				
				List<List<FileVO>> fileList = new ArrayList<List<FileVO>>();
				
				
				IClassesService classesService = ClassesServiceImpl.getInstance();
				IFileService fileService = FileServiceImpl.getInstance();
				
				for (int i = 0; i < faList.size(); i++) {
					FavoriteVO fav = faList.get(i);
					
					ClassesVO cvo = classesService.getClasses(fav.getClsId());
					Map<String, Object> map = ReviewServiceImpl.getInstance().getClassRating(cvo.getClsId());
					cvo.setReviewCnt(Integer.parseInt(String.valueOf(map.get("CNT"))));
					cvo.setRatingAvg(Double.parseDouble(String.valueOf(map.get("AVG"))));
					List<FileVO> fvo = fileService.getClassFileList(fav.getClsId());
					
					clsList.add(cvo);
					fileList.add(fvo);
					 
				}
				
				Map<String, Object> info = memberService.getUsedInfo(mv.getMemId());
				
				for (Map.Entry<String, Object> entry : info.entrySet()) {
					System.out.println(entry.getKey() + " " + entry.getValue());
				}
				
				mv.setFavoriteNo(Integer.parseInt(String.valueOf(info.get("FAVCNT"))));
				mv.setResNo(Integer.parseInt(String.valueOf(info.get("RESCNT"))));
				mv.setReviewNo(Integer.parseInt(String.valueOf(info.get("REVIEWCNT"))));
				
				
				session.setAttribute("loginInfo", mv);
				
				req.setAttribute("clsList", clsList);
				req.setAttribute("fileList", fileList);
				
				req.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(req, resp);
				
			}
		
		} else {
			
			req.setAttribute("loginResult", false);
			
			req.getRequestDispatcher("main.do").forward(req, resp);
			
		}		
	}
	
}
