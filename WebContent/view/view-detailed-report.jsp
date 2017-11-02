<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chi tiết báo cáo</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<nav
		class="navbar navbar-toggleable-md navbar-primary bg-faded fixed-top">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarToggler"
		aria-controls="navbarToggler" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="http://localhost:8080/SearchReport/">Trang
		chủ</a>
	<div class="collapse navbar-collapse" id="navbarToggler">
		<ul class="navbar-nav mr-auto mt-2 mt-md-0">
			<c:if test="${sessionScope['ACCOUNT'] ne null }">
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/SearchReport/accountController?action=my-report-list">Danh
						sách báo cáo</a></li>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/SearchReport/view/upload.jsp">Tải
						lên</a></li>
				<c:if test="${ sessionScope['ACCOUNT'].permission eq true}">
					<li class="nav-item"><a class="nav-link" href="#">Duyệt
							báo cáo</a></li>
				</c:if>
			</c:if>
		</ul>
		<form class="form-inline my-2 my-lg-0" action="./ReportController" method="get">
			<c:choose>
				<c:when test='${searchText ne null and searchText ne "" }'>
					<input class="form-control mr-lg-2 search-input" type="text"
						value="${searchText }" placeholder="Nhập nội dung tìm kiếm" name="searchText">
				</c:when>
				<c:otherwise>
					<input class="form-control mr-lg-2 search-input" type="text"
						placeholder="Nhập nội dung tìm kiếm" name="searchText">
				</c:otherwise>
			</c:choose>
			<input type="hidden" value="search" name="action">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm
				kiếm</button>
		</form>
		<div class="d-inline">
			<ul class="navbar-nav mr-auto mt-2 mt-md-0 ml-2">
				<li class="nav-item"><a class="nav-link" href="#">Đăng ký</a></li>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/SearchReport/view/login.jsp">Đăng
						nhập</a></li>
			</ul>
		</div>


	</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-3 pl-5">
				<div class="card card-outline-primary">
					<div class="card-header">
						<div class="card-title">
							<h4 class="text-primary">Danh mục</h4>
						</div>
					</div>
					<div class="card-boby">
						<ul class="nav flex-column">
							<c:if test="${applicationScope['CATEGORY_LIST'] ne null}">
								<c:forEach items="${applicationScope['CATEGORY_LIST']}"
									var="category">
									<li class="nav-item"><c:url var="url"
											value='./category?view=${category.categoryID}'></c:url> <a
										class="nav-link" href='<c:out value="${url }"></c:out>'> <c:out
												value="${ category.categoryName}"></c:out>
									</a></li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-9">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title d-inline">Chi tiết báo cáo</h4>
							</div>
							<div class="card-body pl-5">
								<h5>Tên báo cáo</h5>
								<p>Nội dung chính</p>
								<iframe class="document" src="http://localhost:8080/SearchReport/documents/2.pdf" ></iframe>
									
							</div>
						</div>
					</div>
					<!--/ col-12 -->
				</div>

			</div>
		</div>
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
</body>
</html>