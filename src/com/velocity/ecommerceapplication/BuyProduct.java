package com.velocity.ecommerceapplication;

import java.sql.SQLException;
import java.util.Scanner;

public class BuyProduct {
	Cart c=new Cart();
	public void userBuyProduct() throws SQLException
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the product id to buy product>>");
		int id=scanner.nextInt();
		c.getProductdetails(id);
		
		System.out.println("Do you want to Add product to Cart? (Yes/No)>>");
		String ans=scanner.next();
		
		if("Yes".equals(ans)||"yes".equals(ans) ||"y".equals(ans)||"Y".equals(ans))
		 {
		
		System.out.println("Enter the quantity>>");
		int quantity=scanner.nextInt();
		c.updateItemquantity(id,quantity);
		
		System.out.println("Do you want to view cart (Yes/No)>>");
		String decision=scanner.next();
		if("Yes".equals(decision)||"yes".equals(decision) ||"y".equals(decision)||"Y".equals(decision))
		 {
			
			c.AddCart(id,quantity);
			
			
		  //System.out.println("Added into cart");
		 }
	}
	}
}
