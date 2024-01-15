package member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.FavoriteVO;
import vo.MemberVO;


@WebServlet("/member/addfavorite.do")
public class AddFavoriteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		
		String clsId = req.getParameter("clsId");
		
		FavoriteVO fv = new FavoriteVO(clsId, memId);
		
		IMemberService memService = MemberServiceImpl.getInstance();
		
		memService.addFavorite(fv);
		
		req.getRequestDispatcher("/detailclass.do").forward(req, resp);
		
		
		
	}
	
}
