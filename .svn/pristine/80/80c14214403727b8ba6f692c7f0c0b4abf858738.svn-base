package classes.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.ClassScheduleVO;
import vo.TimeVO;

public class ScheduleDaoImpl implements IScheduleDao {

	private static IScheduleDao scdDao;

	private ScheduleDaoImpl() {
	}

	public static IScheduleDao getInstance() {
		if (scdDao == null)
			scdDao = new ScheduleDaoImpl();
		return scdDao;
	}

	@Override
	public int insertSchedule(List<ClassScheduleVO> scdList) {

		int cnt = 0;

		SqlSession session = MyBatisUtil.getInstance();

		try {

			for (ClassScheduleVO scd : scdList) {
				cnt += session.insert("schedule.insertSchedule", scd);
			}
			if (cnt > 0)
				session.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<ClassScheduleVO> getClsScd(String clsId) {
		
		List<ClassScheduleVO> scdList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			scdList = session.selectList("schedule.getClsScd", clsId);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return scdList;
	}

	@Override
	public List<Date> getScdDate(String clsId) {
		List<Date> dateList = null;
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			dateList = session.selectList("schedule.getScdDate", clsId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dateList;
	}

	@Override
	public int updateCnt(Map<String, Object> map) {

		int cnt = 0;
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			cnt = session.update("schedule.updateCnt", map);
			if (cnt > 0) session.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public ClassScheduleVO getSchedule(String cssId) {
		
		ClassScheduleVO scd = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			scd = session.selectOne("schedule.getSchedule", cssId);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return scd;
	}

}
