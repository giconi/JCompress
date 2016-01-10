package com.matt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;

import org.apache.logging.log4j.*;


public class Compressor	 {
	
	private File fname;
	private String type;

	final static Logger logger = LogManager.getFormatterLogger(Compressor.class);


	public Compressor(String[] args) {
		// TODO Auto-generated constructor stub
		
		fname = new File(args[0]);
		type = args[1];
					
	}
	
	public void Run() throws Exception{
	
			
		if(!validateFile()){
			logger.error("Problem with file validation");
			throw new Exception();
		}
		
		if(!validateCompression()){
			logger.error("Problem with compression selection");
			throw new Exception();	
		}
		
		
		AbstractCompress ac = new AbstractCompress();
		ac.process(this.fname, this.type);
		
	}
	
	private List<String> getCompressionList(){

		List<String> compressionList = new ArrayList<String>();
		
		compressionList.add("zip");
		compressionList.add("tar");
		compressionList.add("gzip");
		compressionList.add("bzip");
		
		
		return compressionList;
		
	}
	
	private boolean validateCompression(){
		if(!getCompressionList().contains(this.type)){
			try{
				logger.error("Compression type %s not available",this.type);
				throw new Exception();
			}catch (Exception e){
				e.printStackTrace();
			}		
			return false;
		}
		logger.info("Compression type %s selected",this.type);
		
		
		
		return true;
	}

	private boolean validateFile() {
		// TODO Auto-generated method stub	
		if(!this.fname.canRead()){	
			try {
				logger.error("Cannot read %s",this.fname);
				throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			return false;
		}		
		
		logger.info("Can read %s",this.fname.getAbsoluteFile());
		
		if(fname.length()==0){
			try{
				logger.error("Cannot read %s",this.fname);
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}
		
		logger.info("The file is %s bytes",this.fname.length());
		
		return true;
	}

	private void logConfigure() {
		// TODO Auto-generated method stub
		
		
		
	}
	
}
