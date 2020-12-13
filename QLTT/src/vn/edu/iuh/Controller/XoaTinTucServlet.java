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
 * Servlet implementation class XoaTinTucServlet
 */
@WebServlet("/xoaTinTuc")
public class XoaTinTucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaTinTucServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matt=request.getParameter("id");		
		
		TinTucDao tinTucDao=new TinTucDao();
		DanhMucDao danhmucDao=new DanhMucDao();
		TinTuc tintuc=tinTucDao.findById(Integer.parseInt(matt));	
						
		tinTucDao.delete(tintuc);
		
		List<DanhMuc> dsDanhMuc =  danhmucDao.getAll();
		
		request.setAttribute("dsdm", dsDanhMuc);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/danhsachTTView.jsp");
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
