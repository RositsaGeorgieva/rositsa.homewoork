package rositsa.homework.dao.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import rositsa.homework.core.ParkingEvent;
import rositsa.homework.dao.parking.ParkingEventDao;


/**
 * Hibernate implementation of the business DAO operations related to the <tt>PerkingEvent</tt> entity.
 * 
 * @see rositsa.homework.core.ParkingEvent;
 * 
 * @version $ID:$
 * 
 * @author rositsa
 * 
 * @since 1.0
 */
@Repository
public class ParkingEventDaoImpl extends GenericHibernateDAO<ParkingEvent, Serializable> implements ParkingEventDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<ParkingEvent> findAll() {
		Query query = getSession().createQuery("FROM ParkingEvent ORDER BY id DESC");
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ParkingEvent> findOccupied() {
		Query query = getSession().createQuery("FROM ParkingEvent WHERE endTime IS null ORDER BY id DESC");
		return query.list();
	}

	@Override
	public ParkingEvent findByPlateNumber(String plateNumber) {
		Query query = getSession().createQuery("FROM ParkingEvent WHERE plateNumber LIKE :plateNumber ORDER BY id DESC");
		query.setParameter("plateNumber", plateNumber);
		query.setFirstResult(0);
		query.setMaxResults(1);
		return (ParkingEvent) query.uniqueResult();
	}
	
	@Override
	public ParkingEvent findEnteredByPlateNumber(String plateNumber) {
		Query query = getSession().createQuery("FROM ParkingEvent WHERE plateNumber LIKE :plateNumber AND endTime IS null");
		query.setParameter("plateNumber", plateNumber);
		return (ParkingEvent) query.uniqueResult();
	}

	
	@Override
	public List<ParkingEvent> findOccupiedCarSpots() {
		Query query = getSession().createQuery("FROM ParkingEvent WHERE endTime IS null AND type like 'CAR' ORDER BY id DESC");
		return query.list();
	}

	@Override
	public List<ParkingEvent> findOccupiedBusSpots() {
		Query query = getSession().createQuery("FROM ParkingEvent WHERE endTime IS null AND type like 'BUS' ORDER BY id DESC");
		return query.list();
	}

	/**
	 * Date start - start of the day
	 * Date end - end of the day
	 */
	@Override
	public List<ParkingEvent> findByDate(Date start, Date end) {
		Query query = getSession().createQuery("FROM ParkingEvent WHERE startTime <= :end AND (endTime >= :start OR endTime IS null) ORDER BY id DESC");
		query.setParameter("end", end);
		query.setParameter("start", start);
		return query.list();
	}
	
}