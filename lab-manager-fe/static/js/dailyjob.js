/**
* 页面初始化事件
*/

function init () {
    loadNotice();
}

/**
* 加载公告
*/

function loadNotice () {
    $.ajax({
        type: 'GET',
        url: '_notice_ajax',
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
            console.log('_notice_ajax error');
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
            url: '_daily_post_notice',
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
                console.log('_daily_post_notice fail');
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
basicEvent();
