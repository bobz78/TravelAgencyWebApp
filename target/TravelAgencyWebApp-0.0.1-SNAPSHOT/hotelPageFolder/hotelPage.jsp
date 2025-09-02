<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>DreamEscape Hotels</title>
  <link rel="stylesheet" href="hotelPageFolder/hotelPage.css">
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
    <h1>Available Hotels</h1>
    <p class="subtext">Choose your perfect stay from our top-rated hotels.</p>

    <div id="hotelsSection" class="card-container">
    
    <script type="text/javascript">var hotels = JSON.parse('<%= org.apache.commons.text.StringEscapeUtils.escapeEcmaScript((String) session.getAttribute("hotels")) %>');</script>
    <script type="text/javascript">function fun(){console.log(hotels);}</script>
    
    <script src="hotelPageFolder/hotelPage.js"></script>
    
    <script>
    window.onload = function() {loadHotels();};
    </script>
    
    </div>
   
    
  </main>

  <footer>
    © 2025 DreamEscape Travel Agency. All rights reserved.
  </footer>
</body>
</html>
