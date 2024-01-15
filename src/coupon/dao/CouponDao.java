package coupon.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.CouponVO;

public class CouponDao {
	
	public List<CouponVO> getCouponList(String memId){
		
		SqlSession session = MyBatisUtil.getInstance();
		
		List<CouponVO> list = null;
		
		try {
			
			list = session.selectList("coupon.getCouponList", memId);
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
}
