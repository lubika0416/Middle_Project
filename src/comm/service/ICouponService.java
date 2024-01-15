package comm.service;

import java.util.List;

import vo.CouponVO;

public interface ICouponService {
	
	/**
	 * 쿠폰 발급 메소드
	 * @param cv
	 * @return
	 */
	public boolean issuedCoupon(CouponVO cv);
	
	/**
	 * 쿠폰 사용시 쿠폰 삭제 메소드
	 * @param couponNo
	 * @return
	 */
	public boolean usedCoupon(int couponNo);
	
	/**
	 * 회원의 보유 쿠폰 리스트 메소드
	 * @param memId
	 * @return
	 */
	public List<CouponVO> getCouponList(String memId);
}
