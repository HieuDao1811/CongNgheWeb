<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản - hieudaoshop.vn</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
  body { background-color: #f7f7f7; }
  .register-card {
    max-width: 500px;
    margin: 50px auto;
    padding: 25px;
    background: white;
    border-radius: 10px;
    border: 1px solid #e2e2e2;
    box-shadow: 0 2px 10px rgba(0,0,0,0.05);
  }
  .brand-text {
    color: #9E896D;
    font-weight: bold;
    font-size: 24px;
  }
  .btn-register {
    background-color: #9E896D;
    color: white;
  }
  .btn-register:hover {
    background-color: #8b7760;
  }
</style>

</head>
<body>

<!-- Navbar -->
<nav class="navbar bg-white shadow-sm sticky-top">
  <div class="container-fluid">
    <span class="navbar-brand sty" style="color: #9E896D;">hieudaoshop.vn</span>
  </div>
</nav>

<!-- Register box -->
<div class="register-card">

  <h3 class="text-center mb-3" style="color:#9E896D;">Đăng ký tài khoản</h3>

  <form action="CheckRegisterServlet" method="post">

    <!-- Username -->
    <div class="mb-3">
      <label class="form-label">Tên đăng nhập</label>
      <input type="text" name="username" class="form-control" required>
    </div>

    <!-- Fullname -->
    <div class="mb-3">
      <label class="form-label">Họ và tên</label>
      <input type="text" name="fullname" class="form-control" required>
    </div>

    <!-- Phone -->
    <div class="mb-3">
      <label class="form-label">Số điện thoại</label>
      <input type="text" name="phoneNumber" class="form-control" required>
    </div>

    <!-- Address -->
    <div class="mb-3">
      <label class="form-label">Địa chỉ</label>
      <input type="text" name="address" class="form-control" required>
    </div>

    <!-- Password -->
    <div class="mb-3">
      <label class="form-label">Mật khẩu</label>
      <input type="password" name="password" class="form-control" required>
    </div>

    <div class="mb-4">
      <label class="form-label">Nhập lại mật khẩu</label>
      <input type="password" name="confirmPassword" class="form-control" required>
    </div>
	<!-- End Password -->

    <!-- Button -->
    <button type="submit" class="btn btn-register w-100 py-2">Đăng ký</button>

    <div class="text-center mt-3">
      Đã có tài khoản?
      <a href="login.jsp" style="color:#9E896D;">Đăng nhập ngay</a>
    </div>

  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
