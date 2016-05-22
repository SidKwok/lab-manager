/**
* 页面初始化事件
*/
function init () {
    loadEquitCard();
}

function loadEquitCard () {
    /**
    * 初始化设备卡片
    */
    $.ajax({
        type: "GET",
        url: 'equit_ajax',
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
                      '<div class="lab-equitName">' + e.assetName + '</div>',
                      '<div class="lab-buttonGroup">',
                          '<button class="btn btn-danger" class="pro-equitDelete-btn" data-toggle="modal" data-target="#pro-equitDelete-modal">删除</button>',
                          '<button class="btn btn-success" class="pro-equitUpdate-btn" data-toggle="modal" data-target="#pro-equitUpdate-modal">修改</button>',
                      '</div>',
                  '</div>'
              );
          });
          $('#pro-equit').append(domArr.join(''));
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
function basicEvent(){
    // 删除仪器
    $('#pro-equitDelete-btn').on('click', function(){
        $('#pro-equitDelete-modal-label').val($(this).parent('.card').attr('data-assetName'));
    });

    $('#pro-equitDelete').on('click', function(){
        var assetName = $('#pro-equitDelete-modal-label').val();
        $.ajax({
            type: 'POST',
            url: 'del_equit',
            data: {assetName},
            dataType: 'json',
            success: function(retData){
                if(retData === '0') {
                    alert('删除失败');
                }
                if(retData === '1') {
                    alert('删除成功');
                }
            },
            error: function(){
                alert('后台错误');
                console.log('del_equit fail');
            }
        });
    });

    // 修改仪器
    $('#pro-equitUpdate-btn').on('click', function(){
        var assetName = $(this).parent('.card').attr('data-assetName')
        $('#pro-equitUpdate-modal-label').val(assetName);
        $.ajax({
            type: 'POST',
            url: 'equit_info',
            data: {assetName}
            dataType: 'json',
            success: function(retData){
                $('#pro-equitUpdate-modal .pro-equitInfo').children().detach();
                var equitInfo = '<div class="pro-equitInfo-classNo">分类代码： ' + retData.classNo + '</div>' +
                                '<div class="pro-equitInfo-className">分类名称： ' + retData.className + '</div>' +
                                '<div class="pro-equitInfo-valueType">价值类型： ' + retData.classType + '</div>' +
                                '<div class="pro-equitInfo-valueType">数量： ' + retData.number + '</div>';
                $('#pro-equitUpdate-modal .pro-equitInfo').append(equitInfo);
            },
            error: function(){
                console.log('equit_info fail');
                alert('后台错误！');
            }
        });
    });

    $('#post-equitUpdate').on('click', function(){
        var params = {
            assetName: $('#pro-equitUpdate-modal-label').val(),
            classNo: $('#pro-input-classNo').val(),
            className: $('#pro-input-className').val(),
            valueType: $('#pro-input-valueType').val(),
            number: $('#pro-input-number').val()
        };

        $.ajax({
            type: 'POST',
            url: 'update_equit'
            data: params,
            dataType: 'json',
            success: function(retData){
              if(retData === '0') {
                  alert('修改失败');
              }
              if(retData === '1') {
                  alert('修改成功');
              }
            },
            error: function(){
                alert('后台错误');
                console.log('update_equit fail');
            }
        });
    });

    // 添加仪器
    $('post-equitAdd').on('click', function(){
        var params = {
            assetName: $('#pro-input-add-assetName').val(),
            classNo: $('#pro-input-add-classNo').val(),
            className: $('#pro-input-add-className').val(),
            valueType: $('#pro-input-add-valueType').val(),
            number: $('#pro-input-add-number').val(),
        };

        $.ajax({
            type: 'POST',
            url: 'add_equit',
            data: params,
            dataType: 'json',
            success: function(retData){
              if(retData === '0') {
                  alert('添加失败');
              }
              if(retData === '1') {
                  alert('添加成功');
              }
            },
            error: function(){
                alert('后台错误');
                console.log('add_equit fail');
            }
        });
    });
}
