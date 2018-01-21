package io.georegion.out.impl;

import io.georegion.data.GeoRegion;

import java.util.List;

public class FullListOutputGeneratorImpl implements GeoRegionOutputGenerator {

	@Override
	public String generate(List<GeoRegion> regions) {
		StringBuilder sb = new StringBuilder();
		for (GeoRegion region : regions) {
			sb.append(region.getAbbreviation().toLowerCase());
			sb.append("\n");
		}
		for (GeoRegion region : regions) {
			sb.append(region.getName().toLowerCase());
			sb.append("\n");
		}
		return sb.toString();
	}
}
