<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="product" type="com.example.ejb_watch_cart.models.Product"--%>
<%--@elvariable id="cartItem" type="com.example.ejb_watch_cart.models.CartItem"--%>
<html>
<head>
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre-exp.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre-icons.min.css"/>">
</head>
<body>
<%@ include file="navbar.jsp" %>
<c:if test="${empty cart}">
    <div class="container text-center" style="margin-top: 50px;">
        <h3>Giỏ hàng trống</h3>
    </div>
</c:if>
<c:if test="${not empty cart}">
    <h3 style="margin-top: 50px; text-align: center">Giỏ hàng</h3>
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
            <c:forEach items="${cart}" var="cartItem">
                <tr>
                    <td>${cartItem.product.name}</td>
                    <td><fmt:formatNumber value="${cartItem.product.price}" type="currency" currencyCode="VND"
                                          groupingUsed="true"/></td>
                    <td>
                        <div class="input-group">
                            <span class="form-input">${cartItem.quantity}</span>
                            <form action="<c:url value="/cart/decrease"/>" method="post">
                                <input type="hidden" name="productId" value="${cartItem.product.id}">
                                <button class="btn btn-primary input-group-btn">-</button>
                            </form>
                            <form action="<c:url value="/cart/increase"/>" method="post">
                                <input type="hidden" name="productId" value="${cartItem.product.id}">
                                <button class="btn btn-primary input-group-btn">+</button>
                            </form>
                        </div>
                    </td>
                    <td><fmt:formatNumber value="${cartItem.product.price * cartItem.quantity}"
                                          type="currency"
                                          currencyCode="VND"
                                          groupingUsed="true"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="column col-3 text-center">
            <h3>Tổng tiền:</h3>
            <p><fmt:formatNumber value="${total}" type="currency" currencyCode="VND" groupingUsed="true"/></p>
            <form action="<c:url value="/cart/checkout"/>" method="post">
                <button class="btn btn-primary">Đặt hàng</button>
            </form>
        </div>
    </div>

</c:if>
</body>
</html>
