/**
* 页面初始化事件
*/

function init () {

    var role = 'student'; // role
    var username = 'sid'; // username

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

    /**
    * 初始化预约状态
    */
    $.ajax({
        type: 'POST',
        url: '_orderSate',
        data: {role: role, username: username},
        dataType: 'json',
        success: function(retData) {
            var lab = retData.lab;
            var equit = retData.equit;
            var domLab = [];
            var domEquit = [];
            $('#all-lab-orderState').children().detach();
            $.each(lab, function(i, e){
                domLab.push(
                    '<div class="all-lab-order order hvr-sweep-to-right">',
                        '<div class="allLabOrderId">' + e.labOrderId + '</div>',
                        '<div class="allLabOrderDate">' + e.labOrderDate + '</div>',
                        '<div class="allLabOrderContent">' + e.labName + ' ' + e.labWeek + ' ' + e.labWeekday + ' ' + e.labCourse + '</div>',
                        '<div class="allLabOrderState">状态：' + e.state + '</div>',
                    '</div>'
                );
            });
            $('#all-lab-orderState').append(domLab.join(''));

            $('#all-equit-orderState').children().detach();
            $.each(equit, function(i, e){
                domEquit.push(
                    '<div class="all-equit-order order hvr-sweep-to-right">',
                        '<div class="allEquitOrderId">' + e.equitOrderId + '</div>',
                        '<div class="allEquitOrderDate">' + e.equitDate + '</div>',
                        '<div class="allEquitOrderContent">' + e.equitName + ' ' + e.equitNumber + '件 ' + e.equitDays + '天 ' + '</div>',
                        '<div class="allEquitOrderState">状态：' + e.state + '</div>',
                    '</div>'
                );
            });
            $('#all-equit-orderState').append(domEquit.join(''));
        },
        error: function() {
            console.log('_orderState fail');
            alert('后台错误');
            // /***************************************
            // * 用于前端test 测试状态：
            // */
            // /*ajax返回的数据*/
            // var retData = {
            //   "lab":[
            //     {
            //       "labName": "机器人实验",
            //       "labWeek": "第一周",
            //       "labWeekday": "周五",
            //       "labCourse": "第1、2节",
            //       "labOrderId": "0001",
            //       "labOrderDate": "2016-5-21" ,
            //       "state": "允许"
            //     },
            //     {
            //       "labName": "足球实验",
            //       "labWeek": "第二周",
            //       "labWeekday": "周四",
            //       "labCourse": "第3、4节",
            //       "labOrderId": "0002",
            //       "labOrderDate": "2016-5-24" ,
            //       "state": "拒绝"
            //     }
            //   ],
            //   "equit":[
            //     {
            //       "equitName": "西瓜刀",
            //       "equitDate": "2015-9-10",
            //       "equitOrderId": "001",
            //       "equitDays": "10",
            //       "equitNumber": "2",
            //       "state": "未决定"
            //     },
            //     {
            //       "equitName": "狼牙棒",
            //       "equitDate": "2015-11-10",
            //       "equitOrderId": "002",
            //       "equitDays": "2",
            //       "equitNumber": "10",
            //       "state": "未决定"
            //     }
            //   ]
            // };
            // /**************/
            // var lab = retData.lab;
            // var equit = retData.equit;
            // var domLab = [];
            // var domEquit = [];
            // $('#all-lab-orderState').children().detach();
            // $.each(lab, function(i, e){
            //     domLab.push(
            //         '<div class="all-lab-order order hvr-sweep-to-right">',
            //             '<div class="allLabOrderId">' + e.labOrderId + '</div>',
            //             '<div class="allLabOrderDate">' + e.labOrderDate + '</div>',
            //             '<div class="allLabOrderContent">' + e.labName + ' ' + e.labWeek + ' ' + e.labWeekday + ' ' + e.labCourse + '</div>',
            //             '<div class="allLabOrderState">状态：' + e.state + '</div>',
            //         '</div>'
            //     );
            // });
            // $('#all-lab-orderState').append(domLab.join(''));
            //
            // $('#all-equit-orderState').children().detach();
            // $.each(equit, function(i, e){
            //     domEquit.push(
            //         '<div class="all-equit-order order hvr-sweep-to-right">',
            //             '<div class="allEquitOrderId">' + e.equitOrderId + '</div>',
            //             '<div class="allEquitOrderDate">' + e.equitDate + '</div>',
            //             '<div class="allEquitOrderContent">' + e.equitName + ' ' + e.equitNumber + '件 ' + e.equitDays + '天 ' + '</div>',
            //             '<div class="allEquitOrderState">状态：' + e.state + '</div>',
            //         '</div>'
            //     );
            // });
            // $('#all-equit-orderState').append(domEquit.join(''));
            // /***************************************/
        }
    });

    /**
    * 初始化设备卡片
    */
    $.ajax({
        type: "GET",
        url: '_equit_ajax',
        data: {},
        dataType: "json",
        success: function(retData){
          $('#lab-equit').children().detach();
          var domArr = [];
          $.each(retData, function(i, e) {
              domArr.push(
                  '<div class="card hvr-bounce-in" data-assetName="' + e.assetName + '">',
                      '<div class="lab-equitName">' + e.assetName + '</div>',
                      '<div class="lab-buttonGroup">',
                          '<button class="btn btn-info lab-equitInfo-btn" data-toggle="modal" data-target="#lab-equitInfo-modal">简介</button>',
                          '<button class="btn btn-success lab-order-btn" data-toggle="modal" data-target="#lab-equitOrder-modal">预约</button>',
                      '</div>',
                  '</div>'
              );
          });
          $('#lab-equit').append(domArr.join(''));
        },
        error: function(){
          console.log('_equit_ajax', 'fail');
          alert('后台错误！');

          // /***************************************
          // * 用于前端test 测试状态：ok
          // */
          // /*ajax返回的数据*/
          // var retData = [
          //   {
          //     "assetName": "西瓜刀"
          //   },
          //   {
          //     "assetName": "狼牙棒"
          //   },
          //   {
          //     "assetName": "屠龙刀"
          //   },
          //   {
          //     "assetName": "倚天剑"
          //   },
          //   {
          //     "assetName": "绝世好剑"
          //   },
          // ];
          // /**************/
          // $('#lab-equit').children().detach();
          // var domArr = [];
          // $.each(retData, function(i, e) {
          //     domArr.push(
          //         '<div class="card hvr-bounce-in" data-assetName="' + e.assetName + '">',
          //             '<div class="lab-equitName">' + e.assetName + '</div>',
          //             '<div class="lab-buttonGroup">',
          //                 '<button class="btn btn-info lab-equitInfo-btn" data-toggle="modal" data-target="#lab-equitInfo-modal">简介</button>',
          //                 '<button class="btn btn-success lab-order-btn" data-toggle="modal" data-target="#lab-equitOrder-modal">预约</button>',
          //             '</div>',
          //         '</div>'
          //     );
          // });
          // $('#lab-equit').append(domArr.join(''));
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

    // 加载实验室预约框
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

    // 搜索
    $('#search-btn').on('click', function(){
        var params = {
            item: $('#input-search-form').val(),
            type: $('.input-search input[name="searchType"]:checked').val()
        }

        $.ajax({
            type: 'POST',
            url: '_db_post_ajax',
            data: params,
            dataType: 'json',
            success: function(retData){
                $('.db-table').children().detach();
                var domArr = [];
                if (retData.status === '0') {
                    alert('没有该搜查结果')
                }
                if(retData.status === '1') {
                    domArr.push(
                        '<table class="table table-hover">',
                            '<thead>',
                                '<td>教师</td><td>实验</td><td>实验室</td>',
                            '</thead>',
                            '<tbody>'
                    );
                    $.each(retData.result, function(i, e){
                        domArr.push(
                            '<tr><td>' + e.teacher + '</td>' + '<td>' + e.labName + '</td>' + '<td>' + e.roomId + '</td></tr>'
                        );
                    });
                    domArr.push('</tboday></table>');
                    $('.db-table').append(domArr.join(''));
                }
            },
            error: function(){
                console.log('db_post_ajax fail');
                alert('后台错误！');

                // /***************************************
                // * 用于前端test 测试状态：ok
                // */
                // /*ajax返回的数据*/
                // var retData = {
                //   "status": "1",
                //   "result":[
                //     {
                //       "teacher": "sid",
                //       "labName": "fuck",
                //       "roomId": "001"
                //     },
                //     {
                //       "teacher": "mingen",
                //       "labName": "sex",
                //       "roomId": "002"
                //     },
                //     {
                //       "teacher": "nat",
                //       "labName": "ohyeah",
                //       "roomId": "003"
                //     },
                //     {
                //       "teacher": "airdy",
                //       "labName": "ohno",
                //       "roomId": "004"
                //     },
                //     {
                //       "teacher": "bob",
                //       "labName": "ohshit",
                //       "roomId": "005"
                //     },
                //   ]
                // };
                // /**************/
                // $('.db-table').children().detach();
                // var domArr = [];
                // if (retData.status === '0') {
                //     alert('没有该搜查结果')
                // }
                // if(retData.status === '1') {
                //     domArr.push(
                //         '<table class="table table-hover">',
                //             '<thead>',
                //                 '<td>教师</td><td>实验</td><td>实验室</td>',
                //             '</thead>',
                //             '<tbody>'
                //     );
                //     $.each(retData.result, function(i, e){
                //         domArr.push(
                //             '<tr><td>' + e.teacher + '</td>' + '<td>' + e.labName + '</td>' + '<td>' + e.roomId + '</td></tr>'
                //         );
                //     });
                //     domArr.push('</tboday></table>');
                //     $('.db-table').append(domArr.join(''));
                // }
                // /***************************************/
            }
        });
    });

    // 设备简介
    $('.lab-equitInfo-btn').on('click', function(){
        var assetName = $(this).parents('.card').attr('data-assetName');
        $('#lab-equitInfo-modal-label').text(assetName);
        $.ajax({
            type: 'POST',
            url: '_equit_info',
            data: {assetName: assetName},
            dataType: 'json',
            success: function(retData){
                $('#lab-equitInfo-modal .modal-body').children().detach();
                var equitInfo = '<div class="lab-equitInfo-classNo">分类代码： ' + retData.classNo + '</div>' +
                                '<div class="lab-equitInfo-className">分类名称： ' + retData.className + '</div>' +
                                '<div class="lab-equitInfo-valueType">价值类型： ' + retData.valueType + '</div>' +
                                '<div class="lab-equitInfo-number">数量： ' + retData.number + '</div>';
                $('#lab-equitInfo-modal .modal-body').append(equitInfo);
            },
            error: function(){
                console.log('equit_info fail');
                alert('后台错误！');

                // /***************************************
                // * 用于前端test 测试状态：ok
                // */
                // /*ajax返回的数据*/
                // var retData = {
                //   "classNo": "006",
                //   "className": "具",
                //   "valueType": "便宜",
                //   "number": "112"
                // };
                // /**************/
                // $('#lab-equitInfo-modal .modal-body').children().detach();
                // var equitInfo = '<div class="lab-equitInfo-classNo">分类代码： ' + retData.classNo + '</div>' +
                //                 '<div class="lab-equitInfo-className">分类名称： ' + retData.className + '</div>' +
                //                 '<div class="lab-equitInfo-valueType">价值类型： ' + retData.valueType + '</div>' +
                //                 '<div class="lab-equitInfo-number">数量： ' + retData.number + '</div>';
                // $('#lab-equitInfo-modal .modal-body').append(equitInfo);
                // /***************************************/
            }
        });
    });

    // 预约设备
    $('.lab-order-btn').on('click', function(){
      var assetName = $(this).parents('.card').attr('data-assetName');
      $('#lab-equitOrder-modal-label').text(assetName);
    });

    $('#post-equitOrder').on('click', function(){
        var params = {
            assetName: $('#lab-equitOrder-modal-label').text(),
            number: $('#input-equitNumber').val(),
            days: $('#input-equitDays').val(),
            applicant: $('#input-equitApplicant').val()
        };

        $.ajax({
            type: 'POST',
            url: '_lab_post_order',
            data: params,
            dataType: 'json',
            success: function(retData){
                if(retData.status === "0") {
                    alert('预约失败');
                }
                if(retData.status === "1") {
                    alert('预约成功');
                }
            },
            error: function(){
                console.log('_lab_post_order fail');
                alert('后台错误！');
                // /***************************************
                // * 用于前端test 测试状态：ok
                // */
                // /*ajax返回的数据*/
                // var retData = {
                //   "status": "1"
                // };
                // /**************/
                // if(retData.status === "0") {
                //     alert('预约失败');
                // }
                // if(retData.status === "1") {
                //     alert('预约成功');
                // }
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
