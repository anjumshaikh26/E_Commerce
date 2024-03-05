package com.velocity.ecommerceapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cart {

	GetConnection getconnect=new GetConnection();
	Connection con;
	PreparedStatement ps;
	int pquantity = 0;
	String uname = null;
	int prod_id=0;
	int pprice=0;
	
	public void AddCart(int id,int quantity) throws SQLException
	{
		
		
		
		con = getconnect.setConnect();
		 ps=con.prepareStatement("select quantity from product where productid=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			pquantity=rs.getInt("quantity");
			//uname=rs.getString("username");
			//prod_id=rs.getInt("product_id");
			//pprice=rs.getInt("price");
			//System.out.println(uname+prod_id+pprice);
		
		}
		
		
		if(quantity>pquantity)
		{
			System.out.println("Product is not available for quantity"+quantity);
			//System.out.println(uname+prod_id+pprice);
		}
		else
		{
			ps=con.prepareStatement("insert into cart(pid,pquantity)values(?,?)");
			ps.setInt(1, id);
			ps.setInt(2, quantity);
			int a=ps.executeUpdate();
			System.out.println("Item Added in Cart!"+a);
				
		}
}
	
	
	public void viewCart() throws SQLException
	{
		con = getconnect.setConnect();
		PreparedStatement ps=con.prepareStatement("select * from cart");
		//ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			String pid=rs.getString(1);
			int quantity=rs.getInt(2);
			System.out.println("Product id>>"+pid);
			System.out.println("Product Quantity>>"+quantity);
		}
		
	}
	
	
	public void getcartData(int pid)
	{
		try {
			con = getconnect.setConnect();
			ps=con.prepareStatement("select user.userid,username,product.productid,quantity,price from user inner join product on\r\n" + 
			 		"user.userid=product.productid where productid=?;");
			ps.setInt(1,pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int uid=rs.getInt("userid");
				uname=rs.getString("username");
				prod_id=rs.getInt("product_id");
				pquantity=rs.getInt("quantity");
				pprice=rs.getInt("price");
				System.out.println("Product id>>"+pid);
				System.out.println("Product Quantity>>"+pquantity);
		
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	
	public void getProductdetails(int pid)
	{
		try {
			con = getconnect.setConnect();
			ps=con.prepareStatement("select * from product where productid=?");
			ps.setInt(1,pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				/*int uid=rs.getInt("userid");
				uname=rs.getString("username");
				prod_id=rs.getInt("product_id");
				pquantity=rs.getInt("quantity");
				pprice=rs.getInt("price");*/
				System.out.println("Product Name>>"+rs.getString("name"));
				System.out.println("Product Description>>"+rs.getString("description"));
				System.out.println("Product Price>>"+rs.getInt("price"));
				System.out.println("Product Quantity>>"+rs.getInt("quantity"));
		
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void updateItemquantity(int pid,int q)
	{
		int quantity = 0;
		int newquantity=0;
		try {
			con = getconnect.setConnect();
			ps=con.prepareStatement("select quantity,price from product where productid=? ");
			ps.setInt(1,pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				 quantity=rs.getInt("quantity");
				 int price=rs.getInt("price");
				 int amount=price*q;
				 newquantity=quantity-q;
					System.out.println(newquantity);
					System.out.println(amount);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//update query to update new quantity
		try {
			con = getconnect.setConnect();
			ps=con.prepareStatement("update product set quantity=? where productid=? ");
			ps.setInt(1,newquantity);
			ps.setInt(2,pid);
			ps.executeUpdate();
			System.out.println("new quantity updated");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
