package com.jcompress.core;

import java.io.File;

import com.jcompress.compressions.CompressionChooser;
import com.jcompress.compressions.zipCompress;


public class CompressorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		if(args.length!=3){
			
			System.out.print("Three params - in out type");
			return;
		}
		
		CompressionChooser c = new CompressionChooser() ;
		
		Compressor matt = c.whatToDo.get(args[2]);
		
		File InputFile = new File(args[0]);
		matt.setOutPutFile(args[1]);
		matt.setCompressionType(args[2]);
		matt.setFileList(InputFile);
		matt.compressFiles();
		
		System.out.print("done");
		
	}

}
