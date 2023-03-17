package rositsa.homework.dao.parking;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import rositsa.homework.core.ParkingEvent;


/**
 * Business DAO operations related to the <tt>ParkingEvent</tt> entity.
 * @see rositsa.homework.core.ParkingEvent;
 * 
 * @version $ID:$
 * 
 * @author rositsa
 * 
 * @since 1.0
 */
public interface ParkingEventDao extends GenericDAO<ParkingEvent, Serializable> {

	/**
	 * 
	 * @param plateNumber
	 *
	 * @return last parking event for this number
	 */
	ParkingEvent findByPlateNumber(String plateNumber);
	
	/**
	 * @param plateNumber
	 * @return
	 */
	ParkingEvent findEnteredByPlateNumber(String plateNumber);
	
	/**
	 * @return list of all occupied spots in the parking
	 */
	List<ParkingEvent> findOccupied();
	
	/**
	 * @return list of occupied by cars spots in the parking
	 */
	List<ParkingEvent> findOccupiedCarSpots();
	
	/**
	 * @return list of occupied by busses spots in the parking
	 */
	List<ParkingEvent> findOccupiedBusSpots();
	
	List<ParkingEvent> findByDate(Date dateIn, Date dateOut);


}