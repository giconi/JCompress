package com.jcompress.core;

import com.jcompress.core.CompressorRunner;


public class CompressorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		if(args.length!=3){
			
			System.out.print("Three params - in outdir type");
			return;
		}
		
		String inputfile = args[0];
		String compression = args[2];
		String outputfile = args[1];
		
		CompressorRunner cr = new CompressorRunner();
		cr.MakeItSo(inputfile, compression, outputfile);
		
		System.out.println("done");
		
	}
	
}
