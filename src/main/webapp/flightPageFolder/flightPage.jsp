<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Available Flights</title>
  <link rel="stylesheet" href="flightPageFolder/flightPage.css" />
</head>
<body>
  <header>
    <div class="logo">✈️ DreamEscape</div>
    <nav>
      <a href="#">Dashboard</a>
      <a href="#">Bookings</a>
      <a href="#">Explore</a>
      <a href="#">Support</a>
    </nav>
  </header>


  <main>
  
    <section class="welcome">
      <h1>Available Flights</h1>
      <p>Browse and book your next adventure.</p>
    </section>


    <section class="flights" id="flightsSection"></section>
    
    
    <script>
    var flightData = JSON.parse('<%= org.apache.commons.text.StringEscapeUtils.escapeEcmaScript((String) session.getAttribute("flightCard")) %>');
    </script>
    
    <script src="flightPageFolder/flightPage.js"></script>
    
    <script>
    window.onload = function() {loadFlights();};
    </script>
    
    
    
  </main>

  <footer>
    © 2025 DreamEscape Travel Agency. All rights reserved.
  </footer>
</body>
</html>