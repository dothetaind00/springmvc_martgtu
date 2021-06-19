<%@ page import="com.tai06dothe.util.SecurityUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!-- heaser -->
<header class="header">
    <div class="header_top">
        <div class="container">
            <div class="row justify-between align-center">
                <div class="header_bar">
                    <i class="fa fa-bars" aria-hidden="true"></i>
                </div>
                <a href="index.html" class="header_logo">
                    <span>GTU</span>
                    <small>mart</small>
                    <b>.vn</b>
                </a>
                <form class="header_search" action="#">
                    <input type="text" placeholder="Tìm kiếm...">
                    <button type="button">
                        <i class="fa fa-search" aria-hidden="true"></i>
                    </button>
                </form>
                <ul class="d-flex">
                    <security:authorize access = "isAnonymous()">
						<li>
							<a href="<c:url value='/account/login'/>" class="d-flex align-center">
                                <span><i class="fa fa-user" aria-hidden="true"></i></span>
                                <span>Đăng nhập <br> Đăng ký</span>
                            </a>
						</li>
					</security:authorize>
						
					<security:authorize access = "isAuthenticated()">
						<li>
							<a href="<c:url value='/perform_logout'/>" class="d-flex align-center"> 
								<span><i class="fa fa-user" aria-hidden="true"></i></span>
								<span> Hello, <%=SecurityUtil.getPrincipal().getLastName()%> <br> Đăng xuất</span>
							</a>
						</li>
					</security:authorize>
                    <li>
                        <a href="#" class="d-flex align-center">
                            <span><i class="fa fa-cart-plus" aria-hidden="true"></i></span>
                            <span>Giỏ hàng <br> (0) sản phẩm</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <nav class="header_nav">
        <div class="header_close">
            <i class="fa fa-times" aria-hidden="true"></i>
        </div>
        <div class="container">
            <div class="row">
                <ul class="header_menu">
                    <li>
                        <a href="index.html">Trang chủ</a>
                    </li>
                    <li class="header_drop">
                        <a href="#">Sản phẩm <i class="fa fa-chevron-down" aria-hidden="true"></i></a>
                        <div class="drop-down">
                            <a href="#">Thịt</a>
                            <a href="#">Bánh kẹo</a>
                            <a href="#">Nước uống</a>
                            <a href="#">Rau</a>
                            <a href="#">Sữa</a>
                        </div>
                    </li>
                    <li>
                        <a href="#">Giới thiệu</a>
                    </li>
                    <li>
                        <a href="#">Tin tức</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="overlay"></div>
</header>

