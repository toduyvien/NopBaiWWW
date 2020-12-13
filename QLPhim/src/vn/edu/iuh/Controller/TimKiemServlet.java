package vn.edu.iuh.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.iuh.Dao.FlimDao;
import vn.edu.iuh.Entity.Film;

/**
 * Servlet implementation class TimKiemServlet
 */
@WebServlet("/timFilm")
public class TimKiemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/timkiem.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ngay=request.getParameter("ngay");
		
		FlimDao filmDao=new FlimDao();
		
		ArrayList<Film> ds=new ArrayList<Film>();

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Film> dsPhim=filmDao.getAll();
		
		for (int i = 0; i < dsPhim.size(); i++) {

			String strAfterFormat = df.format(dsPhim.get(i).getNgaykhoichieu());
		 	
			if(ngay.equals(strAfterFormat))
				ds.add(dsPhim.get(i));
		}

		request.setAttribute("dstl", ds);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/timkiem.jsp");
		dispatcher.forward(request, response);
	}

}
