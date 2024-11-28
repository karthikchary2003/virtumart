package pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/update")
public class ProductUpdateServlet extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession hs=req.getSession(false);
	if(hs==null) {
		req.setAttribute("msg","data not updated sorry for inconvience");
		req.getRequestDispatcher("Msg.jsp").forward(req, resp);
	}else {
		ArrayList<ProductBean> al= (ArrayList<ProductBean>) hs.getAttribute("alist");
		String pcode=req.getParameter("pcode");
		Iterator<ProductBean> it=al.iterator();
		while(it.hasNext()) {
			ProductBean pb= (ProductBean)it.next();
			if(pcode.equals(pb.getProduct_code())) {
				
			pb.setProduct_price(Double.parseDouble(req.getParameter("pprice")));
			pb.setProductquantity(Integer.parseInt(req.getParameter("pquantity")));
			 
			int k=new ProductUpdateDAO().update(pb);
			if(k>0) {
				req.setAttribute("msg", "product updated successfully");
				req.getRequestDispatcher("UpdateProduct.jsp").forward(req, resp);
			}else {
				req.setAttribute("msg", "unable to update the data");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}
			
			
			}
		}
		
		
	}
		
	}
	
	
}
