package com.pd.service;

import java.util.List;

import com.pd.dao.ProductDAO;
import com.pd.entity.Product;

public class ProductService {
	
	ProductDAO pd = new ProductDAO();
	
	public String storeProduct(Product p) {
		
		if(pd.storeProduct(p)>0) {
			return "Product stored Successfully";
		}
		else {
			return "Product not stored";
		}
		
	}
	
	public List<Product> retriveAllProduct(){
		
		return pd.retriveAllProducts();
		
	}

}

