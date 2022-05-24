<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
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
			<p class="navbar-brand" style="text-align: center;">Search
				Results</p>
			</nav>
			<div class="row">
				<div class="col-lg-12">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Sl</th>
								<th scope="col">Airline</th>
								<th scope="col">From</th>
								<th scope="col">To</th>
								<th scope="col">Departure Date</th>
								<th scope="col">Arrival Date</th>
								<th scope="col">Fares</th>
								<th scope="col">Actions</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Object[]> object = (List<Object[]>) request.getAttribute("results");
								for (Object[] obj : object) {
							%>
							<tr>
								<td>
									<%
										out.println(obj[0]);
									%>
								</td>
								<td>
									<%
										out.println(obj[5]);
									%>
								</td>
								<td>
									<%
										out.println(obj[3]);
									%>
								</td>
								<td>
									<%
										out.println(obj[4]);
									%>
								</td>
								<td>
									<span> <%out.println(obj[1]);%></span><br> 
									<span> <%out.println(obj[6]);%></span>
								</td>
								<td>
									<span> <%out.println(obj[2]);%></span><br> 
									<span> <% out.println(obj[7]);%></span>
								</td>
								<td>Rs <%=obj[8] %></td>
								<td><a class="btn btn-success" href="#"
									onclick="bookBtn(<%=obj[0]%>)">Book</a></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<br> <br>
			<div id="bookRow" class="row justify-content-center"
				style="display: none">
				<div class="col-lg-4">
					<h5 style="text-align: center;">Add user details</h5>
					<form action="book-ticket" method="POST">
						<input type="hidden" name="scheduleId" id="scheduleId">
						<div class="mb-3">
							<label for="name">Name</label> <input type="text"
								class="form-control" id="name" name="name"
								placeholder="Enter Name">
						</div>
						<div class="mb-3">
							<label for="address">Email</label> <input type="email"
								class="form-control" id="address" placeholder="Enter Email"
								name="email">
						</div>
						<div class="mb-3">
							<label for="address">Seats</label> <input type="number"
								class="form-control" id="seats" placeholder="Enter Seats"
								name="passenger">
						</div>
						<div class="mb-3">
							<input type="submit" value="Book Ticket" class="btn btn-success">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
function bookBtn(id) {
	console.log(id)
	$("#scheduleId").val(Number(id))
	$("#bookRow").css({
		"display" : ""
	})
}
</script>
</html>