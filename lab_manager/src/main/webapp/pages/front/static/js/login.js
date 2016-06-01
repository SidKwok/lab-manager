
/**
* 页面事件
*/
function basicEvent () {
    $('#signIn').on('click', function(){
        var username =  $('#username').val();
        var params = {
            username: username,
            password: $('#password').val()
        };
        $.ajax({
            type: 'POST',
            url: '/log/in',
            data: params,
            dataType: 'json',
            success: function(data){
                var retData = eval('(' + data + ')');
                if (retData.status === 'success') {
                    window.location.href = './info/index.html?username=' + username + '&role=' + retData.role;
                } else {
                    alert('登录失败，原因：' + retData.status);
                }
            },
            error: function() {
                console.log('/log/in fail');
                alert('后台错误');
            }
        });
    });
}
basicEvent();
