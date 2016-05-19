/**
* 左菜单事件
*/
$('#menuLeft').on('click', 'li' ,function(event) {
    var content = $(this).children('a').attr('href');

    $('#menuLeft li').removeClass('active');
    $(this).addClass('active');

    $('.content div').css('display', 'none');
    $(content).css('display', 'block');
});
