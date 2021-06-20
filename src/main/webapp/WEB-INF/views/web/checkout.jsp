<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán</title>
</head>
<body>
	<main class="main">
        <section class="main_page-link">
            <div class="container">
                <p class="main_link-name">
                    <span><a href="<c:url value='/trang-chu'/>">Trang chủ</a> > </span>
                    <span class="main_product-name">Thanh toán</span>
                </p>
            </div>
        </section>

        <section class="main_page-checkout">
            <div class="container">
                <div class="main_title">
                    <h2>Điền thông tin nhận hàng</h2>
                </div>
                <form:form class="main_form-checkout" modelAttribute="billDTO" action="" method="post">
                    <div class="main_checkout-info">
                        <label for="name">Họ và tên</label>
                        <input type="text" name="name" id="name" placeholder="Nhập họ và tên đầy đủ">
                    </div>
                    <div class="main_checkout-info">
                        <label for="numberPhone">Điện thoại di động</label>
                        <input type="text" name="numberPhone" id="numberPhone" placeholder="Nhập số điện thoại">
                    </div>
                    <div class="main_checkout-info">
                        <label for="address">Địa chỉ giao hàng</label>
                        <input type="text" name="address" id="address" placeholder="Nhập địa chỉ giao hàng cụ thể">
                    </div>
                    <div class="main_checkout-info">
                        <label for="note">Ghi chú</label>
                        <textarea rows="5" name="note" placeholder="Ghi chú"></textarea>
                    </div>
                    <div class="main_checkout-success">
                        <button type="submit">Hoàn tất</button>
                    </div>
                </form:form>
            </div>
        </section>
    </main>
</body>
</html>