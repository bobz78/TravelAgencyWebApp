let startTime = Date.now();
window.timeSpent = 0; 

setInterval(function () {
    window.timeSpent = Math.floor((Date.now() - startTime) / 1000);
}, 1000);


function loadFlights() {
	const container = document.getElementById("flightsSection");

	flightData.forEach(flight => {
	  const card = document.createElement("div");
	  card.className = "flight-card";

	  card.innerHTML = `
	    <h2>${flight.airline} • ${flight.flightNum}</h2>
	    <p><strong>From:</strong> ${flight.from}</p>
	    <p><strong>To:</strong> ${flight.to}</p>
	    <p><strong>Departure:</strong> ${flight.departureTime}</p>
	    <p><strong>Arrival:</strong> ${flight.arrivalTime}</p>
	    <p><strong>Price:</strong> ${flight.price}</p>
	  `;

	  card.style.cursor = "pointer";

	  card.addEventListener("click", () => {
	      document.cookie = `timeSpentOnPage=${window.timeSpent}; path=/; max-age=3600`;

	      fetch("HotelPageServlet", {
	          method: "POST",
	          credentials: "include",
	          headers: {
	              "Content-Type": "application/x-www-form-urlencoded"
	          },
	          body: "flight=" + encodeURIComponent("flight" + JSON.stringify(flight))
	      }).then(response => {
	          if (response.redirected) {
	              window.location.href = `HotelPageServlet`;
	          } else {    
	              console.log("Trip sent successfully.");
	          }
	      }).catch(error => {
	          console.error("Error sending trip:", error);
	      });
	  });

	  container.appendChild(card);
	});
}