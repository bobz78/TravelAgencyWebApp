<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Travel Receipt - DreamEscape</title>
  <link rel="stylesheet" href="tripPage.css" />
</head>
<body>
  <header class="header">
    <div class="logo">✈️ DreamEscape</div>
  </header>

  <main class="container">
    <h1>Booking Receipt</h1>

<section class="card">
  <h2>Flight Details</h2>
  <div class="info-row"><strong>Airline:</strong> <span id="airline">DreamAir</span></div>
  <div class="info-row"><strong>Flight Number:</strong> <span id="flight-number">DE123</span></div>
  <div class="info-row"><strong>Departure City:</strong> <span id="departure-city">New York (JFK)</span></div>
  <div class="info-row"><strong>Arrival City:</strong> <span id="arrival-city">Paris (CDG)</span></div>
  <div class="info-row"><strong>Price:</strong> <span id="flight-price">$750</span></div>
</section>

<section class="card">
  <h2>Hotel Details</h2>
  <div class="info-row"><strong>Hotel Name:</strong> <span id="hotel-name">Hôtel de Lumière</span></div>
  <div class="info-row"><strong>Rating:</strong> <span id="hotel-rating">⭐⭐⭐⭐☆</span></div>
  <div class="info-row"><strong>Price per Night:</strong> <span id="hotel-price">$200</span></div>
</section>

<section class="card">
  <h2>Travel Dates</h2>
  <div class="info-row"><strong>Departure Date:</strong> <span id="departure-date">2025-07-22</span></div>
  <div class="info-row"><strong>Return Date:</strong> <span id="return-date">2025-07-30</span></div>
</section>

<section class="card total">
  <h2>Total Cost</h2>
  <div class="info-row total-amount"><span id="total-cost">$1,550</span></div>
</section>
    
    <script type="text/javascript">
    var tripData = JSON.parse('<%= org.apache.commons.text.StringEscapeUtils.escapeEcmaScript((String) session.getAttribute("trip")) %>');
    var departureDate = '<%= session.getAttribute("departure") %>';
    var returnDate = '<%= session.getAttribute("return") %>';
    var totalCost = <%= session.getAttribute("totalCost") %>;
    </script>
    
    <script src="tripPage.js"></script>
    
    <script>
    window.onload = function() {loadTripData();};
    </script>
    
  </main>

  <footer class="footer">
    © 2025 DreamEscape Travel Agency. All rights reserved.
  </footer>
</body>
</html>