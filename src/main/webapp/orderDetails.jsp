<%@page import="model.bean.Products"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"></script>

</head>
<body style="background-color: #f7f7f7;">

	<%
    Products product = (Products) request.getAttribute("product");
%>

	<nav class="navbar navbar-expand-lg bg-white sticky-top shadow-sm">
		<div class="container-fluid">
			<span style="color: #9E896D;" class="navbar-brand">hieudaoshop.vn</span>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<div class="d-flex align-items-center ms-auto gap-2">

					<!-- Search -->
					<form class="d-flex" role="search">
						<input class="form-control me-2" type="search"
							placeholder="Tìm kiếm">
						<button class="btn btn-outline-success" type="submit">Tìm</button>
					</form>

					<!-- Login -->
					<a href="login.jsp" class="btn btn-outline-secondary"
						style="border-color: #9E896D; color: #9E896D;"> <img
						src="<%=request.getContextPath()%>/img/login/login.png"
						height="21px">
					</a>
				</div>
			</div>
		</div>
	</nav>


	<div class="container mt-5">
		<div class="row">

			<!-- Image -->
			<div class="col-lg-6 col-md-6 mb-4 text-center">
				<img src="<%=product.getThumbnail()%>" class="img-fluid"
					style="max-height: 400px; border-radius: 8px;">
			</div>

			<!-- Info -->
			<div class="col-lg-6 col-md-6 mb-4">
				<h2 style="color: #9E896D;"><%=product.getName()%></h2>

				<h4 class="mt-3" style="color: red;"><%=product.getPrice()%>
					$
				</h4>

				<p class="mt-3" style="font-size: 15px;">
					<%=product.getDescription()%>
				</p>

				<hr>

				<form action="CheckoutServlet" method="post">
					<input type="hidden" name="productId" value="<%=product.getId()%>">
					<input type="hidden" name="price" value="<%=product.getPrice()%>">

					<label class="form-label">Số lượng</label> <input type="number"
						name="quantity" value="1" min="1" class="form-control mb-3"
						style="max-width: 120px;"> <label class="form-label">Họ
						và tên</label> <input type="text" name="fullname"
						class="form-control mb-3" required> <label
						class="form-label">Email</label> <input type="email" name="email"
						class="form-control mb-3" required> <label
						class="form-label">Số điện thoại</label> <input type="text"
						name="phone" class="form-control mb-3" required> <label
						class="form-label">Địa chỉ</label> <input type="text"
						name="address" class="form-control mb-3" required> <label
						class="form-label">Ghi chú</label>
					<textarea name="note" class="form-control mb-3"></textarea>

					<button type="submit" class="btn"
						style="background-color: #9E896D; color: white; padding: 12px 24px;">
						Mua ngay</button>
				</form>


				<br> <a href="IndexServlet"
					style="text-decoration: none; color: #9E896D;"> ← Quay lại
					trang chủ </a>

			</div>
		</div>
	</div>


	<footer class="text-center text-lg-start mt-5"
		style="background-color: white;">
		<div class="container pt-4">
			<div class="row">
				<div class="col-lg-4 col-md-6 mb-4">
					<h5 style="color: #9E896D;">Liên hệ</h5>
					<p>Email: daohuuhieu18112004@gmail.com</p>
					<p>Phone: 0327419422</p>
				</div>
			</div>
		</div>

		<div class="text-center p-3"
			style="background-color: #9E896D; color: white;">© 2025
			hieudaoshop.vn - All Rights Reserved.</div>
	</footer>

</body>
</html>
