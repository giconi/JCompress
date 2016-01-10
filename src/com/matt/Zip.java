package com.matt;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
	
	final static Logger logger = LogManager.getFormatterLogger(Compressor.class);

	File fname;
	String output;
	
	public Zip(File fname){
		
		logger.info("Got to the ZIP");
		this.fname = fname ;
		
		compress();
		
	}
	
	private boolean compress(){
		
	byte[] buffer = new byte[1024];
    	
    	try{
    		
    		FileOutputStream fos = new FileOutputStream(this.fname.getAbsoluteFile()+".zip");
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		ZipEntry ze= new ZipEntry(this.fname.getAbsolutePath());
    		zos.putNextEntry(ze);
    		FileInputStream in = new FileInputStream(this.fname.getAbsolutePath());
   	   
    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}

    		in.close();
    		zos.closeEntry();
           
    		//remember close it
    		zos.close();
          
    		System.out.println("Done");

    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
		
		
		
		return true;
		
		
		
	}
	

}
