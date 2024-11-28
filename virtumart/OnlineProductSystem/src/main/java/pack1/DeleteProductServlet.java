package pack1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;

import Common.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "session expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		}else {
			ArrayList<ProductBean> al= (ArrayList<ProductBean>) hs.getAttribute("alist");
			String pcode=req.getParameter("pcode");
			Iterator<ProductBean> it=al.iterator();
			while(it.hasNext()) {
				ProductBean pb= (ProductBean)it.next();
				if(pcode.equals(pb.getProduct_code())) {
					it.remove();
				 
				int k=new DeleteProductDAO().delete(pb);
				if(k>0) {
					req.setAttribute("msg", "product updated successfully");
					req.getRequestDispatcher("DeleteProduct.jsp").forward(req, resp);
				}else {
					req.setAttribute("msg", "unable to update the data");
					req.getRequestDispatcher("Msg.jsp").forward(req, resp);
				}
				break;
				
				}
			}
			
		}
	}
}
