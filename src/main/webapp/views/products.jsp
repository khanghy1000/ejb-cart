<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sản phẩm</title>
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre-exp.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre-icons.min.css"/>">
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container" style="margin-top: 50px;">
    <div class="columns">
        <%--@elvariable id="product" type="com.example.ejb_watch_cart.models.Product"--%>
        <c:forEach items="${products}" var="product">
            <div class="card column col-3">
                <div class="card-image">
                    <img src="<c:url value="/img/products/${product.id}/${product.mainImage}"/>" class="img-responsive">
                </div>
                <div class="card-header">
                    <div class="card-title h5">${product.name}</div>
                </div>
                <div class="card-footer">
                    <a class="btn btn-primary" href="<c:url value="/products/details/${product.id}"/>">Xem</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
