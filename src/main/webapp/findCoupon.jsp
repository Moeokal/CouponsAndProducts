<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Coupon</title>
</head>
<body>
<h1>Find Coupon</h1>
<form action="coupons" method="post">

<pre>
Coupon Code: <input type="text" name="couponCode"/>
<input type="hidden" name="action" value="find"/>

<input type="submit" value="find"/>
</pre>

</form>
</body>
</html>