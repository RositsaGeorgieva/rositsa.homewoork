package rositsa.homework.service;

public class BusPayment implements Payment {

	/**
	 * time is in hours
	 */
	@Override
	public double calculate(long hours) {
		
		//calculate the number of full days
		double fullDays = Math.floor(hours / 24);
		
		//remainder after taking full days - it is started hours in the parking
		double  startedHours = hours % 24;
		
		double payment = 0d;
		
		if (10 > startedHours) {
			
			payment = (fullDays * ParkingEventService.PRICE_BUS_24H) + startedHours * ParkingEventService.PRICE_BUS_1H ;
		} else {
			payment = (fullDays + 1) * ParkingEventService.PRICE_BUS_24H; 
		}
				
		return payment;
	}

}
