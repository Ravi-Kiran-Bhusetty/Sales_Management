package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.dao.IProductDao;
import com.capgemini.salesmanagement.dao.ProductDao;
import com.capgemini.salesmanagement.exceptions.InvalidProductCodeException;


//Class that implements the methods of IProductService interface
public class ProductService implements IProductService{

	IProductDao productDao = new ProductDao();
	
	public ProductBean getProductDetails(int productCode) {
		return productDao.getProductDetails(productCode);
	}

	public boolean insertSalesDetails(ProductBean productBean) {
		return productDao.insertSalesDetails(productBean);
	}

}
