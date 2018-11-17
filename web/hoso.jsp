<%-- 
    Document   : huongdan
    Created on : Aug 4, 2018, 11:44:15 AM
    Author     : Administrator
--%>
<%@page import="Model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Patient"%>
<%@page import="java.util.List"%>
<% 
    User user = (User) request.getSession().getAttribute("user");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hồ Sơ</title>
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
                                    <a href="index.jsp"> Trang chủ</a>
                                </li>
                                <li>
                                    <a href="ChanDoanServlet"> Chẩn đoán</a>
                                </li>
                                <li>
                                    <a href="huongdan.jsp"> Hướng dẫn</a>
                                </li>
                                
                                <!--                                <li>
                                                                    <a href="lienhe.jsp"> Liên hệ</a>
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
                                                <i class="fa fa-sign-in"></i> Sign in
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
                                        <h5>Hồ Sơ </h5>
                                    </div>
                                    <div class="ibox-content">
                                        <div class="wrapper animated fadeInRight">
                                            <table class="table table-striped table-bordered table-hover dataTables-example dataTable" id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info" role="grid">
                                                <tr>
                                                    <th>
                                                        Khám Tổng Quát
                                                    </th>
                                                    <th>
                                                        Khám Chuyên Khoa
                                                    </th>
                                                    <th>
                                                        Thời Gian Khám
                                                    </th>
                                                    <th>
                                                        Nhận xét
                                                    </th>

                                                </tr>
                                                <c:forEach items='<%= (ArrayList)request.getAttribute("ListPatient")%>' var="entry">
                                                    <tr>
                                                    <td>
                                                            ${entry.getTongQuat()}
                                                        </td>
                                                             <td>
                                                            ${entry.getChuyenKhoa()}
                                                        </td>
                                                             <td>
                                                            ${entry.getThoiGian()}
                                                        </td>
                                                             <td>
                                                                 ${entry.getNhanXet()}
                                                            
                                                        </td>
                                                </tr>   

                                                </c:forEach>

                                            </table>

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
                    <strong>Doctor AndyLee: </strong> Chăm sóc sức khỏe trọn đời cho bạn !
                </div>

            </div>
        </div>

        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <script src="js/jquery.min.js" type="text/javascript"></script>



    </body>
</html>
