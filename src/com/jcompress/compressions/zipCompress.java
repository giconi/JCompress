package com.jcompress.compressions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.jcompress.core.Compress;
import com.jcompress.core.Compressor;

public class zipCompress extends Compressor implements Compress {
	
	@Override
	public void compressFiles(){
	
	byte[] buffer = new byte[1024];
    	
    	try{	
    		FileOutputStream fos = new FileOutputStream(getOutPutFile());
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		
    		List<String> listOfFiles = getFileList();
    		
 
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
	}





}
