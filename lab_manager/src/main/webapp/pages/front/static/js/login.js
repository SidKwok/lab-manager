
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
        window.location.href = './info/index.html?username=' + username + '&role=teacher?';
        // $.ajax({
        //     type: 'POST',
        //     url: '_login',
        //     data: params,
        //     dataType: 'json',
        //     success: function(retData){
        //         if (retData.status === 'success') {
        //             window.location.href = '/info/index.html?username=' + username + '&role=' + retData.role;
        //         } else {
        //             alert('登录失败，原因：' + retData.status)
        //         }
        //     },
        //     error: function() {
        //         console.log('_login fail');
        //         alert('后台错误');
        //     }
        // });
    });
}
basicEvent();
