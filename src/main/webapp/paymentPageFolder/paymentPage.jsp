<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>DreamEscape Payment</title>
<link rel="stylesheet" href="paymentPage.css" />
</head>
<body>
<header>
  <div class="logo">
    <span class="icon">✈️</span> DreamEscape
  </div>
  <nav>
    <a href="#">Dashboard</a>
    <a href="#">Bookings</a>
    <a href="#">Explore</a>
    <a href="#">Support</a>
  </nav>
</header>

<main>
  <h1>Payment Details</h1>
  <p>Enter your credit card information to complete the booking.</p>

  <form id="payment-form" action="/PaymentPageServlet" method="POST">


    <label for="email">Email Address</label>
    <input
      type="email"
      id="email"
      name="email"
      placeholder="you@example.com"
      autocomplete="email"
      required
    />

    <label for="cardName">Name on Card</label>
    <input type="text" id="cardName" name="cardName" placeholder="John Doe" required />

    <label for="cardNumber">Card Number</label>
    <input
      type="tel"
      id="cardNumber"
      name="cardNumber"
      placeholder="1234 5678 9012 3456"
      pattern="[0-9\s]{13,19}"
      maxlength="19"
      autocomplete="cc-number"
      required
    />

    <div class="row">
      <div>
        <label for="expiry">Expiry Date</label>
        <input type="month" id="expiry" name="expiry" min="2023-08" required />
      </div>
      <div>
        <label for="cvv">CVV</label>
        <input
          type="password"
          id="cvv"
          name="cvv"
          placeholder="123"
          pattern="\d{3,4}"
          maxlength="4"
          autocomplete="cc-csc"
          required
        />
      </div>
    </div>

    <button type="submit">Pay</button>
  </form>
</main>

<footer>
  © 2025 DreamEscape Travel Agency. All rights reserved.
</footer>
</body>
</html>
