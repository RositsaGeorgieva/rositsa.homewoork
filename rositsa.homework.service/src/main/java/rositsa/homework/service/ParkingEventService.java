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
	
	List<ParkingEvent> findAll();
	
	ParkingEvent enterParking();
	
	ParkingEvent exitParking();
	
	/**
	 * Find all occupied spots
	 * @return
	 */
	List<ParkingEvent> findOccupied();
	
	/**
	 * Find sales
	 * @return
	 */
	List<ParkingEvent> findSales(Date date);

	List<ParkingEvent> findAllSales();
}