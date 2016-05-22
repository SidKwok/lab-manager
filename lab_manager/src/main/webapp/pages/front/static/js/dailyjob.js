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
        url: 'notice_ajax',
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
            console.log('notice_ajax error');
            alert('后台错误！');
        }
    });
}

/**
* 加载页面事件
*/
function basicEvent(){
    $('#post-notice').on('click', function(){
        var params = {
            noticeAuthor: $('input-noticeAuthor').val(),
            noticeContent: $('input-noticeContent').val()
        };
        $.ajax({
            type: 'POST',
            url: 'daily_post_notice',
            data: params,
            dataType: 'json',
            success: function(retData){
                if(retData === '0'){
                    alert('发表失败');
                }
                if(retData === '0'){
                    alert('发表成功');
                    loadNotice();
                }
            },
            error: function(retData){
                console.log('daily_post_notice fail');
                alert('后台错误！');
            }
        });
    });
}
