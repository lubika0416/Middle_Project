package report.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.ReportVO;

public class ReportDaoImpl implements IReportDao{
	
	private static IReportDao reportDao;
	
	private ReportDaoImpl() {
	}
	
	public static IReportDao getInstance() {
		if(reportDao == null) {
			reportDao = new ReportDaoImpl();
		}
		return reportDao;
	}

	@Override
	public List<ReportVO> selectAllReport() {

		SqlSession session = MyBatisUtil.getInstance();
		
		List<ReportVO> list = null;
		
		try {
			
			list = session.selectList("report.selectAllReport");
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ReportVO getReport(String reportNo) {

		SqlSession session = MyBatisUtil.getInstance();
		
		ReportVO rpv = null;
		
		try {
			
			rpv = session.selectOne("report.getReport", reportNo);
			System.out.println(rpv);
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return rpv;
	}

	@Override
	public int deleteReport(String reportNo) {

		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.delete("report.deleteReport", reportNo);
			session.commit();
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}
}
