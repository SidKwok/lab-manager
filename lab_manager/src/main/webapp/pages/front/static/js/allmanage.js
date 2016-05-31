// 全局变量
var userInfo = window.location.href.split('?')[1];
var role = userInfo.split('&')[1].split('=')[1]; // role
var username = userInfo.split('&')[0].split('=')[1]; // username

/**
* 页面初始化事件
*/
function init () {
    /**
    * 初始化导航栏
    */
    $($('.nav-location')[0]).attr('href', '../info/index.html?' + userInfo + '?');
    $($('.nav-location')[1]).attr('href', '../stumanage/index.html?' + userInfo + '?');
    $($('.nav-location')[2]).attr('href', '../teamanage/index.html?' + userInfo + '?');
    $($('.nav-location')[3]).attr('href', '../promanage/index.html?' + userInfo + '?');
    $($('.nav-location')[4]).attr('href', '../dailyjob/index.html?' + userInfo + '?');
    $($('.nav-location')[5]).attr('href', '../aboutus/index.html?' + userInfo + '?');

    if ( role === 'student' ) {
      $('#all-room').children().detach();
      $('#all-room').append('<h2>本区域只对教师或管理员开放</h2>');
      $('#lab-equip').children().detach();
      $('#lab-equip').append('<h2>本区域只对教师或管理员开放</h2>');
      $('#lab-db').children().detach();
      $('#lab-db').append('<h2>本区域只对教师或管理员开放</h2>');
      $('#all-orderState').children().detach();
      $('#all-orderState').append('<h2>本区域只对教师或管理员开放</h2>');
    } else {
      /**
      * 初始化实验室卡片
      */
      $.ajax({
          type: "GET",
          url: '/lab/queryAllRoom',
          data: {},
          dataType: "json",
          success: function(data){
            var retData = eval('(' + data + ')');
            $('#all-room .flex-box').children().detach();
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
            $('#all-room .flex-box').append(domArr.join(''));
            // 初始化弹出框
            $('[data-toggle="popover"]').popover();

            // 加载评论
            $('.all-comment-btn').on('click', function(){
                var roomId = $(this).parents('.card').attr('data-roomId');
                $('#all-comment-modal-label').text(roomId);
                $.ajax({
                    type: "POST",
                    url: '/lab/getRoomComment',
                    data: {roomId: roomId},
                    dataType: "json",
                    success: function(data){
                        var retData = eval('(' + data + ')');
                        $('#all-comment-modal .modal-showComment').children().detach();
                        var domArr = [];
                        $.each(retData.comment, function(i, e){
                            domArr.push('<p>' + e + '</>');
                        });
                        $('#all-comment-modal .modal-showComment').append(domArr.join(''));
                    },
                    error: function() {
                        console.log('/lab/getRoomComment fail');
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
                var roomId = $('#all-comment-modal-label').text();
                $.ajax({
                    type: "POST",
                    url: '/lab/addRoomComment',
                    data: {comment: comment, roomId: roomId},
                    dataType: "json",
                    success: function(data){
                        var retData = eval('(' + data + ')');
                        if(retData.status === '0') {
                           alert('发表评论失败');
                        }
                        if(retData.status === '1') {
                           alert('发表评论成功');
                        }
                    },
                    error: function() {
                        console.log('/lab/addRoomComment fail');
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
                  url: '/lab/getRoomOrderInfo',
                  data: {roomId: roomId},
                  success: function(data){
                      var retData = eval('(' + data + ')');
                      $('#order-state').children().detach();
                      var domArr = [];
                      $.each(retData, function(i, e){
                          domArr.push('<p>' + e.labName + ' ' + e.applicant + ' ' + e.week + ' ' + e.weekday + ' ' + e.course + '</p>');
                      });
                      $('#order-state').append(domArr.join(''));
                  },
                  error: function(){
                      console.log('/lab/getRoomOrderInfo fail');
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
                var course = [];
                $.each($('#input-course input[type="checkbox"]:checked'), function(i, e){
                    course.push($(e).attr('value'));
                });
                var params = {
                    roomId: $('#all-order-modal-label').text(),
                    labName: $('#input-labName').val(),
                    applicant: username,
                    start_week: $('#input-startWeek  option:selected').text(),
                    end_week: $('#input-endWeek  option:selected').text(),
                    start_weekday: $('#input-startWeekday  option:selected').text(),
                    end_weekday: $('#input-endWeekday  option:selected').text(),
                    course: course
                };

                $.ajax({
                    type: 'POST',
                    url: '/lab/orderRoom',
                    data: params,
                    dataType: 'json',
                    success: function(data){
                      var retData = eval('(' + data + ')');
                      if(retData.status === '0') {
                         alert('预约失败');
                      }
                      if(retData.status === '1') {
                         alert('预约成功');
                      }
                    },
                    error: function(){
                        console.log('/lab/orderRoom fail');
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
          },
          error: function(){
            console.log('/lab/queryAllRoom', 'fail');
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
            // $('#all-room .flex-box').children().detach();
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
            // $('#all-room .flex-box').append(domArr.join(''));
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
          url: '/experiment/teacherOrderStatus',
          data: {role: role, username: username},
          dataType: 'json',
          success: function(data) {
              var retData = eval('(' + data + ')');
              var lab = retData.lab;
              var equip = retData.equip;
              var domLab = [];
              var domEquip = [];
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

              $('#all-equip-orderState').children().detach();
              $.each(equip, function(i, e){
                  domEquip.push(
                      '<div class="all-equip-order order hvr-sweep-to-right">',
                          '<div class="allEquipOrderId">' + e.equipOrderId + '</div>',
                          '<div class="allEquipOrderDate">' + e.equipDate + '</div>',
                          '<div class="allEquipOrderContent">' + e.equipName + ' ' + e.equipNumber + '件 ' + e.equipDays + '天 ' + '</div>',
                          '<div class="allEquipOrderState">状态：' + e.state + '</div>',
                      '</div>'
                  );
              });
              $('#all-equip-orderState').append(domEquip.join(''));
          },
          error: function() {
              console.log('/experiment/teacherOrderStatus fail');
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
              //   "equip":[
              //     {
              //       "equipName": "西瓜刀",
              //       "equipDate": "2015-9-10",
              //       "equipOrderId": "001",
              //       "equipDays": "10",
              //       "equipNumber": "2",
              //       "state": "未决定"
              //     },
              //     {
              //       "equipName": "狼牙棒",
              //       "equipDate": "2015-11-10",
              //       "equipOrderId": "002",
              //       "equipDays": "2",
              //       "equipNumber": "10",
              //       "state": "未决定"
              //     }
              //   ]
              // };
              // /**************/
              // var lab = retData.lab;
              // var equip = retData.equip;
              // var domLab = [];
              // var domEquip = [];
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
              // $('#all-equip-orderState').children().detach();
              // $.each(equip, function(i, e){
              //     domEquip.push(
              //         '<div class="all-equip-order order hvr-sweep-to-right">',
              //             '<div class="allEquipOrderId">' + e.equipOrderId + '</div>',
              //             '<div class="allEquipOrderDate">' + e.equipDate + '</div>',
              //             '<div class="allEquipOrderContent">' + e.equipName + ' ' + e.equipNumber + '件 ' + e.equipDays + '天 ' + '</div>',
              //             '<div class="allEquipOrderState">状态：' + e.state + '</div>',
              //         '</div>'
              //     );
              // });
              // $('#all-equip-orderState').append(domEquip.join(''));
              // /***************************************/
          }
      });

      /**
      * 初始化设备卡片
      */
      $.ajax({
          type: "GET",
          url: '/equipment/queryAllEquipment',
          data: {},
          dataType: "json",
          success: function(data){
            var retData = eval('(' + data + ')');
            $('#lab-equip .flex-box').children().detach();
            var domArr = [];
            $.each(retData, function(i, e) {
                domArr.push(
                    '<div class="card hvr-bounce-in" data-assetName="' + e.assetName + '" data-assetId="' + e.assetId + '">',
                        '<div class="lab-equipName">' + e.assetName + '</div>',
                        '<div class="lab-buttonGroup">',
                            '<button class="btn btn-info lab-equipInfo-btn" data-toggle="modal" data-target="#lab-equipInfo-modal">简介</button>',
                            '<button class="btn btn-success lab-order-btn" data-toggle="modal" data-target="#lab-equipOrder-modal">预约</button>',
                        '</div>',
                    '</div>'
                );
            });
            $('#lab-equip .flex-box').append(domArr.join(''));

            // 设备简介
            $('.lab-equipInfo-btn').on('click', function(){
                var assetName = $(this).parents('.card').attr('data-assetName');
                var assetId = $(this).parents('.card').attr('data-assetId');
                $('#lab-equipInfo-modal-label').text(assetName);
                $.ajax({
                    type: 'POST',
                    url: '/equipment/queryEquipmentInfo',
                    data: {assetName: assetName, assetId: assetId},
                    dataType: 'json',
                    success: function(data){
                        var retData = eval('(' + data + ')');
                        $('#lab-equipInfo-modal .modal-body').children().detach();
                        var equipInfo = '<div class="lab-equipInfo-classNo">分类代码： ' + retData.classNo + '</div>' +
                                        '<div class="lab-equipInfo-className">分类名称： ' + retData.className + '</div>' +
                                        '<div class="lab-equipInfo-valueType">价值类型： ' + retData.valueType + '</div>' +
                                        '<div class="lab-equipInfo-number">数量： ' + retData.number + '</div>';
                        $('#lab-equipInfo-modal .modal-body').append(equipInfo);
                    },
                    error: function(){
                        console.log('/equipment/queryEquipmentInfo fail');
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
                        // $('#lab-equipInfo-modal .modal-body').children().detach();
                        // var equipInfo = '<div class="lab-equipInfo-classNo">分类代码： ' + retData.classNo + '</div>' +
                        //                 '<div class="lab-equipInfo-className">分类名称： ' + retData.className + '</div>' +
                        //                 '<div class="lab-equipInfo-valueType">价值类型： ' + retData.valueType + '</div>' +
                        //                 '<div class="lab-equipInfo-number">数量： ' + retData.number + '</div>';
                        // $('#lab-equipInfo-modal .modal-body').append(equipInfo);
                        // /***************************************/
                    }
                });
            });

            // 预约设备
            $('.lab-order-btn').on('click', function(){
              var assetName = $(this).parents('.card').attr('data-assetName');
              var assetId = $(this).parents('.card').attr('data-assetId');
              $('#lab-equipOrder-modal-label').text(assetName);
              $('#lab-equipOrder-modal-label').attr('data-assetId', assetId);
            });

            $('#post-equipOrder').on('click', function(){
                var params = {
                    assetName: $('#lab-equipOrder-modal-label').text(),
                    assetId: $('#lab-equipOrder-modal-label').attr('data-assetId'),
                    number: $('#input-equipNumber').val(),
                    days: $('#input-equipDays').val(),
                    applicant: $('#input-equipApplicant').val()
                };

                $.ajax({
                    type: 'POST',
                    url: '/equipment/orderEquip',
                    data: params,
                    dataType: 'json',
                    success: function(data){
                        var retData = eval('(' + data + ')');
                        if(retData.status === "0") {
                            alert('预约失败');
                        }
                        if(retData.status === "1") {
                            alert('预约成功');
                        }
                    },
                    error: function(){
                        console.log('/equipment/orderEquip fail');
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
          },
          error: function(){
            console.log('/equipment/queryAllEquipment', 'fail');
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
            // $('#lab-equip .flex-box').children().detach();
            // var domArr = [];
            // $.each(retData, function(i, e) {
            //     domArr.push(
            //         '<div class="card hvr-bounce-in" data-assetName="' + e.assetName + '">',
            //             '<div class="lab-equipName">' + e.assetName + '</div>',
            //             '<div class="lab-buttonGroup">',
            //                 '<button class="btn btn-info lab-equipInfo-btn" data-toggle="modal" data-target="#lab-equipInfo-modal">简介</button>',
            //                 '<button class="btn btn-success lab-order-btn" data-toggle="modal" data-target="#lab-equipOrder-modal">预约</button>',
            //             '</div>',
            //         '</div>'
            //     );
            // });
            // $('#lab-equip .flex-box').append(domArr.join(''));
            // /***************************************/
        }
      });

      basicEvent();
    }
}

/**
* 加载页面事件
*/
function basicEvent() {

    // 搜索
    $('#search-btn').on('click', function(){
        var params = {
            item: $('#input-search-form').val(),
            type: $('.input-search input[name="searchType"]:checked').val()
        };

        $.ajax({
            type: 'POST',
            url: '/lab/getRoomCurrInfo',
            data: params,
            dataType: 'json',
            success: function(data){
                var retData = eval('(' + data + ')');
                $('.db-table').children().detach();
                var domArr = [];
                if (retData.status === '0') {
                    alert('没有该搜查结果');
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
                console.log('/lab/getRoomCurrInfo fail');
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

}

init();

/***************************************
* 用于前端test 测试状态：
*/
/*ajax返回的数据*/
//var retData = [];
/**************/

/***************************************/
