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
 * Servlet implementation class ThemTinTucController
 */
@WebServlet("/themTinTuc")
public class ThemTinTucController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemTinTucController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DanhMucDao danhmucDAO = new DanhMucDao();
		List<DanhMuc> dsdm = danhmucDAO.getAll();
		
		request.setAttribute("dsdm", dsdm);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/themTTView.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tieude=request.getParameter("tieude");
		String noidung=request.getParameter("noidung");
		String lienket=request.getParameter("lienket");
		String item=request.getParameter("item");
		
		TinTucDao tinTucDao=new TinTucDao();
		DanhMucDao danhmucDao=new DanhMucDao();
		
		DanhMuc danhmuc=danhmucDao.findById(Integer.parseInt(item));
		
		TinTuc tt = new TinTuc(tieude, noidung, lienket);
		tt.setDanhmuc(danhmuc);
		  
		tinTucDao.save(tt);
		
		List<DanhMuc> dsDanhMuc =  danhmucDao.getAll();
		
		request.setAttribute("dsdm", dsDanhMuc);
		  
		response.sendRedirect("danhsachTinTuc");
	}

}
