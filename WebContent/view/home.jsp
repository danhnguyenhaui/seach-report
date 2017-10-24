<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<a class="navbar-brand" href="#">Trang chủ</a>

	<div class="collapse navbar-collapse" id="navbarToggler">
		<ul class="navbar-nav mr-auto mt-2 mt-md-0">

			<li class="nav-item"><a class="nav-link" href="#">Danh sách
					báo cáo</a></li>
			<li class="nav-item"><a class="nav-link" href="./upload.html">Tải
					lên</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Duyệt báo
					cáo</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-lg-2" type="text"
				placeholder="Nhập nội dung tìm kiếm">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm
				kiếm</button>
		</form>

		<div class="d-inline">
			<ul class="navbar-nav mr-auto mt-2 mt-md-0 ml-2">
				<li class="nav-item"><a class="nav-link" href="#">Đăng ký</a></li>
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/SearchReport/view/login.jsp">Đăng nhập</a>
				</li>
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
							<li class="nav-item"><a class="nav-link" href="#">Kinh
									tế</a></li>
							<li class="nav-item"><a class="nav-link " href="#">Khoa
									học tự nhiên</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Khoa
									học xã hội</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Công
									nghệ thông tin</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Thạc
									sỹ - tiến sỹ</a></li>
						</ul>
					</div>
				</div>


			</div>
			<div class="col-9">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title d-inline">Báo cáo nổi bật</h4>
								<a href="#" class="float-right">Xem thêm >></a>
							</div>
							<div class="card-body">
								<div class="row my-2 mx-auto">
									<div class="col-2">
										<img class="pictureCover" src="./image/600x400.png"
											alt="ảnh bìa">
									</div>
									<div class="col-10">
										<a href=""><h5>Hệ thống quản lý chất lượng theo tiêu
												chuẩn TCVN ISO 9001:2008</h5></a>

										<div class="row mx-1">
											<p>Nội dung của tài liệu trình bày về những nguyên tắc
												chủ đạo khi phát triển phương pháp, mô tả tóm tắt trình tự,
												nội dung các bước thực hiện quy hoạch sử dụng đất cấp xã,
												hướng dẫn để tăng cường sự tham gia của người dân địa phương
												vào quá trình này, giới thiệu trình tự, thủ tục đăng ký giao
												đất cấp giấy chứng nhận quyền sử dụng đất, lập hồ sơ địa
												chính đất nông...</p>
										</div>
										<div class="row">
											<img class="icon" src="./image/share-post-symbol.png">
											<span>Danh nguyen</span> <img class="icon"
												src="./image/small-calendar.png"> <span>12/09/2017</span>
											<img class="icon" src="./image/eye.png"> <span>12</span>
											<img class="icon" src="./image/download-button.png"> <span>1</span>
										</div>
									</div>

								</div>
								<div class="dropdown-divider mx-5"></div>
								<!--/row my-1 mx-auto-->
								<div class="row my-2 mx-auto">
									<div class="col-2">
										<img class="pictureCover" src="./image/600x400.png"
											alt="ảnh bìa">
									</div>

									<div class="col-10">
										<a href=""><h5>Tài liệu hướng dẫn Sản xuất sạch hơn</h5></a>
										<div class="row mx-1">
											<p>Nội dung của tài liệu giới thiệu về các doanh nghiệp
												vừa và nhỏ, định nghĩa về doanh nghiệp vừa và nhỏ, vai trò
												của doanh nghiệp vừa và nhỏ, sản xuất sạch hơn – một công cụ
												nâng cao tính cạnh tranh của doanh nghiệp, triển khai sản
												xuất sạch hơn tại doanh nghiệp vừa và nhỏ....</p>
										</div>
										<div class="row">
											<img class="icon" src="./image/share-post-symbol.png">
											<span>Danh nguyen</span> <img class="icon"
												src="./image/small-calendar.png"> <span>12/09/2017</span>
											<img class="icon" src="./image/eye.png"> <span>12</span>
											<img class="icon" src="./image/download-button.png"> <span>1</span>
										</div>
									</div>

								</div>
								<div class="dropdown-divider"></div>
								<!--/row my-1 mx-auto-->
								<div class="row my-2 mx-auto">
									<div class="col-2">
										<img class="pictureCover" src="./image/600x400.png"
											alt="ảnh bìa">
									</div>

									<div class="col-10">
										<a href=""><h5>Tài liệu hướng dẫn Sản xuất sạch hơn</h5></a>
										<div class="row mx-1">
											<p>Nội dung của tài liệu giới thiệu về các doanh nghiệp
												vừa và nhỏ, định nghĩa về doanh nghiệp vừa và nhỏ, vai trò
												của doanh nghiệp vừa và nhỏ, sản xuất sạch hơn – một công cụ
												nâng cao tính cạnh tranh của doanh nghiệp, triển khai sản
												xuất sạch hơn tại doanh nghiệp vừa và nhỏ....</p>
										</div>
										<div class="row">
											<img class="icon" src="./image/share-post-symbol.png">
											<span>Danh nguyen</span> <img class="icon"
												src="./image/small-calendar.png"> <span>12/09/2017</span>
											<img class="icon" src="./image/eye.png"> <span>12</span>
											<img class="icon" src="./image/download-button.png"> <span>1</span>
										</div>
									</div>

								</div>
								<div class="dropdown-divider"></div>
								<!--/row my-1 mx-auto-->
							</div>
						</div>
					</div>
					<!-- / col-12-->
					<div class="col-12 mt-5">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title d-inline">Báo cáo mới nhất</h4>
								<a href="#" class="float-right">Xem thêm >></a>
							</div>
							<div class="card-body">
								<div class="row my-2 mx-auto">
									<div class="col-2">
										<img class="pictureCover" src="./image/600x400.png"
											alt="ảnh bìa">
									</div>
									<div class="col-10">
										<a href=""><h5>Hệ thống quản lý chất lượng theo tiêu
												chuẩn TCVN ISO 9001:2008</h5></a>

										<div class="row mx-1">
											<p>Nội dung của tài liệu trình bày về những nguyên tắc
												chủ đạo khi phát triển phương pháp, mô tả tóm tắt trình tự,
												nội dung các bước thực hiện quy hoạch sử dụng đất cấp xã,
												hướng dẫn để tăng cường sự tham gia của người dân địa phương
												vào quá trình này, giới thiệu trình tự, thủ tục đăng ký giao
												đất cấp giấy chứng nhận quyền sử dụng đất, lập hồ sơ địa
												chính đất nông...</p>
										</div>
										<div class="row">
											<img class="icon" src="./image/share-post-symbol.png">
											<span>Danh nguyen</span> <img class="icon"
												src="./image/small-calendar.png"> <span>12/09/2017</span>
											<img class="icon" src="./image/eye.png"> <span>12</span>
											<img class="icon" src="./image/download-button.png"> <span>1</span>
										</div>
									</div>

								</div>
								<div class="dropdown-divider mx-5"></div>
								<!--/row my-1 mx-auto-->
								<div class="row my-2 mx-auto">
									<div class="col-2">
										<img class="pictureCover" src="./image/600x400.png"
											alt="ảnh bìa">
									</div>

									<div class="col-10">
										<a href=""><h5>Tài liệu hướng dẫn Sản xuất sạch hơn</h5></a>
										<div class="row mx-1">
											<p>Nội dung của tài liệu giới thiệu về các doanh nghiệp
												vừa và nhỏ, định nghĩa về doanh nghiệp vừa và nhỏ, vai trò
												của doanh nghiệp vừa và nhỏ, sản xuất sạch hơn – một công cụ
												nâng cao tính cạnh tranh của doanh nghiệp, triển khai sản
												xuất sạch hơn tại doanh nghiệp vừa và nhỏ....</p>
										</div>
										<div class="row">
											<img class="icon" src="./image/share-post-symbol.png">
											<span>Danh nguyen</span> <img class="icon"
												src="./image/small-calendar.png"> <span>12/09/2017</span>
											<img class="icon" src="./image/eye.png"> <span>12</span>
											<img class="icon" src="./image/download-button.png"> <span>1</span>
										</div>
									</div>

								</div>
								<div class="dropdown-divider"></div>
								<!--/row my-1 mx-auto-->
								<div class="row my-2 mx-auto">
									<div class="col-2">
										<img class="pictureCover" src="./image/600x400.png"
											alt="ảnh bìa">
									</div>

									<div class="col-10">
										<a href=""><h5>Tài liệu hướng dẫn Sản xuất sạch hơn</h5></a>
										<div class="row mx-1">
											<p>Nội dung của tài liệu giới thiệu về các doanh nghiệp
												vừa và nhỏ, định nghĩa về doanh nghiệp vừa và nhỏ, vai trò
												của doanh nghiệp vừa và nhỏ, sản xuất sạch hơn – một công cụ
												nâng cao tính cạnh tranh của doanh nghiệp, triển khai sản
												xuất sạch hơn tại doanh nghiệp vừa và nhỏ....</p>
										</div>
										<div class="row">
											<img class="icon" src="./image/share-post-symbol.png">
											<span>Danh nguyen</span> <img class="icon"
												src="./image/small-calendar.png"> <span>12/09/2017</span>
											<img class="icon" src="./image/eye.png"> <span>12</span>
											<img class="icon" src="./image/download-button.png"> <span>1</span>
										</div>
									</div>

								</div>
								<div class="dropdown-divider"></div>
								<!--/row my-1 mx-auto-->
							</div>
							<!--// card body-->
						</div>
					</div>
					<!--/ col-12 -->
				</div>

			</div>
		</div>
	</div>


	</div>
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<script type="text/javascript" src="./js/popper.min.js"></script>
	<script type="text/javascript" src="./js/bootstrap.min.js"></script>
</body>
</html>