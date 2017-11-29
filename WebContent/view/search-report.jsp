<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/style.css">
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
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/SearchReport/accountController?action=admin">Duyệt
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
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/SearchReport/view/sign-up.jsp">Đăng ký</a></li>
				<c:choose>
					<c:when test="${sessionScope['ACCOUNT'] eq null }">
						<li class="nav-item">
							<a class="nav-link"
							href="http://localhost:8080/SearchReport/view/login.jsp">Đăng nhập</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item">
							<a class="nav-link"
							href="http://localhost:8080/SearchReport/accountController?action=logout">Đăng xuất</a>
						</li>
					</c:otherwise>
				</c:choose>
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
								<h4 class="card-title d-inline">Kết quả tìm kiếm</h4>
								<a href="./category?view=highlight" class="float-right">Xem
									thêm >></a>
							</div>
							<div class="card-body">
								<c:if test="${searchList ne null }">
									<c:forEach items="${searchList }" var="report">
										<div class="row my-2 mx-auto">
											<div class="col-2">
												<img class="pictureCover" src="./pictures/${report.pictureCoverFileCode }"
													alt="ảnh bìa">
											</div>
											<div class="col-10">
												<a href="http://localhost:8080/SearchReport/ReportController?action=viewReportDetail&reportID=${report.reportID }"><h5 class="paragraph">
														<c:out value="${report.reportName }"></c:out>
													</h5></a>

												<div class="row mx-1">
													<p class="paragraph">
														<c:out value="${report.description }"></c:out>
													</p>
												</div>
												<div class="row">
													<img class="icon" src="./image/share-post-symbol.png">
													<span><c:out value="${report.poster }"></c:out></span> <img
														class="icon" src="./image/small-calendar.png"> <span><c:out
															value="${report.dateOfPost }"></c:out></span> <img class="icon"
														src="./image/eye.png"> <span><c:out
															value="${report.numberOfView }"></c:out></span> <img
														class="icon" src="./image/download-button.png"> <span><c:out
															value="${report.numberOfDownload }"></c:out></span>
												</div>
											</div>
										</div>
										<div class="dropdown-divider"></div>
										<!-- /row my-2 mx-auto -->
									</c:forEach>
								</c:if>
							</div>
							<!-- /card-body -->
						</div>
					</div>
					<!-- / col-12-->
				</div>

			</div>
		</div>
	</div>
	<!-- Footer -->
	<footer class="py-5 bg-faded">
	<div class="container">
		<p class="m-0 text-center text-info">Copyright &copy; Danh Nguyen
			- 2017</p>
	</div>
	<!-- /.container --> </footer>
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<script type="text/javascript" src="./js/popper.min.js"></script>
	<script type="text/javascript" src="./js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./js/script.js"></script>
</body>
</html>