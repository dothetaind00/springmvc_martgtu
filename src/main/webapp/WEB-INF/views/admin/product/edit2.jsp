<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="productAPI" value="/api/product"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
				</script>
				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-home home-icon"></i>
						<a href="#">Home</a>
					</li>
					<li>
						<a href="#">Forms</a>
					</li>
					<li class="active">Form Elements</li>
				</ul>
				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<span class="input-icon">
							<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off">
							<i class="ace-icon fa fa-search nav-search-icon"></i>
						</span>
					</form>
				</div>
			</div>
			<div class="page-header">
				<h1>
					Form Elements
					<small>
						<i class="ace-icon fa fa-angle-double-right"></i>
						Common form elements and layouts
					</small>
				</h1>
			</div>
			
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<form class="form-horizontal" role="form" id="formSubmit" enctype="multipart/form-data">
						
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="product.category.id"> Danh mục </label>
								<div class="col-sm-9">
									<select name="category.id" id="categoryId">
										<c:if test="${empty product.category.id}">
											<option value="">Chọn loại sản phẩm</option>
                                            <c:forEach var="entry" items="${menu}">
                                                <option value="${entry.key}">${entry.value}</option>
                                            </c:forEach>
										</c:if>
										<c:if test="${not empty product.category.id}">
											<option value="">Chọn loại sản phẩm</option>
                                            <c:forEach var="entry" items="${menu}">
                                                <option value="${entry.key}" <c:if test="${entry.key == product.category.id}">selected="selected"</c:if>>
                                                        ${entry.value}
                                                </option>
                                            </c:forEach>
										</c:if>
									</select>
								</div>
							</div>
						
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="image"> Hình ảnh </label>
								<div class="col-sm-9">
									<input type="file" id="image" name="image" class="col-xs-10 col-sm-5">
									<c:forEach var="detail" items="${product.details}">
										<img src="<c:url value='/template/static/image/${detail.image}'/>" alt="product" style="height: 75px; width: 75px"/>
									</c:forEach>
								</div>
							</div>
						
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="name"> Tên sản phẩm </label>
								<div class="col-sm-9">
									<input class="col-xs-10 col-sm-5" type="text" name="name" value="${product.name}">
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="price"> Đơn giá </label>
								<div class="col-sm-9">
									<input class="col-xs-10 col-sm-5" type="text" name="price" value="${product.price}">
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="quantity"> Số lượng </label>
								<div class="col-sm-9">
									<input class="col-xs-10 col-sm-5" type="text" name="quantity" value="${product.quantity}">
								</div>
							</div>
							
							<div class="form-group">
							  	<label for="details.description" class="col-sm-3 control-label no-padding-right"> Mô tả </label>
							  	<div class="col-sm-9">
							  		<c:forEach var="detail" items="${product.details}">
										<textarea name="details.description" rows="5" cols="100" cssClass="form-control" id="description">${detail.description}</textarea>
									</c:forEach>
							  	</div>
							</div>
							
							<input type="hidden" name="id" id="productId" value="${product.id}" />
							
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<c:if test="${empty product.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i>
											Thêm sản phẩm
										</button>
									</c:if>
									<c:if test="${not empty product.id}">
										<c:url var="editProduct" value="/admin/edit-product/${model.id}"></c:url>
										<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i>
											Cập nhật sản phẩm
										</button>
									</c:if>
									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i>
										Hủy
									</button>
								</div>		
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	
		$('#btnAddOrUpdateNew').click(function(e){
			e.preventDefault();
			var elements = $('#formSubmit').serializeArray();
			
			var data = {};
			for(let i=0; i < elements.length; i++){
				let element = elements[i];
				var val = element.value;
				if(!val) val="";
				let getName = element.name;
				if (!getName) continue;
				var getNameParts = getName.split('.');
				var prefix = '';
				var stack = data;
				for(let j = 0; j < getNameParts.length -1; j++){
					prefix = getNameParts[j];
					if (prefix === "details") {
						if (!stack[prefix]) {
                            stack[prefix] = [];
                        }
                        stack = stack[prefix];
					} else {
						if (!stack[prefix]) {
                            stack[prefix] = {};
                        }
                        stack = stack[prefix];
					}
				}
				if (prefix === "details") {
					prefix = getNameParts[getNameParts.length - 1];
					if (!stack[prefix]) {
						data["details"].push({
							[prefix] : val,
						});
	                }
				}else{
					prefix = getNameParts[getNameParts.length - 1];
					if (!stack[prefix]) {
						stack[prefix] = val;
	                }
				}
			}
			
			console.log(data);
			
			var id = $('#productId').val();
			if (id == "") {
				addProduct(data);
			} else {
				updateProduct(data);
			}
		});
		
		function addProduct(data) {
			$.ajax({
	            url: '${productAPI}',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	console.log(result);
	            	window.location.href = "${editProduct}";
	            },
	            error: function (error) {
	            	console.log(error);
	            	window.location.href = "${editProduct}";
	            }
	        });
		}
	
		function updateProduct(data) {
			$.ajax({
	            url: '${productAPI}',
	            type: 'PUT',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = "${editProduct}";
	            },
	            error: function (error) {
	            }
	        });
		}
	</script>
</body>
</html>