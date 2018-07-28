<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Dashboard v.4</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
        <script src="js/jquery.min.js" type="text/javascript"></script>
</head>

<body class="top-navigation">

    <div id="wrapper">
        <div id="page-wrapper" class="gray-bg">
            <div class="row border-bottom white-bg">
                <div class="container">
                    <nav class="navbar navbar-static-top" role="navigation">

                        <div class="navbar-collapse collapse" id="navbar">
                            <ul class="nav navbar-nav">
                                <li class="active">
                                    <a href="index.html"> Trang chủ</a>
                                </li>
                                <li class="dropdown">
                                    <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Chuẩn đoán
                                        <span class="caret"></span>
                                    </a>
                                    <ul role="menu" class="dropdown-menu">
                                        <li>
                                            <a href="">Menu item</a>
                                        </li>
                                        <li>
                                            <a href="">Menu item</a>
                                        </li>
                                        <li>
                                            <a href="">Menu item</a>
                                        </li>
                                        <li>
                                            <a href="">Menu item</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Khám chữa bệnh
                                        <span class="caret"></span>
                                    </a>
                                    <ul role="menu" class="dropdown-menu">
                                        <li>
                                            <a href="">Khám tổng quát</a>
                                        </li>
                                        <li>
                                            <a href="">Khám chuyên khoa</a>
                                        </li>
                                        <li>
                                            <a href="">Khám cận lâm sàng</a>
                                        </li>
                                        
                                    </ul>
                                </li>
                                <li>
                                    <a href="lienhe.html"> Liên hệ</a>
                                </li>

                            </ul>
                            <ul class="nav navbar-top-links navbar-right">
                                <li>
                                    <a href="login.html">
                                        <i class="fa fa-sign-in"></i> Sign in
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
            <div class="wrapper wrapper-content">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>CHUẨN ĐOÁN BỆNH</h5>
                                </div>
                                <div class="ibox-content">
                                     <div class="wrapper wrapper-content animated fadeInRight">
                                        <form class="form-horizontal" action="ChanDoanServlet" method="post" id="frm">
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Da</label>

                                                <div class="col-sm-2">
                                                    <select class="form-control m-b" name="Da">
                                                        <option value="BT">Bình thường</option>
                                                        <option value="Vang">Vàng</option>
                                                        <option value="NoiMun">Nổi mụn</option>
                                                        
                                                    </select>
                                                </div>
                                                <label class="col-sm-2 control-label">Mắt </label>

                                                <div class="col-sm-2">
                                                    <select class="form-control m-b" name="Mat">
                                                        <option value="BT">Bình thường</option>
                                                        <option value="Vang">Vàng</option>
                                                    </select>
                                                </div>
                                                 <label class="col-sm-2 control-label">Bụng</label>

                                                <div class="col-sm-2">
                                                    <select class="form-control m-b" name="Bung">
                                                        <option value="BT">Bình thường</option>
                                                        <option value="Chuong">Chướng</option>
                                                        <option value="Dau">Đau</option>
                                                        <option value="KhoTieu">Khó tiêu</option>
                                                    </select>
                                                </div>
                                                 <label class="col-sm-2 control-label">Cân nặng</label>

                                                <div class="col-sm-2">
                                                    <select class="form-control m-b" name="CanNang">
                                                        <option value="BT">Bình thường</option>
                                                        <option value="Cao">Cao</option>
                                                        <option value="Thap">Thấp</option>
                                                        
                                                    </select>
                                                </div>
                                                <label class="col-sm-2 control-label">Cảm giác</label>

                                                <div class="col-sm-2">
                                                    <select class="form-control m-b" name="CamGiac">
                                                        <option value="BT">Bình thường</option>
                                                        <option value="BuonNon">Buồn nôn</option>
                                                        <option value="OChua">Ợ chua</option>
                                                    </select>
                                                </div>
                                               
                                            <div class="form-group">
                                                <div class="col-sm-12 col-sm-offset-2">
                                                    <button type="button" class="btn btn-primary" onclick="getBenh();">Chuẩn đoán</button>
                                                </div>
                                            </div>
                                        

                                    </div>
                                        </form>
                                </div>
                                <h3 id="benh">Nhi bị bệnh: ${benh}</h3>
                                <button class="hidden btn btn-primary" onclick="rd()" id="myBtn">Tiếp tục chẩn đoán </button>
                                <div class="hidden" id="nhombenh"></div>
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
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script>


        function getBenh(){
            $.post($('#frm').attr('action'),$('#frm').serialize(),function (response){
                $('#myBtn').removeClass('hidden');
                $('#benh').text("Nhi đã bị bệnh: "+response);
                $('#nhombenh').val(response);
            });
        }
        function rd(){
            var nhombenh = $('#nhombenh').val();
            alert(nhombenh);
        }
    

    </script>

</body>

</html>