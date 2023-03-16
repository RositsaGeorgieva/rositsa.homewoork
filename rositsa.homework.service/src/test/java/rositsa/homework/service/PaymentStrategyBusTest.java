package rositsa.homework.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaymentStrategyBusTest {

	PaymentStrategy paymentStrategy = new PaymentStrategy(new BusPayment());;
	
	
	
	@Test
	public void testBusPaymentTime0h() {
		double calculcate = paymentStrategy.calculcate(0);
		assertEquals(0, calculcate, 0);
	}
	
	@Test
	public void testBusPaymentTime1h() {
		double calculcate = paymentStrategy.calculcate(1);
		assertEquals(5, calculcate, 0);
	}
	
	@Test
	public void testBusPaymentTime10h() {
		double calculcate = paymentStrategy.calculcate(10);
		assertEquals(40, calculcate, 0);
	}
	@Test
	public void testBusPaymentTime11h() {
		double calculcate = paymentStrategy.calculcate(11);
		assertEquals(40, calculcate, 0);
	}
	@Test
	public void testBusPaymentTime16h() {
		double calculcate = paymentStrategy.calculcate(16);
		assertEquals(40, calculcate, 0);
	}
	
	@Test
	public void testBusPaymentTime24h() {
		double calculcate = paymentStrategy.calculcate(24);
		assertEquals(40, calculcate, 0);
	}
	
	@Test
	public void testBusPaymentTime26h() {
		double calculcate = paymentStrategy.calculcate(26);
		assertEquals(50, calculcate, 0);
	}
	
	/**
	 * This case intentionaly was left to fail. 
	 * The case is not implemented.
	 */
	@Test
	public void testBusPaymentTimeNegative() {
		double calculcate = paymentStrategy.calculcate(-2);
		assertEquals(0, calculcate, 0);
	}

}
