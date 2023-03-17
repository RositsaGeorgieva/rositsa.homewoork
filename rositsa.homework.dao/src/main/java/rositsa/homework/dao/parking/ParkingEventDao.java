package rositsa.homework.dao.parking;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import rositsa.homework.core.ParkingEvent;


/**
 * Business DAO operations related to the ParkingEvent entity.
 * 
 * @version $ID:$
 * 
 * @author rositsa
 * 
 * @since 1.0
 */
public interface ParkingEventDao extends GenericDAO<ParkingEvent, Serializable> {

	/**
	 * Finds last parking event for plate number
	 * 
	 * @param plateNumber
	 *
	 * @return ParkingEvent
	 */
	ParkingEvent findByPlateNumber(String plateNumber);
	
	/**
	 * @param plateNumber
	 * 
	 * @return
	 */
	ParkingEvent findEnteredByPlateNumber(String plateNumber);
	
	/**
	 * @return list of all occupied spots in the parking NOW
	 */
	List<ParkingEvent> findOccupied();
	
	/**
	 * @return list of occupied by cars spots in the parking NOW
	 */
	List<ParkingEvent> findOccupiedCarSpots();
	
	/**
	 * @return list of occupied by busses spots in the parking NOW
	 */
	List<ParkingEvent> findOccupiedBusSpots();
	
	/**
	 * @param start - start of the day
	 * @param end - end of the day
	 * @return
	 */
	List<ParkingEvent> findByDate(Date start, Date end);


}