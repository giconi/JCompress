package com.jcompress.compressions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import com.jcompress.core.Compress;
import com.jcompress.core.Compressor;

public class BzipCompress extends Compressor implements Compress {

	@Override
	public void compressFiles() {
		

			FileInputStream in = null;

			BZip2CompressorOutputStream out = null;
			try {
				out = new BZip2CompressorOutputStream(new FileOutputStream(getOutPutFile()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			final byte[] buffer = new byte[4*1024];
			
			List<String> fname = getFileList();
			
			for (int i = 0; i <fname.size(); i++) {
				
			try {
				in = new FileInputStream(new File(fname.get(i)).getAbsoluteFile());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int n = 0;
			try {
				while (-1 != (n = in.read(buffer))) {
				  out.write(buffer, 0, n);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
	
	public boolean tarFirst(){
		
		return true;
		
	}
	
	public String fileExtension(){
		
		return ".bz2";
		
	}

	
}
