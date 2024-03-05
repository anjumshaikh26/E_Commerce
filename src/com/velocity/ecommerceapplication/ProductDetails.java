package com.velocity.ecommerceapplication;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductDetails {
	ArrayList<Product> productlist=new ArrayList<Product>();
	
	public void AddProduct(int product_id,String product_name,String product_desc,int product_quantity,String product_price) throws SQLException
	{
		GetConnection getconnect=new GetConnection();
		Connection con;
		
		con = getconnect.setConnect();
		PreparedStatement ps=con.prepareStatement("insert into product(productid,name,description,price,quantity)values(?,?,?,?,?)");
		ps.setInt(1, product_id);
		ps.setString(2, product_name);
		ps.setString(3, product_desc);
		ps.setInt(4, product_quantity);
		ps.setString(5, product_price);
		int a=ps.executeUpdate();
		System.out.println("Data inserted"+a);
		
	}
	
	public void getProductDetails() throws SQLException
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product Id>>");
		int pid= Integer. parseInt(scanner. nextLine());
		System.out.println("Enter Product Name>>");
		String pname=scanner.nextLine();
		System.out.println("Enter Product Description>>");
		String pdesc=scanner.nextLine();
		System.out.println("Enter Product Quantity>>");
		int pquantity=scanner.nextInt();
		System.out.println("Enter Product Price>>");
		String pprice=scanner.next();
		AddProduct(pid,pname,pdesc,pquantity,pprice);
	}
	
	public void DisplayProduct() throws SQLException
	{
		GetConnection getconnect=new GetConnection();
		Connection con;
		con = getconnect.setConnect();
		PreparedStatement ps=con.prepareStatement("select * from product");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			int productid=rs.getInt(2);
			String productname=rs.getString(3);
			String productdesc=rs.getString(4);
			String productprice=rs.getString(5);
			int productquantity=rs.getInt(6);
			productlist.add(new Product(productid,productname,productdesc,productprice,productquantity));
		}
			Collections.sort(productlist, new NameComparator());//sort product data as per product name
			for(Product p:productlist)
			{
			System.out.println("Product ID is>>>"+p.getProduct_id());
			System.out.println("Product Name is>>>"+p.getProduct_name());
			System.out.println("Product Description is>>>"+p.getProduct_desc());
			System.out.println("Product Price is>>>"+p.getProduct_price());
			System.out.println("Product Quantity is>>>"+p.getProduct_quantity());
			System.out.println("");
			}
		}
	}
	




