<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Tải lên</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<div class="alert alert-success alert-dismissible fade" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>Holy guacamole!</strong> You should check in on some of those
		fields below.
	</div>
	<div class="container" id="container">
		<div class="card card-outline-primary">
			<div class="card-header">
				<h5 class="card-title">Tải báo cáo lên server</h5>
			</div>
			<div class="card-body">
				<form class="mx-5 my-5" action="../ReportController" enctype="multipart/form-data" method="post">
					<div class="form-group">
						<label for="reportName">Tên báo cáo</label> 
						<input type="text" class="form-control" id="reportName" name="reportName"> 
						<small id="reportNameHelp" class="form-text text-muted">
							Tên báocáo từ 10 - 100 ký tự.
						</small>
					</div>
					<div class="form-group">
						<label for="category">Danh mục</label> 
						<select class="form-control" id="category" name="categoryID">
							<c:if test="${applicationScope['CATEGORY_LIST'] ne null}">
								<c:forEach items="${applicationScope['CATEGORY_LIST']}" var="category">
									<option value="<c:out value='${category.categoryID }'></c:out>">
										<c:out value="${category.categoryName }"></c:out> 
									</option>
								</c:forEach>
							</c:if>
						</select>
					</div>
					<div class="form-group">
						<label for="description">Mô tả báo cáo</label>
						<textarea class="form-control" id="description" rows="3" name="description"></textarea>
					</div>
					<div class="form-group">
						<label for="documentFile">Tệp báo cáo</label> 
						<input name="documentFile" type="file" class="form-control-file" id="documentFile" aria-describedby="fileHelp"> 
						<small id="fileHelp" class="form-text text-muted">Tệp định dạng *.docx, *.pdf.</small>
					</div>
					<div class="form-group">
						<label for="pictureCoverFile">Ảnh trang bìa báo cáo</label> 
						<input name="pictureCoverFile" type="file" class="form-control-file" id="pictureCoverFile" aria-describedby="fileHelp"> 
						<small id="fileHelp" class="form-text text-muted">Tệp định dạng *.png, *.jpeg.</small>
					</div>
					<input type="hidden" name="action" value="upload">
					<input type="hidden" name="accountID" value="${sessionScope['ACCOUNT'].accountID }">
					<input id="btn_upload" type="submit" class="btn btn-primary" value="Tải lên"/>
				</form>
				<!--// form-->
			</div>
			<!--// card .card-body-->
		</div>
		<!--// card card-outline-primary-->
	</div>
	<footer class="py-5 bg-faded">
		<div class="container">
			<p class="m-0 text-center text-info">Copyright &copy; Danh Nguyen - 2017</p>
		</div>
		<!-- /.container -->
	</footer>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/popper.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/script.js"></script>
</body>
</html>