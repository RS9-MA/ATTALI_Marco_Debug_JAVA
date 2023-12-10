package com.hemebiotech.analytics;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
			    String symptom = "Symptoms";
			    BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
			    writer.write(symptom);
			    
			    writer.close();
			}
}