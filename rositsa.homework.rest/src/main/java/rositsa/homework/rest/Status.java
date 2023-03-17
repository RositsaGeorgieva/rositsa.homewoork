package rositsa.homework.rest;


/**
 * Sample of response message:
 * 
 * <pre>
 * {@code
 * 
 * {
 *   "status": {
 *     "type": "success",
 *     "code": "200",
 *     "message": "Homework Server is up!"
 *   } 
 * }
 *
 * }</pre>
 * 
 * @version $Id:$
 * @author rositsa
 * @since 1.0
 * 
 */
public class Status {
	
	private String code;
	
	private ResponseTypes type;
	
	private String message;
	
	/**
	 * Defaul constructor
	 */
	public Status() {
		
	}
	
	/**
	 * @param code
	 * @param type
	 * @param message
	 */
	public Status(String code, ResponseTypes type, String message) {
		this.code = code;
		this.type = type;
		this.message = message;
	}

	/**
	 * Get type
	 * 
	 * @return the type
	 */
	public ResponseTypes getType() {
		return type;
	}

	/**
	 * Set type
	 * 
	 * @param type - the type
	 */
	public void setType(ResponseTypes type) {
		this.type = type;
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public enum ResponseTypes{
		SUCCESS, ERROR
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Status [type" + this.type + "][code=" + this.code + "][message=" + this.message + "]";
	}
}