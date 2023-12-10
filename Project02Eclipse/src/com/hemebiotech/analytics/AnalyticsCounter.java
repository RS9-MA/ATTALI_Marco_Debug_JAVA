package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalyticsCounter {
	private static final Logger logger = Logger.getLogger("AnalyticsCounter");
	private static int headacheCount = 0;
	private static int rashCount = 0;		
	private static int pupilCount = 0;		
	
	public static void main(String[] args) throws Exception {
		try(BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
			FileWriter writer = new FileWriter ("result.out");){
			String line = reader.readLine();

			while (line != null) {
				logger.log(Level.INFO, "Something went wrong: {0} ", line);
				if (line.equals("headache")) {
					headacheCount++;
					logger.log(Level.INFO, "number of headaches: {0}", headacheCount);
				}
				else if (line.equals("rash")) {
					rashCount++;
				}
				else if (line.equals("dialated pupils")) {
					pupilCount++;
				}

				line = reader.readLine();
			}
			
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
		}
		catch(Exception e) {
			logger.log(Level.WARNING, "Impossible to read file {0} ", e.getMessage());
		}
	}
}
