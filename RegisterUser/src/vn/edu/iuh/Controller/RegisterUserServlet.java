package vn.edu.iuh.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.iuh.DB.ConnectionUtils;
import vn.edu.iuh.Model.User;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher= request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String ten=request.getParameter("name");
		String matkhau=request.getParameter("password");
		String reemail=request.getParameter("reemail");
		
		ConnectionUtils db=new ConnectionUtils();
		
		if (email.equals(reemail)) {
			User user=new User(email,ten,matkhau);
			db.insertUser(user);
			
			request.setAttribute("user",user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ResultForm.jsp");
			rd.forward(request, response);
		}
	}

}
