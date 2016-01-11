package com.matt;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
	
	final static Logger logger = LogManager.getFormatterLogger(Compressor.class);

	File fname;
	String output;
	List<String> listOfFiles;

	
	public Zip(List<String> fname){
		
		logger.info("Got to the ZIP");
		this.listOfFiles = fname ;
		System.out.println("thelistoffiles: "+fname);
		compress();	
	}
	
	private boolean compress(){
		
	byte[] buffer = new byte[1024];
	System.out.print(listOfFiles.size());
    	
    	try{	
    		FileOutputStream fos = new FileOutputStream("/var/tmp/filetesting/test1.zip");
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		
    		
    		
    		for (int i = 0; i <listOfFiles.size(); i++) {			
    			File f = new File(listOfFiles.get(i));    			
    			ZipEntry ze = new ZipEntry(f.getAbsolutePath());
    			zos.putNextEntry(ze);
    			FileInputStream in = new FileInputStream(f.getAbsolutePath());
    			int len;
    			while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    			}
        		in.close();
    		}	
    		zos.closeEntry();
    		//remember close it
    		zos.close();
    		}catch(IOException ex){
    	   ex.printStackTrace();
    	}
			
		return true;
	}
}
