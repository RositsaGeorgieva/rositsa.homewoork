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
public class CreateResponse extends BaseResponse {
	
	private static final String CREATE_PARKING_EVENT_SUCCESSFUL = "Parking event created successful";
	
	private static final String PARKING_EVENT_CREATED_PROCESSED = "Parking event creation request processed";
	
	public CreateResponse() {
		super(CREATE_PARKING_EVENT_SUCCESSFUL, ResponseTypes.SUCCESS, PARKING_EVENT_CREATED_PROCESSED);
	}
	
	public CreateResponse(String name) {
		super(CREATE_PARKING_EVENT_SUCCESSFUL + " " + name, ResponseTypes.SUCCESS, PARKING_EVENT_CREATED_PROCESSED);
	}
}