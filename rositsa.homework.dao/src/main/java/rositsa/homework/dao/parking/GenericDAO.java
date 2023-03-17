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

	/**
	 * Finds by ID
	 * 
	 * @param id - the id
	 * 
	 * @param lock - the lock
	 * 
	 * @return Hibernate object
	 */
	public T findById(PK id, boolean lock);

	/**
	 * List all
	 * 
	 * @return list
	 */
	public List<T> findAll();

	/**
	 * FInd by example
	 * 
	 * @param exampleInstance - example
	 * 
	 * @return list
	 */
	public List<T> findByExample(T exampleInstance);
	
	/**
	 * Persist
	 * 
	 * @param entity - the object
	 * 
	 * @return object
	 */
	public T makePersistent(T entity);

	/**
	 * Delete object
	 * 
	 * @param entity - object
	 */
	void makeTransient(T entity);
	
}
