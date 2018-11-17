<%-- 
    Document   : huongdan
    Created on : Aug 4, 2018, 11:44:15 AM
    Author     : Administrator
--%>
<%@page import="Model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    User user = (User) request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Doctor | Clinic</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

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
                                <li class="active">
                                    <a href="index.jsp"> Trang chủ</a>
                                </li>
                                <%-- <li>
                                    <a href="ChanDoanServlet"> Chẩn đoán</a>
                                </li>
                                <li>
                                    <a href="huongdan.jsp"> Hướng dẫn</a>
                                </li>
                                <li>
                                    <a href="lienhe.jsp"> Liên hệ</a>
                                </li>
                                --%>

                            </ul>
                            <ul class="nav navbar-top-links navbar-right">
                                <c:choose>
                                    <c:when test="${user!=null}">
                                        <li>
                                            <a href="HoSo">
                                                Xin chào, <%=user.getFullName()%>
                                            </a>
                                            
                                            
                                        </li>
                                        <li>
                                            <a href="Logout">
                                                Đăng Xuất
                                            </a>
                                            
                                            
                                        </li>
                                    </c:when>    
                                    <c:otherwise>
                                        <li>
                                            <a href="Login">
                                                <i class="fa fa-sign-in"></i> Đăng Nhập
                                            </a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
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
                                        <h5>Doctors </h5>
                                    </div>
                                    <div class="ibox-content">
                                        <div class="wrapper wrapper-content animated fadeInRight">
                                            <div class="row" id="row-hot-profile">
                                                <div class="col-lg-12">
                                                    <div class="contact-box">
                                                        <%--   <a href="profile.html"> --%>
                                                        <a href="ChanDoanServlet">
                                                            <div class="col-sm-4">
                                                                <div class="text-center">
                                                                    <img alt="image" class="img-circle m-t-xs img-responsive" src="picture/aa2.png">
                                                                    <div class="m-t-xs font-bold">AndyLee's Clinic</div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-8">
                                                                <h3><strong>Doctor: Andy Lee</strong></h3>
                                                                <p><i class="fa fa-map-marker"></i> Bạch Mai Hospital</p>
                                                                <address>
                                                                    <strong>Twitter, Inc.</strong><br>
                                                                    78 Giai Phong Street, Phuong Mai Ward, Dong Da District, Ha Noi city<br>

                                                                    <abbr title="Phone">Phone:</abbr> 0123- 456-7890
                                                                </address>
                                                                <button type="button" class="btn btn-primary" onclick="">Khám Tổng Quát </button>
                                                            </div>
                                                            <div class="clearfix"></div>
                                                        </a>
                                                    </div>
                                                </div>
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
                        <strong>AndyLee's Clinic</strong> 
                    </div>
                    <div>
                        <strong>Phòng Khám AndyLee</strong> – Chăm sóc sức khỏe trọn đời cho bạn
                    </div>
                </div>

            </div>
        </div>



        <!-- Mainly scripts -->
        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

        <!-- Custom and plugin javascript -->
        <script src="js/inspinia.js"></script>
        <script src="js/plugins/pace/pace.min.js"></script>

        <!-- Flot -->
        <script src="js/plugins/flot/jquery.flot.js"></script>
        <script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
        <script src="js/plugins/flot/jquery.flot.resize.js"></script>

        <!-- ChartJS-->
        <script src="js/plugins/chartJs/Chart.min.js"></script>

        <!-- Peity -->
        <script src="js/plugins/peity/jquery.peity.min.js"></script>
        <!-- Peity demo -->
        <script src="js/demo/peity-demo.js"></script>


        <script>
            $(document).ready(function () {
                $.get('/hotprofile', function (data) {
                    for (var key in data) {
                        if (data.hasOwnProperty(key)) {
                            var element = data[key];
                            var profileItem = `
                            <div class="col-lg-4">
                                <div class="contact-box">
                                    <a href="${element.url}">
                                    <div class="col-sm-4">
                                        <div class="text-center">
                                            <img alt="image" class="img-circle m-t-xs img-responsive" src="${data.avt}">
                                            <div class="m-t-xs font-bold">Graphics designer</div>
                                        </div>
                                    </div>
                                    <div class="col-sm-8">
                                        <h3><strong>${element.name}</strong></h3>
                                        <p><i class="fa fa-map-marker"></i> ${element.address}</p>
                                        <address>
                                            <abbr title="Phone">P:</abbr> ${element.phone}
                                        </address>
                                    </div>
                                    <div class="clearfix"></div>
                                        </a>
                                </div>
                            </div>
                            `
                            $('#row-hot-profile').append(profileItem)
                        }
                    }
                })
            })
            function redirect() {
                $.get('ChanDoanServlet');
            }
        </script>

    </body>

</html>

