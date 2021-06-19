<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo tài khoản - MartGTU</title>
</head>
<body>
	<section class="login">
        <div class="container login_width">
            <div class="item fix-pd">
                <div class="login_logo">
                    <p><span>GTU</span><small>mart</small><b>.vn</b></p>
                </div>
                <h5>Tạo tài khoản</h5>
                
                <form:form action="" method="post" modelAttribute="user">
                    <input type="text" name="userName" id="userName" placeholder="Tên đăng nhập">
                    <input type="password" name="passwordText" id="password" placeholder="Mật khẩu">
                    <input type="text" name="firstName" id="firstName" placeholder="Họ">
                    <input type="text" name="lastName" id="lastName" placeholder="Tên">
                    
                    <label for="sex">Giới tính</label>
                    <input type="radio" name="sex" id="male" value="true"> Nam
                    <input type="radio" name="sex" id="female" value="false"> Nữ
                    
                    <button type="submit">Tạo tài khoản</button>
                </form:form>
                <a href="<c:url value='/account/login'/>" style="float: right;">Đăng nhập</a>
            </div>
        </div>
    </section>
</body>
</html>