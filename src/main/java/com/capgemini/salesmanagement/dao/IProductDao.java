package com.capgemini.salesmanagement.dao;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.exceptions.InvalidProductCodeException;

public interface IProductDao {

	ProductBean getProductDetails(int productCode);
	boolean insertSalesDetails(ProductBean product);
}
