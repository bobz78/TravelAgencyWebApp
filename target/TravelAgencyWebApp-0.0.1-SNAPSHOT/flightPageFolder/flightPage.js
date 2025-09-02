function loadFlights() {
  const container = document.getElementById("flightsSection");

  flightData.forEach(flight => {
    const card = document.createElement("div");
    card.className = "flight-card";

    card.innerHTML = `
      <h2>${flight[0]} • ${flight[1]}</h2>
      <p><strong>From:</strong> ${flight[2]}</p>
      <p><strong>To:</strong> ${flight[3]}</p>
      <p><strong>Departure:</strong> ${flight[4]}</p>
      <p><strong>Arrival:</strong> ${flight[5]}</p>
      <p><strong>Price:</strong> ${flight[6]}</p>
    `;

    card.style.cursor = "pointer";

    card.addEventListener("click", () => {

      fetch("HotelPageServlet", {
        method: "POST",
        headers: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "flight=" + encodeURIComponent(JSON.stringify(flight))
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