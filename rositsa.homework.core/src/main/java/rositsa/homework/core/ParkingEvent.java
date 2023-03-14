package rositsa.homework.core;

import java.util.Date;

public class ParkingEvent {
	
	private static final String TYPE_BUS = "bus";
	
	private static final String TYPE_CAR = "car";
	
	private Long id;
	
	private String plateNumber;
	
	private String type;
	
	private Date startTime;
	
	private Date endTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ParkingEvent [id=" + this.id + "]");
		sb.append("[plateNymber=" + this.plateNumber + "]");
		sb.append("[type=" + this.type + "]");
		sb.append("[start Time=" + this.startTime + "]");
		sb.append("[send Time=" + this.endTime + "]");
		return sb.toString();
	}
}
