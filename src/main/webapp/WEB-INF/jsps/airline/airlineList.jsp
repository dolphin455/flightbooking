<%@page import="com.flight.booking.airline.entity.Airline"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<div class="container tab-content">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<p class="navbar-brand">Airline List</p>
			<a href="add-airline" class="btn btn-primary">Add Airline</a>
			</nav>
			
			<div class="row">
				<div class="col-lg-12">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Sl</th>
								<th scope="col">Name</th>
								<th scope="col">HQ Address</th>
								<th scope="col">Status</th>
								<th scope="col">Actions</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Airline> airlines = (List<Airline>) request.getAttribute("airlines");
								for (Airline a : airlines) {
							%>
							<tr>
								<td>
									<%
										out.println(a.getId());
									%>
								</td>
								<td>
									<%
										out.println(a.getName());
									%>
								</td>
								<td>
									<%
										out.println(a.getHqAddress());
									%>
								</td>
								<td>
									<%
										out.println(a.isBlocked() ? "Blocked" : "UnBlocked");
									%>
								</td>
								<td><a class="editBtn" href="#" data-toggle="tooltip"
									data-placement="top" data-id="<%=a.getId()%>" title="Edit"><i
										class="fa fa-edit"></i></a> <a href="remove-airline?id=<%=a.getId() %>" data-toggle="tooltip"
									data-placement="top" title="Delete"  onclick="return confirm('Sure you want to Delete');"><i
										class="fa-solid fa-trash-can" style="color: red"></i></a></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true" class="closeBtn">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="update-airline" method="POST" id="updateForm">
						<input type="hidden" name="id" id="airlineId" >
							<div class="form-group">
								<label for="name">Name</label> <input
									type="text" class="form-control" id="name"
									aria-describedby="emailHelp" name="name" placeholder="Enter Airline Name">
							</div>
							<div class="form-group">
								<label for="address">Address</label> <input
									type="text" class="form-control" id="address"
									placeholder="address" name="hqAddress">
							</div>
							<div class="form-group">
								<label for="status">Status</label>
								<select name="isBlocked" id="status" class="form-control">
									<option value="1">Blocked</option>
									<option value="0">UnBlocked</option>
								</select>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary closeBtn"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" id="saveBtn">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var id = 0;
	$(".closeBtn").click(() => $("#editModal").modal("hide"));
	
	$("#saveBtn").click(function(){
		$("#status").val(Number($("#status").val()))
		$("#updateForm").submit()
		/* $.ajax({
			url: "update-airline",
			method: "POST",
			data: { id: Number(id), name: $("#name").val(), hqAddress: $("#address").val(), isBlocked: Number($("#status").val()) },
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
		}).done(function() {
			console.log("called")
		}) */
	});
	
	$(".editBtn").click(function() {
		id = $(this).attr("data-id");
		$.ajax({
			url : "get-airline",
			method : "GET",
			data : {
				id : id
			},
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
		}).done(function(resp) {
			console.log(resp)
			$("#name").val(resp.name);
			$("#airlineId").val(id)
			$("#address").val(resp.address);
			$("#status").val(resp.status ? 1 : 0);
			$("#editModal").modal("show")
		});

	});
</script>
</html>