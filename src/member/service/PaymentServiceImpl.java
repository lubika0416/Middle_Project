package member.service;

import member.dao.IPaymentDao;
import member.dao.PaymentDaoImpl;
import vo.PaymentVO;

public class PaymentServiceImpl implements IPaymentService{
	
	private static IPaymentService payService;
	
	private IPaymentDao payDao;
	
	private PaymentServiceImpl() {
		payDao = PaymentDaoImpl.getInstance();
	}
	
	public static IPaymentService getInstance() {
		if (payService == null) payService = new PaymentServiceImpl();
		return payService;
	}

	@Override
	public int insertPay(PaymentVO pv) {
		
		return payDao.insertPay(pv);
		
	}

	@Override
	public PaymentVO getPay(int resNo) {
		return payDao.getPay(resNo);
	}

}
