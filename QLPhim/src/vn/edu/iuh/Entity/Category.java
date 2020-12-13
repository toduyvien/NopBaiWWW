package vn.edu.iuh.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ma;
	private String ten;
	private String mota;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.EAGER , mappedBy = "category")
	private List<Film>dsFilm;

	public Category() {
		super();
	}   
	public Integer getMa() {
		return this.ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}   
	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}   
	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}
	public List<Film> getDsFilm() {
		return dsFilm;
	}
	public void setDsFilm(List<Film> dsFilm) {
		this.dsFilm = dsFilm;
	}
   
}
