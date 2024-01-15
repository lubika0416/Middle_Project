package member.service;

import java.util.List;

import member.dao.IReservationDao;
import member.dao.ReservationDaoImpl;
import vo.ReservationVO;

public class ReservationServiceImpl implements IReservationService{
	
	private static IReservationService resService;
	
	private IReservationDao resDao; 
	
	private ReservationServiceImpl() {
		resDao = ReservationDaoImpl.getInstance();
	}
	
	public static IReservationService getInstance() {
		return resService == null ? new ReservationServiceImpl() : resService;
	}

	@Override
	public int insertReservation(ReservationVO rv) {
		return resDao.insertReservation(rv);
	}

	@Override
	public int updateReservation(ReservationVO rv) {
		return resDao.updateReservation(rv);
	}

	@Override
	public int deleteReservation(int resNo) {
		return resDao.deleteReservation(resNo);
	}

	@Override
	public ReservationVO getReservation(int resNo) {
		return resDao.getReservation(resNo);
	}

	@Override
	public List<ReservationVO> getCssReservations(String cssId) {
		return resDao.getCssReservations(cssId);
	}

	@Override
	public int getReservationNo(String memId, String cssId) {
		return resDao.getReservationNo(memId, cssId);
	}

	@Override
	public List<ReservationVO> getResList(String proId) {
		return resDao.getResList(proId);
	}

	@Override
	public List<ReservationVO> selectMyReservation(String memId) {
		return resDao.selectMyReservation(memId);
	}

	@Override
	public String getClassName(String clsId) {
		return resDao.getClassName(clsId);
	}






}
