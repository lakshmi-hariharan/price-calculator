package com.lh.costanalysis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class ProductJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product Product = new Product();
			Product.setItemID(rs.getLong("itemID"));
			Product.setItemName(rs.getString("itemName"));
			Product.setItemCost(rs.getDouble("itemCost"));
			return Product;
		}

    }
    


	public List<Product> findAll() {
		return jdbcTemplate.query("select * from Product", new ProductRowMapper());
	}

	public Product findById(long id) {
		return jdbcTemplate.queryForObject("select * from Product where itemID=?", new Object[] { id },
				new BeanPropertyRowMapper<Product>(Product.class));
    }
    
    
    

	public int deleteById(long id) {
		return jdbcTemplate.update("delete from Product where itemID=?", new Object[] { id });
	}

	public int insert(Product Product) {
		return jdbcTemplate.update("insert into Product (itemID, itemName, itemCost) " + "values(?,  ?, ?)",
				new Object[] { Product.getItemID(), Product.getItemName(), Product.getItemCost() });
	}

	public int update(Product Product) {
		return jdbcTemplate.update("update Product " + " set itemName = ?, itemCost = ? " + " where itemID = ?",
				new Object[] { Product.getItemName(), Product.getItemCost(), Product.getItemID() });
	}
    
   
}