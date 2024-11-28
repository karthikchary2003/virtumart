package pack1;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);// it value false takes the existing session 
		
		String pcode=req.getParameter("pcode");
		String pname=req.getParameter("pname");
		double pprice= Double.parseDouble(req.getParameter("pprice"));
		int pquantity=Integer.parseInt(req.getParameter("pquantity"));
		if(hs==null) {
			req.setAttribute("Msg", "session Expired");
			RequestDispatcher rd=req.getRequestDispatcher("Msg.jsp");
			rd.forward(req, resp);
		}else {
			ProductBean pb =new ProductBean();
		
				pb.setProduct_code(pcode);
				pb.setProduct_name(pname);
				pb.setProduct_price(pprice);
				pb.setProductquantity(pquantity);
				
				 int k = new AddProductDAO().insert(pb);
				if(k>0) {
					req.setAttribute("msg", "data entered successffully");
					RequestDispatcher rd=req.getRequestDispatcher("AddproductSuccess.jsp");
					rd.forward(req, resp);
				}else {
					req.setAttribute("msg", "data Not entered successffully");
					RequestDispatcher rd=req.getRequestDispatcher("Msg.jsp");
					rd.include(req, resp);
				}
		}

		
		
		
		
		
	}
	
}
