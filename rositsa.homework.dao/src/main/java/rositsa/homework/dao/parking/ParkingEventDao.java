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

	ParkingEvent findByPlateNumber(String plateNumber);
	
	List<ParkingEvent> findOccupied();


}