package com.matt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;


public class Gzip {
	
	public Gzip(File fname){

    byte[] buffer = new byte[1024];
    
    try{

   	GZIPOutputStream gzos = 
   		new GZIPOutputStream(new FileOutputStream(fname.getAbsoluteFile()+".gzip"));

       FileInputStream in = 
           new FileInputStream(fname.getAbsoluteFile());

       int len;
       while ((len = in.read(buffer)) > 0) {
       	gzos.write(buffer, 0, len);
       }

       in.close();
   	
   	gzos.finish();
   	gzos.close();

   	System.out.println("Done");
   	
   }catch(IOException ex){
      ex.printStackTrace();   
   }
  }
	
}
