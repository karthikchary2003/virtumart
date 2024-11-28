package pack2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;

import Common.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack1.AddProductDAO;
import pack1.ProductBean;
import pack1.ProductUpdateDAO;

@WebServlet("/addtocart")
public class UserAddToCartServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String pcode=req.getParameter("pcode");
		String pname=req.getParameter("pname");
		double pprice=Double.parseDouble(req.getParameter("pprice"));
		int pquantity =Integer.parseInt(req.getParameter("pquantity"));
	
		
		
		
		try {
			Connection c = DBConnection.getCon();
			PreparedStatement ps = c.prepareStatement("INSERT INTO ADDTOCART58  VALUES(?,?,?,?)");
			ps.setString(1, pcode);
			ps.setString(2, pname);
			ps.setDouble(3, pprice);
			ps.setInt(4, pquantity);
			
			int k=ps.executeUpdate();
			if(k>0) {
//				System.out.println(k);
				RequestDispatcher rd=req.getRequestDispatcher("cart.jsp");
						rd.include(req, resp);
			}else {
				resp.setContentType("text/html");
				out.println("<h3 style='color:red'>User registered failed</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("Msg.jsp");
						rd.include(req, resp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
