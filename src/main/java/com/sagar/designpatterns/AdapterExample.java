package com.sagar.designpatterns;

import java.util.Arrays;
import java.util.List;

/**
 * This is used to adapt new interface to work with exiting/legacy interface
 * without changing client code or server code.
 * 
 * Example : List l = Arrays.asList()
 * 
 * 
 * below Example: Suppose we have exsiting service that gets incidentEvent from
 * xml data. Now we have another service that gives data in jsonFormat
 * (HazardIncidentEvent)
 * 
 * So we need to convert HazardIncidentEvent to IncidentEvent using
 * HazardIncidentEventAdapter
 * 
 * @author sitapsha
 *
 */
public class AdapterExample {

	public static void main(String[] args) {
		IncidentEvent incidentEvent1 = getIncidentFromXml("https://provide?xml-data");
		HazardIncidentEvent hazardIncidentEvent = getHazardIncident("https://provide?hazard-data");
		IncidentEvent incidentEvent2 = new HazardIncidentEventAdapter(hazardIncidentEvent);

	}

	private static HazardIncidentEvent getHazardIncident(String string) {
		return null;
	}

	private static IncidentEvent getIncidentFromXml(String string) {
		return null;
	}

}

/**
 * Don't add additional functionality in this Adapter class otherwise it will
 * not be called as Adapter pattern
 * 
 * @author sitapsha
 *
 */
class HazardIncidentEventAdapter extends IncidentEvent {

	private HazardIncidentEvent hazardIncidentEvent;

	public HazardIncidentEventAdapter(HazardIncidentEvent hazardIncidentEvent) {
		super();
		this.hazardIncidentEvent = hazardIncidentEvent;
	}

	@Override
	public String getId() {
		return hazardIncidentEvent.getIncidentId();
	}

	@Override
	public int geteC() {
		return hazardIncidentEvent.getEventCode();
	}

	@Override
	public List<double[]> getCoordinates() {
		return Arrays.asList(
				new double[] { hazardIncidentEvent.getStartLatitude(), hazardIncidentEvent.getStartLongitude() },
				new double[] { hazardIncidentEvent.getEndLatitude(), hazardIncidentEvent.getEndLongitude() });
	}

}

class IncidentEvent {
	private String id;
	private int eC;
	private List<double[]> coordinates;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int geteC() {
		return eC;
	}

	public void seteC(int eC) {
		this.eC = eC;
	}

	public List<double[]> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<double[]> coordinates) {
		this.coordinates = coordinates;
	}
}

class HazardIncidentEvent {
	private String incidentId;
	private int eventCode;
	private double startLatitude;
	private double startLongitude;
	private double endLatitude;
	private double endLongitude;

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}

	public int getEventCode() {
		return eventCode;
	}

	public void setEventCode(int eventCode) {
		this.eventCode = eventCode;
	}

	public double getStartLatitude() {
		return startLatitude;
	}

	public void setStartLatitude(double startLatitude) {
		this.startLatitude = startLatitude;
	}

	public double getStartLongitude() {
		return startLongitude;
	}

	public void setStartLongitude(double startLongitude) {
		this.startLongitude = startLongitude;
	}

	public double getEndLatitude() {
		return endLatitude;
	}

	public void setEndLatitude(double endLatitude) {
		this.endLatitude = endLatitude;
	}

	public double getEndLongitude() {
		return endLongitude;
	}

	public void setEndLongitude(double endLongitude) {
		this.endLongitude = endLongitude;
	}

}