package classes.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import classes.dao.IScheduleDao;
import classes.dao.ScheduleDaoImpl;
import vo.ClassScheduleVO;
import vo.TimeVO;

public class ScheduleServiceImpl implements IScheduleService{
	
	private static IScheduleService scdService;
	
	private IScheduleDao scdDao;
	
	private ScheduleServiceImpl() {
		scdDao = ScheduleDaoImpl.getInstance();
	}
	
	public static IScheduleService getInstance() {
		if (scdService == null) scdService = new ScheduleServiceImpl();
		return scdService;
	}


	@Override
	public int insertSchedule(List<ClassScheduleVO> scdList) {
		
		return scdDao.insertSchedule(scdList);
		
	}

	@Override
	public List<ClassScheduleVO> getClsScd(String clsId) {
		return scdDao.getClsScd(clsId);
	}

	@Override
	public List<Date> getScdDate(String clsId) {
		return scdDao.getScdDate(clsId);
	}

	@Override
	public int updateCnt(Map<String, Object> map) {
		return scdDao.updateCnt(map);
	}

	@Override
	public ClassScheduleVO getSchedule(String cssId) {
		return scdDao.getSchedule(cssId);
	}

}
