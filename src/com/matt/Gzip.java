package com.matt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.GZIPOutputStream;


public class Gzip {
	
	public Gzip(List<String> fname){

    byte[] buffer = new byte[1024];
    
    try{

   	GZIPOutputStream gzos = 
   		new GZIPOutputStream(new FileOutputStream("/var/tmp/filetesting/testfile.gzip"));

   	
	for (int i = 0; i <fname.size(); i++) {			

       FileInputStream in = 
           new FileInputStream(new File(fname.get(i)).getAbsoluteFile());

       int len;
       while ((len = in.read(buffer)) > 0) {
       	gzos.write(buffer, 0, len);
       }

       in.close();
	}
   	
   	gzos.finish();
   	gzos.close();

   	System.out.println("Done");
   	
   }catch(IOException ex){
      ex.printStackTrace();   
   }
  }
	
}
