<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.bean.Products" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xóa sản phẩm</title>

<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
    rel="stylesheet" crossorigin="anonymous">
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
    crossorigin="anonymous"></script>
</head>
<body style="background-color:#f7f7f7;">

<%
    Products p = (Products) request.getAttribute("product");
%>

<div class="container mt-4 mb-5" style="max-width: 700px;">
    <h3 class="mb-3 text-danger">Xóa sản phẩm</h3>

    <div class="card">
        <div class="card-body">

            <%
                if (p == null) {
            %>
                <div class="alert alert-warning">
                    Không tìm thấy sản phẩm.
                </div>
                <a href="product-list" class="btn btn-outline-secondary">Trở lại danh sách</a>
            <%
                } else {
            %>

            <p>Bạn có chắc chắn muốn xóa sản phẩm sau?</p>

            <ul class="list-group mb-3">
                <li class="list-group-item">
                    <strong>ID:</strong> <%= p.getId() %>
                </li>
                <li class="list-group-item">
                    <strong>Tên:</strong> <%= p.getName() %>
                </li>
                <li class="list-group-item">
                    <strong>Giá:</strong> <%= p.getPrice() %>
                </li>
                <li class="list-group-item">
                    <strong>Mô tả:</strong> <%= p.getDescription() %>
                </li>
            </ul>

            <form action="delete-product" method="post" class="text-end">
                <input type="hidden" name="id" value="<%= p.getId() %>">
                <a href="product-list" class="btn btn-outline-secondary me-2">
                    Hủy
                </a>
                <button type="submit" class="btn btn-danger">
                    Xóa
                </button>
            </form>

            <%
                }
            %>

        </div>
    </div>
</div>

</body>
</html>
