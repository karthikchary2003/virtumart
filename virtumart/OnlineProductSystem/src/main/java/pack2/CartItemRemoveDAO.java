package pack2;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Common.DBConnection;
import pack1.ProductBean;

public class CartItemRemoveDAO {
	int k=0;
	public int deleteitem(ViewCartBean vcb) {


		try {
			Connection c=DBConnection.getCon();
			PreparedStatement ps=c.prepareStatement("DELETE FROM ADDTOCART58 WHERE PCODE=?");
			ps.setString(1, vcb.getProduct_code());
			k=	ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;

	}
}
