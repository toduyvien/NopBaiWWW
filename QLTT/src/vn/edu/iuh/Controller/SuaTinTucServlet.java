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
 * Servlet implementation class SuaTinTunServlet
 */
@WebServlet(urlPatterns =  "/suaTinTuc" )
public class SuaTinTucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaTinTucServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matt=request.getParameter("id1");
		TinTucDao tinTucDao=new TinTucDao();
		
		
		TinTuc tintuc= tinTucDao.findById(Integer.parseInt(matt));
		request.setAttribute("tt", tintuc);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/suaTTView.jsp");
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
		
		String matt=request.getParameter("matt");
		
		TinTucDao tinTucDao=new TinTucDao();
		
		
		TinTuc tintuc= tinTucDao.findById(Integer.parseInt(matt));
		
		tintuc.setTieude(tieude);
		tintuc.setNoidung(noidung);
		tintuc.setLienket(lienket);
		
		tinTucDao.update(tintuc);
		
		response.sendRedirect("danhsachTinTuc");
		
		
	}

}
