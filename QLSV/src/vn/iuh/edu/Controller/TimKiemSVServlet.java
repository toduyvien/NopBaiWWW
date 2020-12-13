package vn.iuh.edu.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iuh.edu.Dao.SinnhVienDAO;
import vn.iuh.edu.Model.Student;

/**
 * Servlet implementation class TimKiemSVServlet
 */
@WebServlet("/timkiemsv")
public class TimKiemSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiemSVServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/timkiemsvView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String batdau=request.getParameter("batdau");
		String ketthuc=request.getParameter("ketthuc");

		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Date ngaysinh1=null;
		Date ngaysinh2=null;
		try {
			ngaysinh1=df.parse(batdau);
			ngaysinh2=df.parse(ketthuc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SinnhVienDAO svdao=new SinnhVienDAO();
		List<Student>dssv=svdao.getAll();
		List<Student> list=new ArrayList<Student>();
		for(Student sv : dssv)
			if(sv.getNgaysinh().after(ngaysinh1)&& sv.getNgaysinh().before(ngaysinh2)) {
				list.add(sv);
			}
		request.setAttribute("dssv", list);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/timkiemsvView.jsp");
		dispatcher.forward(request, response);
	}

}
