package com.pd.resource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductResource {
	
	static SessionFactory sf;
	
	static {
		Configuration con = new Configuration();
		
		con.configure("hibernate.cfg.xml");
		
		sf = con.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		
		try {
			return sf;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

}
