package pack1;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/ViewAllProductServlet")
public class ViewAllProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		
		if(hs==null) {
			req.setAttribute("msg", "session Expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		}else {
			ArrayList<ProductBean> al=new ViewAllProductDAO().retrive();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("ViewAllProduct.jsp").forward(req, resp);
		}
	}
}
