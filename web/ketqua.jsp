<%-- 
    Document   : huongdan
    Created on : Aug 4, 2018, 11:44:15 AM
    Author     : Administrator
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="Model.Benh"%>
<%@page import="utils.Base64Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Benh benh = (Benh) request.getAttribute("benh");
    String ketqua = (String) request.getAttribute("ketqua");
    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Báo cáo</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="js/jquery.min.js" type="text/javascript"></script>
    </head>

    <body class="top-navigation">

        <div id="wrapper">
            <div id="page-wrapper" class="gray-bg">
                <div class="row border-bottom white-bg">
                    <nav class="navbar navbar-static-top" role="navigation">
                        <div class="navbar-header">
                            <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                                <i class="fa fa-reorder"></i>
                            </button>
                            <a href="#" class="navbar-brand">Doctor AndyLee</a>
                        </div>
                        <div class="navbar-collapse collapse" id="navbar">
                            <ul class="nav navbar-nav">
                                <li>
                                    <a href="index.html"> Trang chủ</a>
                                </li>
                                <li>
                                    <a href="chandoan.jsp"> Chuẩn đoán</a>
                                </li>
                                <li class="active">
                                    <a href="huongdan.jsp"> Hướng dẫn</a>
                                </li>
                                <li>
                                    <a href="lienhe.jsp"> Liên hệ</a>
                                </li>

                            </ul>
                            <ul class="nav navbar-top-links navbar-right">
                                <li>
                                    <a href="login.html">
                                        <i class="fa fa-sign-in" href="login.html"></i> Sign in
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
                <div class="wrapper wrapper-content">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>Báo cáo </h5>
                                    </div>
                                    <div class="ibox-content">
                                        <div class="wrapper animated fadeInRight">
                                            <c:forEach items="${benh.getMap()}" var="entry">
                                                <p>${Base64Utils.decode(entry.key)}: ${entry.value}</p><br>
                                            </c:forEach>
                                                <h4 style="color: red">Kết luận: ${ketqua}</h4>
                                        </div>

                                    </div>
                                </div>
                            </div>


                        </div>

                    </div>
                </div>


            </div>
            <div class="footer">
                <div class="pull-right">

                    <strong> </strong> 
                </div>
                <div>
                    <strong>Doctor AndyLee: </strong> Better use medicines at the outset than at the last moment
                </div>

            </div>
        </div>

        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <script src="js/jquery.min.js" type="text/javascript"></script>



    </body>
</html>
