package vn.edu.iuh.Controller;

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

import vn.edu.iuh.Dao.CategoryDao;
import vn.edu.iuh.Dao.FlimDao;
import vn.edu.iuh.Entity.Category;
import vn.edu.iuh.Entity.Film;

/**
 * Servlet implementation class ThemFilm
 */
@WebServlet("/themFilm")
public class ThemFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryDao tlDAO = new CategoryDao();
        List<Category> dstl = tlDAO.getAll();
        
        request.setAttribute("dstl", dstl);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addFilm.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tenphim = request.getParameter("tenphim");
		String mota = request.getParameter("mota");
		String thoiluong = request.getParameter("thoigianphim");
		String url = request.getParameter("url");
		String ngaykhoichieu = request.getParameter("ngaykhoichieu");
		String maloaiphim = request.getParameter("matheloai");
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Date ngaynhap = null;
		try {
			ngaynhap = df.parse(ngaykhoichieu);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		FlimDao filmDAO = new FlimDao();
		CategoryDao categoryDao = new CategoryDao();
		Category category = categoryDao.findById(Integer.parseInt(maloaiphim));
		
		Film phim = new Film(tenphim, mota, thoiluong, url, ngaynhap);
		phim.setCategory(category);
			
		filmDAO.save(phim);
		List<Category> dsTheLoai = categoryDao.getAll();
		
		request.setAttribute("dstl", dsTheLoai);
		
		response.sendRedirect("danhsachPhim");
		
		
	}

}
