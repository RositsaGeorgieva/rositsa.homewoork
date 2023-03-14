package rositsa.homework.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import rositsa.homework.dao.parking.GenericDAO;



/**
 * Generic Hibernate DAO implementation.<br/>
 * 
 * @version $Id:$
 * @author inerty.com
 * 
 * @since 1.0
 * @param <T>
 * @param <ID>
 */

public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Default constructor
	 */
	public GenericHibernateDAO() {
		this.persistentClass =
			(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	/**
	 * Gets the <code>Class</code> of the persistent object
	 * @return class
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/* (non-Javadoc)
	 * @see com.partners1993.dao.GenericDAO#findById(java.io.Serializable, boolean)
	 */
	@SuppressWarnings("unchecdked")
	public T findById(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
		} else {
			entity = (T) getSession().load(getPersistentClass(), id);
		}
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.partners1993.dao.GenericDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return findByCriteria();
	}

	/* (non-Javadoc)
	 * @see com.partners1993.dao.GenericDAO#findByExample(java.lang.Object, java.lang.String[])
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example example =  Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		return crit.list();
	}
	
	/* (non-Javadoc)
	 * @see com.partners1993.dao.GenericDAO#findByExample(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance) {
		
		return findByExample(exampleInstance, new String[0]);
	}

	/* (non-Javadoc)
	 * @see com.partners1993.dao.GenericDAO#makePersistent(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public T makePersistent(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.partners1993.dao.GenericDAO#makeTransient(java.lang.Object)
	 */
	public void makeTransient(T entity) {
		getSession().delete(entity);
	}

	/**
	 * Flush hibernate session
	 */
	public void flush() {
		this.getSession().flush();
	}

	/**
	 * Clear hibernate session
	 */
	public void clear() {
		getSession().clear();
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}
	
	
	/**
	 * Get hibernate session if exists or create new one.
	 * 
	 * @return session
	 */
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	/**
	 * Set sessionFactory
	 * 
	 * @param sessionFactory -
	 * 				session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}