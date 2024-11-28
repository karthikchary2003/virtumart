<%@page import="pack2.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="pack1.*,Common.*,java.util.*"%>
<%@page import="pack1.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<style>
html,body{
	height:100vh;
	width:100%;
	display: flex;
	align-items: center;
	justify-content: center;
}
.form {
  background-color: #fff;
  display: block;
  padding: 2rem;
  max-width: 350px;
  border-radius: 0.5rem;
box-shadow: rgba(0, 0, 0, 0.1) 0px 4px 12px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.form-title {
  font-size: 1.25rem;
  line-height: 1.75rem;
  font-weight: 600;
  text-align: center;
  color: #000;
}

.input-container {
  position: relative;
}

.input-container input, .form button {
  outline: none;
  border: 1px solid #e5e7eb;
  margin: 8px 0;
}

.input-container input {
  background-color: #fff;
  padding: 1rem;
  padding-right: 3rem;
  font-size: 0.875rem;
  line-height: 1.25rem;
  width: 250px;
  border-radius: 0.5rem;
  box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
}

.submit {
  display: block;
  padding-top: 0.75rem;
  padding-bottom: 0.75rem;
  padding-left: 1.25rem;
  padding-right: 1.25rem;
  background-color: #36dd52;
  color: #ffffff;
  font-size: 0.875rem;
  line-height: 1.25rem;
  font-weight: 500;
  width: 100%;
  border-radius: 0.5rem;
  text-transform: uppercase;
}

.signup-link {
  color: #6B7280;
  font-size: 0.875rem;
  line-height: 1.25rem;
  text-align: center;
}

.signup-link a {
  text-decoration: underline;
}
</style>
</head>

<body>
	<%
	UserBean ub=(UserBean) session.getAttribute("ubean");
	ArrayList<ProductBean> ul = (ArrayList<ProductBean>) session.getAttribute("alist");
	Iterator<ProductBean> it = ul.iterator();
	String pcode = (String)request.getParameter("pcode");
	while (it.hasNext()) {
		ProductBean pb = (ProductBean) it.next();
		if (pb.getProduct_code().equals(pcode)) {
	%>


	
    <form class="form" action="addtocart" method="post">
       <p class="form-title">CART</p>
        <div class="input-container">
           <input type="text" name="pcode" value="<%=pb.getProduct_code()%>" readonly >
          <span>
          </span>
      </div>
      <div class="input-container">
           <input type="text" name="pname" value="<%=pb.getProduct_name()%>" readonly>
        </div>
      <div class="input-container">
           <input type="text" name="pprice" value="<%=pb.getProduct_price()%>" readonly>
        </div>
        
        <div class="input-container">
        <input type="text" name="pquantity"
			value="<%=pb.getProductquantity()%>" readonly >
        </div>
         <button type="submit" class="submit ">
        <i class="bi bi-bag-plus"></i>&nbsp;&nbsp;Add to Cart
      </button>

    <p class="signup-link">
       	go to back
        <a href="AdminLoginSuccess.jsp">AdminHome</a>
      </p>
   </form>

	<%
	break;
	}
	}
	%>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>