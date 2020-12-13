package vn.edu.iuh.Model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TinTuc
 *
 */
@Entity

public class TinTuc implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matt;
	private String tieude;
	private String noidung;
	private String lienket;
	
	@ManyToOne
	@JoinColumn(name="madm")
	private DanhMuc danhmuc;
	
	private static final long serialVersionUID = 1L;

	public TinTuc() {
		super();
	}   
	public int getMatt() {
		return this.matt;
	}

	public void setMatt(int matt) {
		this.matt = matt;
	}   
	public String getTieude() {
		return this.tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}   
	public String getNoidung() {
		return this.noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}   
	public String getLienket() {
		return this.lienket;
	}

	public void setLienket(String lienket) {
		this.lienket = lienket;
	}
	public TinTuc(String tieude, String noidung, String lienket) {
		super();
		this.tieude = tieude;
		this.noidung = noidung;
		this.lienket = lienket;
	}
	public DanhMuc getDanhmuc() {
		return danhmuc;
	}
	public void setDanhmuc(DanhMuc danhmuc) {
		this.danhmuc = danhmuc;
	}
   
}
