package member.service;

import vo.PaymentVO;

public interface IPaymentService {
	
	public int insertPay(PaymentVO pv);
	
	/**
	 * 예약번호로 결제정보 가져오는 메소드
	 * @param resNo
	 * @return
	 */
	public PaymentVO getPay(int resNo);
	
}
