package vn.iuh.edu.Model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Lop
 *
 */
@Entity

public class Lop implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer malop;
	private String tenlop;
	
	@OneToMany(mappedBy = "lop",fetch = FetchType.EAGER)
	private List<Student> dsSinhVien;
	private static final long serialVersionUID = 1L;

	public Lop() {
		super();
	}   
	public int getMalop() {
		return this.malop;
	}

	public void setMalop(int malop) {
		this.malop = malop;
	}   
	public String getTenlop() {
		return this.tenlop;
	}

	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	public List<Student> getDsSinhVien() {
		return dsSinhVien;
	}
	public void setDsSinhVien(List<Student> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}
	public Lop(String tenlop) {
		super();
		this.tenlop = tenlop;
	}
	
   
}
