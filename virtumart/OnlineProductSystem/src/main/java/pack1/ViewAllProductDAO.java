package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Common.DBConnection;

public class ViewAllProductDAO {
	
 ArrayList<ProductBean> al=new ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> retrive(){
		Connection c = DBConnection.getCon();
		try {
			
			PreparedStatement ps = c.prepareStatement("select * from product58");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				ProductBean pb=new ProductBean();
				
				pb.setProduct_code(rs.getString(1));
				pb.setProduct_name(rs.getString(2));
				pb.setProduct_price(rs.getDouble(3));
				pb.setProductquantity(rs.getInt(4));
				al.add(pb);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return al;
		
	}
	
}
