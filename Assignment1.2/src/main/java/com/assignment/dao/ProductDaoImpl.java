package com.assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.assignment.util.DBUtils.getConnection;
import com.assignment.entity.Product;

public class ProductDaoImpl implements ProductDao {

	
	private Connection cn;
	private PreparedStatement ps;
	
	
	public ProductDaoImpl() throws SQLException {
		cn=getConnection();
		ps = cn.prepareStatement("SELECT p.* FROM products p JOIN categories c ON p.category_id = c.category_id WHERE c.category_name = ?");
	}
	@Override
	public void cleanUp() throws SQLException {
		// TODO Auto-generated method stub
		if(cn!=null) {
			cn.close();
			cn=null;
		}
		if(ps!=null) {
			ps.close();
			ps=null;
			
		}

	}

	@Override
	public List<Product> getProducts(String catname) throws SQLException {
		// TODO Auto-generated method stub
        List<Product> list = new ArrayList<>();
        ps.setString(1, catname);
		try (ResultSet rs = ps.executeQuery()) {
		    while (rs.next()) {

		        int id = rs.getInt("product_id");
		        String name = rs.getString("product_name");
		        int categoryId = rs.getInt("category_id");
		        double price = rs.getDouble("price");
		        int stock = rs.getInt("stock");
		        String desc = rs.getString("description");

				list.addLast(
		            new Product(id, name, categoryId, price, stock, desc)
		        );
		    }
		    return list;
		}
		
 	}

}
