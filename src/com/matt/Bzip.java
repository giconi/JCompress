package com.matt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

public class Bzip {
	
	public Bzip(File fname) throws IOException{

	FileInputStream in = null;
	try {
		in = new FileInputStream(fname.getAbsoluteFile());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	BZip2CompressorOutputStream out = null;
	try {
		out = new BZip2CompressorOutputStream(new FileOutputStream(fname+".bz2"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	final byte[] buffer = new byte[4*1024];
	int n = 0;
	try {
		while (-1 != (n = in.read(buffer))) {
		  out.write(buffer, 0, n);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	out.close();
	in.close();
	
	}
	
}
