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
	
	public ParkingEvent get(Long id);
	
	public ParkingEvent get(String plateNumber);
	
	public void save(ParkingEvent parkingEvent);
	
	public List<ParkingEvent> findAll();
	
	public ParkingEvent enterParking();
	
	public ParkingEvent exitParking(); 
	
	/**
	 * Find all occupied spots
	 * @return
	 */
	public List<ParkingEvent> findOccupied();
	
	/**
	 * Find sales
	 * @return
	 */
	public List<ParkingEvent> findSales(Date date);

	public List<ParkingEvent> findAllSales();
}