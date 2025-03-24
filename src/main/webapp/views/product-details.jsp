<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="product" type="com.example.ejb_watch_cart.models.Product"--%>
<html>
<head>
    <title>${product.name}</title>
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre-exp.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/spectre-0.5.9/spectre-icons.min.css"/>">
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container" style="margin-top: 50px;">
    <div class="columns">
        <div class="column col-2"></div>
        <div class="column col-4">
            <img src="<c:url value="/img/products/${product.id}/${product.mainImage}"/>" class="img-responsive">
        </div>
        <div class="column col-4">
            <h3>${product.name}</h3>
            <p><b>Giá: </b>
                <span><fmt:formatNumber value="${product.price}"
                                        type="currency"
                                        currencyCode="VND"
                                        groupingUsed="true"/>
                </span>
            </p>
            <form action="<c:url value="/cart/add"/>" method="post">
                <div class="form-group">
                    <label class="form-label" for="quantity">Số lượng</label>
                    <input class="form-input" type="number" name="quantity" id="quantity" value="1" min="1">
                </div>
                <input type="hidden" name="productId" value="${product.id}">
                <button class="btn btn-primary">Mua</button>
            </form>
        </div>
        <div class="column col-2"></div>
    </div>
</div>
</body>
</html>
