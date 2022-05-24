<%@page import="java.util.List"%>
<%@page import="com.flight.booking.airport.entity.Airport"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<div class="wrapper">
		<div class="container tab-content">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<p class="navbar-brand">Search Flights</p>
			</nav>
			<div class="row justify-content-center">
				<div class="col-lg-4">
					<form action="search-ticket" method="POST">
						<div class="mb-3">
							<label for="from" class="form-label">Depart From</label> <select
								name="from" class="form-control">
								<option>Select Depart</option>
								<%
									List<Airport> airports = (List<Airport>) request.getAttribute("airports");
									for (Airport a : airports) {
								%>
								<option value="<%=a.getId()%>"><%=a.getName()%></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="mb-3">
							<label for="to" class="form-label">Going To</label> <select
								name="to" class="form-control">
								<option>Select Depart</option>
								<%
									for (Airport a : airports) {
								%>
								<option value="<%=a.getId()%>"><%=a.getName()%></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="mb-3">
							<label for="date" class="form-label">Date</label> <input
								type="date" class="form-control" id="date" name="date">
						</div>
						<div class="mb-3">
							<!-- <label for="passengers" class="form-label">Passengers</label> <input
								type="number" class="form-control" id="passengers"
								name="passengers"> -->
						</div>
						<button type="submit" class="btn btn-primary">Search</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>