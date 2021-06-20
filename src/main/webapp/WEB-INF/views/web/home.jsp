<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<main class="main">
        <!-- main banner -->
        <section class="main_banner">
            <div class="container">
                <div class="main_banner-img">
                   	<img src="<c:url value='/template/static/image/banner-1.jpg'/>">
                </div>
            </div>
        </section>
        
        <c:forEach var="category" items="${lstProductOfCategory}">
            <section class="main_products main_page-index">
	            <div class="container">
	                <div class="main_title">
	                    <h2>${category.name}</h2>
	                </div>
	                <div class="main_list-product">
                    	<div class="row">
		            		<c:forEach var="product" items="${category.products}">
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
		        		</div>
                	</div>
	        	</div>
	        </section>
        </c:forEach>
    </main>
</body>
</html>