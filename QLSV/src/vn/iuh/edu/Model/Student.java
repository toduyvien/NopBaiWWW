package vn.iuh.edu.Model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SinhVien
 *
 */
@Entity

public class Student implements Serializable {

	   
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer masv;
	private String tensv;
	private String gioitinh;
	
	@Temporal(TemporalType.DATE)
	private Date ngaysinh;
	@ManyToOne
	@JoinColumn(name="malop")
	private Lop lop;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}   
	public int getMasv() {
		return this.masv;
	}

	public void setMasv(int masv) {
		this.masv = masv;
	}   
	public String getTensv() {
		return this.tensv;
	}

	public void setTensv(String tensv) {
		this.tensv = tensv;
	}   
	public String getGioitinh() {
		return this.gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public Lop getLop() {
		return lop;
	}
	public void setLop(Lop lop) {
		this.lop = lop;
	}
	public Student(String tensv, String gioitinh, Date ngaysinh) {
		super();
		this.tensv = tensv;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
	}
	
   
}
