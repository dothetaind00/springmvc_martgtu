<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
</head>
<body>
	<main class="main">
        <section class="main_page-link">
            <div class="container">
                <p class="main_link-name">
                    <span><a href="<c:url value='/trang-chu'/>">Trang chủ</a> > </span>
                    <span class="main_product-name">${product.name}</span>
                </p>
            </div>
        </section>

        <section class="main_product-detail">
            <div class="container">
                <div class="row justify-between main_detail">
                    <div class="main_detail-img">
                    	<c:forEach var="detail" items="${product.details}">
                    		<img src="${pageContext.request.contextPath}/${detail.image}">
                    	</c:forEach>
                    </div>
                    <div class="main_detail-info">
                        <div class="main_product-info">
                            <p class="main_product-name">${product.name}</p>
                            <div class="main_item">
                                <span class="main_label">Giá</span>
                                <span class="main_product-price">
                                <span>${product.price}</span>đ
                                </span>
                            </div>
                            <div class="main_item">
                                <span class="main_label">Tình trạng</span>
                                <span>${product.status}</span>
                            </div>
                        </div>
                        <div class="main_product-control">
                            <div class="main_item">
                                <span class="main_label">Số lượng</span>
                                <span class="main_control">
                                    <button type="button"><i class="fa fa-plus" aria-hidden="true"></i></button>
                                    <input type="text" value="1" disabled>
                                    <button type="button"><i class="fa fa-minus" aria-hidden="true"></i></button>
                                </span>
                            </div>
                            <a href="<c:url value='/cart//add-cart/${product.id}'/>">Thêm giỏ hàng</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="main_product-about">
            <div class="container">
                <h3 class="main_product-title">Về sản phẩm</h3>
                <div class="main_about">
                    <p class="main_product-name">${product.name}</p>
                    <c:forEach var="detail" items="${product.details}">
	                    <div class="main_product-img">
	                        <img src="${pageContext.request.contextPath}/${detail.image}">
	                    </div>
	                    <p class="main_product-desc">
	                    	${detail.description}
	                    </p>
                    </c:forEach>
                </div>
            </div>
        </section>
    </main>
</body>
</html>