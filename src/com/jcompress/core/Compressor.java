package com.jcompress.core;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import com.jcompress.util.FileList;


public abstract class Compressor implements Compress  {

	String compression;
	List<String> fileList = new ArrayList<String>();
	String OutputFile;

	
	public void setCompressionType(String compression) {
		// TODO Auto-generated method stub
		this.compression = compression ;
		
	}

	public void setFileList(File InputFile) {
		// TODO Auto-generated method stub
		FileList fileList = new FileList();
		fileList.GenerateRecursiveFileList(InputFile);
		this.fileList = fileList.getFileList();
	}

	public List<String> getFileList() {
		// TODO Auto-generated method stub
		return this.fileList;
		
	}

	public String getCompressionType() {
		// TODO Auto-generated method stub
		return this.compression;
	}

	public void setOutPutFile(String OutputFile){
		this.OutputFile = OutputFile + fileExtension();
	}
	
	public String getOutPutFile(){		
		return this.OutputFile;		
	}
	
	public void moveOutputFIle(File output, String outputdir){
		output.renameTo(new File(outputdir+"/"+output.getName()));
		
		
	}

	public void compressFiles() {
		// TODO Auto-generated method stub
		
	}
	
	
}
