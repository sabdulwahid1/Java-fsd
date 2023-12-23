package com.pd.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pd.entity.Product;
import com.pd.resource.ProductResource;

public class ProductDAO {
	
	public int storeProduct(Product p) {
		try {
		SessionFactory sf = ProductResource.getSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tt = session.getTransaction();
		
		tt.begin();
		
		session.save(p);
		
		tt.commit();
		
		return 1;
		
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public List<Product> retriveAllProducts(){
	
	try {
		SessionFactory sf = ProductResource.getSessionFactory();
		
		Session session = sf.openSession();
		
		TypedQuery tq = session.createQuery("from Product");
		
		List<Product> listofProduct = tq.getResultList();
		
		return listofProduct;
		
	}catch(Exception e) {
		return null;
	}
	}
}
