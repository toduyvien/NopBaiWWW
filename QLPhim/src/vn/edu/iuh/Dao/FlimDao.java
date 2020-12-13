package vn.edu.iuh.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import vn.edu.iuh.Entity.Film;

public class FlimDao extends Persistentce<Film>{
	public Film findById(int id) {
		return em.find(Film.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Film> getAll(){
		String hql="from Film";
		Query q=em.createQuery(hql);
		return q.getResultList();
		
	}
	public List<Film> getFilmByCategory (int ma){
		List<Film> list = new ArrayList<Film>();
		 list = this.getAll();
		
		for (Film film : list) {
			if(film.getCategory().getMa() == ma) {
				list.add(film);
			}
			
		}
		return list;
	}	
	
}
	
