package vo;

public class TimeVO {
	
	private String startTime;
	
	private String endTime;

	public TimeVO(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
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

	@Override
	public String toString() {
		return "TimeVO [startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
}
