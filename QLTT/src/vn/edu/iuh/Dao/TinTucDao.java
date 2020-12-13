package vn.edu.iuh.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import vn.edu.iuh.Model.TinTuc;

public class TinTucDao extends TinTucPersistence<TinTuc>{

	public TinTuc findById(int id) {
		return em.find(TinTuc.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<TinTuc> getAll(){
		String hql = "FROM TinTuc";
		Query query = this.em.createQuery(hql);
		return query.getResultList();
	}
	
	
	public List<TinTuc> getTinTucByMaDM (int madm){
		List<TinTuc> list = new ArrayList<TinTuc>();
		List<TinTuc> tt = this.getAll();
		
		for (TinTuc tinTuc : tt) {
			if(tinTuc.getDanhmuc().getMadm() == madm) {
				list.add(tinTuc);
			}
			
		}
		
		return list;
	}
}
