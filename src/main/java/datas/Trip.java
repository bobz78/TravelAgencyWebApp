package datas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Trip {
	
	
	public Flight flight;
	public Hotel hotel;
	
	public Trip(String tripJson){
		
		ArrayList<String> temp =  extractBracketedStrings(tripJson);
		
		flight = new Flight(extractQuotedStrings(temp.get(0)));
		hotel = new Hotel(extractQuotedStrings(temp.get(1)));

		
	}
	
	private static ArrayList<String> extractBracketedStrings(String input){
		ArrayList<String> list = new ArrayList<String>();
		while(input.length()>1) {
			String temp = "";
			int i = 0;
			if(input.charAt(0)=='[') {
				int index = 1;
				while(index<input.length()) {
					if(input.charAt(index)==']') {
						i = index;
						break;
					}
					temp+= input.substring(index, index+1);
					index++;
				}
			}
			
			list.add(temp);
			input = input.substring(i+1);
		}
		
		return list;
	}
	
	
	private static ArrayList<String> extractQuotedStrings(String input) {
        ArrayList<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"(.*?)\"");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            result.add(matcher.group(1));
        }

        return result;
    }
	
	
	
	
	public double tripTotalCost(String departureDate, String returnDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d1 = LocalDate.parse(departureDate, formatter);
        LocalDate d2 = LocalDate.parse(returnDate, formatter);

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
	
	
	public class Hotel{
		
		private String name;
		private String rating;
		private double price;
		
		Hotel(ArrayList<String> hotelInfo){
			name = hotelInfo.get(0);
			rating = hotelInfo.get(1);
			price = Double.parseDouble(hotelInfo.get(2));
		}

		public String getName() {
			return name;
		}

		public String getRating() {
			return rating;
		}

		public double getPrice() {
			return price;
		}
	}

	public class Flight{
		
		private String airline;
		private String flightNum;
		private String from;
		private String to;
		private String departureTime;
		private String arrivalTime;
		private double price;
		
		Flight(ArrayList<String> flightInfo){
			airline = flightInfo.get(0);
			flightNum = flightInfo.get(1);
			from = flightInfo.get(2);
			to = flightInfo.get(3);
			departureTime = flightInfo.get(4);
			arrivalTime = flightInfo.get(5);
			price = Double.parseDouble(flightInfo.get(6));
		}

		public String getAirline() {
			return airline;
		}

		public String getFlightNum() {
			return flightNum;
		}

		public String getFrom() {
			return from;
		}

		public String getTo() {
			return to;
		}

		public String getDepartureTime() {
			return departureTime;
		}

		public String getArrivalTime() {
			return arrivalTime;
		}

		public double getPrice() {
			return price;
		}
	}
}