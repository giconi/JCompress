package com.jcompress.core;

import java.io.File;
import java.util.List;

public interface Compress {

	public List<String> getFileList();
	public void setCompressionType(String Compression);
	public String getCompressionType();
	public void compressFiles();
	public void setFileList(File InputFile);
	public void setOutPutFile(String OutputFile);
	public String getOutPutFile();
	
}
