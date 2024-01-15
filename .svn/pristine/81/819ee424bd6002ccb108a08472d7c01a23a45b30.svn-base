package visit.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import visit.dao.VisitCountDao;

@WebListener
public class VisitSessionListner implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//세션이 새로 생성되면 execute()를 실행한다.
		if(se.getSession().isNew()) {
			execute(se);
		}	
	}
	
	private void execute(HttpSessionEvent se) {
		VisitCountDao dao = VisitCountDao.getInstance();
		
		try {
			
			//전체 방문자 수 증가
			dao.setTotalCount();
			//총 방문자 수
			int totalCount = dao.getTotalCount();
			//오늘 방문자 수
			int todayCount = dao.getTodayCount();
			
			HttpSession session = se.getSession();
			
			//세션에 방문자 수를 담는다.
			session.setAttribute("totalCount", totalCount);
			session.setAttribute("todayCount", todayCount);
			
			System.out.println(totalCount +" totalCount임");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}
}