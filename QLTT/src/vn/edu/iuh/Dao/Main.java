package vn.edu.iuh.Dao;

import java.util.List;

import vn.edu.iuh.Model.DanhMuc;
import vn.edu.iuh.Model.TinTuc;

public class Main {

	
		public static void main(String[] args) {

			DanhMucDao danhmucDAO = new DanhMucDao();

			TinTucDao tintucDAO = new TinTucDao();

			
			  DanhMuc dm = new DanhMuc("kinh te", "nql1", "xyz");
			  
			  danhmucDAO.save(dm);
			  
			  TinTuc tt = new TinTuc("tieu de1", "noi dung 1", "http://vnexpress.net");
			  tt.setDanhmuc(dm);
			  TinTuc tt1 = new TinTuc("tieu de2", "noi dung 2", "http://vnexpress.net");
			  tt1.setDanhmuc(dm);
			  
			  tintucDAO.save(tt);
			  tintucDAO.save(tt1);
			 
			
			List<TinTuc> list =  tintucDAO.getTinTucByMaDM(1);
			list.forEach(ttt->System.out.println(ttt));

		}
}
