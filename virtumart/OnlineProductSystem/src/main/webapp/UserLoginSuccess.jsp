<%@page import="pack2.UserBean" import="pack2.*,pack1.*,Common.*,java.util.*"%>

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
	padding: 0px 50px 0px 50px;
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

.content {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: row;
	height: 100%;
	width: 100%;
	/* background-color: black;   */
}

#contentpng {
	width: 35%;
}

.right {
	display: flex;
	flex-direction: column;
	width: 40%;
	/* background-color: azure; */
	padding: 50px;
}

@media ( max-width :990px) {
	.content {
		flex-direction: column;
		align-items: center;
		justify-content: center;
		width: 100%;
	}
	.right {
		width: 100%;
	}
	#contentpng {
		height: 47%;
		width: 85%;
	}
}

@media ( max-width :450px) {
	.content {
		padding: 0%;
	}
	.navbar {
		padding: 0%;
	}
	#navlogo {
		justify-content: space-between;
	}
}
</style>
<body>
	<%
	
	UserBean ub = (UserBean) session.getAttribute("ubean");
	String user=ub.getFirstname();
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
						href="UserLogin.html">Login</a></li>


				</ul>
				<span class="navbar-text"> <i class="bi bi-person-check-fill"></i>&nbsp;
					<%=user %>&nbsp; <a href="home.html">
						<button type="button" class="btn btn-primary">
							<i class="bi bi-box-arrow-left"></i> Logout
						</button>
				</a>
				</span>

			</div>
		</div>
	</nav>
	<div class="content">

		<img src="images/userpic.avif" id="contentpng" alt="">

		<div class="right">
			<div>
				<h1>
					Welcome back, 
					<%=user %>!</h1>
				<p>"Discover the latest products tailored just for you."</p>
			</div>
			<div class="buttons">
			<!-- 	<a href="product.html"><button type="button"
						class="btn btn-info">
						<i class="bi bi-database-add"></i> AddProduct
					</button></a> -->
			 <a href="UserViewAllProductServlet">
					<button type="button" class="btn btn-success">
						<i class="bi bi-eye"></i> ViewAllProduct
					</button>
				</a>

			</div>
		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>