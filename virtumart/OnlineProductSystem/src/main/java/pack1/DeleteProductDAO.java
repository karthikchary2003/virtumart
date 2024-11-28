package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Common.DBConnection;

public class DeleteProductDAO {
	int k=0;
	public int delete(ProductBean pb) {


		try {
			Connection c=DBConnection.getCon();
			PreparedStatement ps=c.prepareStatement("DELETE FROM product58 WHERE PCODE=?");
			ps.setString(1, pb.getProduct_code());
			k=	ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;

	}


}
