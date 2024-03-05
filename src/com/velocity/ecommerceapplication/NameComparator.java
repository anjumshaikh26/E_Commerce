package com.velocity.ecommerceapplication;

import java.util.Comparator;

public class NameComparator implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		return p1.product_name.compareTo(p2.product_name);
	}

}
