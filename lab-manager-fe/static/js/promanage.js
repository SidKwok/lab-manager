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
    $($('.nav-location')[4]).attr('href', '../dailyjob/index.html?' + userInfo + '?');
    $($('.nav-location')[5]).attr('href', '../aboutus/index.html?' + userInfo + '?');

    if (role === 'manager'){
        loadEquipCard();
        loadLabRoomCard();
        loadLabOrder();
        loadEquipOrder();
        basicEvent();
    } else {
        $('#pro-equip').children().detach();
        $('#pro-order').children().detach();
        $('#pro-labRoom').children().detach();
        $('#pro-equip').append('<h2>本区域只对管理员开放</h2>');
        $('#pro-order').append('<h2>本区域只对管理员开放</h2>');
        $('#pro-labRoom').append('<h2>本区域只对管理员开放</h2>');
    }
}

/**
* 加载设备卡片
*/
function loadEquipCard () {
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
          $('#pro-equip .flex-box').children().detach();
          var domArr = [];
          domArr.push(
              '<div class="hvr-pulse" id="pro-equipAdd" data-toggle="modal" data-target="#pro-equipAdd-modal">',
                  '<div class="pro-equipName">添加</div>',
              '</div>'
          );
          $.each(retData, function(i, e) {
              domArr.push(
                  '<div class="card hvr-bounce-in" data-assetName="' + e.assetName + '">',
                      '<div class="pro-equipName">' + e.assetName + '</div>',
                      '<div class="pro-buttonGroup">',
                          '<button class="btn btn-danger pro-equipDelete-btn" data-toggle="modal" data-target="#pro-equipDelete-modal">删除</button>',
                          '<button class="btn btn-success pro-equipUpdate-btn" data-toggle="modal" data-target="#pro-equipUpdate-modal">修改</button>',
                      '</div>',
                  '</div>'
              );
          });
          $('#pro-equip .flex-box').append(domArr.join(''));

          // 加载设备卡片事件
          equipCardEvent();
        },
        error: function(){
          console.log('/equipment/queryAllEquipment', 'fail');
          alert('后台错误！');

          // /***************************************
          // * 用于前端test 测试状态：
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
          // $('#pro-equip .flex-box').children().detach();
          // var domArr = [];
          // domArr.push(
          //     '<div class="hvr-pulse" id="pro-equipAdd" data-toggle="modal" data-target="#pro-equipAdd-modal">',
          //         '<div class="pro-equipName">添加</div>',
          //     '</div>'
          // );
          // $.each(retData, function(i, e) {
          //     domArr.push(
          //         '<div class="card hvr-bounce-in" data-assetName="' + e.assetName + '">',
          //             '<div class="pro-equipName">' + e.assetName + '</div>',
          //             '<div class="pro-buttonGroup">',
          //                 '<button class="btn btn-danger pro-equipDelete-btn" data-toggle="modal" data-target="#pro-equipDelete-modal">删除</button>',
          //                 '<button class="btn btn-success pro-equipUpdate-btn" data-toggle="modal" data-target="#pro-equipUpdate-modal">修改</button>',
          //             '</div>',
          //         '</div>'
          //     );
          // });
          // $('#pro-equip .flex-box').append(domArr.join(''));
          // /***************************************/
      }
    });
}

/**
* 设备卡片事件
*/
function equipCardEvent() {
  // 删除仪器
  $('.pro-equipDelete-btn').on('click', function(){
      $('#pro-equipDelete-modal-label').text($(this).parents('.card').attr('data-assetName'));
  });

  $('#pro-equipDelete').on('click', function(){
      var assetName = $('#pro-equipDelete-modal-label').text();
      $.ajax({
          type: 'POST',
          url: '/equipment/delEquipment',
          data: {assetName: assetName},
          dataType: 'json',
          success: function(data){
              var retData = eval('(' + data + ')');
              if(retData.status === '0') {
                  alert('删除失败');
              }
              if(retData.status === '1') {
                  alert('删除成功');
                  loadEquipCard();
              }
          },
          error: function(){
              alert('后台错误');
              console.log('/equipment/delEquipment fail');

              // /***************************************
              // * 用于前端test 测试状态：ok
              // */
              // /*ajax返回的数据*/
              // var retData = {
              //   "status": "1"
              // };
              // /**************/
              // if(retData.status === '0') {
              //     alert('删除失败');
              // }
              // if(retData.status === '1') {
              //     alert('删除成功');
              //     loadEquipCard();
              // }
              //
              // /***************************************/
          }
      });
  });

  // 修改仪器
  $('.pro-equipUpdate-btn').on('click', function(){
      var assetName = $(this).parents('.card').attr('data-assetName')
      $('#pro-equipUpdate-modal-label').text(assetName);
      $.ajax({
          type: 'POST',
          url: '/equipment/queryEquipmentInfo',
          data: {assetName: assetName},
          dataType: 'json',
          success: function(data){
              var retData = eval('(' + data + ')');
              $('#pro-equipUpdate-modal .pro-equipInfo').children().detach();
              var equipInfo = '<div class="pro-equipInfo-classNo">分类代码： ' + retData.classNo + '</div>' +
                              '<div class="pro-equipInfo-className">分类名称： ' + retData.className + '</div>' +
                              '<div class="pro-equipInfo-valueType">价值类型： ' + retData.valueType + '</div>' +
                              '<div class="pro-equipInfo-number">数量： ' + retData.number + '</div>';
              $('#pro-equipUpdate-modal .pro-equipInfo').append(equipInfo);
          },
          error: function(){
              console.log('/equipment/queryEquipmentInfo fail');
              alert('后台错误！');

              /***************************************
              * 用于前端test 测试状态：ok
              */
              // /*ajax返回的数据*/
              // var retData = {
              //   "classNo": "002",
              //   "className": "具",
              //   "valueType": "贵",
              //   "number": "1"
              // };
              // /**************/
              // $('#pro-equipUpdate-modal .pro-equipInfo').children().detach();
              // var equipInfo = '<div class="pro-equipInfo-classNo">分类代码： ' + retData.classNo + '</div>' +
              //                 '<div class="pro-equipInfo-className">分类名称： ' + retData.className + '</div>' +
              //                 '<div class="pro-equipInfo-valueType">价值类型： ' + retData.valueType + '</div>' +
              //                 '<div class="pro-equipInfo-number">数量： ' + retData.number + '</div>';
              // $('#pro-equipUpdate-modal .pro-equipInfo').append(equipInfo);
              // /***************************************/
          }
      });
  });

  $('#post-equipUpdate').on('click', function(){
      var params = {
          assetName: $('#pro-equipUpdate-modal-label').text(),
          classNo: $('#pro-input-classNo').val(),
          className: $('#pro-input-className').val(),
          valueType: $('#pro-input-valueType').val(),
          number: $('#pro-input-number').val()
      };

      $.ajax({
          type: 'POST',
          url: '/equipment/updateEquipment',
          data: params,
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData.status === '0') {
                alert('修改失败');
            }
            if(retData.status === '1') {
                alert('修改成功');
                loadEquipCard();
            }
          },
          error: function(){
              alert('后台错误');
              console.log('/equipment/updateEquipment fail');
              // /***************************************
              // * 用于前端test 测试状态：
              // */
              // /*ajax返回的数据*/
              // var retData = {
              //   "status": "1"
              // };
              // /**************/
              // if(retData.status === '0') {
              //     alert('修改失败');
              // }
              // if(retData.status === '1') {
              //     alert('修改成功');
              //     loadEquipCard();
              // }
              // /***************************************/
          }
      });
  });

  // 添加仪器
  $('#post-equipAdd').on('click', function(){
      var params = {
          assetName: $('#pro-input-add-assetName').val(),
          classNo: $('#pro-input-add-classNo').val(),
          className: $('#pro-input-add-className').val(),
          valueType: $('#pro-input-add-valueType').val(),
          number: $('#pro-input-add-number').val(),
      };

      $.ajax({
          type: 'POST',
          url: '/equipment/addEquipment',
          data: params,
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData.status === '0') {
                alert('添加失败');
            }
            if(retData.status === '1') {
                alert('添加成功');
                loadEquipCard();
            }
          },
          error: function(){
              alert('后台错误');
              console.log('/equipment/addEquipment fail');

              // /***************************************
              // * 用于前端test 测试状态：
              // */
              // /*ajax返回的数据*/
              // var retData = {
              //   "status": "1"
              // };
              // /**************/
              // if(retData.status === '0') {
              //     alert('添加失败');
              // }
              // if(retData.status === '1') {
              //     alert('添加成功');
              //     loadEquipCard();
              // }
              // /***************************************/
          }
      });
  });
}

/**
* 加载实验室卡片
*/
function loadLabRoomCard () {
    // 初始化设备卡片
    $.ajax({
        type: "GET",
        url: '/lab/getLabsInfo',
        data: {},
        dataType: "json",
        success: function(data){
          var retData = eval('(' + data + ')');
          $('#pro-labRoom .flex-box').children().detach();
          var domArr = [];
          domArr.push(
              '<div class="hvr-pulse" id="pro-labRoomAdd" data-toggle="modal" data-target="#pro-labRoomAdd-modal">',
                  '<div class="pro-labRoomName">添加</div>',
              '</div>'
          );
          $.each(retData, function(i, e) {
              domArr.push(
                  '<div class="card hvr-bounce-in" data-labRoomName="' + e.labRoomName + '">',
                      '<div class="pro-labRoomName">' + e.labRoomName + '</div>',
                      '<div class="pro-buttonGroup">',
                          '<button class="btn btn-danger pro-labRoomDelete-btn" data-toggle="modal" data-target="#pro-labRoomDelete-modal">删除</button>',
                          '<button class="btn btn-success pro-labRoomUpdate-btn" data-toggle="modal" data-target="#pro-labRoomUpdate-modal">修改</button>',
                      '</div>',
                  '</div>'
              );
          });
          $('#pro-labRoom .flex-box').append(domArr.join(''));

          // 加载实验室卡片事件
          labRoomCardEvent();
        },
        error: function(){
          console.log('/lab/getLabsInfo', 'fail');
          alert('后台错误！');

          // /***************************************
          // * 用于前端test 测试状态：
          // */
          // /*ajax返回的数据*/
          // var retData = [
          //   {
          //     "labRoomName": "机器人实验室"
          //   },
          //   {
          //     "labRoomName": "足球实验室"
          //   },
          //   {
          //     "labRoomName": "操蛋实验室"
          //   }
          // ];
          // /**************/
          // $('#pro-labRoom .flex-box').children().detach();
          // var domArr = [];
          // domArr.push(
          //     '<div class="hvr-pulse" id="pro-labRoomAdd" data-toggle="modal" data-target="#pro-labRoomAdd-modal">',
          //         '<div class="pro-labRoomName">添加</div>',
          //     '</div>'
          // );
          // $.each(retData, function(i, e) {
          //     domArr.push(
          //         '<div class="card hvr-bounce-in" data-labRoomName="' + e.labRoomName + '">',
          //             '<div class="pro-labRoomName">' + e.labRoomName + '</div>',
          //             '<div class="pro-buttonGroup">',
          //                 '<button class="btn btn-danger pro-labRoomDelete-btn" data-toggle="modal" data-target="#pro-labRoomDelete-modal">删除</button>',
          //                 '<button class="btn btn-success pro-labRoomUpdate-btn" data-toggle="modal" data-target="#pro-labRoomUpdate-modal">修改</button>',
          //             '</div>',
          //         '</div>'
          //     );
          // });
          // $('#pro-labRoom .flex-box').append(domArr.join(''));
          // /***************************************/
      }
    });
}

/**
* 实验室卡片事件
*/
function labRoomCardEvent(){
  // 删除实验室
  $('.pro-labRoomDelete-btn').on('click', function(){
      $('#pro-labRoomDelete-modal-label').text($(this).parents('.card').attr('data-labRoomName'));
  });

  $('#pro-labRoomDelete').on('click', function(){
      var labRoomName = $('#pro-labRoomDelete-modal-label').text();
      $.ajax({
          type: 'POST',
          url: '/lab/delLabRoom',
          data: {labRoomName: labRoomName},
          dataType: 'json',
          success: function(data){
              var retData = eval('(' + data + ')');
              if(retData.status === '0') {
                  alert('删除失败');
              }
              if(retData.status === '1') {
                  alert('删除成功');
                  loadEquipCard();
              }
          },
          error: function(){
              alert('后台错误');
              console.log('/lab/delLabRoom fail');

              // /***************************************
              // * 用于前端test 测试状态：ok
              // */
              // /*ajax返回的数据*/
              // var retData = {
              //   "status": "1"
              // };
              // /**************/
              // if(retData.status === '0') {
              //     alert('删除失败');
              // }
              // if(retData.status === '1') {
              //     alert('删除成功');
              //     loadEquipCard();
              // }
              //
              // /***************************************/
          }
      });
  });

  // 修改实验室
  $('.pro-labRoomUpdate-btn').on('click', function(){
      var labRoomName = $(this).parents('.card').attr('data-labRoomName')
      $('#pro-labRoomUpdate-modal-label').text(labRoomName);
      $.ajax({
          type: 'POST',
          url: '/lab/roomConcreateInfo',
          data: {labRoomName: labRoomName},
          dataType: 'json',
          success: function(data){
              var retData = eval('(' + data + ')');
              $('#pro-labRoomUpdate-modal .pro-labRoomInfo').children().detach();
              var labRoomInfo = '<div class="pro-labRoomInfo-labRoomName">实验室名称： ' + retData.labRoomName + '</div>' +
                              '<div class="pro-labRoomInfo-labRoomType">实验室类型： ' + retData.labRoomType + '</div>' +
                              '<div class="pro-labRoomInfo-labRoomIntro">简介： ' + retData.labRoomIntro + '</div>';
              $('#pro-labRoomUpdate-modal .pro-labRoomInfo').append(labRoomInfo);
          },
          error: function(){
              console.log('/lab/roomConcreateInfo fail');
              alert('后台错误！');

              // /***************************************
              // * 用于前端test 测试状态：ok
              // */
              // /*ajax返回的数据*/
              // var retData = {
              //   "labRoomName":"机器人实验室",
              //   "labRoomType":"机器人",
              //   "labRoomIntro":"棒"
              // };
              // /**************/
              // $('#pro-labRoomUpdate-modal .pro-labRoomInfo').children().detach();
              // var labRoomInfo = '<div class="pro-labRoomInfo-labRoomName">实验室名称： ' + retData.labRoomName + '</div>' +
              //                 '<div class="pro-labRoomInfo-labRoomType">实验室类型： ' + retData.labRoomType + '</div>' +
              //                 '<div class="pro-labRoomInfo-labRoomIntro">简介： ' + retData.labRoomIntro + '</div>';
              // $('#pro-labRoomUpdate-modal .pro-labRoomInfo').append(labRoomInfo);
              // /***************************************/
          }
      });
  });

  $('#post-labRoomUpdate').on('click', function(){
      var params = {
          labRoomName: $('#pro-input-labRoomName').val(),
          labRoomType: $('#pro-input-labRoomType').val(),
          labRoomIntro: $('#pro-input-labRoomIntro').val()
      };

      $.ajax({
          type: 'POST',
          url: '/lab/updateRoomInfo',
          data: params,
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData.status === '0') {
                alert('修改失败');
            }
            if(retData.status === '1') {
                alert('修改成功');
                loadEquipCard();
            }
          },
          error: function(){
              alert('后台错误');
              console.log('/lab/updateRoomInfo fail');
              // /***************************************
              // * 用于前端test 测试状态：
              // */
              // /*ajax返回的数据*/
              // var retData = {
              //   "status": "1"
              // };
              // /**************/
              // if(retData.status === '0') {
              //     alert('修改失败');
              // }
              // if(retData.status === '1') {
              //     alert('修改成功');
              //     loadEquipCard();
              // }
              // /***************************************/
          }
      });
  });

  // 添加实验室
  $('#post-labRoomAdd').on('click', function(){
      var params = {
          labRoomName: $('#pro-input-add-labRoomName').val(),
          labRoomType: $('#pro-input-add-labRoomType').val(),
          labRoomIntro: $('#pro-input-add-labRoomIntro').val(),
      };
      console.log(params);

      $.ajax({
          type: 'POST',
          url: '/lab/addLabRoom',
          data: params,
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData.status === '0') {
                alert('添加失败');
            }
            if(retData.status === '1') {
                alert('添加成功');
                loadEquipCard();
            }
          },
          error: function(){
              alert('后台错误');
              console.log('/lab/addLabRoom fail');

              // /***************************************
              // * 用于前端test 测试状态：
              // */
              // /*ajax返回的数据*/
              // var retData = {
              //   "status": "1"
              // };
              // /**************/
              // if(retData.status === '0') {
              //     alert('添加失败');
              // }
              // if(retData.status === '1') {
              //     alert('添加成功');
              //     loadEquipCard();
              // }
              // /***************************************/
          }
      });
  });
}

/**
* 加载实验室预约
*/
function loadLabOrder() {
    $.ajax({
        type: 'GET',
        url: '/lab/labUseStatus',
        data: {},
        dataType: 'json',
        success: function(data){
            var retData = eval('(' + data + ')');
            $('#pro-lab-order').children().detach();
            var domArr = [];
            $.each(retData, function(i, e){
                domArr.push(
                    '<div class="lab-order order hvr-sweep-to-right">',
                        '<div class="labOrderId">' + e.labOrderId + '</div>',
                        '<div class="labOrderDate">' + e.labOrderDate + '</div>',
                        '<div class="labOrderContent">' + e.labOrderName + ' ' + e.labOrderWeed + ' ' + e.labOrderWeekday + ' ' + e.labOrderCourse + '</div>',
                        '<div class="labOrderApplicant">' + e.labOrderApplicant + '</div>',
                        '<div class="pro-order-btnGroup">',
                            '<button class="btn btn-success labOrder-confirm-btn">批准</button>',
                            '<button class="btn btn-danger labOrder-refuse-btn">拒绝</button>',
                        '</div>',
                    '</div>'
                );
            });
            $('#pro-lab-order').append(domArr.join(''));

            // 加载实验室预约事件
            labOrderEvent();
        },
        error: function() {
            alert('后台出错');
            console.log('/lab/labUseStatus fail');
            // /***************************************
            // * 用于前端test 测试状态：ok
            // */
            // /*ajax返回的数据*/
            // var retData = [
            //   {
            //     "labOrderId": "0001",
            //     "labOrderName": "机器人实验",
            //     "labOrderDate": "2016-5-21",
            //     "labOrderWeek": "第一周",
            //     "labOrderWeekday": "周五",
            //     "labOrderCourse": "第1、2节",
            //     "labOrderApplicant": "sid"
            //   },
            //   {
            //     "labOrderId": "0002",
            //     "labOrderName": "足球实验",
            //     "labOrderDate": "2016-5-21",
            //     "labOrderWeek": "第二周",
            //     "labOrderWeekday": "周四",
            //     "labOrderCourse": "第5、6节",
            //     "labOrderApplicant": "mingen"
            //   },
            //   {
            //     "labOrderId": "0003",
            //     "labOrderName": "混合实验",
            //     "labOrderDate": "2016-6-21",
            //     "labOrderWeek": "第三周",
            //     "labOrderWeekday": "周一",
            //     "labOrderCourse": "第9、10节",
            //     "labOrderApplicant": "nat"
            //   },
            //   {
            //     "labOrderId": "0004",
            //     "labOrderName": "jiao实验",
            //     "labOrderDate": "2016-1-21",
            //     "labOrderWeek": "第八周",
            //     "labOrderWeekday": "周二",
            //     "labOrderCourse": "第1、2节",
            //     "labOrderApplicant": "airdy"
            //   },
            // ];
            // /**************/
            // $('#pro-lab-order').children().detach();
            // var domArr = [];
            // $.each(retData, function(i, e){
            //     domArr.push(
            //         '<div class="lab-order order hvr-sweep-to-right">',
            //             '<div class="labOrderId">' + e.labOrderId + '</div>',
            //             '<div class="labOrderDate">' + e.labOrderDate + '</div>',
            //             '<div class="labOrderContent">' + e.labOrderName + ' ' + e.labOrderWeek + ' ' + e.labOrderWeekday + ' ' + e.labOrderCourse + '</div>',
            //             '<div class="labOrderApplicant">' + e.labOrderApplicant + '</div>',
            //             '<div class="pro-order-btnGroup">',
            //                 '<button class="btn btn-success labOrder-confirm-btn">批准</button>',
            //                 '<button class="btn btn-danger labOrder-refuse-btn">拒绝</button>',
            //             '</div>',
            //         '</div>'
            //     );
            // });
            // $('#pro-lab-order').append(domArr.join(''));
            // /***************************************/
        }
    });
}

/**
* 实验室预约事件
*/
function labOrderEvent(){
  // 批准实验室预约
  $('.labOrder-confirm-btn').on('click', function(){
      $.ajax({
          type: 'POST',
          url: '/lab/confirmLabOrder',
          data: {labOrderId: $(this).parents('.lab-order').children('.labOrderId').text()},
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData.status === '0') {
                alert('批准实验室预约失败');
            }
            if(retData.status === '1') {
                alert('批准实验室预约成功');
                loadLabOrder();
            }
          },
          error: function(){
            alert('后台出错');
            console.log('/lab/confirmLabOrder fail');

            // /***************************************
            // * 用于前端test 测试状态：
            // */
            // /*ajax返回的数据*/
            // var retData = {
            //   "status": "1"
            // };
            // /**************/
            // if(retData.status === '0') {
            //     alert('批准实验室预约失败');
            // }
            // if(retData.status === '1') {
            //     alert('批准实验室预约成功');
            //     loadLabOrder();
            // }
            // /***************************************/
          }
      });
  });

  // 拒绝实验室预约
  $('.labOrder-refuse-btn').on('click', function(){
      $.ajax({
          type: 'POST',
          url: '/lab/refuseLabOrder',
          data: {labOrderId: $(this).parents('.lab-order').children('.labOrderId').text()},
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData.status === '0') {
                alert('拒绝实验室预约失败');
            }
            if(retData.status === '1') {
                alert('拒绝实验室预约成功');
                loadLabOrder();
            }
          },
          error: function(){
            alert('后台出错');
            console.log('/lab/refuseLabOrder fail');

            // /***************************************
            // * 用于前端test 测试状态：
            // */
            // /*ajax返回的数据*/
            // var retData = {
            //   "status": "1"
            // };
            // /**************/
            // if(retData.status === '0') {
            //     alert('拒绝实验室预约失败');
            // }
            // if(retData.status === '1') {
            //     alert('拒绝实验室预约成功');
            //     loadLabOrder();
            // }
            // /***************************************/
          }
      });
  });
}

/**
* 加载设备预约
*/
function loadEquipOrder(){
  $.ajax({
      type: 'GET',
      url: '/equipment/equitOrderStatus',
      data: {},
      dataType: 'json',
      success: function(data){
        var retData = eval('(' + data + ')');
        $('#pro-equip-order').children().detach();
        var domArr = [];
        $.each(retData, function(i, e){
            domArr.push(
                '<div class="equip-order order hvr-sweep-to-right">',
                    '<div class="equipOrderId">' + e.equipOrderId + '</div>',
                    '<div class="equipOrderDate">' + e.equipOrderDate + '</div>',
                    '<div class="equipOrderContent">' + e.equipOrderName + ' ' + e.equipOrderNumber + '件 ' + e.equipOrderDay + '天</div>',
                    '<div class="equipOrderApplicant">' + e.equipOrderApplicant + '</div>',
                    '<div class="pro-order-btnGroup">',
                        '<button class="btn btn-success equipOrder-confirm-btn">批准</button>',
                        '<button class="btn btn-danger equipOrder-refuse-btn">拒绝</button>',
                    '</div>',
                '</div>'
            );
        });
        $('#pro-equip-order').append(domArr.join(''));

        //加载设备预约事件
        equipOrderEvent();
      },
      error: function() {
          alert('后台出错');
          console.log('/equipment/equitOrderStatus fail');

          // /***************************************
          // * 用于前端test 测试状态：
          // */
          // /*ajax返回的数据*/
          // var retData = [
          //   {
          //     "equipOrderId": "0003",
          //     "equipOrderName": "西瓜刀",
          //     "equipOrderNumber": "10",
          //     "equipOrderDay": "5",
          //     "equipOrderApplicant": "sid",
          //     "equipOrderDate": "2016-5-7"
          //   },
          //   {
          //     "equipOrderId": "0004",
          //     "equipOrderName": "狼牙棒",
          //     "equipOrderNumber": "5",
          //     "equipOrderDay": "10",
          //     "equipOrderApplicant": "mingen",
          //     "equipOrderDate": "2016-5-7"
          //   },
          //   {
          //     "equipOrderId": "0005",
          //     "equipOrderName": "倚天剑",
          //     "equipOrderNumber": "10",
          //     "equipOrderDay": "2",
          //     "equipOrderApplicant": "nat",
          //     "equipOrderDate": "2016-5-7"
          //   },
          //   {
          //     "equipOrderId": "0006",
          //     "equipOrderName": "绝世好剑",
          //     "equipOrderNumber": "5",
          //     "equipOrderDay": "6",
          //     "equipOrderApplicant": "bob",
          //     "equipOrderDate": "2016-5-7"
          //   },
          //   {
          //     "equipOrderId": "0007",
          //     "equipOrderName": "屠龙刀",
          //     "equipOrderNumber": "10",
          //     "equipOrderDay": "1",
          //     "equipOrderApplicant": "airdy",
          //     "equipOrderDate": "2016-5-7"
          //   },
          // ];
          // /**************/
          // $('#pro-equip-order').children().detach();
          // var domArr = [];
          // $.each(retData, function(i, e){
          //     domArr.push(
          //         '<div class="equip-order order hvr-sweep-to-right">',
          //             '<div class="equipOrderId">' + e.equipOrderId + '</div>',
          //             '<div class="equipOrderDate">' + e.equipOrderDate + '</div>',
          //             '<div class="equipOrderContent">' + e.equipOrderName + ' ' + e.equipOrderNumber + '件 ' + e.equipOrderDay + '天</div>',
          //             '<div class="equipOrderApplicant">' + e.equipOrderApplicant + '</div>',
          //             '<div class="pro-order-btnGroup">',
          //                 '<button class="btn btn-success equipOrder-confirm-btn">批准</button>',
          //                 '<button class="btn btn-danger equipOrder-refuse-btn">拒绝</button>',
          //             '</div>',
          //         '</div>'
          //     );
          // });
          // $('#pro-equip-order').append(domArr.join(''));
          // /***************************************/
      }
  });
}

/**
* 设备预约事件
*/
function equipOrderEvent(){
  // 批准设备预约
  $('.equipOrder-confirm-btn').on('click', function(){
      $.ajax({
          type: 'POST',
          url: '/equipment/confirmEquitOrder',
          data: {equipOrderId: $(this).parents('.equip-order').children('.equipOrderId').text()},
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData.status === '0') {
                alert('批准设备预约失败');
            }
            if(retData.status === '1') {
                alert('批准设备预约成功');
                loadEquipOrder();
            }
          },
          error: function(){
            alert('后台出错');
            console.log('/equipment/confirmEquitOrder fail');

            // /***************************************
            // * 用于前端test 测试状态：ok
            // */
            // /*ajax返回的数据*/
            // var retData = {
            //   "status": "1"
            // };
            // /**************/
            // if(retData.status === '0') {
            //     alert('批准设备预约失败');
            // }
            // if(retData.status === '1') {
            //     alert('批准设备预约成功');
            //     loadEquipOrder();
            // }
            // /***************************************/
          }
      });
  });

  // 拒绝设备预约
  $('.equipOrder-refuse-btn').on('click', function(){
      $.ajax({
          type: 'POST',
          url: '/equipment/refuseEquitOrder',
          data: {equipOrderId: $(this).parents('.equip-order').children('.equipOrderId').text()},
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData === '0') {
                alert('拒绝设备预约失败');
            }
            if(retData === '1') {
                alert('拒绝设备预约成功');
                loadEquipOrder();
            }
          },
          error: function(){
            alert('后台出错');
            console.log('/equipment/refuseEquitOrder fail');

            // /***************************************
            // * 用于前端test 测试状态：ok
            // */
            // /*ajax返回的数据*/
            // var retData = {
            //   "status": "1"
            // };
            // /**************/
            // if(retData.status === '0') {
            //     alert('拒绝设备预约失败');
            // }
            // if(retData.status === '1') {
            //     alert('拒绝设备预约成功');
            //     loadEquipOrder();
            // }
            // /***************************************/
          }
      });
  });
}

/**
* 加载页面事件
*/
function basicEvent(){

}

init();
