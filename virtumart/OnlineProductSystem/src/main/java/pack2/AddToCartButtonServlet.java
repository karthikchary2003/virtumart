package pack2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addItemsToCart")
public class AddToCartButtonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "session expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("UserAddTOCart.jsp").forward(req, resp);
			
		}
	}
	
}
