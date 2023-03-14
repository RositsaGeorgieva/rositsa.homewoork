package rositsa.homework.rest.controller.parkingevent.get;

import rositsa.homework.rest.Status;
import rositsa.homework.rest.Status.ResponseTypes;

/**
 * Base response class that contains a {@link Status}
 * 
 * * <pre>
 * {@code
 * {
 *   "status": {
 *        "code": "string",
 *        "message": "string",
 *        "type": "SUCCESS"
 *   }
 * }
 * 
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
	
	public BaseResponse(String code, ResponseTypes type, String message) {
		status = new Status(code, type, message);
	}
	
	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "BaseResponse [status=" + status + "]";
	}
	
}
