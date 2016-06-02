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
                  '<div class="card hvr-bounce-in" data-assetName="' + e.assetName + '" data-assetId="' + e.assetId + '">',
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
          setTimeout(function(){
              equipCardEvent();
          }, 500);
        },
        error: function(){
          console.log('/equipment/queryAllEquipment', 'fail');
          alert('后台错误！');
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
      $('#pro-equipDelete-modal-label').attr('data-assetId', $(this).parents('.card').attr('data-assetId'));
  });

  $('#pro-equipDelete').on('click', function(){
      var assetName = $('#pro-equipDelete-modal-label').text();
      var assetId = $('#pro-equipDelete-modal-label').attr('data-assetId');
      $.ajax({
          type: 'POST',
          url: '/equipment/delEquipment',
          data: {assetName: assetName, assetId: assetId},
          dataType: 'json',
          success: function(data){
              var retData = eval('(' + data + ')');
              if(retData.status === '0') {
                  alert('删除失败');
              }
              if(retData.status === '1') {
                  alert('删除成功');
                  setTimeout(function(){
                      loadEquipCard();
                  }, 500);
              }
              $('#pro-equipDelete-modal').modal('hide');
          },
          error: function(){
              alert('后台错误');
              console.log('/equipment/delEquipment fail');
          }
      });
  });

  // 修改仪器
  $('.pro-equipUpdate-btn').on('click', function(){
      var assetName = $(this).parents('.card').attr('data-assetName');
      var assetId = $(this).parents('.card').attr('data-assetId');
      $('#pro-equipUpdate-modal-label').text(assetName);
      $('#pro-equipUpdate-modal-label').attr('data-assetId', assetId);
      $.ajax({
          type: 'POST',
          url: '/equipment/queryEquipmentInfo',
          data: {assetName: assetName, assetId: assetId},
          dataType: 'json',
          success: function(data){
              var retData = eval('(' + data + ')');
              $('#pro-input-originName').attr('placeholder', retData.originName);
              $('#pro-input-valueType').attr('placeholder', retData.valueType);
              $('#pro-input-unitPrice').attr('placeholder', retData.unitPrice);
              $('#pro-input-invoiceNum').attr('placeholder', retData.invoiceNum);
              $('#pro-input-measurementUnit').attr('placeholder', retData.measurementUnit);
              $('#pro-input-purchaseDate').attr('placeholder', retData.purchaseDate);
              $('#pro-input-handlePerson').attr('placeholder', retData.handlePerson);
              $('#pro-input-chargeType').attr('placeholder', retData.chargeType);
              $('#pro-input-checkDate').attr('placeholder', retData.checkDate);
              $('#pro-input-receptDate').attr('placeholder', retData.receptDate);
              $('#pro-input-remark').attr('placeholder', retData.remark);
              $('#pro-input-finantialOpinion').attr('placeholder', retData.finantialOpinion);
              $('#pro-input-purchasingAgent').attr('placeholder', retData.purchasingAgent);
              $('#pro-input-modal').attr('placeholder', retData.modal);
              $('#pro-input-standard').attr('placeholder', retData.standard);
              $('#pro-input-productionDate').attr('placeholder', retData.productionDate);
              $('#pro-input-country').attr('placeholder', retData.country);
              $('#pro-input-manufacture').attr('placeholder', retData.manufacture);
              $('#pro-input-brand').attr('placeholder', retData.brand);
              $('#pro-input-power').attr('placeholder', retData.power);
              $('#pro-input-estimatedExpirationDate').attr('placeholder', retData.estimatedExpirationDate);
              $('#pro-input-durableYears').attr('placeholder', retData.durableYears);
              $('#pro-input-retailer').attr('placeholder', retData.retailer);
              $('#pro-input-number').attr('placeholder', retData.number);
          },
          error: function(){
              console.log('/equipment/queryEquipmentInfo fail');
              alert('后台错误！');
          }
      });
  });

  $('#post-equipUpdate').on('click', function(){
      var params = {
          assetName: $('#pro-equipUpdate-modal-label').text(),
          assetId: $('#pro-equipUpdate-modal-label').attr('data-assetId'),
          classNo: $('#pro-input-classNo option:selected').text(),
          className: $('#pro-input-className option:selected').text(),
          originName: $('#pro-input-originName').val(),
          purchaseUnit: $('#pro-input-purchaseUnit option:selected').text(),
          valueType: $('#pro-input-valueType').val(),
          unitPrice: $('#pro-input-unitPrice').val(),
          invoiceNum: $('#pro-input-invoiceNum').val(),
          measurementUnit: $('#pro-input-measurementUnit').val(),
          purchaseDate: $('#pro-input-purchaseDate').val(),
          financialRes: $('#pro-input-financialRes option:selected').text(),
          assetRes: $('#pro-input-assetRes option:selected').text(),
          handlePerson: $('#pro-input-handlePerson').val(),
          chargeType: $('#pro-input-chargeType').val(),
          checkDate: $('#pro-input-checkDate').val(),
          receptDate: $('#pro-input-receptDate').val(),
          purchaseForm: $('#pro-input-purchaseForm option:selected').text(),
          managePart: $('#pro-input-managePart option:selected').text(),
          subjectType: $('#pro-input-subjectType option:selected').text(),
          subject: $('#pro-input-subject option:selected').text(),
          remark: $('#pro-input-remark').val(),
          finantialOpinion: $('#pro-input-finantialOpinion').val(),
          purchasingAgent: $('#pro-input-purchasingAgent').val(),
          modal: $('#pro-input-modal').val(),
          standard: $('#pro-input-standard').val(),
          productionDate: $('#pro-input-productionDate').val(),
          country: $('#pro-input-country').val(),
          manufacture: $('#pro-input-manufacture').val(),
          brand: $('#pro-input-brand').val(),
          power: $('#pro-input-power').val(),
          estimatedExpirationDate: $('#pro-input-estimatedExpirationDate').val(),
          durableYears: $('#pro-input-durableYears').val(),
          retailer: $('#pro-input-retailer').val(),
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
                setTimeout(function(){
                    loadEquipCard();
                }, 500);
            }
            $('#pro-equipUpdate-modal').modal('hide');
          },
          error: function(){
              alert('后台错误');
              console.log('/equipment/updateEquipment fail');
          }
      });
  });

  // 添加仪器
  $('#post-equipAdd').on('click', function(){
      var params = {
          assetName: $('#pro-input-add-assetName').val(),
          classNo: $('#pro-input-add-classNo option:selected').text(),
          className: $('#pro-input-add-className option:selected').text(),
          originName: $('#pro-input-add-originName').val(),
          purchaseUnit: $('#pro-input-add-purchaseUnit option:selected').text(),
          valueType: $('#pro-input-add-valueType').val(),
          unitPrice: $('#pro-input-add-unitPrice').val(),
          invoiceNum: $('#pro-input-add-invoiceNum').val(),
          measurementUnit: $('#pro-input-add-measurementUnit').val(),
          purchaseDate: $('#pro-input-add-purchaseDate').val(),
          financialRes: $('#pro-input-add-financialRes option:selected').text(),
          assetRes: $('#pro-input-add-assetRes option:selected').text(),
          handlePerson: $('#pro-input-add-handlePerson').val(),
          chargeType: $('#pro-input-add-chargeType').val(),
          checkDate: $('#pro-input-add-checkDate').val(),
          receptDate: $('#pro-input-add-receptDate').val(),
          purchaseForm: $('#pro-input-add-purchaseForm option:selected').text(),
          managePart: $('#pro-input-add-managePart option:selected').text(),
          subjectType: $('#pro-input-add-subjectType option:selected').text(),
          subject: $('#pro-input-add-subject option:selected').text(),
          remark: $('#pro-input-add-remark').val(),
          finantialOpinion: $('#pro-input-add-finantialOpinion').val(),
          purchasingAgent: $('#pro-input-add-purchasingAgent').val(),
          modal: $('#pro-input-add-modal').val(),
          standard: $('#pro-input-add-standard').val(),
          productionDate: $('#pro-input-add-productionDate').val(),
          country: $('#pro-input-add-country').val(),
          manufacture: $('#pro-input-add-manufacture').val(),
          brand: $('#pro-input-add-brand').val(),
          power: $('#pro-input-add-power').val(),
          estimatedExpirationDate: $('#pro-input-add-estimatedExpirationDate').val(),
          durableYears: $('#pro-input-add-durableYears').val(),
          retailer: $('#pro-input-add-retailer').val(),
          number: $('#pro-input-add-number').val()
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
                setTimeout(function(){
                    loadEquipCard();
                }, 500);
            }
            $('#pro-equipAdd-modal').modal('hide');
          },
          error: function(){
              alert('后台错误');
              console.log('/equipment/addEquipment fail');
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
                  '<div class="card hvr-bounce-in" data-labRoomName="' + e.labRoomName + '" data-labRoomId="' + e.labRoomId + '">',
                      '<div class="pro-labRoomName">' + e.labRoomId + ' ' + e.labRoomName + '</div>',
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
      $('#pro-labRoomDelete-modal-label').attr('data-labRoomId', $(this).parents('.card').attr('data-labRoomId'));
  });

  $('#pro-labRoomDelete').on('click', function(){
      var labRoomName = $('#pro-labRoomDelete-modal-label').text();
      var labRoomId = $('#pro-labRoomDelete-modal-label').attr('data-labRoomId');
      $.ajax({
          type: 'POST',
          url: '/lab/delLabRoom',
          data: {labRoomName: labRoomName, labRoomId: labRoomId},
          dataType: 'json',
          success: function(data){
              var retData = eval('(' + data + ')');
              if(retData.status === '0') {
                  alert('删除失败');
              }
              if(retData.status === '1') {
                  alert('删除成功');
                  setTimeout(function(){
                      loadLabRoomCard();
                  }, 500);
              }
              $('#pro-labRoomDelete-modal').modal('hide');
          },
          error: function(){
              alert('后台错误');
              console.log('/lab/delLabRoom fail');
          }
      });
  });

  // 修改实验室
  $('.pro-labRoomUpdate-btn').on('click', function(){
      var labRoomName = $(this).parents('.card').attr('data-labRoomName');
      var labRoomId = $(this).parents('.card').attr('data-labRoomId');
      $('#pro-labRoomUpdate-modal-label').text(labRoomName);
      $('#pro-labRoomUpdate-modal-label').attr('data-labRoomId', labRoomId);
      $.ajax({
          type: 'POST',
          url: '/lab/roomConcreateInfo',
          data: {labRoomName: labRoomName, labRoomId: labRoomId},
          dataType: 'json',
          success: function(data){
              var retData = eval('(' + data + ')');
              $('#pro-labRoomUpdate-modal .pro-labRoomInfo').children().detach();
              var labRoomInfo = '<div class="pro-labRoomInfo-labRoomNo">实验室名称： ' + retData.labRoomNo + '</div>' +
                                '<div class="pro-labRoomInfo-labRoomName">实验室名称： ' + retData.labRoomName + '</div>' +
                                '<div class="pro-labRoomInfo-labRoomType">实验室类型： ' + retData.labRoomType + '</div>' +
                                '<div class="pro-labRoomInfo-labRoomIntro">简介： ' + retData.labRoomIntro + '</div>';
              $('#pro-labRoomUpdate-modal .pro-labRoomInfo').append(labRoomInfo);
          },
          error: function(){
              console.log('/lab/roomConcreateInfo fail');
              alert('后台错误！');
          }
      });
  });

  $('#post-labRoomUpdate').on('click', function(){
      var params = {
          labRoomId: $('#pro-labRoomUpdate-modal-label').attr('data-labRoomId'),
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
                setTimeout(function(){
                    loadLabRoomCard();
                }, 500);
            }
            $('#pro-labRoomUpdate-modal').modal('hide');
          },
          error: function(){
              alert('后台错误');
              console.log('/lab/updateRoomInfo fail');
          }
      });
  });

  // 添加实验室
  $('#post-labRoomAdd').on('click', function(){
      var params = {
          labRoomNo: $('#pro-input-add-labRoomNo').val(),
          labRoomName: $('#pro-input-add-labRoomName').val(),
          labRoomType: $('#pro-input-add-labRoomType').val(),
          labRoomIntro: $('#pro-input-add-labRoomIntro').val(),
      };

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
                setTimeout(function(){
                    loadLabRoomCard();
                }, 500);
            }
            $('#pro-labRoomAdd-modal').modal('hide');
          },
          error: function(){
              alert('后台错误');
              console.log('/lab/addLabRoom fail');
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
                        '<div class="labOrderContent">' + e.labOrderName + ' ' + e.labOrderStartWeek + '-' + e.labOrderendtWeek + ' ' + e.labOrderStartWeekday + '-' + e.labOrderEndWeekday + ' ' + e.labOrderCourse + '</div>',
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
                setTimeout(function(){
                    loadLabOrder();
                }, 500);
            }
          },
          error: function(){
            alert('后台出错');
            console.log('/lab/confirmLabOrder fail');
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
                setTimeout(function(){
                    loadLabOrder();
                }, 500);
            }
          },
          error: function(){
            alert('后台出错');
            console.log('/lab/refuseLabOrder fail');
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
      url: '/equipment/equipOrderStatus',
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
                    '<div class="equipOrderContent">' + e.equipOrderName + ' ' + e.equipOrderNumber + '件 ' + e.equipOrderStartTime + '~' + e.equipOrderEndTime + '</div>',
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
          console.log('/equipment/equipOrderStatus fail');
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
          url: '/equipment/confirmEquipOrder',
          data: {equipOrderId: $(this).parents('.equip-order').children('.equipOrderId').text()},
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData.status === '0') {
                alert('批准设备预约失败');
            }
            if(retData.status === '1') {
                alert('批准设备预约成功');
                setTimeout(function(){
                    loadEquipOrder();
                }, 500);
            }
          },
          error: function(){
            alert('后台出错');
            console.log('/equipment/confirmEquipOrder fail');
          }
      });
  });

  // 拒绝设备预约
  $('.equipOrder-refuse-btn').on('click', function(){
      $.ajax({
          type: 'POST',
          url: '/equipment/refuseEquipOrder',
          data: {equipOrderId: $(this).parents('.equip-order').children('.equipOrderId').text()},
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData === '0') {
                alert('拒绝设备预约失败');
            }
            if(retData === '1') {
                alert('拒绝设备预约成功');
                setTimeout(function(){
                    loadEquipOrder();
                }, 500);
            }
          },
          error: function(){
            alert('后台出错');
            console.log('/equipment/refuseEquipOrder fail');
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
