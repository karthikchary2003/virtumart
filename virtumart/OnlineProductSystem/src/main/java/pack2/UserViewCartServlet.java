package pack2;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack1.ProductBean;
@WebServlet("/UserViewCartServlet")
public class UserViewCartServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		
		if(hs==null) {
			req.setAttribute("msg", "session Expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		}else {
			ArrayList<ViewCartBean> vcl=new UserViewCartDAO().retriveCart();
			hs.setAttribute("vlist", vcl);
			req.getRequestDispatcher("viewcart.jsp").forward(req, resp);
		}
	}
	
}
