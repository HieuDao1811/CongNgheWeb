<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.lang.Integer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Trang chủ</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
    crossorigin="anonymous">
<script
    src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc2pM8ODewa9r"
    crossorigin="anonymous"></script>
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
    integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y"
    crossorigin="anonymous"></script>
</head>
<body style="background-color:#f7f7f7;">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg bg-white sticky-top shadow-sm">
        <div class="container-fluid">
            <span style="color: #9E896D;" class="navbar-brand">
                hieudaoshop.vn
                <span class="badge bg-secondary ms-2">Admin</span>
            </span>
            <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="ms-auto d-flex align-items-center gap-2">
                    <a href="login.jsp"
                       class="btn btn-outline-danger">
                        Đăng xuất
                    </a>
                </div>
            </div>
        </div>
    </nav>
    <!-- End Navbar -->

    <!-- Page content -->
    <div class="container mt-4 mb-5">

        <div class="row mb-4">
            <div class="col-12">
                <h3 style="color:#9E896D;">Trang quản trị hieudaoshop.vn</h3>
                <p class="text-muted mb-1">
                    Chào mừng bạn đến với khu vực quản lý. Tại đây bạn có thể theo dõi tổng quan shop,
                    quản lý sản phẩm, đơn hàng và khách hàng.
                </p>
            </div>
        </div>
        <!-- Hàng chức năng nhanh -->
        <div class="row g-3">
            <div class="col-lg-4">
                <div class="card border-0 shadow-sm h-100">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title" style="color:#9E896D;">Quản lý sản phẩm</h5>
                        <a href="admin-products"
                           class="btn btn-outline-secondary mt-2"
                           style="border-color:#9E896D; color:#9E896D;">
                            Đi tới danh sách sản phẩm
                        </a>
                    </div>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="card border-0 shadow-sm h-100">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title" style="color:#9E896D;">Quản lý đơn hàng</h5>
                        <a href="order-list"
                           class="btn btn-outline-secondary mt-2"
                           style="border-color:#9E896D; color:#9E896D;">
                            Xem đơn hàng
                        </a>
                    </div>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="card border-0 shadow-sm h-100">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title" style="color:#9E896D;">Quản lý người dùng</h5>
                        <a href="customer-list"
                           class="btn btn-outline-secondary mt-2"
                           style="border-color:#9E896D; color:#9E896D;">
                            Xem người dùng
                        </a>
                    </div>
                </div>
            </div>
        </div>



</body>
</html>
