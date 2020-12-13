package vn.edu.iuh.Dao;

import java.util.List;

import javax.persistence.Query;

import vn.edu.iuh.Model.DanhMuc;

public class DanhMucDao extends TinTucPersistence<DanhMuc>{
	
	public DanhMuc findById(int id) {
		return em.find(DanhMuc.class, id);
	}
	
	public List<DanhMuc> getAll(){
		String hql = "FROM DanhMuc";
		Query q = em.createQuery(hql);
		
		return q.getResultList();
		
		
	}

}
