package rositsa.homework.service;

public interface PaimentStretegy {

	/**
	 * @param spent time in seconds
	 * @return payment
	 */
	public double calculate (long time);

}