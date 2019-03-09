package com.capgemini.salesmanagement.exceptions;

public class InvalidQuantityException extends Exception{

	public InvalidQuantityException()
	{
		System.err.println("Quantity should be atleast 1");
	}
}
