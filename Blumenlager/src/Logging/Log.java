package Logging;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*Logger für das Blumenlager*/
public class Log {
	
	public Logger logger;
	FileHandler fh;
	private static Log log;
	
	private Log(String fileName) throws Exception{
		
		File file = new File(fileName);
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		fh = new FileHandler(fileName, true);
		logger = Logger.getLogger("BlumenlagerLogger");
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
	}
	
	public static Log getInstance(String fileName) throws Exception{
		if(log == null){
			log = new Log(fileName);
		}
		return log;
	}

}
