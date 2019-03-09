package com.capgemini.salesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.exceptions.InvalidProductCodeException;
import com.capgemini.salesmanagement.utility.DatabaseConnection;

//Class that implements the methods of IProductDao interface
public class ProductDao implements IProductDao {

	DatabaseConnection databaseConnection = new DatabaseConnection();
	ProductBean productBean = new ProductBean();
	Connection connection = databaseConnection.database();

	public ProductBean getProductDetails(int productCode) {
		int flag = 0;
		try {

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");

			while (rs.next()) {
				if (rs.getInt(1) == productCode) {
					productBean.setProduct_code(productCode);
					productBean.setProduct_name(rs.getString(2));
					productBean.setProduct_category(rs.getString(3));
					productBean.setProduct_description(rs.getString(4));
					productBean.setProduct_price(rs.getInt(5));
					flag++;
				}
			}
			if (flag == 0)
				try {
					throw new InvalidProductCodeException();
				} catch (InvalidProductCodeException e) {
					System.exit(0);
				}
		} catch (SQLException e) {
			
		}
		return productBean;
	}


	public boolean insertSalesDetails(ProductBean productBean) {
		// LocalDate now = LocalDate.now();
		boolean ret = false;
		int id = 2000 + new Random().nextInt(10000);
		try {
			//System.out.println("Updating");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into sales values(?,?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, productBean.getProduct_code());
			preparedStatement.setInt(3, productBean.getQuantity());
			preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
			preparedStatement.setInt(5, productBean.getQuantity() * productBean.getProduct_price());
			preparedStatement.executeUpdate();
			ret = true;
			//System.out.println("Updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
