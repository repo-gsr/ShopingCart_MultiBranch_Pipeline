<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Shoping Cart</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/custom.css" />
</head>

<body>
	<nav class="navbar">
		<div class="container">
			<a class="navbar-brand" href="#">Online store</a>
			<div class="navbar-right">
				<div class="container minicart"></div>
			</div>
		</div>
	</nav>
	<!-- <h1>Microservices Sample Demo(By Subbareddy)</h1>
	<div class="container">
		<div class="row">
			<h2>Produts List</h2>
			<p>
				<a href="/getItems">Product List</a>
			</p>
		</div>
	</div> -->
	<hr class="hline">
	<div class="topnav">
		<a class="active" href="/index">Home</a> <a href="/getProducts">Products</a> <a
			href="/getOrderedProducts">Order</a> <a href="/getCartProducts">Cart</a>
	</div>
	<div class="container">
		<div class="row">
			<h2>Product Details</h2>
			<table id="product">
				<tr>
					<th>Name</th>
					<th>Brand</th>
					<th>Color</th>
					<th>Price</th>
				</tr>
				<c:forEach items="${items}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>${item.brand}</td>
						<td>${item.color}</td>
						<td>${item.price}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>