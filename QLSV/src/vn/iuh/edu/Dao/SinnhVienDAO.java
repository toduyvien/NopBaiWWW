package vn.iuh.edu.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import vn.iuh.edu.Model.Student;

public class SinnhVienDAO extends Persistentce<Student>{
	public Student findByID(int id) {
		return em.find(Student.class, id);
	}
	public List<Student> getAll(){
		String hql="from Student";
		Query q=em.createQuery(hql);
		return q.getResultList();
	}
	public List<Student> getAllmalop(int malop){
		List<Student> list=this.getAll();
		List<Student> sv=new ArrayList<Student>();
		
		for(Student sinhvien : list) {
			if(sinhvien.getLop().getMalop()==malop)
				sv.add(sinhvien);
		}
		return sv;
		
	}
}
