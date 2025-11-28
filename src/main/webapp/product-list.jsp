<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List, model.bean.Products" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Danh sách sản phẩm</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
    crossorigin="anonymous">
<script
    src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
    crossorigin="anonymous"></script>
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
    integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y"
    crossorigin="anonymous"></script>
</head>
<body style="background-color:#f7f7f7;">

<%
    List<Products> productList = (List<Products>) request.getAttribute("productList");
%>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg bg-white sticky-top shadow-sm">
        <div class="container-fluid">
            <span style="color: #9E896D;" class="navbar-brand">
                hieudaoshop.vn <span class="badge bg-secondary ms-1">Admin</span>
            </span>
            <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="d-flex align-items-center ms-auto gap-2">
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

        <div class="d-flex justify-content-between align-items-center mb-3">
         	<!-- Nút quay về admin -->
		    <a href="admin_index.jsp"
		       class="btn btn-outline-secondary"
		       style="border-color:#9E896D; color:#9E896D;">
		        Quay về
		    </a>
        
            <h3 style="color:#9E896D;">Quản lý sản phẩm</h3>
            <a href="add-product.jsp"
               class="btn btn-outline-secondary"
               style="border-color:#9E896D; color:#9E896D;">
                + Thêm sản phẩm
            </a>
        </div>

        <div class="card">
            <div class="card-body">

                <div class="table-responsive">
                    <table class="table table-striped table-hover align-middle mb-0">
                        <thead class="table-light">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Ảnh</th>
                                <th scope="col">Tên sản phẩm</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Danh mục</th>
                                <th scope="col">Mô tả</th>
                                <th scope="col" class="text-center">Thao tác</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                            if (productList != null && !productList.isEmpty()) {
                                for (Products p : productList) {
                                    String thumb = (p.getThumbnail() != null && !p.getThumbnail().isEmpty())
                                                 ? p.getThumbnail()
                                                 : "img/product/default.png"; // nếu cần ảnh mặc định
                        %>
                            <tr>
                                <td><%= p.getId() %></td>

                                <td>
                                    <img src="<%= thumb %>"
                                         alt="<%= p.getName() %>"
                                         style="width:60px; height:60px; object-fit:cover; border-radius:4px;">
                                </td>

                                <td><%= p.getName() %></td>

                                <td><%= p.getPrice() %></td>

                                <td><%= p.getCategoryName() != null ? p.getCategoryName() : "" %></td>

                                <td style="max-width:250px;">
                                    <span class="d-inline-block text-truncate" style="max-width: 250px;">
                                        <%= p.getDescription() %>
                                    </span>
                                </td>

                                <td class="text-center">
                                    <a href="edit-product?id=<%= p.getId() %>"
                                       class="btn btn-sm btn-outline-primary me-1">
                                        Sửa
                                    </a>
                                    <a href="delete-product?id=<%= p.getId() %>"
                                       class="btn btn-sm btn-outline-danger"
                                       onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">
                                        Xóa
                                    </a>
                                </td>
                            </tr>
                        <%
                                } 
                            } else {
                        %>
                            <tr>
                                <td colspan="7" class="text-center text-muted">
                                    Chưa có sản phẩm nào.
                                </td>
                            </tr>
                        <%
                            } // end if
                        %>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>

    </div>
    <!-- End Page content -->

    <!-- Footer -->
    <footer class="text-center text-lg-start mt-5" style="background-color: white;">
      <div class="text-center p-3" style="background-color: #9E896D; color: white;">
        © 2025 hieudaoshop.vn - Admin
      </div>
    </footer>
    <!-- End Footer -->

</body>
</html>
