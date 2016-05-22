/**
* 页面初始化事件
*/
function init () {
    loadEquitCard();
    loadLabOrder();
    loadEquitOrder();
}

/**
* 加载设备卡片
*/
function loadEquitCard () {
    /**
    * 初始化设备卡片
    */
    $.ajax({
        type: "GET",
        url: '_equit_ajax',
        data: {},
        dataType: "json",
        success: function(retData){
          $('#pro-equit').children().detach();
          var domArr = [];
          domArr.push(
              '<div class="hvr-pulse" id="pro-equitAdd" data-toggle="modal" data-target="#pro-equitAdd-modal">',
                  '<div class="pro-equitName">添加</div>',
              '</div>'
          );
          $.each(retData, function(i, e) {
              domArr.push(
                  '<div class="card hvr-bounce-in" data-assetName="' + e.assetName + '">',
                      '<div class="pro-equitName">' + e.assetName + '</div>',
                      '<div class="pro-buttonGroup">',
                          '<button class="btn btn-danger pro-equitDelete-btn" data-toggle="modal" data-target="#pro-equitDelete-modal">删除</button>',
                          '<button class="btn btn-success pro-equitUpdate-btn" data-toggle="modal" data-target="#pro-equitUpdate-modal">修改</button>',
                      '</div>',
                  '</div>'
              );
          });
          $('#pro-equit').append(domArr.join(''));
        },
        error: function(){
          console.log('_equit_ajax', 'fail');
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
          // $('#pro-equit').children().detach();
          // var domArr = [];
          // domArr.push(
          //     '<div class="hvr-pulse" id="pro-equitAdd" data-toggle="modal" data-target="#pro-equitAdd-modal">',
          //         '<div class="pro-equitName">添加</div>',
          //     '</div>'
          // );
          // $.each(retData, function(i, e) {
          //     domArr.push(
          //         '<div class="card hvr-bounce-in" data-assetName="' + e.assetName + '">',
          //             '<div class="pro-equitName">' + e.assetName + '</div>',
          //             '<div class="pro-buttonGroup">',
          //                 '<button class="btn btn-danger pro-equitDelete-btn" data-toggle="modal" data-target="#pro-equitDelete-modal">删除</button>',
          //                 '<button class="btn btn-success pro-equitUpdate-btn" data-toggle="modal" data-target="#pro-equitUpdate-modal">修改</button>',
          //             '</div>',
          //         '</div>'
          //     );
          // });
          // $('#pro-equit').append(domArr.join(''));
          // /***************************************/
      }
    });
}

/**
* 加载实验室预约
*/
function loadLabOrder() {
    $.ajax({
        type: 'GET',
        url: '_labOrder_ajax',
        data: {},
        dataType: 'json',
        success: function(retData){
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
        },
        error: function() {
            alert('后台出错');
            console.log('_labOrder_ajax fail');
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
* 加载设备预约
*/
function loadEquitOrder(){
  $.ajax({
      type: 'GET',
      url: '_equitOrder_ajax',
      data: {},
      dataType: 'json',
      success: function(retData){
        $('#pro-equit-order').children().detach();
        var domArr = [];
        $.each(retData, function(i, e){
            domArr.push(
                '<div class="equit-order order hvr-sweep-to-right">',
                    '<div class="equitOrderId">' + e.equitOrderId + '</div>',
                    '<div class="equitOrderDate">' + e.equitOrderDate + '</div>',
                    '<div class="equitOrderContent">' + e.equitOrderName + ' ' + e.equitOrderNumber + '件 ' + e.equitOrderDay + '天</div>',
                    '<div class="equitOrderApplicant">' + e.equitOrderApplicant + '</div>',
                    '<div class="pro-order-btnGroup">',
                        '<button class="btn btn-success equitOrder-confirm-btn">批准</button>',
                        '<button class="btn btn-danger equitOrder-refuse-btn">拒绝</button>',
                    '</div>',
                '</div>'
            );
        });
        $('#pro-equit-order').append(domArr.join(''));
      },
      error: function() {
          alert('后台出错');
          console.log('_labOrder_ajax fail');

          // /***************************************
          // * 用于前端test 测试状态：
          // */
          // /*ajax返回的数据*/
          // var retData = [
          //   {
          //     "equitOrderId": "0003",
          //     "equitOrderName": "西瓜刀",
          //     "equitOrderNumber": "10",
          //     "equitOrderDay": "5",
          //     "equitOrderApplicant": "sid",
          //     "equitOrderDate": "2016-5-7"
          //   },
          //   {
          //     "equitOrderId": "0004",
          //     "equitOrderName": "狼牙棒",
          //     "equitOrderNumber": "5",
          //     "equitOrderDay": "10",
          //     "equitOrderApplicant": "mingen",
          //     "equitOrderDate": "2016-5-7"
          //   },
          //   {
          //     "equitOrderId": "0005",
          //     "equitOrderName": "倚天剑",
          //     "equitOrderNumber": "10",
          //     "equitOrderDay": "2",
          //     "equitOrderApplicant": "nat",
          //     "equitOrderDate": "2016-5-7"
          //   },
          //   {
          //     "equitOrderId": "0006",
          //     "equitOrderName": "绝世好剑",
          //     "equitOrderNumber": "5",
          //     "equitOrderDay": "6",
          //     "equitOrderApplicant": "bob",
          //     "equitOrderDate": "2016-5-7"
          //   },
          //   {
          //     "equitOrderId": "0007",
          //     "equitOrderName": "屠龙刀",
          //     "equitOrderNumber": "10",
          //     "equitOrderDay": "1",
          //     "equitOrderApplicant": "airdy",
          //     "equitOrderDate": "2016-5-7"
          //   },
          // ];
          // /**************/
          // $('#pro-equit-order').children().detach();
          // var domArr = [];
          // $.each(retData, function(i, e){
          //     domArr.push(
          //         '<div class="equit-order order hvr-sweep-to-right">',
          //             '<div class="equitOrderId">' + e.equitOrderId + '</div>',
          //             '<div class="equitOrderDate">' + e.equitOrderDate + '</div>',
          //             '<div class="equitOrderContent">' + e.equitOrderName + ' ' + e.equitOrderNumber + '件 ' + e.equitOrderDay + '天</div>',
          //             '<div class="equitOrderApplicant">' + e.equitOrderApplicant + '</div>',
          //             '<div class="pro-order-btnGroup">',
          //                 '<button class="btn btn-success equitOrder-confirm-btn">批准</button>',
          //                 '<button class="btn btn-danger equitOrder-refuse-btn">拒绝</button>',
          //             '</div>',
          //         '</div>'
          //     );
          // });
          // $('#pro-equit-order').append(domArr.join(''));
          // /***************************************/
      }
  });
}

/**
* 加载页面事件
*/
function basicEvent(){
    // 删除仪器
    $('.pro-equitDelete-btn').on('click', function(){
        $('#pro-equitDelete-modal-label').text($(this).parents('.card').attr('data-assetName'));
    });

    $('#pro-equitDelete').on('click', function(){
        var assetName = $('#pro-equitDelete-modal-label').text();
        $.ajax({
            type: 'POST',
            url: '_del_equit',
            data: {assetName: assetName},
            dataType: 'json',
            success: function(retData){
                if(retData.status === '0') {
                    alert('删除失败');
                }
                if(retData.status === '1') {
                    alert('删除成功');
                    loadEquitCard();
                }
            },
            error: function(){
                alert('后台错误');
                console.log('del_equit fail');

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
                //     loadEquitCard();
                // }
                //
                // /***************************************/
            }
        });
    });

    // 修改仪器
    $('.pro-equitUpdate-btn').on('click', function(){
        var assetName = $(this).parents('.card').attr('data-assetName')
        $('#pro-equitUpdate-modal-label').text(assetName);
        $.ajax({
            type: 'POST',
            url: '_equit_info',
            data: {assetName: assetName},
            dataType: 'json',
            success: function(retData){
                $('#pro-equitUpdate-modal .pro-equitInfo').children().detach();
                var equitInfo = '<div class="pro-equitInfo-classNo">分类代码： ' + retData.classNo + '</div>' +
                                '<div class="pro-equitInfo-className">分类名称： ' + retData.className + '</div>' +
                                '<div class="pro-equitInfo-valueType">价值类型： ' + retData.valueType + '</div>' +
                                '<div class="pro-equitInfo-number">数量： ' + retData.number + '</div>';
                $('#pro-equitUpdate-modal .pro-equitInfo').append(equitInfo);
            },
            error: function(){
                console.log('_equit_info fail');
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
                // $('#pro-equitUpdate-modal .pro-equitInfo').children().detach();
                // var equitInfo = '<div class="pro-equitInfo-classNo">分类代码： ' + retData.classNo + '</div>' +
                //                 '<div class="pro-equitInfo-className">分类名称： ' + retData.className + '</div>' +
                //                 '<div class="pro-equitInfo-valueType">价值类型： ' + retData.valueType + '</div>' +
                //                 '<div class="pro-equitInfo-number">数量： ' + retData.number + '</div>';
                // $('#pro-equitUpdate-modal .pro-equitInfo').append(equitInfo);
                // /***************************************/
            }
        });
    });

    $('#post-equitUpdate').on('click', function(){
        var params = {
            assetName: $('#pro-equitUpdate-modal-label').text(),
            classNo: $('#pro-input-classNo').val(),
            className: $('#pro-input-className').val(),
            valueType: $('#pro-input-valueType').val(),
            number: $('#pro-input-number').val()
        };

        $.ajax({
            type: 'POST',
            url: '_update_equit',
            data: params,
            dataType: 'json',
            success: function(retData){
              if(retData.status === '0') {
                  alert('修改失败');
              }
              if(retData.status === '1') {
                  alert('修改成功');
                  loadEquitCard();
              }
            },
            error: function(){
                alert('后台错误');
                console.log('_update_equit fail');
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
                //     loadEquitCard();
                // }
                // /***************************************/
            }
        });
    });

    // 添加仪器
    $('#post-equitAdd').on('click', function(){
        var params = {
            assetName: $('#pro-input-add-assetName').val(),
            classNo: $('#pro-input-add-classNo').val(),
            className: $('#pro-input-add-className').val(),
            valueType: $('#pro-input-add-valueType').val(),
            number: $('#pro-input-add-number').val(),
        };

        $.ajax({
            type: 'POST',
            url: '_add_equit',
            data: params,
            dataType: 'json',
            success: function(retData){
              if(retData.status === '0') {
                  alert('添加失败');
              }
              if(retData.status === '1') {
                  alert('添加成功');
                  loadEquitCard();
              }
            },
            error: function(){
                alert('后台错误');
                console.log('add_equit fail');

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
                //     loadEquitCard();
                // }
                // /***************************************/
            }
        });
    });

    // 批准实验室预约
    $('.labOrder-confirm-btn').on('click', function(){
        $.ajax({
            type: 'POST',
            url: '_confirm_labOrder',
            data: {labOrderId: $(this).parents('.lab-order').children('.labOrderId').text()},
            dataType: 'json',
            success: function(retData){
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
              console.log('_confirm_labOrder fail');

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
            url: '_refuse_labOrder',
            data: {labOrderId: $(this).parents('.lab-order').children('.labOrderId').text()},
            dataType: 'json',
            success: function(retData){
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
              console.log('_refuse_labOrder fail');

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

    // 批准设备预约
    $('.equitOrder-confirm-btn').on('click', function(){
        $.ajax({
            type: 'POST',
            url: '_confirm_equitOrder',
            data: {equitOrderId: $(this).parents('.equit-order').children('.equitOrderId').text()},
            dataType: 'json',
            success: function(retData){
              if(retData.status === '0') {
                  alert('批准设备预约失败');
              }
              if(retData.status === '1') {
                  alert('批准设备预约成功');
                  loadEquitOrder();
              }
            },
            error: function(){
              alert('后台出错');
              console.log('_confirm_equitOrder fail');

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
              //     loadEquitOrder();
              // }
              // /***************************************/
            }
        });
    });

    // 拒绝设备预约
    $('.equitOrder-refuse-btn').on('click', function(){
        $.ajax({
            type: 'POST',
            url: '_refuse_equitOrder',
            data: {equitOrderId: $(this).parents('.equit-order').children('.equitOrderId').text()},
            dataType: 'json',
            success: function(retData){
              if(retData === '0') {
                  alert('拒绝设备预约失败');
              }
              if(retData === '1') {
                  alert('拒绝设备预约成功');
                  loadEquitOrder();
              }
            },
            error: function(){
              alert('后台出错');
              console.log('_refuse_equitOrder fail');

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
              //     loadEquitOrder();
              // }
              // /***************************************/
            }
        });
    });
}

init();
basicEvent();
