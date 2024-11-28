package pack2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Common.DBConnection;
import pack1.ProductBean;

public class UserViewCartDAO {


ArrayList<ViewCartBean> vcl=new ArrayList<ViewCartBean>();
	
	public ArrayList<ViewCartBean> retriveCart(){
		Connection c = DBConnection.getCon();
		try {
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM ADDTOCART58");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				ViewCartBean vcb=new ViewCartBean();
				
				vcb.setProduct_code(rs.getString(1));
				vcb.setProduct_name(rs.getString(2));
				vcb.setProduct_price(rs.getDouble(3));
				vcb.setProductquantity(rs.getInt(4));
				vcl.add(vcb);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vcl;
		
	}
	
}
