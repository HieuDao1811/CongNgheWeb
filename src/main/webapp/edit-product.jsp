<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa sản phẩm</title>

<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
    rel="stylesheet" crossorigin="anonymous">
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
    crossorigin="anonymous"></script>
</head>
<body style="background-color:#f7f7f7;">

<div class="container mt-4 mb-5" style="max-width: 700px;">
    <h3 class="mb-3" style="color:#9E896D;">Sửa sản phẩm</h3>

    <div class="card">
        <div class="card-body">

            <form action="edit-product" method="post">
                <!-- gửi id ẩn -->
                <input type="hidden" name="id" value="${product.id}"/>

                <div class="mb-3">
                    <label class="form-label">Tên sản phẩm</label>
                    <input type="text" name="name" class="form-control"
                           value="${product.name}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Giá</label>
                    <input type="number" step="0.01" min="0" name="price"
                           class="form-control" value="${product.price}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Danh mục</label>
                    <select name="category_id" class="form-select" required>
                        <option value="">-- Chọn danh mục --</option>
                        <option value="1" ${product.categoryId == 1 ? "selected" : ""}>Túi xách tay</option>
                        <option value="2" ${product.categoryId == 2 ? "selected" : ""}>Túi mini</option>
                        <!-- Sau này bạn thay bằng forEach categories từ DB -->
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Ảnh sản phẩm (link)</label>
                    <input type="text" name="thumbnail" class="form-control"
                           value="${product.thumbnail}">
                </div>

                <div class="mb-3">
                    <label class="form-label">Mô tả</label>
                    <textarea name="description" class="form-control" rows="3">${product.description}</textarea>
                </div>

                <div class="text-end">
                    <a href="product-list" class="btn btn-outline-secondary me-2">Trở lại</a>
                    <button type="submit" class="btn btn-primary"
                            style="background-color:#9E896D;border-color:#9E896D;">
                        Lưu thay đổi
                    </button>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>
