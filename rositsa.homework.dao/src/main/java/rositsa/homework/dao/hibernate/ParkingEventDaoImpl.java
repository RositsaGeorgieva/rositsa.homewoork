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
		Query query = getSession().createQuery("FROM ParkingEvent WHERE plateNumber LIKE :plateNumber");
		query.setParameter("plateNumber", plateNumber);
		return (ParkingEvent) query.uniqueResult();
	}
	
}