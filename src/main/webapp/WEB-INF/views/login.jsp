<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tài khoản - MartGTU</title>
</head>
<body>
	<section class="login">
        <div class="container login_width">
            <div class="item">
                <div class="login_logo">
                    <p><span>GTU</span><small>mart</small><b>.vn</b></p>
                </div>
                <h5>Đăng Nhập</h5>
                
                <form action="<c:url value='/perform_login'/>" method="post">
                    <input type="text" name="username" id="username" placeholder="Tên đăng nhập">
                    <input type="password" name="password" id="password" placeholder="Mật khẩu">
                    <button type="submit">Đăng nhập</button>
                </form>
                
                <c:if test="${param.incorrectAccount != null}">
                	<p>UserName or Password Incorrect !</p>
                	<br>
                </c:if>
                
                <a href="<c:url value='/account/register'/>">Tạo tài khoản</a>
            </div>
        </div>
    </section>
</body>
</html>