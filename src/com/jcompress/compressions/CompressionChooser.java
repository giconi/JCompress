package com.jcompress.compressions;

import java.util.HashMap;
import java.util.Map;

import com.jcompress.core.Compressor;

public class CompressionChooser {

	
	public Map<String, Compressor> whatToDo = new HashMap<>();
	{
	    // Populate my map.
	    whatToDo.put("zip", new zipCompress());
	    whatToDo.put("gzip", new GzipCompress());
	    whatToDo.put("tar", new TarPackage());
	    whatToDo.put("bz2", new BzipCompress());

	}
	
}
