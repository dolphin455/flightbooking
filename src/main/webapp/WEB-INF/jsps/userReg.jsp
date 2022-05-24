<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>User Registration</title>
</head>
<body>
	<div class="wrapper">
		<div class="container tab-content">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<p class="navbar-brand">Add User</p>
		</nav>
			<div class="row">
			<div class="col-lg-4">
				<form action="save-user" method="POST">
					<div class="mb-3">
						<label for="email" class="form-label">Name</label> 
						<input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label>
						<input type="email" class="form-control"
							id="email" name="email">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label>
						<input type="password" class="form-control"
							id="password" name="password">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>