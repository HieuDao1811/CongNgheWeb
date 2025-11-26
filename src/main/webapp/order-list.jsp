<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List, model.bean.Orders"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Đơn hàng</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet" crossorigin="anonymous">
</head>
<body style="background-color:#f7f7f7;">

<%
    List<Orders> orderList = (List<Orders>) request.getAttribute("orderList");
    String keyword = (String) request.getAttribute("keyword");
%>

<div class="container mt-4 mb-5">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h3 style="color:#9E896D;">Quản lý đơn hàng</h3>

        <form class="d-flex" method="get" action="order-list">
            <input class="form-control me-2" type="search" name="keyword"
                   placeholder="Tìm theo mã, tên KH, SĐT, trạng thái"
                   value="<%= keyword != null ? keyword : "" %>">
            <button class="btn btn-outline-secondary"
                    style="border-color:#9E896D; color:#9E896D;">Tìm</button>
        </form>
    </div>

    <div class="mb-3 text-end">
        <a href="add-order" class="btn btn-outline-secondary"
           style="border-color:#9E896D; color:#9E896D;">
            + Thêm đơn hàng
        </a>
    </div>

    <div class="card">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>Mã đơn</th>
                            <th>Khách hàng</th>
                            <th>SĐT</th>
                            <th>Ngày đặt</th>
                            <th>Trạng thái</th>
                            <th>Tổng tiền</th>
                            <th class="text-center">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        if (orderList != null && !orderList.isEmpty()) {
                            for (Orders o : orderList) {
                    %>
                        <tr>
                            <td>#<%= o.getId() %></td>
                            <td><%= o.getFullname() %></td>
                            <td><%= o.getPhoneNumber() %></td>
                            <td><%= o.getOrderDate() %></td>
                            <td><span class="badge bg-secondary"><%= o.getStatus() %></span></td>
                            <td><%= o.getTotalMoney() %></td>
                            <td class="text-center">
                                <a href="edit-order?id=<%= o.getId() %>"
                                   class="btn btn-sm btn-outline-primary me-1">Sửa</a>
                                <a href="delete-order?id=<%= o.getId() %>"
                                   class="btn btn-sm btn-outline-danger"
                                   onclick="return confirm('Xóa đơn hàng này?');">
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
                                Chưa có đơn hàng nào.
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
