package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassScheduleVO {
	
	private String cssId;
	
	private Date cssDate;
	
	private String startTime;
	
	private String endTime;
	
	private int maxPerson;
	
	private int currentPerson = 0;
	
	private String clsId;
	
	private String formatDate;
	
	public ClassScheduleVO() {}

	public ClassScheduleVO(Date cssDate, String startTime, String endTime, int maxPerson, String clsId) {
		this.cssDate = cssDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.maxPerson = maxPerson;
		this.clsId = clsId;
	}
	
	public String getFormatDate() {
		return formatDate;
	}
	
	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	public String getCssId() {
		return cssId;
	}

	public void setCssId(String cssId) {
		this.cssId = cssId;
	}

	public Date getCssDate() {
		return cssDate;
	}

	public void setCssDate(Date cssDate) {
		this.cssDate = cssDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}

	public int getCurrentPerson() {
		return currentPerson;
	}

	public void setCurrentPerson(int currentPerson) {
		this.currentPerson = currentPerson;
	}

	public String getClsId() {
		return clsId;
	}

	public void setClsId(String clsId) {
		this.clsId = clsId;
	}
	
	/**
	 * MM-dd
	 * @param date
	 * @return
	 */
	public String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return sdf.format(date);
	}
	
	/**
	 * yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public String formatDate2(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	@Override
	public String toString() {
		return "ClassScheduleVO [cssId=" + cssId + ", cssDate=" + cssDate + ", startTime=" + startTime + ", endTime="
				+ endTime + ", maxPerson=" + maxPerson + ", currentPerson=" + currentPerson + ", clsId=" + clsId + "]";
	}
	
	
	
	
	
}
