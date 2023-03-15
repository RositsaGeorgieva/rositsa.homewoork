package rositsa.homework.rest.controller.parkingevent.create;

/**
 * 
 * @version 
 * @author rositsa
 * @since 1.0
 *
 */
public class CreateParkingEventBody {

	private String plateNumber;
	
	private String type;
	
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CreateParkingEventBody: ");
		sb.append("[plateNumber=" + this.plateNumber + "");
		
		return sb.toString();
	}
}