package member.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.PaymentVO;

public class PaymentDaoImpl implements IPaymentDao{
	
	private static IPaymentDao payDao;
	
	private PaymentDaoImpl () {}
	
	public static IPaymentDao getInstance() {
		if (payDao == null) payDao = new PaymentDaoImpl();
		return payDao;
	}
	

	@Override
	public int insertPay(PaymentVO pv) {
		
		int cnt = 0;
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			
			cnt = session.insert("pay.insertPay", pv);
			
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
	public PaymentVO getPay(int resNo) {

		PaymentVO pv = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			pv = session.selectOne("pay.getPay", resNo);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
				
		return pv;
	}

}
