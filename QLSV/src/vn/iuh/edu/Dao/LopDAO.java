package vn.iuh.edu.Dao;

import java.util.List;

import javax.persistence.Query;

import vn.iuh.edu.Model.Lop;

public  class LopDAO extends Persistentce<Lop>{
	public Lop findByID(int id) {
		return em.find(Lop.class, id);
	}
	public List<Lop> getAll(){
		String hql="from Lop";
		Query q=em.createQuery(hql);
		return q.getResultList();
	}

}
