package vn.edu.iuh.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class Persistentce <T>{
	protected EntityManager em;

	public Persistentce() {
		em=Persistence.createEntityManagerFactory("QLPhim").createEntityManager();
	}
	public boolean save (T t) {
		EntityTransaction tr=em.getTransaction();
		try {

			tr.begin();
			em.persist(t);
			tr.commit();
			return true;
		}catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean update (T t) {
		EntityTransaction tr=em.getTransaction();
		try {

			tr.begin();
			em.merge(t);
			tr.commit();
			return true;
		}catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean delete (T t) {
		EntityTransaction tr=em.getTransaction();
		try {

			tr.begin();
			em.remove(t);
			tr.commit();
			return true;
		}catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
		
	}
	

}
