/**
* 页面初始化事件
*/

function init () {
    /**
    * 初始化实验室卡片
    */
    $.ajax({
        type: "GET",
        url: 'room_ajax',
        data: {},
        dataType: "json",
        success: function(retData){
          $('#all-room').children().detach();
          var domArr = [];
          $.each(retData, function(i, e) {
              domArr.push(
                  '<div class="card hvr-bounce-in" data-roomId="' + e.room_id + '">',
                      '<div class="all-roomId">' + e.room_id + '</div>',
                      '<div class="all-teacher">' + e.manage_teacher + '</div>',
                      '<div class="all-buttonGroup">',
                          '<button class="btn btn-primary" data-toggle="modal" data-target="#all-comment-modal" class="all-comment-btn">评论</button>',
                          '<button class="btn btn-info" data-toggle="popover" data-placement="top" title="' + e.room_id + '" data-content="' + e.intro + '" class="all-info-btn">简介</button>',
                          '<button class="btn btn-success" data-toggle="modal" data-target="#all-order-modal" class="all-order-btn">预约</button>',
                      '</div>',
                  '</div>'
              );
          });
          $('#all-room').append(domArr.join(''));
          // 初始化弹出框
          $('[data-toggle="popover"]').popover();
        },
        error: function(){
          console.log('room_ajax', 'fail');
          alert('后台错误！');
      }
    });
}

/**
* 加载页面事件
*/
function basicEvent() {
    // 加载评论
    $('#all-comment-btn').on('click', function(){
        var roomId = $(this).parent('.card').attr('data-roomId');
        $('#all-comment-modal-label').val(roomId);
        $.ajax({
            type: "POST",
            url: 'room_comment',
            data: {roomId},
            dataType: "json",
            success: function(retData){
                $('#all-comment-modal .modal-showComment').children().detach();
                var domArr = [];
                $.each(retData, function(i, e){
                    domArr.push('<p>' + e + '</>');
                });
                $('#all-comment-modal .modal-showComment').append(domArr.join(''));
            },
            error: function() {
                console.log('room_comment fail');
                alert('后台错误！');
            }
        });
    });

    // 发表评论
    $('#post-comment').on('click', function(){
        var comment = $('#all-comment-modal textarea').val();
        var roomId = $('#all-comment-modal-label').val();
        $.ajax({
            type: "POST",
            url: 'room_post_comment',
            data: {comment, roomId},
            dataType: "json",
            success: function(retData){
                if(retData === '0') {
                   alert('发表评论失败');
                }
                if(retData === '1') {
                   alert('发表评论成功');
                }
            },
            error: function() {
                console.log('room_post_comment fail');
                alert('后台错误！');
            }
        });
    });

    // 加载预约框
    $('all-order-btn').on('click', function(){
      var roomId = $(this).parent('.card').attr('data-roomId');
      $('#all-order-modal-label').val(roomId);

      $.ajax({
          type: 'POST',
          url: 'room_order_state',
          data: {roomId},
          success: function(retData){
              $('#order-state').children().detach();
              var domArr = [];
              $.each(retData, function(i, e){
                  domArr.push('<p>' + e.labName + ' ' + e.applicant + ' ' + e.week + ' ' + e.weekday + ' ' + e.course + '</p>');
              });
              $('#order-state').val(domArr.join(''));
          },
          error: function(){
              console.log('room_order_state fail');
              alert('后台错误！');
          }
      });
    });

    // 预约实验室
    $('#post-labOrder').on('click', function(){
        var params = {
            roomId: $('#all-order-modal-label').val();
            labName: $('#input-labName').val(),
            applicant: $('#input-applicant').val(),
            week: $('#input-week  option:selected').text(),
            weekday: $('#input-weekday  option:selected').text(),
            course: $('#input-course  option:selected').text()
        }

        $.ajax({
            type: 'POST',
            url: 'room_post_order',
            data: params,
            dataType: 'json',
            success: function(retData){
              if(retData === '0') {
                 alert('预约失败');
              }
              if(retData === '1') {
                 alert('预约成功');
              }
            },
            error: function(){
                console.log('room_post_order fail');
                alert('后台错误！');
            }
        });
    });
}

init();
basicEvent();
