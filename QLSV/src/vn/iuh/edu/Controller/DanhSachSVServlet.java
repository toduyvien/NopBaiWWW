package vn.iuh.edu.Controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class DanhSachSVServlet
 */
@WebServlet("/danhsachsv")
public class DanhSachSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachSVServlet() {
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
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/danhsachsvView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
