package com.velocity.ecommerceapplication;

import java.sql.SQLException;

public interface UserRegister {
	public void getUserData();
	public void saveUserData(String fname,String lname,String uname,String password,String city,String mail,String mob);
	public void getLogin();
	public void checkLogin(String uname,String pass);
	

}
