package com.alm.log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.MDC;
import org.apache.log4j.spi.ErrorCode;
import org.apache.log4j.spi.LoggingEvent;
 

public class LogImplimentation extends FileAppender {
 
	private final static String DOT = ".";
	private final static String HIPHEN = "-";
	private static final String ORIG_LOG_FILE_NAME = "OrginalLogFileName";
	private String date1;

	public LogImplimentation() {
 
	}
 
	public LogImplimentation(Layout layout, String fileName,
			boolean append, boolean bufferedIO, int bufferSize) throws IOException {
		super(layout, fileName, append, bufferedIO, bufferSize);
	}

	public LogImplimentation(Layout layout, String fileName,
			boolean append) throws IOException {
		super(layout, fileName, append);
	}
 
	public LogImplimentation(Layout layout, String fileName)
			throws IOException {
		super(layout, fileName);
	}

	@Override
	public void activateOptions() {
		MDC.put(ORIG_LOG_FILE_NAME, "D:/log4j/logs.log");
		super.activateOptions();
	}
 
	@Override
	public void append(LoggingEvent event) {
		try {
			//System.out.println("Event level "+event.getLevel().toString());
			if(event.getLevel().toString().equals("FATAL"))
			{
			//System.out.println("Log4j file name "+MDC.get(ORIG_LOG_FILE_NAME));	
			//setFile(appendLevelToFileName((String) MDC.get(ORIG_LOG_FILE_NAME),
					//event.getLevel().toString()), fileAppend, bufferedIO,bufferSize);
			setFile(appendLevelToFileName("D:/log4j/logs.log",
					event.getLevel().toString()), fileAppend, bufferedIO,bufferSize);
			}
		} catch (IOException ie) {
			errorHandler.error(
					"Error occured while setting file for the log level "
							+ event.getLevel(), ie,
							ErrorCode.FILE_OPEN_FAILURE);
		}
		super.append(event);
	}
 
	private String appendLevelToFileName(String oldLogFileName, String level) {
		if (oldLogFileName != null) {
			final File logFile = new File(oldLogFileName);
			String newFileName = "";
			final String fn = logFile.getName();
			final int dotIndex = fn.indexOf(DOT);
			Date date = new Date();
			 SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
			 SimpleDateFormat ft1 = new SimpleDateFormat ("hh.mm.ss");
			 date1 = ft.format(date)+" "+ft1.format(date);
			if (dotIndex != -1) {
				// the file name has an extension. so, insert the level
				// between the file name and the extension
				newFileName = fn.substring(0, dotIndex) + HIPHEN + level + " " + date1 + DOT
						+ fn.substring(dotIndex + 1) ;
			} else {
				// the file name has no extension. So, just append the level
				// at the end.
				newFileName = fn + HIPHEN + level + " " + date1;
			}
			return logFile.getParent() + File.separator + newFileName;
		}
		return null;
	}
}