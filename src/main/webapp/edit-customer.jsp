<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.bean.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa khách hàng</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet" crossorigin="anonymous">
</head>
<body style="background-color:#f7f7f7;">

<%
    Users c = (Users) request.getAttribute("customer");
%>

<div class="container mt-4 mb-5" style="max-width:700px;">
    <h3 class="mb-3" style="color:#9E896D;">Sửa khách hàng</h3>

    <div class="card">
        <div class="card-body">
            <form action="edit-customer" method="post">
                <input type="hidden" name="id" value="<%= c.getId() %>">

                <div class="mb-3">
                    <label class="form-label">Họ tên</label>
                    <input type="text" name="fullname" class="form-control"
                           value="<%= c.getFullname() %>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Số điện thoại</label>
                    <input type="text" name="phone_number" class="form-control"
                           value="<%= c.getPhoneNumber() %>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" name="address" class="form-control"
                           value="<%= c.getAddress() %>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Mật khẩu</label>
                    <input type="text" name="password" class="form-control"
                           value="<%= c.getPassword() %>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Role</label>
                    <select name="role" class="form-select">
                        <option value="0" <%= c.getRole()==0?"selected":"" %>>User</option>
                        <option value="1" <%= c.getRole()==1?"selected":"" %>>Admin</option>
                    </select>
                </div>
                <div class="text-end">
                    <a href="customer-list" class="btn btn-outline-secondary me-2">Trở lại</a>
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
