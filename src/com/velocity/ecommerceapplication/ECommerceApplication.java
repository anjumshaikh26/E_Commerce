package com.velocity.ecommerceapplication;

import java.sql.SQLException;
import java.util.Scanner;

public class ECommerceApplication {

	public static void main(String[] args) throws SQLException {

		UserRegistrationImpl u=new UserRegistrationImpl();
		ProductDetails productdetails=new ProductDetails();
		BuyProduct buyproduct=new BuyProduct();
		
		//Display choice list top user
		System.out.println("Welcome to E-Commerce based application");
		System.out.println("");
		
		System.out.println("User Operation");
		System.out.println("\t 1. User Registration");
		System.out.println("\t 2. User Login");
		System.out.println("\t 3. User view Product item as Sorted Order");
		System.out.println("\t 4. Buy Product");
		System.out.println("\t 5. View Cart");
		System.out.println("\t 6. Purchase the item");
		System.out.println("");
		
		System.out.println("Admin Operation");
		System.out.println("\t 7. Add product item");
		System.out.println("\t 8. Calculate Bill");
		System.out.println("\t 9. Display amount to End User");
		System.out.println("\t 10.Check Quantity");
		System.out.println("\t 11. Check registered user");
		System.out.println("\t 12. Check the particular user history");
		System.out.println("");
		
		System.out.println("Guest Operation");
		System.out.println("\t 13. View product item");
		System.out.println("\t 14. Not purchase item");
		System.out.println("");
	
		//taking user choice
		System.out.println("Enter Choice");
		Scanner scanner=new Scanner(System.in);
		int choice=scanner.nextInt();
		switch(choice)
		{
		case 1:
			u.getUserData();
			
			break;
		case 2:
			u.getLogin();
			break;
		
		case 3:
			productdetails.DisplayProduct();
			break;
		
		case 4: buyproduct.userBuyProduct();
			break;
		
		case 5: Cart cart=new Cart();
			//cart.viewCart();
		cart.getcartData(101);
			break;
			
		case 6:
			break;
		
		case 7:
			productdetails.getProductDetails();
			break;
		
		case 8:
			break;
			
		case 9:
			break;
		
		case 10:
			break;
		
		case 11:
			break;
		
		case 12:
			break;
		
		case 13:
			break;
		
		case 14:
			break;
			
		default :
		{
			System.out.println("invalid choice");
		}
		}
		
	}

}
