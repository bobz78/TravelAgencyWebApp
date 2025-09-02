package datas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TripDates {
	
	private String departureDate;
	private String returnDate;
	
	public TripDates() {}
	public TripDates(String departureDate, String returnDate) {
		this.departureDate = departureDate;
		this.returnDate = returnDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	public String jsonify() {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return "TripDates [departureDate=" + departureDate + ", returnDate=" + returnDate + "]";
	}
}
