package com.assignment.dao;

 import java.sql.SQLException;
import java.util.List;

import com.assignment.entity.Product;

public interface ProductDao extends BaseDao {
	public List<Product> getProducts(String catname) throws SQLException;
}
