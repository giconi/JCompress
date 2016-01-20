package com.jcompress.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileList {

	private List<String> fileList = new ArrayList<String>();
	
	public boolean GenerateRecursiveFileList(File node){
		
		if(node.isFile()){
			getFileList().add(node.getAbsolutePath());
		}
		
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){					
				GenerateRecursiveFileList(new File(node, filename));
			}
		}
		
		return true;
	}

	public List<String> getFileList() {
		return fileList;
	}

	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}	
}
