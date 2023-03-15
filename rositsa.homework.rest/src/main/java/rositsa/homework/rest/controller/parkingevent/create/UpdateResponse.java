package rositsa.homework.rest.controller.parkingevent.create;

import rositsa.homework.rest.Status.ResponseTypes;
import rositsa.homework.rest.controller.parkingevent.BaseResponse;

/**
 * 
 * @version $Id:$
 * @author rosy@inerty.com
 * @since 1.0
 *
 */
public class UpdateResponse extends BaseResponse {
	
	private static final String UPDATE_PARKING_EVENT_SUCCESSFUL = "Parking event updated successful";
	
	private static final String PARKING_EVENT_UPDATE_PROCESSED = "Parking event update request processed";
	
	public UpdateResponse() {
		super(UPDATE_PARKING_EVENT_SUCCESSFUL, ResponseTypes.SUCCESS, PARKING_EVENT_UPDATE_PROCESSED);
	}
	
	public UpdateResponse(String name) {
		super(UPDATE_PARKING_EVENT_SUCCESSFUL + " " + name, ResponseTypes.SUCCESS, PARKING_EVENT_UPDATE_PROCESSED);
	}
}