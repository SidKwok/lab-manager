// 全局变量
var userInfo = window.location.href.split('?')[1];
var role = userInfo.split('&')[1].split('=')[1]; // role
var username = userInfo.split('&')[0].split('=')[1];; // username

/**
* 页面初始化事件
*/
function init () {
    /**
    * 初始化导航栏
    */
    $($('.nav-location')[0]).attr('href', '../info/index.html?' + userInfo + '?');
    $($('.nav-location')[1]).attr('href', '../allmanage/index.html?' + userInfo + '?');
    $($('.nav-location')[2]).attr('href', '../stumanage/index.html?' + userInfo + '?');
    $($('.nav-location')[3]).attr('href', '../teamanage/index.html?' + userInfo + '?');
    $($('.nav-location')[4]).attr('href', '../promanage/index.html?' + userInfo + '?');
    $($('.nav-location')[5]).attr('href', '../aboutus/index.html?' + userInfo + '?');

    if (role === 'student'){
        $('#daily-notice').children().detach();
        $('#daily-notice').append('<h2>本区域只对管理员或教师开放</h2>');
    } else {
        loadNotice();
        basicEvent();
    }
}

/**
* 加载公告
*/
function loadNotice () {
    $.ajax({
        type: 'GET',
        url: '/notice/queryAllNotice',
        data: {},
        dataType: 'json',
        success: function(retData){
            $('#noticeModal').children().detach();
            var domArr = [];
            $.each(retData, function(i, e){
                domArr.push(
                    '<div class="notice hvr-sweep-to-right">',
                        '<div class="noticeId">' + e.noticeId + '</div>',
                        '<div class="noticeDate">' + e.noticeDate + '</div>',
                        '<div class="noticeContent">' + e.noticeContent + '</div>',
                        '<div class="noticeAuthor">' + e.noticeAuthor + '</div>',
                    '</div>'
                );
            });
            $('#noticeModal').append(domArr.join(''));
        },
        error: function(){
            console.log('/notice/queryAllNotice error');
            alert('后台错误！');

            // /***************************************
            // * 用于前端test 测试状态：ok
            // */
            // /*ajax返回的数据*/
            // var retData = [
            //   {
            //     "noticeId": "0001",
            //     "noticeDate": "2016-5-21",
            //     "noticeContent": "Sid is the best!",
            //     "noticeAuthor": "sid"
            //   },
            //   {
            //     "noticeId": "0002",
            //     "noticeDate": "2016-5-21",
            //     "noticeContent": "Mingen is the best!",
            //     "noticeAuthor": "mingen"
            //   },
            //   {
            //     "noticeId": "0003",
            //     "noticeDate": "2016-6-11",
            //     "noticeContent": "Natalie is the best!",
            //     "noticeAuthor": "nata"
            //   },
            //   {
            //     "noticeId": "0004",
            //     "noticeDate": "2016-7-21",
            //     "noticeContent": "Airdy is the best!",
            //     "noticeAuthor": "bob"
            //   },
            //   {
            //     "noticeId": "0005",
            //     "noticeDate": "2016-1-21",
            //     "noticeContent": "bob is the best!",
            //     "noticeAuthor": "bob"
            //   }
            // ];
            // /**************/
            // $('#noticeModal').children().detach();
            // var domArr = [];
            // $.each(retData, function(i, e){
            //     domArr.push(
            //         '<div class="notice hvr-sweep-to-right">',
            //             '<div class="noticeId">' + e.noticeId + '</div>',
            //             '<div class="noticeDate">' + e.noticeDate + '</div>',
            //             '<div class="noticeContent">' + e.noticeContent + '</div>',
            //             '<div class="noticeAuthor">' + e.noticeAuthor + '</div>',
            //         '</div>'
            //     );
            // });
            // $('#noticeModal').append(domArr.join(''));
            //
            // /***************************************/
        }
    });
}

/**
* 加载页面事件
*/
function basicEvent(){
    $('#post-notice').on('click', function(){
        var params = {
            noticeAuthor: $('#input-noticeAuthor').val(),
            noticeContent: $('#input-noticeContent').val()
        };
        $.ajax({
            type: 'POST',
            url: '/notice/addNotice',
            data: params,
            dataType: 'json',
            success: function(retData){
                if(retData.status === '0'){
                    alert('发表失败');
                }
                if(retData.status === '1'){
                    alert('发表成功');
                    loadNotice();
                }
            },
            error: function(retData){
                console.log('/notice/addNotice fail');
                alert('后台错误！');

                // /***************************************
                // * 用于前端test 测试状态：ok
                // */
                // /*ajax返回的数据*/
                // var retData = [];
                // /**************/
                // if(retData.status === '0'){
                //     alert('发表失败');
                // }
                // if(retData.status === '1'){
                //     alert('发表成功');
                //     loadNotice();
                // }
                // /***************************************/
            }
        });
    });
}

init();
