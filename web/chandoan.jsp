
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Patient"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="Model.TuDien"%>
<%@page import="Model.ListTrieuChung" %>
<%
    HashMap<String, String> td = (HashMap<String, String>) request.getAttribute("TuDien");
    HashMap<String, List<String>> ltc = (HashMap<String, List<String>>) request.getAttribute("lTrieuChung");
    User user = (User) request.getSession().getAttribute("user");
    
//     HashMap<String, String> td = (HashMap<String, String>) request.getAttribute("TuDien");
//    HashMap<String, String[]> ltc = (HashMap<String, String[]>) request.getAttribute("lTrieuChung");
//    User user = (User) request.getSession().getAttribute("user"); 

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
                                <li class="dropdown active" id="khamsobo">
                                    <a href="ChanDoanServlet" onclick="active('khamsobo')"> Chẩn đoán </a>
                                </li>

                                <li class="dropdown" id="khamchuyen">
                                    <a aria-expanded="false" role="button" onclick="active('khamchuyen');" class="dropdown-toggle" data-toggle="dropdown"> Khám chuyên khoa
                                        <span class="caret"></span>
                                    </a>
                                    <ul role="menu" class="dropdown-menu">
                                        <li>
                                            <!--<a href="#" onclick="TieuHoa();">Khám Tiêu Hóa</a>-->
                                            <a href="#" onclick="TieuHoa();">Khám Tiêu Hóa</a>
                                        </li>
                                        <li>
                                            <!--<a href="#" onclick="HoHap();">Khám Hô Hấp</a>-->
                                            <a href="#" onclick="HoHap();">Khám Hô Hấp</a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="huongdan.jsp"> Hướng dẫn</a>
                                </li>
<!--                                <li>
                                    <a href="hoso.jsp"> Hồ Sơ </a>
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
                                        <h5 id="title">KHÁM TỔNG QUÁT</h5>
                                    </div>
                                    <div class="ibox-content">
                                        <div class="wrapper wrapper-content animated fadeInRight">
                                            <form action="KetQua" method="POST" class="form-horizontal" id="frm1">
                                                <div class="form-group">
                                                    <div class="SB">
                                                        <div class="TieuHoa HoHap"> 
                                                            <label class="col-sm-2 control-label">Sốt</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="Sot">
                                                                    <%
                                                                        List<String> tc = ltc.get("Sot");
                                                                        int size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%
                                                                        }
                                                                    %>
                                                                </select>
                                                            </div>

                                                            <label class="col-sm-2 control-label">Ăn uống</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="AnUong">
                                                                    <%
                                                                        tc = ltc.get("AnUong");
                                                                         size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="TieuHoa">
                                                            <label class="col-sm-2 control-label">Bụng</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="Bung" >
                                                                    <%
                                                                        tc = ltc.get("Bung");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>
                                                            <label class="col-sm-2 control-label">Cảm giác</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="CamGiac">
                                                                    <%
                                                                        tc = ltc.get("CamGiac");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="Khac">
                                                            <label class="col-sm-2 control-label">Da</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="Da">
                                                                    <%
                                                                        tc = ltc.get("Da");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>
                                                            <label class="col-sm-2 control-label">Ngực</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="Nguc"> 
                                                                    <%
                                                                        tc = ltc.get("Nguc");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>

                                                            <label class="col-sm-2 control-label">Thể trạng</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="TheTrang" >
                                                                    <%
                                                                        tc = ltc.get("TheTrang");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="Chuyen" hidden>
                                                        <div  class="TieuHoa">
                                                            <label class="col-sm-2 control-label">Triệu chứng</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="TrieuChung"> 
                                                                    <%
                                                                        tc = ltc.get("TrieuChung");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>

                                                            <label class="col-sm-2 control-label">Cân nặng</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="CanNang"> 
                                                                    <%
                                                                        tc = ltc.get("CanNang");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>    
                                                        </div>

                                                        <div class ="HoHap">
                                                            <label class="col-sm-2 control-label">Ho</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="Ho">
                                                                    <%
                                                                        tc = ltc.get("Ho");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>
                                                            <label class="col-sm-2 control-label">Nhịp thở</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="KhoTho">
                                                                    <%
                                                                        tc = ltc.get("KhoTho");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>
                                                            <label class="col-sm-2 control-label">Mũi</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="Mui">
                                                                    <%
                                                                        tc = ltc.get("Mui");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>
                                                            <label class="col-sm-2 control-label">Họng</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="Hong">
                                                                    <%
                                                                        tc = ltc.get("Hong");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>
                                                            <label class="col-sm-2 control-label">Toàn thân</label>
                                                            <div class="col-sm-2">
                                                                <select class="form-control m-b " name="ToanThan">
                                                                    <%
                                                                        tc = ltc.get("ToanThan");
                                                                        size = tc.size();
                                                                        for (int i = 0; i < size; i++) {
                                                                    %>
                                                                    <option value="<%=tc.get(i)%>"><%=td.get(tc.get(i))%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group" id="btnSoBo">
                                                    <div class="col-sm-12 col-sm-offset-2">
                                                        <button type="button" class="btn btn-primary" onclick="getNhomBenh();">Chẩn đoán</button>
                                                    </div>
                                                </div>
                                                <div class="form-group" id="btnChuyen" hidden>
                                                    <div class="col-sm-12 col-sm-offset-2">
                                                        <button type="button" class="btn btn-primary" onclick="getBenh();">Chẩn đoán</button>
                                                    </div>
                                                </div>
                                                <center>
                                                    <div class="row">
                                                        <h3 id="TQ"></h3>
                                                        <h3 id="benh"></h3>
                                                        <input type="hidden" id="nhombenh" name="nhombenh">
                                                        <input type="hidden" id="ketqua" name="ketqua">
                                                        <%-- <button type="submit" id="btnXemKetQua" class="btn btn-primary" style="display: none">Xem</button> --%>
                                                    </div>
                                                    <div class="form-group row" hidden id="myBtn">
                                                        <div class="col-sm-12">
                                                            <button type="button" class="btn btn-primary" onclick="rd()">Khám Chuyên Khoa </button>
                                                        </div>
                                                    </div>
                                                </center>

                                            </form>
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
                    <strong>Phòng Khám AndyLee: </strong> Chăm sóc sức khỏe trọn đời cho bạn !
                </div>

            </div>
        </div>

        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript">

                                                                function getBenh() {
                                                                    var nhombenh = $('#nhombenh').val();
                                                                    var servlet;
                                                                    switch (nhombenh) {
                                                                        case "Hô hấp":
                                                                            servlet = 'ChanDoanHoHapServlet';
                                                                            break;
                                                                        case "Tiêu hóa":
                                                                            servlet = 'ChanDoanTieuHoaServlet';
                                                                            break;
                                                                    }
                                                                    console.log($('#frm1').serialize())
                                                                    $.post(servlet, $('#frm1').serialize(), function (response) {
                                                                        $('#benh').text("Bạn đã bị bệnh: " + response);
                                                                        $('#ketqua').val(response);
                                                                        $('#btnXemKetQua').show();
                                                                    });
                                                                }
                                                                ;
                                                                function xemKetQua() {
                                                                    var nhombenh = $('#nhombenh').val();
                                                                    switch (nhombenh) {
                                                                        case "Hô hấp":
                                                                            nhombenh = "hohap";
                                                                            break;
                                                                        case "Tiêu hóa":
                                                                            nhombenh = "tieuhoa";
                                                                            break;
                                                                    }

                                                                    $.post('KetQua', $('#frm1').serialize() + '&nhombenh=' + nhombenh, function (response) {
                                                                        console.log('Successful')
                                                                    });
                                                                }
                                                                function getNhomBenh() {
                                                                    console.log($('#frm1').serialize());
                                                                    $.post('ChanDoanServlet', $('#frm1').serialize(), function (response) {
                                                                        $('#TQ').text("Tổng quát: " + response);
                                                                        $('#nhombenh').val(response);
                                                                        if ("Bình thường" !== response &&"Tim"!== response &&"Gan" !== response)
                                                                            $('#myBtn').show();
                                                                        else
                                                                            $('#myBtn').hide();
                                                                    });
                                                                }
                                                                ;

                                                                function rd() {
                                                                    var nhombenh = $('#nhombenh').val();
                                                                    console.log(nhombenh)
                                                                    $('.HoHap').hide();
                                                                    $('.Khac').hide();
                                                                    $('.TieuHoa').hide();
                                                                    $('.Chuyen').show();
                                                                    $('.SB select').attr('disabled', true);
                                                                    $('#title').text("KHÁM CHUYÊN KHOA");
                                                                    switch (nhombenh) {
                                                                        case "Hô hấp":
                                                                            $('.HoHap').fadeIn(1000);
                                                                            break;
                                                                        case "Tiêu hóa":
                                                                            $('.TieuHoa').fadeIn(1000);
                                                                            break;
                                                                    }
                                                                    $('#myBtn').hide(); // button khám tiếp
                                                                    $('#btnSoBo').hide(); // button chẩn đoán sơ bộ
                                                                    $('#btnChuyen').show(); //button chẩn đoán chuyên khoa
                                                                }
                                                                ;
                                                                function active(a) {
                                                                    $('#khamchuyen').removeClass('active');
                                                                    $('#khamsobo').removeClass('active');
                                                                    $('#' + a).addClass('active');
                                                                }

                                                                function HoHap() {
                                                                    reset();
                                                                    $('#nhombenh').val("Hô hấp");
                                                                    $('.HoHap').show();
                                                                }
                                                                ;
                                                                function TieuHoa() {
                                                                    reset();
                                                                    $('#nhombenh').val("Tiêu hóa");
                                                                    $('.TieuHoa').show();
                                                                }
                                                                ;

                                                                function reset() {
                                                                    $('#benh').text("");
                                                                    $('#btnXemKetQua').hide();
                                                                    $('#TQ').text("");
                                                                    $('#myBtn').hide();
                                                                    $('select').val('BT');
                                                                    $('.SB').show();
                                                                    $('.Khac').hide();
                                                                    $('.Chuyen').show();
                                                                    $('.TieuHoa').hide();
                                                                    $('.HoHap').hide();
                                                                    $('#title').text("KHÁM CHUYÊN KHOA");
                                                                    $('#btnSoBo').hide();
                                                                    $('#btnChuyen').show();
                                                                    
                                                                }
                                                                ;
        </script>

        
    </body>

</html>