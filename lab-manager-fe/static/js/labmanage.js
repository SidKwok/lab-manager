/**
* 页面初始化事件
*/

function init () {
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
