package vn.edu.iuh.Model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;

/**
 * Entity implementation class for Entity: DanhMuc
 *
 */
@Entity

public class DanhMuc implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int madm;
	private String tendanhmuc;
	private String nguoiquanly;
	private String ghichu;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "danhmuc")
	private List<TinTuc> dsTinTuc;
	private static final long serialVersionUID = 1L;

	public DanhMuc() {
		super();
	}   
	public int getMadm() {
		return this.madm;
	}

	public void setMadm(int madm) {
		this.madm = madm;
	}   
	public String getTendanhmuc() {
		return this.tendanhmuc;
	}

	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}   
	public String getNguoiquanly() {
		return this.nguoiquanly;
	}

	public void setNguoiquanly(String nguoiquanly) {
		this.nguoiquanly = nguoiquanly;
	}   
	public String getGhichu() {
		return this.ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public List<TinTuc> getDsTinTuc() {
		return dsTinTuc;
	}
	public void setDsTinTuc(List<TinTuc> dsTinTuc) {
		this.dsTinTuc = dsTinTuc;
	}
	public DanhMuc(String tendanhmuc, String nguoiquanly, String ghichu) {
		super();
		this.tendanhmuc = tendanhmuc;
		this.nguoiquanly = nguoiquanly;
		this.ghichu = ghichu;
	}
	
   
}
