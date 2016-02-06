package com.jcompress.compressions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.GZIPOutputStream;


import com.jcompress.core.Compress;
import com.jcompress.core.Compressor;

public class GzipCompress extends Compressor implements Compress {

	@Override
	public void compressFiles(){
	
		
	   byte[] buffer = new byte[1024];
	    
	    try{

	   	GZIPOutputStream gzos = 
	   		new GZIPOutputStream(new FileOutputStream(getOutPutFile()));

	   	List<String> fileList = getFileList();	
	   	
	   	
	   	
		for (int i = 0; i <fileList.size(); i++) {			

		 
			
	       FileInputStream in = 
	           new FileInputStream(new File(fileList.get(i)).getAbsoluteFile());
	  	       
	       int len;
	       while ((len = in.read(buffer)) > 0) {
	       		gzos.write(buffer, 0, len);
	       }

	       in.close();
		}
	   	
	   	gzos.finish();
	   	gzos.close();
	   	
	   }catch(IOException ex){
	      ex.printStackTrace();   
	   }
	  }
	
	public boolean tarFirst(){
		
		return true;
		
	}
	
	public String fileExtension(){
		
		return ".gz";
		
	}

	
}
