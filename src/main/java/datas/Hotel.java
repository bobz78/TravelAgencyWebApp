package datas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Hotel{
			
			private String name;
			private String rating;
			private double price;
			
			
			
			Hotel(){}
			Hotel(String name, String rating, String price){
				this.name = name;
				this.rating = rating;
				this.price = Double.parseDouble(price);
			}
			
			Hotel(String name, String rating, double price){
				this.name = name;
				this.rating = rating;
				this.price = price;
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
				return "Hotel [name=" + name + ", rating=" + rating + ", price=" + price + "]";
			}
		}