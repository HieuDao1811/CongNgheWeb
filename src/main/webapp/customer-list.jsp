<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.bean.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Khách hàng</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet" crossorigin="anonymous">
</head>
<body style="background-color:#f7f7f7;">

<%
    List<Users> customers = (List<Users>) request.getAttribute("customerList");
    String keyword = (String) request.getAttribute("keyword");
%>

<div class="container mt-4 mb-5">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h3 style="color:#9E896D;">Quản lý khách hàng</h3>

        <form class="d-flex" method="get" action="customer-list">
            <input class="form-control me-2" type="search" name="keyword"
                   placeholder="Tìm theo tên, SĐT, địa chỉ"
                   value="<%= keyword != null ? keyword : "" %>">
            <button class="btn btn-outline-secondary"
                    style="border-color:#9E896D; color:#9E896D;">Tìm</button>
        </form>
    </div>

    <div class="mb-3 text-end">
        <a href="add-customer" class="btn btn-outline-secondary"
           style="border-color:#9E896D; color:#9E896D;">
            + Thêm khách hàng
        </a>
    </div>

    <div class="card">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>ID</th>
                            <th>Họ tên</th>
                            <th>SĐT</th>
                            <th>Địa chỉ</th>
                            <th>Role</th>
                            <th class="text-center">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        if (customers != null && !customers.isEmpty()) {
                            for (Users u : customers) {
                    %>
                        <tr>
                            <td><%= u.getId() %></td>
                            <td><%= u.getFullname() %></td>
                            <td><%= u.getPhoneNumber() %></td>
                            <td><%= u.getAddress() %></td>
                            <td><%= u.getRole() == 1 ? "Admin" : "User" %></td>
                            <td class="text-center">
                                <a href="edit-customer?id=<%= u.getId() %>"
                                   class="btn btn-sm btn-outline-primary me-1">Sửa</a>
                                <a href="delete-customer?id=<%= u.getId() %>"
                                   class="btn btn-sm btn-outline-danger"
                                   onclick="return confirm('Xóa khách hàng này?');">
                                    Xóa
                                </a>
                            </td>
                        </tr>
                    <%
                            }
                        } else {
                    %>
                        <tr>
                            <td colspan="6" class="text-center text-muted">
                                Chưa có khách hàng nào.
                            </td>
                        </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
