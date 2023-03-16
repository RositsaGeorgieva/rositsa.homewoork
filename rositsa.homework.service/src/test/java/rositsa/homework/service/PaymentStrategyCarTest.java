package rositsa.homework.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaymentStrategyCarTest {

	PaymentStrategy paymentStrategy = new PaymentStrategy(new CarPayment());;
	
	
	
	@Test
	public void testCarPaymentTime0h() {
		double calculcate = paymentStrategy.calculcate(0);
		assertEquals(0, calculcate, 0);
	}
	
	@Test
	public void testCarPaymentTime1h() {
		double calculcate = paymentStrategy.calculcate(1);
		assertEquals(1, calculcate, 0);
	}
	
	@Test
	public void testCarPaymentTime10h() {
		double calculcate = paymentStrategy.calculcate(10);
		assertEquals(10, calculcate, 0);
	}
	@Test
	public void testCarPaymentTime11h() {
		double calculcate = paymentStrategy.calculcate(11);
		assertEquals(10, calculcate, 0);
	}
	@Test
	public void testCarPaymentTime16h() {
		double calculcate = paymentStrategy.calculcate(16);
		assertEquals(10, calculcate, 0);
	}
	
	@Test
	public void testCarPaymentTime24h() {
		double calculcate = paymentStrategy.calculcate(24);
		assertEquals(10, calculcate, 0);
	}
	
	@Test
	public void testCarPaymentTime26h() {
		double calculcate = paymentStrategy.calculcate(26);
		assertEquals(12, calculcate, 0);
	}
	
	/**
	 * This case intentionaly was left to fail. 
	 * The case is not implemented.
	 */
	@Test
	public void testCarPaymentTimeNegative() {
		double calculcate = paymentStrategy.calculcate(-2);
		assertEquals(0, calculcate, 0);
	}

}
