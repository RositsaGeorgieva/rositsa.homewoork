package rositsa.homework.rest.controller.parkingevent.get;

import java.util.ArrayList;
import java.util.List;

import rositsa.homework.core.ParkingEvent;
import rositsa.homework.rest.Status.ResponseTypes;
import rositsa.homework.rest.controller.parkingevent.BaseResponse;


/**
 * List parkingEvents response:
 * 
 * @version $Id:$
 * @author rositsa
 * @since 1.0
 *
 */
public class ListParkingEventsResponse extends BaseResponse {

	private static final String CODE = "001";
	private static final String MESSAGE = "Parking events Retrieved Successfully";
	
	private List<ParkingEvent> parkingEvents = new ArrayList<ParkingEvent>();

	public ListParkingEventsResponse() {
		super(CODE, ResponseTypes.SUCCESS, MESSAGE);
	}

	public List<ParkingEvent> getParkingEvents() {
		return parkingEvents;
	}

	public void setParkingEvents(List<ParkingEvent> parkingEvents) {
		this.parkingEvents = parkingEvents;
	}

}