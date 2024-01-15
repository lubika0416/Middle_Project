package comm.service;

import java.util.List;

import comm.dao.CouponDaoImpl;
import comm.dao.ICouponDao;
import vo.CouponVO;

public class CouponServiceImpl implements ICouponService{
	
	private static ICouponService cpService;
	
	private ICouponDao cpDao;
	
	private CouponServiceImpl() {
		cpDao = CouponDaoImpl.getInstance();
	}
	
	public static ICouponService getInstance() {
		if (cpService == null) cpService = new CouponServiceImpl();
		return cpService;
	}

	@Override
	public boolean issuedCoupon(CouponVO cv) {
		boolean result = false;
		
		int cnt = cpDao.issuedCoupon(cv);
		if (cnt > 0) result = true;
		
		return result;
	}

	@Override
	public boolean usedCoupon(int couponNo) {
		boolean result = false;
		
		int cnt = cpDao.usedCoupon(couponNo);
		if (cnt > 0) result = true;
		
		return result;
	}

	@Override
	public List<CouponVO> getCouponList(String memId) {
		return cpDao.getCouponList(memId);
	}

}
