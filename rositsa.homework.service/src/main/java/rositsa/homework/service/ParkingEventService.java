package rositsa.homework.service;

import java.util.Date;
import java.util.List;

import rositsa.homework.core.ParkingEvent;

/**
 * 
 * Parking service
 * 
 * 
 * @version $Id:$
 * @author rosy@inerty.com
 * @since 1.0
 *
 */
public interface ParkingEventService {
	

	public static final int PRICE_CAR_1H = 1;
	public static final int PRICE_CAR_24H = 10;
	public static final int PRICE_BUS_1H = 5;
	public static final int PRICE_BUS_24H = 40;
	public static final int BUS_SPOTS = 10;
	public static final int CAR_SPOTS = 50;
	
	/**
	 * Get parking event by id
	 * 
	 * @param id
	 * @return
	 */
	public ParkingEvent get(Long id);
	
	
	/**
	 * Get parking event by plate number
	 * 
	 * @param plateNumber
	 * @return
	 */
	public ParkingEvent get(String plateNumber);
	
	/**
	 * save parking event
	 * 
	 * @param parkingEvent
	 */
	public void save(ParkingEvent parkingEvent);
	
	/**
	 * Find all parking events
	 * @return
	 */
	public List<ParkingEvent> findAll();
	
	/**
	 * Car or bus at the entrance of parking
	 * 
	 * @param plateNumber
	 * @param type
	 * @return
	 * @throws FullParkingException
	 */
	public ParkingEvent enterParking(String plateNumber, String type) throws FullParkingException;
	
	/**
	 * Car or bus  at the exit of the parking
	 * 
	 * @param plateNumber
	 * @return
	 */
	public ParkingEvent exitParking(String plateNumber); 
	
	/**
	 * Find all occupied spots NOW
	 * @return
	 */
	public List<ParkingEvent> findOccupied();
	
	/**
	 * Number of free car's spots
	 * 
	 * @return
	 */
	public int findFreeCarSpots();
	
	/**
	 * Number of free bus's spots
	 * 
	 * @return
	 */
	public int findFreeBusSpots();
	
	/**
	 * when we want to see which cars were parked that day
	 * @param date
	 * @return
	 */
	public List<ParkingEvent> findByDate(Date date);
}