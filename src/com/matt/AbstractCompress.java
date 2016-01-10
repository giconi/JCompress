package com.matt;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.matt.Zip;


public class AbstractCompress {

	public void process(File file,String type){
		
		createCompress(file, type);
		
	}

	private void createCompress(File param1, String param2) {
		// TODO Auto-generated method stub		
		
		String className = param2 ;
		className = "com.matt."+Character.toUpperCase(className.charAt(0)) + className.substring(1); 

		Object xyz = null;
	
		Class cl = null;
		try {
			cl = Class.forName(className);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Constructor con = null;
		try {
			con = cl.getConstructor(File.class);
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			xyz = con.newInstance(param1);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
}