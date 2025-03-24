<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<header class="navbar m-2">
  <section class="navbar-section">
    <a href="<c:url value="/products"/>" class="btn btn-link">Trang chủ</a>
  </section>
  <section class="navbar-section">
      <a class="btn btn-primary" href="<c:url value="/cart"/>">Giỏ hàng</a>
  </section>
</header>
</body>
</html>
