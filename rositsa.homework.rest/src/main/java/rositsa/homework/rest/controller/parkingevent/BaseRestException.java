package rositsa.homework.rest.controller.parkingevent;

/**
 * @version $Id:$
 * @author inerty.com
 * @since 1.0
 *
 */
public class BaseRestException extends Exception {

	/** Serial Id*/
	private static final long serialVersionUID = -1695340610713317597L;

	private String code;

	public BaseRestException() {

	}
	
	public BaseRestException(String message, String code){
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	
}
