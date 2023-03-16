package rositsa.homework.service;

import java.text.SimpleDateFormat;
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


	@Autowired
	protected ParkingEventDao parkingEventDAO;

	Calendar calendar = Calendar.getInstance();

	Date now = calendar.getTime();

	@Transactional
	public ParkingEvent get(Long id) {
		ParkingEvent parkingEvent = this.parkingEventDAO.findById(id, false);
		return parkingEvent;
	}


	@Transactional
	public ParkingEvent get(String plateNumber) {
		ParkingEvent parkingEvent = this.parkingEventDAO.findByPlateNumber(plateNumber);
		return parkingEvent;
	}

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

	@Transactional
	public ParkingEvent enterParking(String plateNumber, String type) throws FullParkingException {

		if (ParkingEvent.TYPE_CAR.equalsIgnoreCase(type)) {
			int findOccupiedCarSpots =  this.parkingEventDAO.findOccupiedCarSpots().size();
			if (CAR_SPOTS > findOccupiedCarSpots) {
				ParkingEvent parkingEvent = new ParkingEvent();
				parkingEvent.setPlateNumber(plateNumber);
				parkingEvent.setType(type);
				parkingEvent.setStartTime(now);
				this.save(parkingEvent);
				return parkingEvent;
			} else {
				throw new FullParkingException("Parking is full. The capacity for cars is " + CAR_SPOTS + ".");
			}
		}

		if (ParkingEvent.TYPE_BUS.equalsIgnoreCase(type)) {
			int findOccupiedBusSpots =  this.parkingEventDAO.findOccupiedBusSpots().size();;
			if (BUS_SPOTS > findOccupiedBusSpots) {
				ParkingEvent parkingEvent = new ParkingEvent();
				parkingEvent.setPlateNumber(plateNumber);
				parkingEvent.setType(type);
				parkingEvent.setStartTime(now);
				this.save(parkingEvent);
				return parkingEvent;
			} else {
				throw new FullParkingException("Parking is full. The capacity for busses is " + BUS_SPOTS + ".");
			}
		}
		
		throw new IllegalArgumentException("The parking is not for " + type + ".");

	}

	@Transactional
	public ParkingEvent exitParking(String plateNumber) {
		
		ParkingEvent parkingEvent = this.parkingEventDAO.findByPlateNumber(plateNumber);
		parkingEvent.setEndTime(now);
		

		long millisSpentTime = parkingEvent.getEndTime().getTime() - parkingEvent.getStartTime().getTime();
		
		float spentMinutes = millisSpentTime / (1000*60);
		
		
		System.out.println("spent time in minutes: " + spentMinutes);
		System.out.println("spent time in hours: " + spentMinutes / 60);
		
		double roundHours = Math.ceil(spentMinutes / 60);
		
		System.out.println("spent time in round hours: " + roundHours);
		parkingEvent.setSpentTime(roundHours);
		
		if (ParkingEvent.TYPE_CAR.equalsIgnoreCase(parkingEvent.getType())) {
			parkingEvent.setPaidSumm(roundHours * ParkingEventService.PRICE_CAR_1H);
		} else if (10.0 <= roundHours &&  roundHours <= 24.0) {
			parkingEvent.setPaidSumm(ParkingEventService.PRICE_CAR_24H);
		}
		
		this.save(parkingEvent);
		return parkingEvent;
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


	@Transactional
	public int findFreeCarSpots() {
		int size = this.parkingEventDAO.findOccupiedCarSpots().size();
		return CAR_SPOTS - size;
	}


	@Transactional
	public int findFreeBusSpots() {
		int size = this.parkingEventDAO.findOccupiedBusSpots().size();
		return BUS_SPOTS - size;
	}

}