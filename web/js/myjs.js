function getBenh() {
    //
    $.post('ChanDoanGanServlet', $('#frm1').serialize(), function (response) {
        $('#benh').text("Bạn đã bị bệnh: " + response);
    });
}

function getNhomBenh() {
    $.post('ChanDoanServlet', $('#frm1').serialize(), function (response) {
        $('#TQ').text("Tổng quát: " + response);
        $('#nhombenh').val(response);
        if ("Bình thường" !== response)
            $('#myBtn').show();
        else
            $('#myBtn').hide();
    });
}

function rd() {
    var nhombenh = $('#nhombenh').val();
    $('.SB').hide();
    $('.Chuyen').show();
    $('.HoHap').show();
    $('.Gan').show();
    $('.Tieuhoa').show();
    switch (nhombenh) {
        case "Hô Hấp":
            $('.HoHap').show();
            break;
        case "Tiêu Hóa":
            $('.Tieuhoa').show();
            break;
        case "Gan":
            $('.Gan').show();
            break;
        default:
            break;
    }

    $('#myBtn').hide();
    $('#sobo').hide();
    $('#chuyen').show();
}


function test() {
    displayGan();
    $('select').val('BT');
    $('#title').text("KHÁM CHUYÊN KHOA")
    $('#sobo').hide();
    $('#chuyen').show();
}


function displayGan() {
    $(document).ready(function () {
        $('.SB').show();
        $('.Chuyen').show();
        $('.Tieuhoa').hide();
        $('.HoHap').hide();
        $('.Gan').show();
    });
}
