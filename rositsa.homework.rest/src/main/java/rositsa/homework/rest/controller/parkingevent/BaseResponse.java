package rositsa.homework.rest.controller.parkingevent;

import rositsa.homework.rest.Status;
import rositsa.homework.rest.Status.ResponseTypes;

/**
 * Base response class that contains a {@link Status}
 * 
 * <pre>
 * {
 *   "status": {
 *        "code": "string",
 *        "message": "string",
 *        "type": "SUCCESS"
 *   }
 * }
 * </pre>
 * 
 * @version $Id:$
 * @author inerty.com
 * @since 1.0
 *
 */
public abstract class BaseResponse {
	
	protected Status status;
	
	/**
	 * Default constructor
	 */
	public BaseResponse() {
		
	}
	
	/**
	 * Costructor
	 * 
	 * @param code - response code
	 * @param type - response type
	 * @param message - response message
	 */
	public BaseResponse(String code, ResponseTypes type, String message) {
		status = new Status(code, type, message);
	}
	
	/**
	 * Get status
	 * 
	 * @return status
	 */
	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "BaseResponse [status=" + status + "]";
	}
	
}
