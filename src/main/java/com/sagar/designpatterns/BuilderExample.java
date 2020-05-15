package com.sagar.designpatterns;

import java.util.List;

/**
 * 
 * Problem : <br>
 * 1. Too many constructor arguments.<br>
 * 2. Incorrect object state. Incident(startLatitude,endLatitude ...) -- Here we
 * can end up switching values while creating Incident object using constructor
 * 
 * Example StringBuilder
 * 
 * @author sitapsha
 *
 */
public class BuilderExample {

	public static void main(String[] args) {
		Incident.Builder incidentBuilder = new Incident.Builder("1");

		Incident incident = incidentBuilder.startLatitude(12.123).startLongitude(12.123).endLatitude(31.3133)
				.endLongitude(43.13).altitude(23.12).eventCode(401).build();
		System.out.println(incident);
	}

}

class Incident {

	private Incident() {
		// so that incident object is created using builder only
	}

	private String incidentId;
	private double startLatitude;
	private double startLongitude;
	private double endLatitude;
	private double endLongitude;
	private double altitude;
	private int eventCode;
	private List<String> links;
	private List<String> tmcs;

	public String getIncidentId() {
		return incidentId;
	}

	public double getStartLatitude() {
		return startLatitude;
	}

	public double getStartLongitude() {
		return startLongitude;
	}

	public double getEndLatitude() {
		return endLatitude;
	}

	public double getEndLongitude() {
		return endLongitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public int getEventCode() {
		return eventCode;
	}

	public List<String> getLinks() {
		return links;
	}

	public List<String> getTmcs() {
		return tmcs;
	}

	@Override
	public String toString() {
		return "Incident [incidentId=" + incidentId + ", startLatitude=" + startLatitude + ", startLongitude="
				+ startLongitude + ", endLatitude=" + endLatitude + ", endLongitude=" + endLongitude + ", altitude="
				+ altitude + ", eventCode=" + eventCode + ", links=" + links + ", tmcs=" + tmcs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(altitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(endLatitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(endLongitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + eventCode;
		result = prime * result + ((incidentId == null) ? 0 : incidentId.hashCode());
		result = prime * result + ((links == null) ? 0 : links.hashCode());
		temp = Double.doubleToLongBits(startLatitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(startLongitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tmcs == null) ? 0 : tmcs.hashCode());
		return result;
	}

	public static class Builder {

		private String incidentId;
		private double startLatitude;
		private double startLongitude;
		private double endLatitude;
		private double endLongitude;
		private double altitude;
		private int eventCode;
		private List<String> links;
		private List<String> tmcs;

		// id is mandatory.
		public Builder(String id) {
			this.incidentId = id;
		}

		public Incident build() {
			Incident incident = new Incident();
			incident.incidentId = this.incidentId;
			incident.startLatitude = this.startLatitude;
			incident.startLongitude = this.startLongitude;
			incident.endLatitude = this.endLatitude;
			incident.endLongitude = this.endLongitude;
			incident.altitude = this.altitude;
			incident.eventCode = this.eventCode;
			incident.links = this.links;
			incident.tmcs = this.tmcs;

			return incident;
		}

		public Builder startLatitude(double startLatitude) {
			this.startLatitude = startLatitude;
			return this;
		}

		public Builder startLongitude(double startLongitude) {
			this.startLongitude = startLongitude;
			return this;
		}

		public Builder endLongitude(double endLongitude) {
			this.endLongitude = endLongitude;
			return this;
		}

		public Builder endLatitude(double endLatitude) {
			this.endLatitude = endLatitude;
			return this;
		}

		public Builder altitude(double altitude) {
			this.altitude = altitude;
			return this;
		}

		public Builder eventCode(int eventCode) {
			this.eventCode = eventCode;
			return this;
		}

		public Builder links(List<String> links) {
			this.links = links;
			return this;
		}

		public Builder tmcs(List<String> tmcs) {
			this.tmcs = tmcs;
			return this;
		}
	}
}
