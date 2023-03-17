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
	 * @param id
	 * @return
	 */
	public ParkingEvent get(Long id);
	
	public ParkingEvent get(String plateNumber);
	
	public void save(ParkingEvent parkingEvent);
	
	public List<ParkingEvent> findAll();
	
	public ParkingEvent enterParking(String plateNumber, String type) throws FullParkingException;
	
	public ParkingEvent exitParking(String plateNumber); 
	
	/**
	 * Find all occupied spots
	 * @return
	 */
	
	public List<ParkingEvent> findOccupied();
	
	public int findFreeCarSpots();
	
	public int findFreeBusSpots();
	
	public List<ParkingEvent> findByDate(Date date);
}