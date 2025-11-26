<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.dao.OrdersDAO"%>
<%@page import="model.bean.Orders"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đặt hàng thành công</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color:#f7f7f7;">

<div class="container mt-5">
    <div class="card shadow-sm mx-auto" style="max-width:600px; border-radius:10px;">
        <div class="card-body text-center">
            <h2 class="card-title text-success">🎉 Đặt hàng thành công!</h2>
            <p class="card-text mt-3">Cảm ơn bạn đã mua hàng tại <strong>hieudaoshop.vn</strong>.</p>
            
            <%
                String orderIdParam = request.getParameter("orderId");
                if (orderIdParam != null) {
                    int orderId = Integer.parseInt(orderIdParam);
                    OrdersDAO ordersDAO = new OrdersDAO();
                    Orders order = ordersDAO.getOrderById(orderId);
                    if (order != null) {
            %>
                        <div class="mt-4 text-start">
                            <p><strong>Mã đơn hàng:</strong> <%=order.getId()%></p>
                            <p><strong>Họ tên:</strong> <%=order.getFullname()%></p>
                            <p><strong>Email:</strong> <%=order.getEmail()%></p>
                            <p><strong>Số điện thoại:</strong> <%=order.getPhoneNumber()%></p>
                            <p><strong>Địa chỉ:</strong> <%=order.getAddress()%></p>
                            <p><strong>Tổng tiền:</strong> <span style="color:red;"><%=order.getTotalMoney()%> $</span></p>
                        </div>
            <%
                    }
                }
            %>

            <a href="IndexServlet" class="btn mt-4" style="background-color:#9E896D; color:white; padding:10px 20px;">
                ← Quay về trang chủ
            </a>
        </div>
    </div>
</div>

</body>
</html>
