package comm.dao;

import java.util.List;

import vo.CouponVO;

public interface ICouponDao {
	
	/**
	 * 쿠폰 발급 메소드
	 * @param cv
	 * @return
	 */
	public int issuedCoupon(CouponVO cv);
	
	/**
	 * 쿠폰 사용시 쿠폰 삭제 메소드
	 * @param couponNo
	 * @return
	 */
	public int usedCoupon(int couponNo);
	
	/**
	 * 회원의 보유 쿠폰 리스트 메소드
	 * @param memId
	 * @return
	 */
	public List<CouponVO> getCouponList(String memId);
	
}
