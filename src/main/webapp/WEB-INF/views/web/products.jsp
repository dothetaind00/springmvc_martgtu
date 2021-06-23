<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
</head>
<body>
	<!-- main -->
    <main class="main">
        <section class="main_page-link">
            <div class="container">
                <p class="main_link-name">
                    <span><a href="<:url value='/trang-chu'/>">Trang chủ</a> > Sản phẩm > </span>
                    <span class="main_product-name">Thịt</span>
                </p>
            </div>
        </section>
        <section class="main_page-sanpham main_products">
            <div class="container">
                <div class="row">
                    <div class="main_list-category">
                        <p>Danh mục sản phẩm</p>
                        <ul>
                        	<c:forEach var="entry" items="${menu}">
                        		<li>
	                                <a href="<c:url value='/product/products-of-catgory/${entry.key}'/>">${entry.value}</a>
	                            </li>
                        	</c:forEach>
                        </ul>
                    </div>
                    <div class="main_list-product">
                        <div class="row">
                        	<c:if test="${empty products}">
                        		<p>Không có sản phẩm nào được tìm thấy !</p>
                        	</c:if>
                        	<c:if test="${not empty products}">
                        		<c:forEach var="product" items="${products}">
	                        		<div class="main_item">
			                            <div class="main_product-view">
			                                <i class="fa fa-eye" aria-hidden="true"></i>
			                            </div>
	                            		<div class="main_product-img">
			                                <a href="<c:url value='/product/product-detail/${product.id}' />">
			                                	<c:forEach var="detail" items="${product.details}">
			                                		<img src="<c:url value='/template/static/image/${detail.image}'/>">
			                                	</c:forEach>
			                                </a>
	                            		</div>
			                            <div class="main_product-info">
			                                <p class="main_product-name">${product.name}</p>
			                                <p class="main_product-price">
			                                    <span>${product.price}</span>
			                                    <span>đ</span>
			                                </p>
			                            </div>
			                            <div class="main_product-control">
			                                <a href="<c:url value='/cart/add-cart/${product.id}'/>">Thêm giỏ hàng</a>
			                            </div>
	                        		</div>
	                        	</c:forEach>
                        	</c:if>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
</body>
</html>