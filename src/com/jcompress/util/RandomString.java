package com.jcompress.util;

import java.util.Random;

public class RandomString{

	private String rstring;

	private String GenRandomString(){
		
		String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		
	    Random rand=new Random();
	    StringBuilder res=new StringBuilder("a");
	    		
	    for (int i = 0; i < 10; i++) {
	    
	    	int randIndex=rand.nextInt(aToZ.length()); 
	    	res.append(aToZ.charAt(randIndex));            
	    
	    }

	    return res.toString();
	}
	
	public void setRandomString(){
		
		this.rstring = GenRandomString(); 
	}

	public String getRandomString(){
		return this.rstring;
		
	}
	
}



	

