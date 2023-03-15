package rositsa.homework.core;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name = "parkingevent")
@Proxy(lazy = false)
public class ParkingEvent {
	
	public static final String TYPE_BUS = "bus";
	
	public static final String TYPE_CAR = "car";
	
	/**unique number used to identify the {@link ParkingEvent}*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**unique name of the {@link ParkingEvent}*/
	@Column(name = "plateNumber")
	private String plateNumber;
	
	/**unique name of the {@link ParkingEvent}*/
	@Column(name = "type")
	private String type;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	
	@Column(name = "spentTime")
	private int spentTime;
	
	@Column(name = "paidSumm")
	private int paidSumm;

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
		sb.append("ParkingEvent [id=" + this.id + "]");
		sb.append("[plateNymber=" + this.plateNumber + "]");
		sb.append("[type=" + this.type + "]");
		sb.append("[start Time=" + this.startTime + "]");
		sb.append("[send Time=" + this.endTime + "]");
		return sb.toString();
	}
}
