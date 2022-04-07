package miniproject;

public class RouteInfo {
	private String from;
	private String to;
	private String distance;
	private String travelTime;
	private String airFare;
	
	public RouteInfo() {
	}

	public RouteInfo(String from, String to, String distance, String travelTime, String airFare) {
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
		this.travelTime = travelTime;
		this.airFare = airFare;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}

	public String getAirFare() {
		return airFare;
	}

	public void setAirFare(String airFare) {
		this.airFare = airFare;
	}

	@Override
	public String toString() {
		return   from + ",  " + to + ",  " + distance + ",  " + travelTime
				+ ",  " + airFare ;
	}
	
	
	
}
