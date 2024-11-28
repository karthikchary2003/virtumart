package pack2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack1.DeleteProductDAO;
import pack1.ProductBean;
@WebServlet("/RemoveItemsFromCart")
public class CartItemRemoveServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "session expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		}else {
			ArrayList<ViewCartBean> vcl= (ArrayList<ViewCartBean>) hs.getAttribute("vlist");
			String pcode=req.getParameter("pcode");
			Iterator<ViewCartBean> it=vcl.iterator();
			while(it.hasNext()) {
				ViewCartBean vcb= (ViewCartBean)it.next();
				if(pcode.equals(vcb.getProduct_code())) {
					it.remove();
				 
				int k=new CartItemRemoveDAO().deleteitem(vcb);
				if(k>0) {
					req.setAttribute("msg", "product updated successfully");
					req.getRequestDispatcher("removecart.jsp").forward(req, resp);
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
