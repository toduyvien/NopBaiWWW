package vn.edu.iuh.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.iuh.Dao.TinTucDao;
import vn.edu.iuh.Model.TinTuc;

/**
 * Servlet implementation class TimTinTucDMServlet
 */
@WebServlet("/timTinTucDM")
public class TimTinTucDMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimTinTucDMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/timkiemTTView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String madm=request.getParameter("ma");
		
		
		TinTucDao tinTucDao=new TinTucDao();
		
		List<TinTuc> listtintuc=tinTucDao.getTinTucByMaDM(Integer.parseInt(madm));
		
		
		
		
		request.setAttribute("list", listtintuc);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/timkiemTTView.jsp");
		dispatcher.forward(request, response);
	}

}
