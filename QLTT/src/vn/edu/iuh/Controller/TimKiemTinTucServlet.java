package vn.edu.iuh.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.iuh.Dao.DanhMucDao;
import vn.edu.iuh.Dao.TinTucDao;
import vn.edu.iuh.Model.DanhMuc;
import vn.edu.iuh.Model.TinTuc;

/**
 * Servlet implementation class TimKiemTinTucServlet
 */
@WebServlet("/timTinTuc")
public class TimKiemTinTucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiemTinTucServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/timtintuctheomsTT.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matt=request.getParameter("ma");
				
		TinTucDao tinTucDao=new TinTucDao();
		
		TinTuc tintuc=tinTucDao.findById(Integer.parseInt(matt));

		request.setAttribute("tt", tintuc);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/timtintuctheomsTT.jsp");
		dispatcher.forward(request, response);
	}

}
