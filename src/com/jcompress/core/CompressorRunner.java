package com.jcompress.core;
import java.io.File;

import com.jcompress.compressions.CompressionChooser;
import com.jcompress.compressions.TarPackage;


public class CompressorRunner {

	
	public void MakeItSo(String inputfile, String compression, String outputfile){
		
		File InputFile = new File(inputfile);
		CompressionChooser c = new CompressionChooser() ;
		Compressor matt = c.whatToDo.get(compression);
		if(matt.tarFirst()==true){
			
			Compressor tarFirst = new TarPackage();
			
			tarFirst.setOutPutFile(inputfile);
			tarFirst.setCompressionType("tar");
			tarFirst.setFileList(InputFile);
			tarFirst.compressFiles();
			
			matt.setOutPutFile(tarFirst.getOutPutFile());
			matt.setCompressionType(outputfile);
			matt.setFileList(new File(tarFirst.getOutPutFile()));
			System.out.println(matt.getOutPutFile());
			matt.compressFiles();
			
			matt.moveOutputFIle(new File(matt.getOutPutFile()), outputfile);
			
		}else{
				
			matt.setOutPutFile(inputfile);
			matt.setCompressionType(compression);
			matt.setFileList(InputFile);
			matt.compressFiles();
			matt.moveOutputFIle(new File(matt.getOutPutFile()), outputfile);
		
		}
		
	}
		
		
	}
	
