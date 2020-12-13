package vn.edu.iuh.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class TinTucPersistence<T> {
	
	protected EntityManager em;
	
	public TinTucPersistence(){
		em=Persistence.createEntityManagerFactory("QLTT").createEntityManager();
	}
	public boolean save(T t) {
		EntityTransaction tr = em.getTransaction();

		try {

			tr.begin();
			em.persist(t);
			tr.commit();
			return true;
		} catch (Exception ex) {
			tr.rollback();
			ex.printStackTrace();
		}

		return false;

	}

	public boolean delete(T t) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.remove(t);
			tr.commit();
			return true;
		} catch (Exception ex) {
			tr.rollback();
		}

		return false;
	}

	public boolean update(T t) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.merge(t);
			tr.commit();
			return true;
		} catch (Exception ex) {
			tr.rollback();
		}
		
		return false;

	}

}
