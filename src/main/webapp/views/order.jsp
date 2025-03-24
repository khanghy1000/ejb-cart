<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="order" type="com.example.ejb_watch_cart.models.Order"--%>
<html>
<head>
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre-exp.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre-icons.min.css"/>">
</head>
<body>
<%@ include file="navbar.jsp" %>
<h3 style="margin-top: 50px; text-align: center;">Đơn hàng</h3>
<p style="margin-top: 20px; text-align: center"><b>Mã đơn hàng: </b>${order.id}</p>
<div class="container columns" style="margin-top: 50px;">
    <table class="table column col-9">
        <thead>
        <tr>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${order.orderDetails}" var="orderDetails">
            <tr>
                <td>${orderDetails.product.name}</td>
                <td><fmt:formatNumber value="${orderDetails.unitPrice}" type="currency" currencyCode="VND"
                                      groupingUsed="true"/></td>
                <td>${orderDetails.quantity}</td>
                <td><fmt:formatNumber value="${orderDetails.unitPrice * orderDetails.quantity}"
                                      type="currency"
                                      currencyCode="VND"
                                      groupingUsed="true"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="column col-3 text-center">
        <h3>Tổng tiền:</h3>
        <p><fmt:formatNumber value="${order.total}" type="currency" currencyCode="VND" groupingUsed="true"/></p>
    </div>
</div>
</body>
</html>
