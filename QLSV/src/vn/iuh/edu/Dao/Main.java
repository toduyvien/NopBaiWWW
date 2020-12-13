package vn.iuh.edu.Dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import vn.iuh.edu.Model.Lop;
import vn.iuh.edu.Model.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LopDAO  lopdao=new LopDAO();
		SinnhVienDAO sihviendao=new  SinnhVienDAO();
		
		
		Lop lop1=new Lop("12A1");
		Lop lop2=new Lop("12A2");
		lopdao.save(lop1);
		lopdao.save(lop2);
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Date ngay1=null;
		Date ngay2=null;
		Date ngay3=null;
		try {
			ngay1=df.parse("10/02/1998");
			ngay2=df.parse("25/12/1998");
			ngay3=df.parse("10/10/2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Student sv1= new  Student("Vien", "Nam", ngay1);
		Student sv2= new  Student("Truong", "Nam", ngay2);
		Student sv3= new  Student("Huy", "Nam", ngay3);
		
		sv1.setLop(lop1);
		sv2.setLop(lop1);
		sv3.setLop(lop2);
		
		sihviendao.save(sv1);
		sihviendao.save(sv2);
		sihviendao.save(sv3);
	}

}
