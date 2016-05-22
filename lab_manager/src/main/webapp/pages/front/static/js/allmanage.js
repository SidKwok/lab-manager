/**
* 页面初始化事件
*/

function init () {
    /**
    * 初始化实验室卡片
    */
    $.ajax({
        type: "GET",
        url: '_room_ajax',
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
                          '<button class="btn btn-primary all-comment-btn" data-toggle="modal" data-target="#all-comment-modal">评论</button>',
                          '<button class="btn btn-info all-info-btn" data-toggle="popover" data-placement="top" title="' + e.room_id + '" data-content="' + e.intro + '" ">简介</button>',
                          '<button class="btn btn-success all-order-btn" data-toggle="modal" data-target="#all-order-modal">预约</button>',
                      '</div>',
                  '</div>'
              );
          });
          $('#all-room').append(domArr.join(''));
          // 初始化弹出框
          $('[data-toggle="popover"]').popover();
        },
        error: function(){
          console.log('_room_ajax', 'fail');
          alert('后台错误！');

          // /***************************************
          // * 用于前端test 测试状态：ok
          // */
          // /*ajax返回的数据*/
          // var retData = [
          //   {
          //     "room_id": "0001",
          //     "manage_teacher": "sid",
          //     "intro": "good"
          //   },
          //   {
          //     "room_id": "0002",
          //     "manage_teacher": "mingen",
          //     "intro": "bad"
          //   },
          //   {
          //     "room_id": "0003",
          //     "manage_teacher": "natalie",
          //     "intro": "bad"
          //   },
          //   {
          //     "room_id": "0004",
          //     "manage_teacher": "airdy",
          //     "intro": "so good"
          //   },
          //   {
          //     "room_id": "0005",
          //     "manage_teacher": "bob",
          //     "intro": "YES!"
          //   },
          //   {
          //     "room_id": "0006",
          //     "manage_teacher": "taylor",
          //     "intro": "badbad"
          //   },
          // ];
          // /**************/
          // $('#all-room').children().detach();
          // var domArr = [];
          // $.each(retData, function(i, e) {
          //     domArr.push(
          //         '<div class="card hvr-bounce-in" data-roomId="' + e.room_id + '">',
          //             '<div class="all-roomId">' + e.room_id + '</div>',
          //             '<div class="all-teacher">' + e.manage_teacher + '</div>',
          //             '<div class="all-buttonGroup">',
          //             '<button class="btn btn-primary all-comment-btn" data-toggle="modal" data-target="#all-comment-modal">评论</button>',
          //             '<button class="btn btn-info all-info-btn" data-toggle="popover" data-placement="top" title="' + e.room_id + '" data-content="' + e.intro + '" ">简介</button>',
          //             '<button class="btn btn-success all-order-btn" data-toggle="modal" data-target="#all-order-modal">预约</button>',
          //             '</div>',
          //         '</div>'
          //     );
          // });
          // $('#all-room').append(domArr.join(''));
          // // 初始化弹出框
          // $('[data-toggle="popover"]').popover();
          // /***************************************/
      }
    });
}

/**
* 加载页面事件
*/
function basicEvent() {
    // 加载评论
    $('.all-comment-btn').on('click', function(){
        var roomId = $(this).parents('.card').attr('data-roomId');
        $('#all-comment-modal-label').text(roomId);
        $.ajax({
            type: "POST",
            url: '_room_comment',
            data: {roomId: roomId},
            dataType: "json",
            success: function(retData){
                $('#all-comment-modal .modal-showComment').children().detach();
                var domArr = [];
                $.each(retData.comment, function(i, e){
                    domArr.push('<p>' + e + '</>');
                });
                $('#all-comment-modal .modal-showComment').append(domArr.join(''));
            },
            error: function() {
                console.log('_room_comment fail');
                alert('后台错误！');

                // /***************************************
                // * 用于前端test 测试状态： ok
                // */
                // /*ajax返回的数据*/
                // var retData = {
                //   "comment": [
                //     "good",
                //     "not bad",
                //     "good",
                //     "good",
                //     "sadasd",
                //     "sadasd"
                //   ]
                // };
                // /**************/
                // $('#all-comment-modal .modal-showComment').children().detach();
                // var domArr = [];
                // $.each(retData.comment, function(i, e){
                //     domArr.push('<p>' + e + '</>');
                // });
                // $('#all-comment-modal .modal-showComment').append(domArr.join(''));
                // /***************************************/
            }
        });
    });

    // 发表评论
    $('#post-comment').on('click', function(){
        var comment = $('#all-comment-modal textarea').val();
        var roomId = $('#all-comment-modal-label').val();
        $.ajax({
            type: "POST",
            url: '_room_post_comment',
            data: {comment: comment, roomId: roomId},
            dataType: "json",
            success: function(retData){
                if(retData.status === '0') {
                   alert('发表评论失败');
                }
                if(retData.status === '1') {
                   alert('发表评论成功');
                }
            },
            error: function() {
                console.log('_room_post_comment fail');
                alert('后台错误！');

                // /***************************************
                // * 用于前端test 测试状态：ok
                // */
                // /*ajax返回的数据*/
                // var retData = {
                //   "status": "0"
                // };
                // /**************/
                // if(retData.status === '0') {
                //    alert('发表评论失败');
                // }
                // if(retData.status === '1') {
                //    alert('发表评论成功');
                // }
                // /***************************************/
            }
        });
    });

    // 加载预约框
    $('.all-order-btn').on('click', function(){
      var roomId = $(this).parents('.card').attr('data-roomId');
      $('#all-order-modal-label').text(roomId);

      $.ajax({
          type: 'POST',
          url: '_room_order_state',
          data: {roomId: roomId},
          success: function(retData){
              $('#order-state').children().detach();
              var domArr = [];
              $.each(retData, function(i, e){
                  domArr.push('<p>' + e.labName + ' ' + e.applicant + ' ' + e.week + ' ' + e.weekday + ' ' + e.course + '</p>');
              });
              $('#order-state').append(domArr.join(''));
          },
          error: function(){
              console.log('_room_order_state fail');
              alert('后台错误！');

              // /***************************************
              // * 用于前端test 测试状态：ok
              // */
              // /*ajax返回的数据*/
              // var retData = [
              //   {
              //     "labName": "fuck",
              //     "applicant": "sid",
              //     "week": "第十周",
              //     "weekday": "周一",
              //     "course": "1、2节"
              //   },
              //   {
              //     "labName": "sex",
              //     "applicant": "mingen",
              //     "week": "第十一周",
              //     "weekday": "周二",
              //     "course": "3、4节"
              //   }
              // ];
              // /**************/
              //
              // $('#order-state').children().detach();
              // var domArr = [];
              // $.each(retData, function(i, e){
              //     domArr.push('<p>' + e.labName + ' ' + e.applicant + ' ' + e.week + ' ' + e.weekday + ' ' + e.course + '</p>');
              // });
              // $('#order-state').html(domArr.join(''));
              //
              // /***************************************/
          }
      });
    });

    // 预约实验室
    $('#post-labOrder').on('click', function(){
        var params = {
            roomId: $('#all-order-modal-label').text(),
            labName: $('#input-labName').val(),
            applicant: $('#input-applicant').val(),
            week: $('#input-week  option:selected').text(),
            weekday: $('#input-weekday  option:selected').text(),
            course: $('#input-course  option:selected').text()
        }

        $.ajax({
            type: 'POST',
            url: '_room_post_order',
            data: params,
            dataType: 'json',
            success: function(retData){
              if(retData.status === '0') {
                 alert('预约失败');
              }
              if(retData.status === '1') {
                 alert('预约成功');
              }
            },
            error: function(){
                console.log('_room_post_order fail');
                alert('后台错误！');

                // /***************************************
                // * 用于前端test 测试状态：
                // */
                // /*ajax返回的数据*/
                // var retData = {
                //   "status": "0"
                // };
                // /**************/
                // if(retData.status === '0') {
                //    alert('预约失败');
                // }
                // if(retData.status === '1') {
                //    alert('预约成功');
                // }
                //
                // /***************************************/
            }
        });
    });
}

init();
basicEvent();

/***************************************
* 用于前端test 测试状态：
*/
/*ajax返回的数据*/
//var retData = [];
/**************/

/***************************************/
