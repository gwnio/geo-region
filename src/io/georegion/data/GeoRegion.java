package io.georegion.data;

public class GeoRegion {

	private String abbreviation;
	
	private String name;
	
	public GeoRegion() {
	}
	
	public GeoRegion(String abbreviation, String name) {
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
