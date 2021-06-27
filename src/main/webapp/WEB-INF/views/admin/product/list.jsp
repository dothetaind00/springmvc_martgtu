<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lí danh sách sản phẩm</title>
</head>
<body>
	<div class="main-content">
		<form id="formSubmit" action="<c:url value='/admin/products'/>"
			method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li>
							<i class="ace-icon fa fa-home home-icon"></i> 
							<a href="#">Trang chủ</a>
						</li>
					</ul>
				</div>
				
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
										
											<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm sản phẩm'
												href="#"> 
												<span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
												</span>
											</a>
											
											<button id="btnDelete" type="button"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa sản phẩm'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
											
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Hình ảnh</th>
											<th>Tên sản phẩm</th>
											<th>Danh mục</th>
											<th>Đơn giá</th>
											<th>Số lượng</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${product.listResult}">
											<tr>
												<c:forEach var="detail" items="${item.details}">
<%-- 													<td><img src="<c:url value='/template/static/image/${detail.image}'/>" alt="product" style="height: 75px; width: 75px"/></td> --%>
													<td><img src="${pageContext.request.contextPath}/${detail.image}" alt="product" style="height: 75px; width: 75px"/></td>
												</c:forEach>
												<td>${item.name}</td>
												<td>${item.category.name}</td>
												<td>${item.price}</td>
												<td>${item.quantity}</td>
												<td>
													<c:url var="editURL" value="/admin/edit-product/${item.id}">
													</c:url>
													<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
														title="Cập nhật sản phẩm" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
													</a>	
												</td>
												<td>
													<button id="btnDeleteProduct_${item.id}" type="button"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
														data-toggle="tooltip" title='Xóa sản phẩm'>
														<span> <i class="fa fa-trash-o bigger-110 pink"></i>
														</span>
													</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
								<ul class="pagination" id="pagination"></ul>
								<input type="hidden" id="page" name="page" value="" /> 
								<input type="hidden" id="limit" name="limit" value="" />
								<input type="hidden" id="sortName" name="sortName" value="" />
								<input type="hidden" id="sortBy" name="sortBy" value="" />
							</div>
						</div>
					</div>
				</div>
			</div> 
		</form>
	</div>
	
	<script type="text/javascript">
		var totalPages = ${product.totalPage};
		var currentPage = ${product.page};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 3,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage !== page) {
						$('#page').val(page);
						$('#limit').val(10);
						$('#sortName').val('name');
						$('#sortBy').val('asc');
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>
</body>
</html>