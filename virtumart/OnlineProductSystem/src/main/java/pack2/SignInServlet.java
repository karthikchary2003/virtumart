package pack2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Common.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String fname=req.getParameter("firstname");
		String lname=req.getParameter("lastname");
		String uname=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String phno=req.getParameter("phonenumber");
		String address=req.getParameter("address");
		
		
		
		try {
			Connection c = DBConnection.getCon();
			PreparedStatement ps = c.prepareStatement("INSERT INTO USERTAB58 VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, password);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, address);
			ps.setString(6, email);
			ps.setString(7, phno);
			
			int k=ps.executeUpdate();
			if(k>0) {
			
				RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
//				resp.setContentType("text/html");
//				out.println("<h3 style='color:green'>User registered Successfully</h3>");
						rd.include(req, resp);
			}else {
				resp.setContentType("text/html");
				out.println("<h3 style='color:red'>User registered failed</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("SignIn.jsp");
						rd.include(req, resp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
