/**
 * 
 */

// Target container

function func() {
  const container = document.getElementById("flightsSection");

  flightData.forEach(flight => {
    const card = document.createElement("div");
    card.className = "flight-card";
    
    console.log(flight[1])

    card.innerHTML = `
      <h2>${flight[0]} • ${flight[1]}</h2>
      <p><strong>From:</strong> ${flight[2]}</p>
      <p><strong>To:</strong> ${flight[3]}</p>
      <p><strong>Departure:</strong> ${flight[4]}</p>
      <p><strong>Arrival:</strong> ${flight[5]}</p>
      <p><strong>Price:</strong> ${(flight[6])}</p>
    `;

    container.appendChild(card);
  });
}