package io.georegion.out.impl;

import io.georegion.data.GeoRegion;

import java.util.List;

public interface GeoRegionOutputGenerator {

	public String generate(List<GeoRegion> regions);
}
