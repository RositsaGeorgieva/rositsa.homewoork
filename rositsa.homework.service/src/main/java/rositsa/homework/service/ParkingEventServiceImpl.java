package rositsa.homework.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rositsa.homework.core.ParkingEvent;
import rositsa.homework.dao.parking.ParkingEventDao;

/**
 * @version $Id:$
 * @author rositsa
 * @since 1.0
 *
 */
@Service
public class ParkingEventServiceImpl implements ParkingEventService {

	@Autowired
	protected ParkingEventDao parkingEventDAO;
	
	@Transactional
	public List<ParkingEvent> findAll() {
		return this.parkingEventDAO.findAll();
	}

	@Transactional
	public void save(ParkingEvent parkingEvent) {
		this.parkingEventDAO.makePersistent(parkingEvent);
		
	}

	@Override
	public List<ParkingEvent> findOccupied() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParkingEvent enterParking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParkingEvent exitParking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParkingEvent> findSales(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParkingEvent> findAllSales() {
		// TODO Auto-generated method stub
		return null;
	}


}