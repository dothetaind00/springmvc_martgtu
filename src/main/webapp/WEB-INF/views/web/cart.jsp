<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>
<body>
	<main class="main">
        <section class="main_page-link">
            <div class="container">
                <p class="main_link-name">
                    <span><a href="<c:url value='/trang-chu'/>">Trang chủ</a> > </span>
                    <span class="main_product-name">Giỏ hàng</span>
                </p>
            </div>
        </section>

        <section class="main_page-cart">
            <div class="container">
                <form action="#" class="row">
                    <table class="main_table-cart">
                        <thead>
                            <tr>
                                <th>Tên sản phẩm</th>
                                <th class="main_cart-title">Giá</th>
                                <th class="main_cart-title">Số lượng</th>
                                <th>Thành tiền</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:if test="${not empty sessionScope.cart}">
	                        	<c:forEach items="${sessionScope.cart}" var="item">
		                            <tr class="main_cart-item">
		                                <td class="d-flex align-center">
		                                    <div class="main_check-product">
		                                        <input type="checkbox" name="checkBuy" id="checkBuy">
		                                    </div>
		                                    <div class="main_cart-img">
		                                        <a href="#">
		                                        	<c:forEach var="detail" items="${item.value.product.details}">
		                                        		<img src="<c:url value='/template/static/image/${detail.image}'/>" alt="sanpham">
		                                        	</c:forEach>
		                                        </a>
		                                    </div>
		                                    <div class="main_cart-info">
		                                        <p class="main_cart-name">${item.value.product.name}</p>
		                                        <p class="cart-quantity-price">
		                                            <span class="cart-quantity">${item.value.quantity}</span>
		                                            <span><i class="fa fa-times" aria-hidden="true"></i></span>
		                                            <span class="cart-price">${item.value.price}</span><span>đ</span>
		                                        </p>
		                                        <p class="main_remove-product">
		                                            <i class="fa fa-trash" aria-hidden="true"></i>
		                                            <a href="#">Xóa sản phẩm</a>
		                                        </p>
		                                    </div>
		                                </td>
		                                <td class="main_cart-price">
		                                    <span>${item.value.price}</span><span>đ</span>
		                                </td>
		                                <td class="main_cart-quantity">
		                                    <span>
		                                        <button type="button"><i class="fa fa-plus" aria-hidden="true"></i></button>
		                                        <input type="text" value="${item.value.quantity}" disabled>
		                                        <button type="button"><i class="fa fa-minus" aria-hidden="true"></i></button>
		                                    </span>
		                                </td>
		                                <td class="main_cart-money">
		                                    <span>${item.value.summoney}</span><span>đ</span>
		                                </td>
		                            </tr>
		                        </c:forEach>
	                    	</c:if>
	                    	
	                    	 <c:if test="${empty sessionScope.cart}">
	                    	 	<tr>
	                    	 		<td>Không có sản phẩm nào trong giỏ hàng !</td>
	                    	 	</tr>
		                    </c:if>
	                    	
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="4">
                                    <a href="<c:url value='/trang-chu'/>">Tiếp tục mua hàng</a>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                    
                    <div class="main_cart-control">
                        <div class="main_cart-item d-flex">
                            <p class="main_label">Tổng tiền</p>
                            <p>
                                <span>${sessionScope.totalMonney}</span>
                                <span>đ</span>
                            </p>
                        </div>
                        <div class="main_cart-status">
                            <input type="checkbox" name="checkBuyAll" id="checkBuyAll">
                            <label for="checkBuyAll">Tất cả sản phẩm</label>
                        </div>
                        <a href="<c:url value='/thanh-toan'/>">Thanh toán</a>
                        
                    </div>
                </form>
            </div>
        </section>
    </main>
</body>
</html>