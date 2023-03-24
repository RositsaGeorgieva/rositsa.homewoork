package rositsa.homework.service;

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
				parkingEvent.setStartTime(new Date());
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
				parkingEvent.setStartTime(new Date());
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
		parkingEvent.setEndTime(new Date());
		
		PaymentStrategy paymentStrategy = null;
		if (ParkingEvent.TYPE_CAR.equalsIgnoreCase(parkingEvent.getType())) {
			Payment carPayment = new CarPayment();
			paymentStrategy = new PaymentStrategy(carPayment);
		} else if (ParkingEvent.TYPE_BUS.equalsIgnoreCase(parkingEvent.getType())) {
			
			Payment busPayment = new BusPayment();
			paymentStrategy = new PaymentStrategy(busPayment);
		}
		
		double calculcate = paymentStrategy.calculcate(parkingEvent.getSpentTime());
		parkingEvent.setPaidSumm(calculcate);
		
		this.save(parkingEvent);
		return parkingEvent;
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

	@Transactional
	public List<ParkingEvent> findByDate(Date start) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);
		cal.add(Calendar.HOUR, 24);
		Date end = cal.getTime();
		
		System.out.println("date 00h: " + start);
		System.out.println("date 24h: " + end);
		
		return this.parkingEventDAO.findByDate(start, end);
	}

}