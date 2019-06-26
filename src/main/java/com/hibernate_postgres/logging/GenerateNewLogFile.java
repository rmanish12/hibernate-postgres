package com.hibernate_postgres.logging;

import java.io.File;

import org.apache.log4j.FileAppender;

public class GenerateNewLogFile extends FileAppender{
	
	@Override
	public void activateOptions() {
		String fileName = "testLogger.log";
		
		try {
			File file = new File(fileName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
