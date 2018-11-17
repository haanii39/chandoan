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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                                    <a href="."> Trang chủ</a>
                                </li>
                                <li>
                                    <a href="ChanDoanServlet"> Chẩn đoán</a>
                                </li>
                                <li class="active">
                                    <a href="huongdan.jsp"> Hướng dẫn</a>
                                </li>
<!--                                <li>
                                    <a href="hoso.jsp"> Hồ Sơ</a>
                                </li>-->

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
                                        <h5>MỘT SỐ THUẬT NGỮ Y KHOA </h5>
                                    </div>
                                    <div class="ibox-content">
                                        <div class="wrapper animated fadeInRight">
                                            <div class="panel-group " id="accordion" role="tablist" aria-multiselectable="true">
                                                <div class="panel hover-list wow zoomIn panel-question">
                                                    <div class="panel-heading accordion-toggle" role="tab" id="headingOne" data-toggle="collapse" data-parent="#accordion" data-target="#collapseOne">
                                                        <h4 class="panel-title">
                                                            Sao mạch
                                                    </div>
                                                    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                                        <div class="panel-body"> Là các u mạch hơi nổi trên mặt da từ đó nhánh mạch nhỏ lan tỏa ra xung quanh (giống nhện)</div>
                                                    </div>
                                                </div>
                                                <div class="panel hover-list wow zoomIn panel-question">
                                                    <div class="panel-heading accordion-toggle" role="tab" id="headingTwo" data-toggle="collapse" data-parent="#accordion" data-target="#collapseTwo">
                                                        <h4 class="panel-title">
                                                            Tràn Dịch Màng Phổi
                                                        </h4>
                                                    </div>
                                                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                                                        <div class="panel-body">thuật ngữ dùng để chỉ về tình trạng tích tụ dịch (có thể là máu, dịch hoặc khí) trong khoang trống giữa phổi và thành ngực vượt quá mức cho phép ở khoang màng phổi từ đó gây nên những biến đổi trên lâm sàng.
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="panel hover-list wow zoomIn panel-question">
                                                    <div class="panel-heading accordion-toggle" role="tab" id="headingThree" data-toggle="collapse" data-parent="#accordion"
                                                         data-target="#collapseThree">
                                                        <h4 class="panel-title">
                                                            Vôi Hóa Màng Phổi
                                                        </h4>
                                                    </div>
                                                    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                                                        <div class="panel-body">@Html(Messages.get(lang,"simple.pricing.question.3.content"))</div>
                                                    </div>
                                                </div>
                                                <div class="panel hover-list wow zoomIn panel-question">
                                                    <div class="panel-heading accordion-toggle" role="tab" id="headingThree" data-toggle="collapse" data-parent="#accordion"
                                                         data-target="#collapseFour">
                                                        <h4 class="panel-title">
                                                            Mồ Hôi Trộn
                                                        </h4>
                                                    </div>
                                                    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                                                        <div class="panel-body">@Html(Messages.get(lang,"simple.pricing.question.4.content"))</div>
                                                    </div>
                                                </div>
                                                <div class="panel hover-list wow zoomIn panel-question">
                                                    <div class="panel-heading accordion-toggle" role="tab" id="headingThree" data-toggle="collapse" data-parent="#accordion"
                                                         data-target="#collapseFive">
                                                        <h4 class="panel-title">
                                                            Màu Sắc Đàm Thay Đổi
                                                        </h4>
                                                    </div>
                                                    <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                                                        <div class="panel-body">@Html(Messages.get(lang,"simple.pricing.question.5.content"))</div>
                                                    </div>
                                                </div>
                                                <div class="panel hover-list wow zoomIn panel-question">
                                                    <div class="panel-heading accordion-toggle" role="tab" id="headingSix" data-toggle="collapse" data-parent="#accordion"
                                                         data-target="#collapseSix">
                                                        <h4 class="panel-title">
                                                            Rét Run
                                                        </h4>
                                                    </div>
                                                    <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
                                                        <div class="panel-body">@Html(Messages.get(lang,"simple.pricing.question.6.content"))</div>
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


            </div>
            <div class="footer">
                <div class="pull-right">

                    <strong> </strong> 
                </div>
                <div>
                    <strong>Phòng Khám AndyLee: </strong> Chăm sóc sức khỏe trọn đời cho bạn
                </div>

            </div>
        </div>

        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <script src="js/jquery.min.js" type="text/javascript"></script>



    </body>
</html>
