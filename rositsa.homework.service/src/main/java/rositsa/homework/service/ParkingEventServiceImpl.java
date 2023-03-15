package rositsa.homework.service;

import java.time.LocalTime;
import java.util.Calendar;
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

	
	private static final int PRICE_CAR_1H = 1;
	private static final int PRICE_CAR_24H = 10;
	private static final int PRICE_BUS_1H = 5;
	private static final int PRICE_BUS_24H = 40;
	private static final int BUS_SPOTS = 10;
	private static final int CAR_SPOTS = 50;
	
	@Autowired
	protected ParkingEventDao parkingEventDAO;
	
	Calendar calendar = Calendar.getInstance();
	
	Date now = calendar.getTime();
	
	@Transactional
	public List<ParkingEvent> findAll() {
		return this.parkingEventDAO.findAll();
	}

	@Transactional
	public void save(ParkingEvent parkingEvent) {
		this.parkingEventDAO.makePersistent(parkingEvent);
		
	}

	@Transactional
	public List<ParkingEvent> findOccupied() {
		return this.parkingEventDAO.findOccupied();
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