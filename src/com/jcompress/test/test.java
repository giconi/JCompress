package com.jcompress.test;

import java.util.Date;

import java.net.URL;
import java.net.URLClassLoader;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
 

public class test {
	
	public static void main(String[] args) {  

	 //creating configuration object  
		ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
        	System.out.println(url.getFile());
        }
    Configuration cfg = new Configuration(); 
    
    cfg.configure();//populates the data of the configuration file  
    
    
    //creating seession factory object  
    SessionFactory factory=cfg.buildSessionFactory();  
      
    //creating session object  
    Session session=factory.openSession();  
      
    //creating transaction object  
    Transaction t=session.beginTransaction();  
          
    event e1=new event();  
    
    e1.setTitle("test1");  
    e1.setDate(new Date());  
      
    session.persist(e1);//persisting the object  
      
    t.commit();//transaction is commited  
    session.close();  
      
    System.out.println("successfully saved");  
    
	}

}
