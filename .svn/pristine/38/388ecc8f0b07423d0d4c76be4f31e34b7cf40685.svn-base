package faq.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.FAQServiceImpl;
import faq.service.IFAQService;
import vo.FAQVO;

@WebServlet("/FAQBoard.do")
public class CommonFAQBoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int currentPage = 1; //현재 페이지 값
		currentPage = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		
		//전체 글 갯수 조회하기
		IFAQService service = FAQServiceImpl.getInstance();
		
		//전체 글 갯수
		int count = service.countList();
		
		//화면에 표시될 페이지의 수
		int perPage = 5;
		
		//한 페이지 당 출력할 글 갯수
		int perList = 10;
		
		//전체 페이지 수 = 전체 글갯수(count) / 페이지 당 글 갯수(perList)
		//double
		//전체 페이지 갯수
		int totalPage = (int)Math.ceil((double)count / (double)perList);
		
		//페이지 당 출력할 게시글 범위(start ~ end)
		//start = (currentPage - 1) * perList + 1;
		//1페이지 (1 - 1) * perList + 1; // =1
		//2페이지 (2 - 1) * perList + 1; // =6
		//3페이지 (3 - 1) * perList + 1; // =11
		//4페이지 (4 - 1) * perList + 1; // =16
		
		int start = (currentPage - 1) * perList;
		
		//end = start + perList - 1
		//1페이지  1 + 5 - 1; // =5
		//2페이지  6 + 5 - 1; // =10
		//3페이지  11 + 5 - 1; // =15
		//4페이지  16 + 5 - 1; // =20
		//4페이지  21 + 5 - 1; // =25
		int end = start + perList - 1;
		if(end < count) end = count; //전체 글 갯수보다 큰 값이 생성되었을 때 제어
		
		//화면에 표시될 페이지 범위(startPage ~ endPage) 구하기
		//startPage = ((currentPage - 1) / (perPage * perPage) + 1
		//1페이지 ((1 - 1) / 2 * 2) + 1; // =1
		//2페이지 ((2 - 1) / 2 * 2) + 1; // =1
		//3페이지 ((3 - 1) / 2 * 2) + 1; // =3
		//3페이지 ((4 - 1) / 2 * 2) + 1; // =3
		//3페이지 ((5 - 1) / 2 * 2) + 1; // =5
		int startPage = ((currentPage - 1) / perPage * perPage) + 1;
		
		//endPage = startPage + perPage -1;
		//1페이지 1 + 2 - 1; //2
		//2페이지 1 + 2 - 1; //2
		//3페이지 3 + 2 - 1; //4
		//4페이지 3 + 2 - 1; //4
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage; //전체 페이지 수보다 큰 값이 생성되었을 때 제어
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		
		//게시글 범위 값(start,end)로 해당 영역의 게시물 조회하기
		List<FAQVO> list = service.boardList(map);
		
		//req 객체에 담아서 활용할 위치로 데이터 넘기기
		req.setAttribute("list", list);
		req.setAttribute("sPage", startPage);
		req.setAttribute("ePage", endPage);
		req.setAttribute("ttPage", totalPage);
		req.setAttribute("cPage", currentPage);
		
		req.getRequestDispatcher
		("/WEB-INF/views/common/FAQ.jsp").forward(req, resp);
	}
}
