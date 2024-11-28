package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		
		AdminBean ab = new AdminLoginDAO().login(username, password);
		if (ab == null) {
			req.setAttribute("msg", "Invalid Credentials");
			RequestDispatcher rd = req.getRequestDispatcher("Msg.jsp");
			rd.forward(req, resp);
		} else {
			HttpSession s = req.getSession(); //
			s.setAttribute("abean", ab); //
			s.setAttribute("username",username );
			req.getRequestDispatcher("AdminLoginSuccess.jsp").forward(req, resp);
		}

//	if(email.equals("karthik@gmail.com") && password.equals("karthik123")) {
//		HttpSession session=req.getSession();
//		session.setAttribute("email", email);
//		
//		RequestDispatcher rd=req.getRequestDispatcher("AdminLoginSuccess.jsp");
//		rd.forward(req, resp);
//	}else {
//		RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
//		rd.include(req, resp);
//		out.println("<br><p style=\"color:red;\">Invalid Credentials</p>");
//	}
//		

	}
}
