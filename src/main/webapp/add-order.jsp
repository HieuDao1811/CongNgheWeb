<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm đơn hàng</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet" crossorigin="anonymous">
</head>
<body style="background-color:#f7f7f7;">

<div class="container mt-4 mb-5" style="max-width:800px;">
    <h3 class="mb-3" style="color:#9E896D;">Thêm đơn hàng</h3>

    <div class="card">
        <div class="card-body">
            <form action="add-order" method="post">
                <div class="row g-3">
                    <div class="col-md-3">
                        <label class="form-label">User ID</label>
                        <input type="number" name="user_id" class="form-control" value="0">
                    </div>
                    <div class="col-md-9">
                        <label class="form-label">Tên khách hàng</label>
                        <input type="text" name="fullname" class="form-control" required>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Email</label>
                        <input type="email" name="email" class="form-control">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">SĐT</label>
                        <input type="text" name="phone_number" class="form-control" required>
                    </div>
                    <div class="col-12">
                        <label class="form-label">Địa chỉ</label>
                        <input type="text" name="address" class="form-control" required>
                    </div>
                    <div class="col-12">
                        <label class="form-label">Ghi chú</label>
                        <textarea name="note" class="form-control" rows="2"></textarea>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Trạng thái</label>
                        <select name="status" class="form-select">
                            <option value="Mới tạo">Mới tạo</option>
                            <option value="Đang xử lý">Đang xử lý</option>
                            <option value="Hoàn thành">Hoàn thành</option>
                            <option value="Hủy">Hủy</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Tổng tiền</label>
                        <input type="number" step="0.01" min="0" name="total_money"
                               class="form-control" required>
                    </div>
                </div>

                <div class="text-end mt-3">
                    <a href="order-list" class="btn btn-outline-secondary me-2">Trở lại</a>
                    <button type="submit" class="btn btn-primary"
                            style="background-color:#9E896D;border-color:#9E896D;">
                        Lưu đơn hàng
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
