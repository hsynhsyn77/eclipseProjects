package com.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.vendor.Database;

public class MySqlCustomerDal implements ICustomerDal{
	
	@Value("${database.connectionString}")
	String connectionString;
	
	public String getConnectionString() {
		return connectionString;
	}



	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}



	@Override
	public void add() {
		System.out.println("Conntection String :"+this.connectionString);
		System.out.println("MySql veritabanına eklendi.");
		
	}
	
}
