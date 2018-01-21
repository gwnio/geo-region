package io.georegion.out;

import io.georegion.data.GeoRegion;
import io.georegion.out.impl.JavaAbbreviationMapOutputGeneratorImpl;
import io.georegion.out.impl.FullListOutputGeneratorImpl;
import io.georegion.out.impl.GeoRegionOutputGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;

public class RunGenerator {

	public static void main(String[] args) {
		new RunGenerator().run();
	}
	
	private List<GeoRegion> regions = new ArrayList<GeoRegion>();
	
	protected void run() {
		loadRegionsFromFile("src/main/resources/us-region.txt");
		loadRegionsFromFile("src/main/resources/us-territory.txt");
		
		if (regions.size() > 0) {
			generateFileOutput("output/regions-list.txt", new FullListOutputGeneratorImpl());
			generateFileOutput("output/regions-get-abbreviation-map.txt", new JavaAbbreviationMapOutputGeneratorImpl());
		}
	}
	
	private void loadRegionsFromFile(String filename) {
		try {
			Scanner sc = new Scanner(new File(filename));
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			sc.close();
			
			for (String line : lines) {
				GeoRegion region = new GeoRegion();
				int count = 0;
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				while (tokenizer.hasMoreTokens()) {
					String token = tokenizer.nextToken();
					if (count == 0) {
						region.setAbbreviation(token);
					} else {
						region.setName(token);
					}
					count++;
				}
				regions.add(region);
			}
		} catch (FileNotFoundException e) {
		}
	}
	
	private void generateFileOutput(String filename, GeoRegionOutputGenerator outputGenerator) {
		String output = outputGenerator.generate(regions);
		try {
			File file = new File(filename);
			FileUtils.writeStringToFile(file, output);
		} catch (IOException e) {
			
		}
	}
}
