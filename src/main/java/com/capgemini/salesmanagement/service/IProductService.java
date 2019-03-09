package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.exceptions.InvalidProductCodeException;

public interface IProductService {

	ProductBean getProductDetails(int productCode);
	boolean insertSalesDetails(ProductBean product);
}
