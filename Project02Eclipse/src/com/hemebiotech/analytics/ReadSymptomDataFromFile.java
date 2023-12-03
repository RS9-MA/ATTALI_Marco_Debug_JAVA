package com.hemebiotech.analytics;

//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();

		if (filepath == null) {
			throw new IllegalArgumentException("filepath is null");
		}

		try (Stream<String> stream = Files.lines(Paths.get(filepath))) {
			stream.filter(line -> line != null).forEach(line -> result.add(line));
		} catch (IOException e) {
			System.out.println("Error while reading file: " + e.getMessage());
		}

		/*
		 * try { BufferedReader reader = new BufferedReader(new FileReader(filepath));
		 * String line = reader.readLine();
		 * 
		 * while (line != null) { result.add(line); line = reader.readLine(); }
		 * reader.close(); }catch (IOException e) { e.printStackTrace(); }
		 */

		return result;
	}

}
