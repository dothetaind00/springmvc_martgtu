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
						<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="product">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="category.id"> Thể loại </label>
								<div class="col-sm-9">
							  	 	<form:select path="category.id" id="categoryId">
								  	 	<form:option value="" label="-- Chọn loại sản phẩm --"/>
								  	 	<form:options items="${menu}"/>
								  	</form:select>
								</div>
							</div>
						
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="name"> Tên sản phẩm </label>
								<div class="col-sm-9">
									<form:input path="name" cssClass="col-xs-10 col-sm-5"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="price"> Đơn giá </label>
								<div class="col-sm-9">
									<form:input cssClass="col-xs-10 col-sm-5" path="price" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="quantity"> Số lượng </label>
								<div class="col-sm-9">
									<form:input cssClass="col-xs-10 col-sm-5" path="quantity" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="image"> Hình ảnh </label>
								<div class="col-sm-9">
									<input type="file" id="image" name="file" class="col-xs-10 col-sm-5">
								</div>
							</div>
							
							<div class="form-group">
							  	<label for="description" class="col-sm-3 control-label no-padding-right"> Mô tả </label>
							  	<div class="col-sm-9">
							  		<c:forEach var="detail" items="${product.details}">
							  			<input type="hidden" name="id" id="detailProductId" value="${detail.id}"/>
							  			<input type="hidden" name="image" id="nameImage" value="${detail.image}"/> 
							  			<textarea name="description" rows="5" cols="100" cssClass="form-control" id="description">${detail.description}</textarea>
							  		</c:forEach>
							  	</div>
							</div>
							
							<div class="form-group">
							  	<label for="description" class="col-sm-3 control-label no-padding-right"> Trạng thái </label>
							  	<div class="col-sm-9">
							  		<form:radiobutton path="status" value="true"/> Đang bán
							  		<form:radiobutton path="status" value="false"/> Ngừng kinh doanh
							  	</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="category.id"> Khuyến mại </label>
								<div class="col-sm-9">
							  	 	<form:select path="sale.id" id="saleId">
								  	 	<form:option value="" label="-- Phần trăm sale --"/>
								  	 	<form:options items="${sales}"/>
								  	</form:select>
								</div>
							</div>
							
							<form:hidden path="id" id="productId"/>
							
							
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
								
									<c:if test="${empty product.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i>
											Thêm sản phẩm
										</button>
									</c:if>
									
									<c:if test="${not empty product.id}">
										<c:url var="editProduct" value="/admin/edit-product/${product.id}"></c:url>
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
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		var dataArray = undefined;
		$('#image').change(function () {
			dataArray = {};
		    var files = $(this)[0].files[0];
		    if (files != undefined) {
	            var reader = new FileReader();
	            reader.onload = function(e) {
	                dataArray["base64"] = e.target.result;
	                dataArray["image"] = files.name;
	            };
	            reader.readAsDataURL(files);
			}
	    });
	
		$('#btnAddOrUpdateNew').click(function(e){
			e.preventDefault();
			var data = {};
			data.id = $('#productId').val();
			data.name = $('#name').val();
			data.price = $('#price').val();
			data.quantity = $('#quantity').val();
			data.status = $('input[name="status"]:checked').val();
			data.category = {};
			data.category.id = $('#categoryId').val();
			data.sale = {};
			data.sale.id = $('#saleId').val();
			data.details = [];
// 			data.details.push({
// 				id : $('#detailProductId').val(),
// 				description : $('#description').val(),
// 			});

			if(dataArray != undefined){
				data.details.push({
					id : $('#detailProductId').val(),
					description : $('#description').val(),
					base64 : dataArray["base64"],
					image : dataArray["image"],
				});
			}else{
				data.details.push({
					id : $('#detailProductId').val(),
					description : $('#description').val(),
					image : $('#nameImage').val(),
				});
			}
			
// 			console.log(JSON.stringify(data));
			
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