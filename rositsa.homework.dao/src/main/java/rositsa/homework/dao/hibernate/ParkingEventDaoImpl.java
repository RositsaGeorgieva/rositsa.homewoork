package rositsa.homework.dao.hibernate;

import java.io.Serializable;
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
 * @author rosy@inerty.com
 * 
 * @since 1.0
 */
@Repository
public class ParkingEventDaoImpl extends GenericHibernateDAO<ParkingEvent, Serializable> implements ParkingEventDao {

	
}