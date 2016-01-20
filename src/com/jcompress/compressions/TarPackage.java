package com.jcompress.compressions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;

import com.jcompress.core.Compress;
import com.jcompress.core.Compressor;

public class TarPackage extends Compressor implements Compress {

	@Override
	public void compressFiles() {
		// TODO Auto-generated method stub
	     OutputStream tar_output = null;
	     
	     List<String> fname = getFileList();
	     
		try {
			tar_output = new FileOutputStream(new File("/var/tmp/filetesting/tarfile"+".tar"));
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
        /* Create Archive Output Stream that attaches File Output Stream / and specifies TAR as type of compression */
        ArchiveOutputStream my_tar_ball = null;
		try {
			my_tar_ball = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.TAR, tar_output);
		} catch (ArchiveException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        /* Create Archieve entry - write header information*/
		for (int i = 0; i <fname.size(); i++) {			

			
		
        File tar_input_file= new File(fname.get(i)).getAbsoluteFile();
        TarArchiveEntry tar_file = new TarArchiveEntry(tar_input_file);
        /* length of the TAR file needs to be set using setSize method */
        tar_file.setSize(tar_input_file.length());
        try {
			my_tar_ball.putArchiveEntry(tar_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			IOUtils.copy(new FileInputStream(tar_input_file), my_tar_ball);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /* Close Archieve entry, write trailer information */
        try {
			my_tar_ball.closeArchiveEntry();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /* Repeat steps for the next file that needs to be added to the TAR */
		}
     
        /* Close output stream, our files are zipped */
        try {
			tar_output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
