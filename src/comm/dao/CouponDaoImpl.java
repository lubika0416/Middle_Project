package comm.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.CouponVO;

public class CouponDaoImpl implements ICouponDao {

	private static ICouponDao cpDao;

	private CouponDaoImpl() {
	}

	public static ICouponDao getInstance() {
		if (cpDao == null)
			cpDao = new CouponDaoImpl();
		return cpDao;
	}

	@Override
	public int issuedCoupon(CouponVO cv) {

		int cnt = 0;

		SqlSession session = MyBatisUtil.getInstance();

		try {
			cnt = session.insert("coupon.issuedCoupon", cv);
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
	public int usedCoupon(int couponNo) {
		int cnt = 0;

		SqlSession session = MyBatisUtil.getInstance();

		try {
			cnt = session.update("coupon.usedCoupon", couponNo);
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
	public List<CouponVO> getCouponList(String memId) {

		List<CouponVO> cpList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			cpList = session.selectList("coupon.getCouponList", memId);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return cpList;
	}

}
