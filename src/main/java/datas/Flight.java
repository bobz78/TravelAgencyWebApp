package datas;

public class Flight{
		
		private String airline;
		private String flightNum;
		private String from;
		private String to;
		private String departureTime;
		private String arrivalTime;
		private double price;
		
		Flight(){}
		Flight(String airline, String flightNum, String from, String to, String departureTime, String arrivalTime, double price){
			this.airline = airline;
			this.flightNum = flightNum;
			this.from = from;
			this.to = to;
			this.departureTime = departureTime;
			this.arrivalTime = arrivalTime;
			this.price = price;
		}
		
		Flight(String airline, String flightNum, String from, String to, String departureTime, String arrivalTime, String price){
			this.airline = airline;
			this.flightNum = flightNum;
			this.from = from;
			this.to = to;
			this.departureTime = departureTime;
			this.arrivalTime = arrivalTime;
			this.price = Double.parseDouble(price);
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
		@Override
		public String toString() {
			return "Flight [airline=" + airline + ", flightNum=" + flightNum + ", from=" + from + ", to=" + to
					+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", price=" + price + "]";
		}
	}