package com.matt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.*;

import org.apache.logging.log4j.*;

public class Compressor	 {
	
	private File fname;
	private String type;
	private List<String> listOfFiles;
	List<String> fileList = new ArrayList<String>();
	private String oname;

	final static Logger logger = LogManager.getFormatterLogger(Compressor.class);


	public Compressor(String[] args) {
		// TODO Auto-generated constructor stub
		
		if(args.length==0){
			logger.error("No arguments set.  Need at least a file.");
			return;
		};
		if(args.length==1){
			fname = new File(args[0]);
			this.type = user_menu();			
		}
		if(args.length==2){
			fname = new File(args[0]);
			this.type = args[1];
		}
		if(args.length==3){
			fname = new File(args[0]);
			this.type = args[1];
			this.oname = args[2];

			
		}
		
	}
	
	private String user_menu() {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		List<String> compressionList = getCompressionList();
		for (int i = 0; i < compressionList.size(); i++) {			
			System.out.println(i+". "+compressionList.get(i).toString());
		}
		System.out.println("Select compression type: ");
		int n = reader.nextInt();
		reader.close();
		return compressionList.get(n).toString();
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
		
		System.out.print(this.fileList);
		
		ac.process(this.fileList, this.type);
		
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
	
    public boolean generateFileList(File node){

    	//add file only
    	
		
		System.out.println("a file");

	if(node.isFile()){
		System.out.println("a file");
		fileList.add(node.getAbsoluteFile().toString());
	}
		
	if(node.isDirectory()){
		logger.info("Is a directory");
		String[] subNote = node.list();
		//System.out.println("SubNote "+subNote);
		for(String filename : subNote){
						
			generateFileList(new File(node, filename));
		}
	}
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
		
		generateFileList(fname);
		
		//logger.info("The file is %s bytes",this.fname.length());
		
		return true;
	}

	private void logConfigure() {
		// TODO Auto-generated method stub
		
		
		
	}
	
}
