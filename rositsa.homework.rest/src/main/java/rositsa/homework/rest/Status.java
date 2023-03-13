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
	
	public Status() {
		// TODO Auto-generated constructor stub
	}
	
	public Status(String code, ResponseTypes type, String message) {
		this.code = code;
		this.type = type;
		this.message = message;
	}

	public ResponseTypes getType() {
		return type;
	}

	public void setType(ResponseTypes type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

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