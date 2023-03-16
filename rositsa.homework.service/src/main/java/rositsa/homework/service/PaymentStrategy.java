package rositsa.homework.service;

public class PaymentStrategy {

	private Payment payment;

	public PaymentStrategy(Payment payment) {
		this.payment = payment;
	}

	public double calculcate(long spentSeconds) {
		return payment.calculate(spentSeconds);
	}

}