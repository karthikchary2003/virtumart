package pack2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/user")
public class UserLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("uname");
		String password = req.getParameter("pword");
		PrintWriter out = resp.getWriter();
		UserBean ub;
		try {
			 ub = new UserLoginDAO().login(username, password);
			 if (ub == null) {
					req.setAttribute("msg", "Invalid Credentials");
					RequestDispatcher rd = req.getRequestDispatcher("Msg.jsp");
					rd.forward(req, resp);
				} else {
					HttpSession s = req.getSession(); //
					s.setAttribute("ubean", ub); //
					s.setAttribute("username", username);
					req.getRequestDispatcher("UserLoginSuccess.jsp").forward(req, resp);
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}

}
