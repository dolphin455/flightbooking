<%@page import="java.math.BigInteger"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="wrapper">
		<div class="container tab-content">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<p class="navbar-brand">Booking Details</p>
				<a href="flights" class="btn btn-secondary">Go Search Flights</a>
			</nav>
			<div class="row">
				<div class="alert alert-success" role="alert">
					Your booking is confirmed. Here is the details.
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Sl</th>
								<th scope="col">Airline</th>
								<th scope="col">PNR</th>
								<th scope="col">From</th>
								<th scope="col">To</th>
								<th scope="col">Departure Time</th>
								<th scope="col">Arrival Time</th>
								<th scope="col">Total Cost</th>
							</tr>
						</thead>
						<tbody>
						<% 
						List<Object[]> list = (List<Object[]>) request.getAttribute("records");
						for(Object[] item: list) {
						%>
						<tr>
							<td><%=item[0] %></td>
							<td><%=item[14] %></td>
							<td><%=item[3] %></td>
							<td><%=item[15] %></td>
							<td><%=item[16] %></td>
							<td><span><%=item[10] %></span><br><span><%=item[11] %></span></td>
							<td><span><%=item[12] %></span><br><span><%=item[13] %></span></td>
							<td>
								<span><%=item[1] %> x Rs <%=item[8] %> = 
								Rs <%=((int)item[1] * ((BigInteger) item[8]).intValue()) %></span>
							</td>
						</tr>
						<% } %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>