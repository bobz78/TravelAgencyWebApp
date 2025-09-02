package datas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Trip {

	private Flight flight;
	private Hotel hotel;
	private TripDates dates;
	
	public Trip(Flight flight, Hotel hotel, TripDates dates) {
		this.dates = dates;
		this.flight = flight;
		this.hotel = hotel;
	}
	
	public Trip(String tripJSON){
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			
			while(tripJSON.length()>1) {
				if(tripJSON.substring(0, 6).equals("flight")) {
					int index = 7;
					String temp = "";
					while(tripJSON.charAt(index)!='}') {
						temp += tripJSON.charAt(index);
						++index;
					}
					this.flight = mapper.readValue("{"+temp+"}", Flight.class);
					tripJSON = tripJSON.substring(index+1);
				}
				if(tripJSON.substring(0, 5).equals("hotel")) {
					int index = 6;
					String temp = "";
					while(tripJSON.charAt(index)!='}') {
						temp += tripJSON.charAt(index);
						++index;
					}
					this.hotel = mapper.readValue("{"+temp+"}", Hotel.class);
					tripJSON = tripJSON.substring(index+1);
				}
				if(tripJSON.length()>9)if(tripJSON.substring(0, 9).equals("tripDates")) {
					int index = 10;
					String temp = "";
					while(tripJSON.charAt(index)!='}') {
						temp += tripJSON.charAt(index);
						++index;
					}
					this.dates = mapper.readValue("{"+temp+"}", TripDates.class);
					tripJSON = tripJSON.substring(index+1);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public double tripTotalCost() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d1 = LocalDate.parse(dates.getDepartureDate(), formatter);
        LocalDate d2 = LocalDate.parse(dates.getReturnDate(), formatter);

        int days = (int) ChronoUnit.DAYS.between(d1, d2);
        
        return hotel.getPrice()*days + flight.getPrice();
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
	
	
	public Flight getFlight() {
		return flight;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public TripDates getDates() {
		return dates;
	}

	@Override
	public String toString() {
		return "Trip: [" + flight + " ," + hotel + " ," + dates + "]";
	}
}