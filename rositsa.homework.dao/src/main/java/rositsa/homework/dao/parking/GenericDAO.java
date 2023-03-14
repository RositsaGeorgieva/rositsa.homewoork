package rositsa.homework.dao.parking;


import java.util.List;
import java.io.Serializable;

/**
 * An interface shared by all business data access objects.
 * <p>
 * All CRUD (create, read, update, delete) basic data access operations are
 * isolated in this interface and shared accross all DAO implementations.
 * The current design is for a state-management oriented persistence layer
 * (for example, there is no UDPATE statement function) that provides
 * automatic transactional dirty checking of business objects in persistent
 * state.
 *
 * @version $Id:$
 * @author rosy@inerty.com
 * @since 1.0
 */
public interface GenericDAO<T, PK extends Serializable> {

	public T findById(PK id, boolean lock);

	public List<T> findAll();

	public List<T> findByExample(T exampleInstance);
	
	public T makePersistent(T entity);

	void makeTransient(T entity);
	
}
