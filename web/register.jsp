<%-- 
    Document   : login.jsp
    Created on : Oct 21, 2018, 11:34:50 AM
    Author     : Administrator
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>INSPINIA | Login 2</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>

    <body class="gray-bg">

        <div class="loginColumns animated fadeInDown">
            <div class="row">

                <div class="col-md-6">
                    <h2 class="font-bold">Welcome to Doctor AndyLee </h2>



                    <p>
                        <small></small>
                    </p>

                </div>
                <div class="col-md-6">
                    <div class="ibox-content">
                        <form class="m-t" role="form" action="Register" method="POST">
                            <div class="form-group">
                                <input type="text" class="form-control" name="username" placeholder="Username" required="">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="password" placeholder="Password" required="">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="fullName" placeholder="Full name">
                            </div>
                            <c:if test="${exist}">
                                <p class="text-danger">
                                    <small>Username already exists</small>
                                </p>
                            </c:if>


                            <button type="submit" class="btn btn-primary block full-width m-b">Register</button>

                            <p class="text-muted text-center">
                                <small>Already have an account?</small>
                            </p>
                            <a class="btn btn-sm btn-white btn-block" href="Login">Login</a>
                        </form>
                        <p class="m-t">
                            <small></small>
                        </p>
                    </div>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col-md-6">

                </div>
                <div class="col-md-6 text-right">
                    <small></small>
                </div>
            </div>
        </div>

        <script src="public/js/jquery-2.1.1.js"></script>
        <script>
            $.get("/login", function (data) {
                console.log(data)
            })
        </script>
    </body>

</html>

