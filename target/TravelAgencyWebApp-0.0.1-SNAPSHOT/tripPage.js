/**
 * 
 */
function loadTripData(){
	
	
	console.log(tripData.flight);
	console.log(departureDate);
	console.log(returnDate);
	console.log(totalCost);
	
	document.getElementById("airline").innerHTML = tripData.flight.airline;
	document.getElementById("flight-number").innerHTML = tripData.flight.flightNum;
	document.getElementById("departure-city").innerHTML = tripData.flight.from + " |Departure Time: " + tripData.flight.departureTime;
	document.getElementById("arrival-city").innerHTML = tripData.flight.to + " |Arrival Time: " + tripData.flight.arrivalTime;
	document.getElementById("flight-price").innerHTML = tripData.flight.price;
	
	document.getElementById("hotel-name").innerHTML = tripData.hotel.name
	document.getElementById("hotel-rating").innerHTML = tripData.hotel.rating
	document.getElementById("hotel-price").innerHTML = tripData.hotel.price
	
	document.getElementById("departure-date").innerHTML = departureDate
	document.getElementById("return-date").innerHTML = returnDate
	
	document.getElementById("total-cost").innerHTML = totalCost+" CAD$"
}