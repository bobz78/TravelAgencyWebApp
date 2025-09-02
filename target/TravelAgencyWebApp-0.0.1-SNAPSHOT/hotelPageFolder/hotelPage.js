function loadHotels() {
  const container = document.getElementById("hotelsSection");
  
  console.log("sdsd");

  hotels.forEach(hotel => {
    const card = document.createElement("div");
    card.className = "hotel-card";

    card.innerHTML = `
      <h2>${hotel.name}</h2>
      <p><strong>Rating:</strong> ${hotel.ratg} ⭐</p>
      <p><strong>Price/Night:</strong> $${hotel.price}</p>
    `;

    card.style.cursor = "pointer";

    card.addEventListener("click", () => {
      fetch("TripPageServlet", {
        method: "POST",
        headers: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "hotel=" + encodeURIComponent(JSON.stringify(hotel))
      })
      .then(response => {
        if (response.redirected) {
          window.location.href = response.url;
        } else {
          console.log("Hotel data sent successfully.");
        }
      })
      .catch(error => {
        console.error("Error sending hotel data:", error);
      });
    });

    container.appendChild(card);
  });
}