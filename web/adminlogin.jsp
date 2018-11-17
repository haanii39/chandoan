<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
   
    <title>AndyLee's Clinic | Login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script>
        function checkLogin(){
            var admin = '<%= session.getAttribute("admin") %>';
            console.log(doctor);
            if(admin !== 'null'){
                window.location ='AdminServlet';
            }
        }
    </script>

</head>

<body class="gray-bg" onload="checkLogin();">
 
 <h1 class="logo-name">Phòng khám </h1>
    <div class="middle-box text-center loginscreen animated fadeInDown">
       <div>
            <div>

            </div>
            <h3>Xin Chào Bác Sĩ</h3>
            <p>
                <!--Continually expanded and constantly improved Inspinia Admin Them (IN+)-->
            </p>
            <p>Đăng nhập. Để theo dõi tình hình sức khỏe của bệnh nhân</p>
            <form class="m-t" role="form" action="AdminServlet" method="POST">
                <div class="form-group">
                    <input type="text" class="form-control" name="username" placeholder="Tên Bác Sĩ " required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="Mật Khẩu" required="">
                </div>
               <c:if test="${error}">
                            <p class="text-danger">
                                <small>Đăng nhập thất bại</small>
                            </p>
                        </c:if> 
                <button type="submit" class="btn btn-primary block full-width m-b">Đăng Nhập</button>
<!--                <a href="#">-->
                <a href="index.jsp">
                            <small>Bạn Quên Mật Khẩu </small>
                        </a>

               <!--   <a href="#"><small>Forgot password?</small></a>
                <p class="text-muted text-center"><small>Do not have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>-->
            </form>
            <p class="m-t"> <small></small> </p>
        </div>

    </div>
     <div class="footer">
                    <div class="pull-right">
                        <strong>AndyLee's Clinic</strong> 
                    </div>
                    <div>
                        <strong>Phòng Khám AndyLee</strong>? Chăm sóc sức khỏe trọn đời cho bạn
                    </div>
                </div>

    <!-- Mainly scripts -->
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.js"></script>

</body>



<script src="public/js/jquery-2.1.1.js"></script>
<script>
    $.get("/adminlogin", function (data) {
        console.log(data)
    })
</script>

</html>
