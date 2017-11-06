<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css ">
</head>
<body>
	<div class="container">
		<div class="card w-50 mx-auto">
			<div class="card-header">
				<h4 class="card-title text-center">Đăng ký</h4>
			</div>
			<div class="card-body">
				<form class="mx-5 my-5" action="../accountController" method="post">
					<div class="form-group">
						<div class="form-group">
							<label for="username">Tài khoản</label> <input type="text"
								class="form-control" id="username" name="username">
						</div>
					</div>
					<div class="form-group">
						<div class="form-group">
							<label for="password">Mật khẩu</label> <input type="password"
								class="form-control" id="password" name="password">
						</div>
					</div>
					<div class="form-group">
						<div class="form-group">
							<label for="password">Email</label> <input type="text"
								class="form-control" id="email" name="email">
						</div>
					</div>
					<div class="form-group">
						<div class="form-group">
							<label for="password">Họ tên</label> <input type="text"
								class="form-control" id="fullname" name="fullname">
						</div>
					</div>
					<input type="hidden" name="action" value="signUp">
					<input value="Đăng Ký" type="submit" class="btn btn-primary"></input>
				</form>
			</div>
		</div>
	</div>
</body>
</html>