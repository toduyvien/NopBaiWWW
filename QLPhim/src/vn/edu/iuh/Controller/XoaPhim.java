package vn.edu.iuh.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.iuh.Dao.CategoryDao;
import vn.edu.iuh.Dao.FlimDao;
import vn.edu.iuh.Entity.Category;
import vn.edu.iuh.Entity.Film;

/**
 * Servlet implementation class XoaPhim
 */
@WebServlet("/xoaFilm")
public class XoaPhim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaPhim() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		FlimDao filmDAO = new FlimDao();
		CategoryDao categoryDao = new CategoryDao();
		Film phim = filmDAO.findById(Integer.parseInt(id));
		
		
			
		filmDAO.delete(phim);
		List<Category> dsTheLoai = categoryDao.getAll();
		
		request.setAttribute("dstl", dsTheLoai);
		
		response.sendRedirect("danhsachPhim");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
