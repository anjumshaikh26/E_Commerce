package com.velocity.ecommerceapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistrationImpl implements UserRegister  {

	Scanner scanner=new Scanner(System.in);
	 
	@Override
	public void getUserData() {
		// Get user details for registration
		
		System.out.println("Enter First Name:");
		String fname=scanner.next();
		System.out.println("Enter Last Name:");
		String lname=scanner.next();
		System.out.println("Enter Username:");
		String uname=scanner.next();
		System.out.println("Enter Password:");
		String pswd=scanner.next();
		System.out.println("Enter City Name:");
		String city=scanner.next();
		System.out.println("Enter Mailid:");
		String mid=scanner.next();
		System.out.println("Enter Mobile Number:");
		String mnum=scanner.next();
		saveUserData(fname,lname,uname,pswd,city,mid,mnum);
		
	}

		
	
	//save Data in Database
	@Override
	public void saveUserData(String fname, String lname, String uname, String password, String city, String mail,
			String mob) {
		GetConnection getconnect=new GetConnection();
		Connection con;
		try {
			con = getconnect.setConnect();
			PreparedStatement ps=con.prepareStatement("insert into user(firstname,lastname,"
					+ "username,password,city,mailid,mobile)values(?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, uname);
			ps.setString(4, password);
			ps.setString(5, city);
			ps.setString(6, mail);
			ps.setString(7, mob);
			int a=ps.executeUpdate();
			System.out.println("Data inserted"+a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

					
			
	



		@Override
		public void getLogin() {
			//taking login credentials from user
			System.out.println("Enter Username");
			String uname=scanner.next();
			System.out.println("Enter Password");
			String pass=scanner.next();
			
			//calling checklogin method
			checkLogin(uname,pass);
			
		}



		@Override
		public void checkLogin(String uname, String pass)  {
		
			//checking the user entered login details with database
			GetConnection getconnect=new GetConnection();
			Connection con;
			try {
				con = getconnect.setConnect();
				PreparedStatement ps=con.prepareStatement("select username,password from user where username=? OR password=?");
				ps.setString(1, uname);
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					String username=rs.getString("username");
					String password=rs.getString("password");
				
					if(uname.equals(username) && pass.equals(password))
					{
						System.out.println("Login successfully");
						
					}
					else
					{
						System.out.println("Incorrect credentials!!!");
					}
					
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}









		

}
