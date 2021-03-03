package org.dp.restclient.api.domain;

import java.io.Serializable;

public class Geo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4716912154874329051L;

	public String lat;
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String lng;
}
