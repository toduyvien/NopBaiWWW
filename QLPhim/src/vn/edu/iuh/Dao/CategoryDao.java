package vn.edu.iuh.Dao;

import java.util.List;

import javax.persistence.Query;

import vn.edu.iuh.Entity.Category;

public class CategoryDao extends Persistentce<Category>{
	public Category findById(int id) {
		return em.find(Category.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getAll(){
		String hql = "FROM Category";
		Query q = em.createQuery(hql);
		
		return q.getResultList();
		
		
	}

}
