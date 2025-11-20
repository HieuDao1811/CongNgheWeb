<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>

<style>
    body {
        background-color: #f7f5f2;
        font-family: 'Segoe UI', sans-serif;
    }

    /* ===== SIDEBAR ===== */
    .sidebar {
        position: fixed;
        top: 0;
        left: 0;
        width: 240px;
        height: 100vh;
        background-color: #9E896D;       /* Màu nâu */
        color: #fff;
        padding-top: 0.5rem;
    }

    .sidebar-brand {
        font-weight: bold;
        font-size: 1.2rem;
        padding: 1rem 1.5rem;
    }

    .sidebar-user {
        padding: 0.7rem 1.5rem;
        display: flex;
        align-items: center;
        gap: 0.8rem;
    }

    .sidebar-user img {
        width: 42px;
        height: 42px;
        border-radius: 50%;
        object-fit: cover;
        border: 2px solid #fff;
    }

    .sidebar .nav-link {
        color: #f2ece6;
        padding: 0.65rem 1.5rem;
        font-size: 0.95rem;
    }
    .sidebar .nav-link:hover {
        background-color: #8A7457;        /* Hover nâu đậm */
        color: #fff;
    }
    .sidebar .nav-link.active {
        background-color: #8A7457;
        color: #fff;
    }

    .sidebar-section-title {
        font-size: 0.75rem;
        padding: 0.5rem 1.5rem;
        color: #f2ece6;
        opacity: 0.9;
        text-transform: uppercase;
    }

    /* ===== MAIN CONTENT ===== */
    .main-content {
        margin-left: 240px;
        min-height: 100vh;
    }

    .topbar {
        height: 56px;
        background-color: #ffffff;
        border-bottom: 1px solid #ddd;
        display: flex;
        align-items: center;
        padding: 0 1.5rem;
        font-size: 0.95rem;
        font-weight: 500;
    }

    .page-wrapper {
        padding: 2rem 1.5rem;
    }

    .card-form {
        max-width: 720px;
        margin: 0 auto;
        border-radius: 12px;
        border: 0;
        box-shadow: 0 8px 24px rgba(0,0,0,0.08);
    }

    .card-form-header {
        background-color: #9E896D;
        color: #fff;
        padding: 1rem 1.5rem;
        font-weight: 500;
    }

    .btn-brown {
        background-color: #9E896D;
        border-color: #9E896D;
        color: white;
    }
    .btn-brown:hover {
        background-color: #8A7457;
        border-color: #8A7457;
    }

</style>
</head>
<body>

<!-- ===== SIDEBAR ===== -->
<nav class="sidebar">
    <div class="sidebar-brand">Quản lý Shop</div>

    <div class="sidebar-user">
        <img src="https://i.pravatar.cc/100?img=12" alt="avatar">
        <div>
            <div style="font-size:0.85rem;">Xin chào,</div>
            <div style="font-weight:600;">Admin</div>
        </div>
    </div>

    <div class="sidebar-section-title">Menu</div>
    <ul class="nav nav-pills flex-column">
        <li><a href="index.jsp" class="nav-link">Trang chủ</a></li>
        <li><a href="#" class="nav-link active">Quản lý sản phẩm</a></li>
        <li><a href="#" class="nav-link">Danh sách sản phẩm</a></li>
        <li><a href="add_product.jsp" class="nav-link">Thêm sản phẩm</a></li>
        <li><a href="#" class="nav-link">Danh mục</a></li>
        <li><a href="#" class="nav-link">Đơn hàng</a></li>
    </ul>

    <div class="mt-auto" style="padding-top: 10px;">
        <hr class="text-light mx-3">
        <a href="#" class="nav-link text-white px-4">Đăng xuất</a>
    </div>
</nav>

<!-- ===== MAIN CONTENT ===== -->
<div class="main-content">

    <!-- Top bar -->
    <div class="topbar">
        Thêm sản phẩm / Quản lý cửa hàng
    </div>

    <!-- Page body -->
    <div class="page-wrapper">
        <div class="card card-form">
            <div class="card-form-header">
                Thêm sản phẩm mới
            </div>

            <div class="card-body p-4">

                <form action="AddProductServlet" method="post">

                    <div class="mb-3">
                        <label class="form-label">Tên sản phẩm</label>
                        <input type="text" class="form-control"
                               name="name" required placeholder="Nhập tên sản phẩm">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Danh mục</label>
                        <select class="form-select" name="category_id" required>
                            <option value="">-- Chọn danh mục --</option>
                            <option value="1">Túi xách tay</option>
                            <option value="2">Túi mini</option>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Giá</label>
                        <input type="number" class="form-control"
                               name="price" min="0" step="0.01" required placeholder="VD: 500000">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Ảnh sản phẩm (link)</label>
                        <input type="text" class="form-control"
                               name="thumbnail" placeholder="VD: img/product/a.png">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Mô tả</label>
                        <textarea class="form-control" rows="3" name="description"
                                  placeholder="Mô tả sản phẩm..."></textarea>
                    </div>

                    <div class="text-end">
                        <a href="index.jsp" class="btn btn-outline-secondary me-2">Trở lại</a>
                        <button type="submit" class="btn btn-brown">Lưu sản phẩm</button>
                    </div>

                </form>

            </div>
        </div>
    </div>

</div>

</body>
</html>
