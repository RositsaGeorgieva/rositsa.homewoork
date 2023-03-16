package rositsa.homework.service;

public interface Payment {

	/**
	 * @param spent time in hours
	 * @return payment
	 */
	public double calculate (long spentHours);

}