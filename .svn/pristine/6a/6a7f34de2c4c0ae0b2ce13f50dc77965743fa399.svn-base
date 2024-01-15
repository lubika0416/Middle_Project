package admin.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AdminServiceImpl;
import admin.service.IAdminService;
import vo.PaymentVO;

@WebServlet("/admin/statistics.do")
public class AdminStatistics extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IAdminService service = AdminServiceImpl.getInstance();
		
		List<PaymentVO> pList = service.selectAllPayment();
		List<Date> vList = service.selectAllVisit();
//		System.out.println(pList);
//		System.out.println(vList);
		
		List<String> cList = new ArrayList<String>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

		for(int i = 0; i < vList.size(); i++) {
			cList.add(sdf.format(vList.get(i)));
		}
		System.out.println(cList.get(0).substring(3, 5));
		System.out.println(cList.get(0));
		


		// 월별 방문자 수 계산
		// 월별 방문자 수 계산
		Map<String, Integer> monthVisits = new HashMap<>();
		for (int i = 0; i < vList.size(); i++) {
		    String month = cList.get(i).substring(3, 5);
		    
		    // 해당 월에 방문자 수를 가져와서 1을 더합니다.
		    // 이미 해당 월의 데이터가 있으면 기존 값을 가져와서 1을 더한 후 다시 저장합니다.
		    int currentMonthVisits = monthVisits.getOrDefault(month, 0);
		    monthVisits.put(month, currentMonthVisits + 1);
		}
		System.out.println(monthVisits.get("01"));
		System.out.println(monthVisits.get("09"));
		
		// 분기별 방문자 수 계산
		Map<String, Integer> quarterVisits = new HashMap<>();
		
		int FirstQuarterVisit = 0;
		int SecondQuarterVisit = 0;
		int ThirdQuarterVisit = 0;
		int FourthQuarterVisit = 0;

		for (int i = 0; i < vList.size(); i++) {
		    String month = cList.get(i).substring(3, 5);
		    
		    if (month.equals("01") || month.equals("02") || month.equals("03")) {
		        FirstQuarterVisit++;
		    } else if (month.equals("04") || month.equals("05") || month.equals("06")) {
		        SecondQuarterVisit++;
		    } else if (month.equals("07") || month.equals("08") || month.equals("09")) {
		        ThirdQuarterVisit++;
		    } else if (month.equals("10") || month.equals("11") || month.equals("12")) {
		        FourthQuarterVisit++;
		    }
		}

		// 각 분기별 방문자 수를 Map에 저장
		quarterVisits.put("FirstQuarterVisit", FirstQuarterVisit);
		quarterVisits.put("SecondQuarterVisit", SecondQuarterVisit);
		quarterVisits.put("ThirdQuarterVisit", ThirdQuarterVisit);
		quarterVisits.put("FourthQuarterVisit", FourthQuarterVisit);

		
		
		req.setAttribute("pList", pList);
		req.setAttribute("cList", cList);
		req.setAttribute("quarterVisits", quarterVisits);
		req.setAttribute("monthVisits", monthVisits);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/Statistics/statistics.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
