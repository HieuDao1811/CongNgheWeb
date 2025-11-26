<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập - hieudaoshop.vn</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<style>
body {
	background-color: #f7f7f7;
}

.login-card {
	max-width: 420px;
	margin: 100px auto;
	padding: 25px;
	background: white;
	border-radius: 10px;
	border: 1px solid #e2e2e2;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
}

.brand-text {
	color: #9E896D;
	font-weight: bold;
	font-size: 24px;
}

.btn-login {
	background-color: #9E896D;
	color: white;
}

.btn-login:hover {
	background-color: #8b7760;
}
</style>

</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg bg-white shadow-sm sticky-top">
		<div class="container-fluid">
			<span style="color: #9E896D;" class="navbar-brand">hieudaoshop.vn</span>
		</div>
	</nav>
	<!-- End Navbar -->

	<!-- Login box -->
	<div class="login-card">

		<h3 class="text-center mb-4" style="color: #9E896D;">Đăng nhập</h3>

		<!-- Hiển thị lỗi nếu có -->

		<form action="CheckLoginServlet" method="post">
			<%String errorMessage = (String)request.getAttribute("errorMessage");
                		String successMessage = (String)request.getAttribute("successMessage");%>
			<%if (errorMessage != null) { %>
			<p style="color: red;"><%= errorMessage %></p>
			<% } %>
			<%if (successMessage != null) { %>
			<p style="color: green;"><%= successMessage %></p>
			<% } %>

			<!-- Username -->
			<div class="mb-3">
				<label class="form-label" for="usernameId">Tên đăng nhập</label> <input
					type="text" name="username" id="usernameId" class="form-control"
					required>
			</div>

			<!-- Password -->
			<div class="mb-3">
				<label class="form-label" for="passwordId">Mật khẩu</label> <input
					type="password" name="password" id="passwordId"
					class="form-control" required>
			</div>


			<!-- Button login -->
			<button type="submit" class="btn btn-login w-100 py-2">Đăng
				nhập</button>

			<div class="text-center mt-3">
				Chưa có tài khoản? <a href="register.jsp" style="color: #9E896D;">Đăng
					ký ngay</a>
			</div>

		</form>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
