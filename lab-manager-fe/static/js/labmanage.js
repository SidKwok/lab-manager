/**
* 页面初始化事件
*/

function init () {
    /**
    * 初始化设备卡片
    */
    $.ajax({
        type: "GET",
        url: 'equit_ajax',
        data: {},
        dataType: "json",
        success: function(retData){
          $('#lab-equit').children().detach();
          var domArr = [];
          $.each(retData, function(i, e) {
              domArr.push(
                  '<div class="card hvr-bounce-in">',
                      '<div class="lab-equitName">' + e.assetName + '</div>',
                      '<div class="lab-buttonGroup">',
                          '<button class="btn btn-info" class="lab-equitInfo-btn" data-toggle="modal" data-target="#lab-equitInfo-modal">简介</button>',
                          '<button class="btn btn-success" data-toggle="modal" data-target="#lab-equitOrder-modal" class="lab-order-btn">预约</button>',
                      '</div>',
                  '</div>'
              );
          });
          $('#all-room').append(domArr.join(''));
        },
        error: function(){
          console.log('equit_ajax', 'fail');
          alert('后台错误！');
      }
    });
}


/**
* 加载页面事件
*/

function basicEvent() {
    // 搜索
    $('search-btn').on('click', function(){
        var params = {
            item: $('#input-search-form').val(),
            type: $('.input-search input[name="searchType"]:checked').val();
        }

        $.ajax({
            type: 'POST',
            url: 'db_post_ajax',
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
                            '<tbody>',
                    );
                    $.each(retData.result, function(i, e){
                        domArr.push(
                            '<td>' + e.teacher + '</td>' + '<td>' + e.labName + '</td>' + '<td>' + e.roomId + '</td>',
                        );
                    });
                    domArr.push('</tboday></table>');
                    $('.db-table').append(domArr.join(''));
                }
            },
            error: function(){
                console.log('db_post_ajax fail');
                alert('后台错误！');
            }
        });
    });

    // 设备简介
    $('.lab-equitInfo-btn').on('click', function(){
        var assetName = $(this).parent('.card').attr('data-assetName');
        $.ajax({
            type: 'POST',
            url: 'equit_info',
            data: {assetName}
            dataType: 'json',
            success: function(retData){
                $('#lab-equitInfo-modal .modal-body').children().detach();
                var equitInfo = '<div class="lab-equitInfo-classNo">分类代码： ' + retData.classNo + '</div>' +
                                '<div class="lab-equitInfo-className">分类名称： ' + retData.className + '</div>' +
                                '<div class="lab-equitInfo-valueType">价值类型： ' + retData.classType + '</div>' +
                                '<div class="lab-equitInfo-valueType">数量： ' + retData.number + '</div>';
                $('#lab-equitInfo-modal .modal-body').append(equitInfo);
            },
            error: function(){
                console.log('equit_info fail');
                alert('后台错误！');
            }
        });
    });

    // 预约设备
    $('#post-equitOrder').on('click', function(){
        var params = {
            assetName: $('lab-equitOrder-modal-label').val(),
            number: $('input-equitNumber').val(),
            days: $('input-equitDays').val(),
            applicant: $('input-equitApplicant').val()
        };

        $.ajax({
            type: 'POST',
            url: 'lab_post_order',
            data: params,
            dataType: 'json',
            success: function(retData){
                if(retData === "0") {
                    alert('预约失败');
                }
                if(retData === "1") {
                    alert('预约成功');
                }
            },
            error: function(){
                console.log('lab_post_order fail');
                alert('后台错误！');
            }
        });
    });
}
