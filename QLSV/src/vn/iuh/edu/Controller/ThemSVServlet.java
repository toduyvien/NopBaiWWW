package vn.iuh.edu.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iuh.edu.Dao.LopDAO;
import vn.iuh.edu.Dao.SinnhVienDAO;
import vn.iuh.edu.Model.Lop;
import vn.iuh.edu.Model.Student;

/**
 * Servlet implementation class ThemSVServlet
 */
@WebServlet("/themsv")
public class ThemSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSVServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LopDAO  lopdao=new LopDAO();
		
		List<Lop> dslop = lopdao.getAll();
	
		request.setAttribute("dslop", dslop);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/themsvView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ten =  request.getParameter("tensv");
		String gioitinh =  request.getParameter("gioitinh");
		String ngaysinh =  request.getParameter("ngaysinh");
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		String id = request.getParameter("lop");
		
		Date ngaysinh1=null;
		try {
			ngaysinh1=df.parse(ngaysinh);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student sv= new Student(ten, gioitinh, ngaysinh1);
		LopDAO lopdao=new LopDAO();
		Lop lop=lopdao.findByID(Integer.parseInt(id));
		SinnhVienDAO svdao=new SinnhVienDAO();
		sv.setLop(lop);
		svdao.save(sv);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/danhsachsvView.jsp");
		dispatcher.forward(request, response);
	}

}
