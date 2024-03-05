package com.velocity.ecommerceapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Product {
	 int product_id;
	String product_name;
	String product_price;
	int  product_quantity;
	String product_desc;
	public Product(int product_id, String product_name,String product_desc, String product_price, int product_quantity
			) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_desc = product_desc;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	
	
	
	/*
	public void addProduct() throws SQLException
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product id>>");
		product_id+=scanner.nextLine();
		System.out.println("Enter Product Name>>");
		product_name+=scanner.nextLine();
		System.out.println("Enter Product Description>>");
		product_desc+=scanner.nextLine();
		System.out.println("Enter Product Quantity>>");
		product_quantity=scanner.next();
		System.out.println("Enter Product Price>>");
		product_price=scanner.next();
		
		GetConnection getconnect=new GetConnection();
		Connection con;
		
		con = getconnect.setConnect();
		PreparedStatement ps=con.prepareStatement("insert into product(id,name,description,price,quantity)values(?,?,?,?,?)");
		ps.setString(1, product_id);
		ps.setString(2, product_name);
		ps.setString(3, product_desc);
		ps.setString(4, product_quantity);
		ps.setString(5, product_price);
		int a=ps.executeUpdate();
		System.out.println("Data inserted"+a);
		
		
	}*/
}
