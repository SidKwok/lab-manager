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
    $($('.nav-location')[3]).attr('href', '../promanage/index.html?' + userInfo + '?');
    $($('.nav-location')[4]).attr('href', '../dailyjob/index.html?' + userInfo + '?');
    $($('.nav-location')[5]).attr('href', '../aboutus/index.html?' + userInfo + '?');

    if (role !== 'teacher'){
        $('#tea-checkDuty').children().detach();
        $('#tea-checkDuty').append('<h2>本区域只对教师开放</h2>');
        $('#tea-correctGrade').children().detach();
        $('#tea-correctGrade').append('<h2>本区域只对教师开放</h2>');
    } else {
        loadLabNotice();
        loadLabCard();
        basicEvent();
    }
}

/**
* 加载实习课程
*/
function loadLabNotice() {
    var params = {username: username, role: role};
    $.ajax({
        type: 'POST',
        url: '/experiment/teaAllCourse',
        data: params,
        dataType: 'json',
        success: function(data){
            var retData = eval('(' + data + ')');
            $('#tea-course').children().detach();
            var domArr = [];
            $.each(retData, function(i, e){
                domArr.push(
                    '<div class="course hvr-sweep-to-right">',
                        '<div class="tea-courseId">' + e.courseId + '</div>',
                        '<div class="tea-courseContent">' + e.labName + ' ' + e.labWeek + ' ' + e.labWeekday + ' ' + e.labCourse + '</div>',
                        '<button class="btn btn-success tea-course-check-btn" data-toggle="modal" data-target="#tea-checkDuty-modal">考勤</button>',
                    '</div>'
                );
            });
            $('#tea-course').append(domArr.join(''));

            // 加载实习课程事件
            labNoticeEvent();
        },
        error: function(){
            console.log('/experiment/teaAllCourse');
            alert('后台错误');

            // /***************************************
            // * 用于前端test 测试状态：
            // */
            // /*ajax返回的数据*/
            // var retData = [
            //   {
            //     "courseId": "0001",
            //     "labName": "机器人实验",
            //     "labWeek": "第一周",
            //     "labWeekday": "周一",
            //     "labCourse": "第1、2节"
            //   },
            //   {
            //     "courseId": "0002",
            //     "labName": "足球实验",
            //     "labWeek": "第二周",
            //     "labWeekday": "周二",
            //     "labCourse": "第3、4节"
            //   },
            //   {
            //     "courseId": "0003",
            //     "labName": "sex实验",
            //     "labWeek": "第三周",
            //     "labWeekday": "周三",
            //     "labCourse": "第5、6节"
            //   }
            // ];
            // /**************/
            // $('#tea-course').children().detach();
            // var domArr = [];
            // $.each(retData, function(i, e){
            //     domArr.push(
            //         '<div class="course hvr-sweep-to-right">',
            //             '<div class="tea-courseId">' + e.courseId + '</div>',
            //             '<div class="tea-courseContent">' + e.labName + ' ' + e.labWeek + ' ' + e.labWeekday + ' ' + e.labCourse + '</div>',
            //             '<button class="btn btn-success tea-course-check-btn" data-toggle="modal" data-target="#tea-checkDuty-modal">考勤</button>',
            //         '</div>'
            //     );
            // });
            // $('#tea-course').append(domArr.join(''));
            // /***************************************/

        }
    });
}

/**
* 实习课程事件
*/
function labNoticeEvent() {
  // 加载学生信息
  $('.tea-course-check-btn').on('click', function(){
      var courseId = $(this).parents('.course').children('.tea-courseId').text();
      $('#tea-checkDuty-modal-label').text($(this).parents('.course').children('.tea-courseContent').text());
      $('#tea-checkDuty-modal-label').attr('data-courseId', courseId);
      $.ajax({
          type: 'POST',
          url: '/experiment/courseStuInfo',
          data: {username: username, role: role, courseId: courseId},
          dataType: 'json',
          success: function(data){
              var retData = eval('(' + data + ')');
              $('#tea-checkDuty-table').children().detach();
              var domArr = [];
              $.each(retData, function(i, e){
                  domArr.push(
                      '<tr>',
                          '<td>' + e.stuId + '</td>',
                          '<td>' + e.stuName + '</td>',
                          '<td><input class="form-control"></input></td>',
                          '<td>',
                              '<select class="form-control">',
                              '<option></option>',
                              '<option>已到</option>',
                              '<option>未到</option>',
                          '</td>',
                      '</tr>'
                  );
              });
              $('#tea-checkDuty-table').append(domArr.join(''));
          },
          error: function(){
              console.log('/experiment/courseStuInfo fail');
              alert('后台错误!');
              // /***************************************
              // * 用于前端test 测试状态：
              // */
              // /*ajax返回的数据*/
              // var retData = [
              //   "sid","mingen","natalie","Airdy"
              // ];
              // /**************/
              // $('#tea-checkDuty-table').children().detach();
              // var domArr = [];
              // $.each(retData, function(i, e){
              //     domArr.push(
              //         '<tr>',
              //             '<td>' + e.stuId + '</td>',
              //             '<td>' + e.stuName + '</td>',
              //             '<td><input class="form-control"></input></td>',
              //             '<td>',
              //                 '<select class="form-control">',
              //                 '<option></option>',
              //                 '<option>已到</option>',
              //                 '<option>未到</option>',
              //             '</td>',
              //         '</tr>'
              //     );
              // });
              // $('#tea-checkDuty-table').append(domArr.join(''));
              // /***************************************/
          }
      });
  });

  // 考勤提交
  $('#post-checkDutyConfirm').on('click', function(){
      var params = {
        stu:[],
        courseId: $('#tea-checkDuty-modal-label').attr('data-courseId'),
        username: username,
        role: role
      };
      var trs = $('#tea-checkDuty-table').children();
      $.each(trs, function(i, e){
          params.stu.push({
              stuId: $(e).children('td').eq(1).text(),
              stuName: $(e).children('td').eq(2).text(),
              stuGrade: $(e).children('td').eq(3).children('input').val(),
              stuState: $(e).children('td').eq(4).children('select').children('option:selected').text()
          });
      });
      $.ajax({
          type: 'POST',
          url: '/equipment/uploacAttendence',
          data: params,
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData.status === "0") {
                alert('考勤失败');
            }
            if(retData.status === "1") {
                alert('考勤成功');
            }
          },
          error: function(){
              console.log('/equipment/uploacAttendence, fail');
              alert('后台错误');
          }
      });
  });
}

/**
* 加载实验
*/
function loadLabCard () {
    $.ajax({
        type: 'POST',
        url: '/teacher/teaAllLab',
        data: {username: username, role: role},
        dataType: 'json',
        success: function(data){
            var retData = eval('(' + data + ')');
            $('#tea-correctGrade .flex-box').children().detach();
            var domArr = [];
            $.each(retData, function(i, e){
                domArr.push(
                    '<div class="card hvr-bounce-in" data-labName="' + e.labName + '">',
                        '<div class="tea-labId">' + e.labId + '</div>',
                        '<div class="tea-correctGrade-labName">' + e.labName + '</div>',
                        '<button class="btn btn-success tea-correct-btn" data-toggle="modal" data-target="#tea-correctGrade-modal">给成绩</button>',
                    '</div>'
                );
            });
            $('#tea-correctGrade .flex-box').append(domArr.join(''));

            // 加载实验事件
            labCardEvent();
        },
        error: function(){
            console.log('/teacher/teaAllLab fail');
            alert('后台错误');

            // /***************************************
            // * 用于前端test 测试状态：
            // */
            // /*ajax返回的数据*/
            // var retData = [
            //   {
            //     "labName": "机器人实验",
            //     "labId": "0001"
            //   },
            //   {
            //     "labName": "足球实验",
            //     "labId": "0002"
            //   },
            //   {
            //     "labName": "sex实验",
            //     "labId": "0003"
            //   },
            //   {
            //     "labName": "禁忌实验",
            //     "labId": "0004"
            //   }
            // ];
            // /**************/
            // $('#tea-correctGrade .flex-box').children().detach();
            // var domArr = [];
            // $.each(retData, function(i, e){
            //     domArr.push(
            //         '<div class="card hvr-bounce-in" data-labName="' + e.labName + '">',
            //             '<div class="tea-labId">' + e.labId + '</div>',
            //             '<div class="tea-correctGrade-labName">' + e.labName + '</div>',
            //             '<button class="btn btn-success tea-correct-btn" data-toggle="modal" data-target="#tea-correctGrade-modal">给成绩</button>',
            //         '</div>'
            //     );
            // });
            // $('#tea-correctGrade .flex-box').append(domArr.join(''));
            // /***************************************/
        }
    });
}

/**
* 实验事件
*/
function labCardEvent() {
  // 加载学生信息
  $('.tea-correct-btn').on('click', function(){
      var labName = $(this).parents('.card').attr('data-labName');
      var labId = $(this).parents('.card').children('.tea-labId').text();
      var params = {
        labName: labName,
        labId: labId,
        username: username,
        role: role
      };
      $('#tea-correctGrade-modal-label').text(labName);
      $('#tea-correctGrade-modal-label').attr('data-labId', labId);
      $.ajax({
          type: 'POST',
          url: '/teacher/getExpStuInfo',
          data: params,
          dataType: 'json',
          success: function(data){
              var retData = eval('(' + data + ')');
              $('#tea-correctGrade-table').children().detach();
              var domArr = [];
              $.each(retData, function(i, e){
                  domArr.push(
                      '<tr><td>' + e.stuId + '</td><td>' + e.stuName + '</td><td><input class="form-control"></input></td></tr>'
                  );
              });
              $('#tea-correctGrade-table').append(domArr.join(''));
          },
          error: function(){
              console.log('/teacher/getExpStuInfo fail');
              alert('后台错误');
              // /***************************************
              // * 用于前端test 测试状态：
              // */
              // /*ajax返回的数据*/
              // var retData = [
              //   "sid","mingen","natalie","Airdy", "Bob"
              // ];
              // /**************/
              // $('#tea-correctGrade-modal-label').text(labName);
              // $('#tea-correctGrade-table').children().detach();
              // var domArr = [];
              // $.each(retData, function(i, e){
              //     domArr.push(
              //         '<tr><td>' + e + '</td><td><input class="form-control"></input></td></tr>'
              //     );
              // });
              // $('#tea-correctGrade-table').append(domArr.join(''));
              // /***************************************/
          }
      });
  });

  // 发送成绩
  $('#post-correctGradeConfirm').on('click', function(){
      var params = {
          stu: [],
          username: username,
          role: role,
          laId: $('#tea-correctGrade-modal-label').attr('data-labId')
      };
      var trs = $('#tea-correctGrade-table').children();
      $.each(trs, function(i, e){
          params.stu.push({
              stuName: $(e).children('td').eq(0).text(),
              stuGrade: $(e).children('td').eq(1).children('input').val()
          });
      });
      console.log(params);
      $.ajax({
          type: 'POST',
          url: '/teacher/uploadStuGrade',
          data: params,
          dataType: 'json',
          success: function(data){
            var retData = eval('(' + data + ')');
            if(retData.status === "0") {
                alert('给成绩失败');
            }
            if(retData.status === "1") {
                alert('给成绩成功');
            }
          },
          error: function(){
              console.log('/teacher/uploadStuGrade');
              alert('后台出错');
          }
      });
  });
}

/**
* 页面事件
*/
function basicEvent () {

}

init();
