<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="pack1.*,pack2.*,Common.*,java.util.*"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<style>
* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
}

html, body {
	height: 100%;
	width: 100%;
}

#table {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
}

a {
	text-decoration: none;
	color: white;
}

th {
	padding: 10px !important;
}

td {
	padding: 10px !important;
}

html, body {
	display: flex;
	align-items: center;
	flex-direction: column;
	height: 100%;
	width: 100%;
}

.buttons {
	display: flex;
	flex-direction: row;
	gap: 30px;
}

button {
	display: flex;
	align-items: center;
	justify-content: center;
}

.navbar {
	height: 70px;
	width: 100%;
	display: flex;
	align-items: center;
	justify-content: space-around;
	padding: 5px 50px 5px 50px;
	background: transparent;
}

.container-fluid {
	width: 100%;
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.collapse {
	width: 100%;
	/* background-color: aqua; */
	display: flex;
	align-items: center;
	justify-content: space-between;
}
</style>
<body>
	<%
	
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	String admin=ab.getFirstname();
	%>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<div>
				<a class="navbar-brand" href="AdminLoginSuccess.jsp"> <img
					src="images/logo.png" alt="Logo" width="30" height="24"
					class="d-inline-block align-text-top "> VirtuMart
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home.html">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="AdminLogin.html">Login</a></li>


				</ul>
				<span class="navbar-text"> <i class="bi bi-person-check-fill"></i>&nbsp;
					<%=admin %>&nbsp; <a href="home.html">
						<button type="button" class="btn btn-primary">
							<i class="bi bi-box-arrow-left"></i> Logout
						</button>
				</a>
				</span>

			</div>
		</div>
	</nav>
	<div>
		<%
		ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
		
		%>

	</div>
	<div id="table">
		<h3>Database Product Data</h3>
		<table class="table table-hover">
			<tr>
				<th>Product Code</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Product Quantity</th>
				<th>Actions</th>
			</tr>
			<%
		Iterator<ProductBean> it = al.iterator();
		while (it.hasNext()) {
			ProductBean pb = (ProductBean) it.next();
		%>
			<tr>

				<td><%=pb.getProduct_code()%></td>
				<td><%=pb.getProduct_name()%></td>
				<td><%=pb.getProduct_price()%></td>
				<td><%=pb.getProductquantity()%></td>
				<td>
					<button class="btn btn-success">
						<a href='edit?pcode=<%=pb.getProduct_code()%>'>Edit</a>
					</button> &nbsp;
					<button class="btn btn-danger">
						<a href='delete?pcode=<%=pb.getProduct_code()%>'>delete</a>
					</button>

				</td>

			</tr>
			<%
		}
		%>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>