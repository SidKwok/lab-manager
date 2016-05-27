
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
        // console.log(params);
        // window.location.href = './info/index.html?username=' + username + '&role=teacher?';
        $.ajax({
            type: 'POST',
            url: '/log/in',
            data: params,
            dataType: 'json',
            success: function(retData){
                if (retData.status === 'success') {
                    window.location.href = './info/index.html?username=' + username + '&role=' + retData.role;
                } else {
                    alert('登录失败，原因：' + retData.status)
                }
            },
            error: function() {
                console.log('/log/in fail');
                alert('后台错误');

                // /***************************************
                // * 用于前端test 测试状态：
                // */
                // /*ajax返回的数据*/
                // var retData = {
                //   "status": "success",
                //   "role": "student"
                // };
                // /**************/
                // if (retData.status === 'success') {
                //     window.location.href = './info/index.html?username=' + username + '&role=' + retData.role;
                // } else {
                //     alert('登录失败，原因：' + retData.status)
                // }
                // /***************************************/
            }
        });
    });
}
basicEvent();
