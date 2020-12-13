package vn.edu.iuh.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Film
 *
 */
@Entity

public class Film implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer maphim;
	private String tenphim;
	private String mota;
	private String thoiluong;
	private String url;
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	private Date ngaykhoichieu;
	
	@ManyToOne
	@JoinColumn(name = "ma")
	private Category category;

	public Film() {
		super();
	}   
	public Integer getMaphim() {
		return this.maphim;
	}

	public void setMaphim(Integer maphim) {
		this.maphim = maphim;
	}   
	public String getTenphim() {
		return this.tenphim;
	}

	public void setTenphim(String tenphim) {
		this.tenphim = tenphim;
	}   
	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}   
	public String getThoiluong() {
		return this.thoiluong;
	}

	public void setThoiluong(String thoiluong) {
		this.thoiluong = thoiluong;
	}   
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public Date getNgaykhoichieu() {
		return ngaykhoichieu;
	}
	public void setNgaykhoichieu(Date ngaykhoichieu) {
		this.ngaykhoichieu = ngaykhoichieu;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Film(String tenphim, String mota, String thoiluong, String url, Date ngaykhoichieu) {
		super();
		this.tenphim = tenphim;
		this.mota = mota;
		this.thoiluong = thoiluong;
		this.url = url;
		this.ngaykhoichieu = ngaykhoichieu;
	}
   
}
