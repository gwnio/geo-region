package io.georegion.out.impl;

import io.georegion.data.GeoRegion;

import java.util.List;

public class JavaAbbreviationMapOutputGeneratorImpl implements GeoRegionOutputGenerator {

	@Override
	public String generate(List<GeoRegion> regions) {
		String variableName = "regionMap";
		StringBuilder sb = new StringBuilder();
		sb.append("Map<String, String> " + variableName + " = new HashMap<String, String>();");
		sb.append("\n");
		for (GeoRegion region : regions) {
			sb.append(variableName).append(".put(\"" + region.getAbbreviation().toLowerCase() + "\",\"" + region.getAbbreviation().toLowerCase() + "\");");
			sb.append("\n");
		}
		for (GeoRegion region : regions) {
			sb.append(variableName).append(".put(\"" + region.getName().toLowerCase() + "\",\"" + region.getAbbreviation().toLowerCase() + "\");");
			sb.append("\n");
		}
		return sb.toString();
	}
}
