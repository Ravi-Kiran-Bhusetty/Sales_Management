package com.capgemini.salesmanagement.exceptions;

public class InvalidProductCodeException extends Exception{

	public InvalidProductCodeException()
	{
		System.err.println("Product Doesn't Exist");
	}
}
