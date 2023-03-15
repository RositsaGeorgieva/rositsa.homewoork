package rositsa.homework.rest.controller.parkingevent.create;

import java.util.Date;

/**
 * 
 * @version 
 * @author rositsa
 * @since 1.0
 *
 */
public class UpdateParkingEventBody {

	private String plateNumber;
	
	private Date endDate;
	
	private int spentTime;
	
	private int paidSumm;

	
	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getSpentTime() {
		return spentTime;
	}

	public void setSpentTime(int spentTime) {
		this.spentTime = spentTime;
	}

	public int getPaidSumm() {
		return paidSumm;
	}

	public void setPaidSumm(int paidSumm) {
		this.paidSumm = paidSumm;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("UpdateParkingEventBody: ");
		sb.append("[plateNumber=" + this.getPlateNumber() + "]");
		sb.append("[endDate=" + this.getEndDate() + "]");
		sb.append("[spentTime=" + this.spentTime + "]");
		sb.append("[paidSumm=" + this.paidSumm + "]");
		
		return sb.toString();
	}
}