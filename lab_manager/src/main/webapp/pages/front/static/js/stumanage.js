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
    $($('.nav-location')[2]).attr('href', '../teamanage/index.html?' + userInfo + '?');
    $($('.nav-location')[3]).attr('href', '../promanage/index.html?' + userInfo + '?');
    $($('.nav-location')[4]).attr('href', '../dailyjob/index.html?' + userInfo + '?');
    $($('.nav-location')[5]).attr('href', '../aboutus/index.html?' + userInfo + '?');

    if (role !== 'student'){
        $('#stu-duty').children().detach();
        $('#stu-duty').append('<h2>本区域只对学生开放</h2>');
        $('#stu-grade').children().detach();
        $('#stu-grade').append('<h2>本区域只对学生开放</h2>');
    } else {
        loadDutyState();
        loadGrade();
    }
}

/**
* 加载出勤状态
*/
function loadDutyState () {
    var params = {username: username, role:role};
    $.ajax({
        type: 'POST',
        url: '/student/getAttendence',
        data: params,
        dataType: 'json',
        success: function(data){
            var retData = eval('(' + data + ')');
            $('#stu-dutyState').children().detach();
            var domArr = [];
            $.each(retData, function(i, e){
                domArr.push(
                    '<div class="dutyState hvr-sweep-to-right">',
                        '<div class="dutyStateContent">' + e.stuDutyLab + ' ' + e.stuDutyPos + ' ' + e.stuDutyWeek + ' ' + e.stuDutyWeekday + ' ' + e.stuDutyCourse+ '</div>',
                        '<div class="dutyStateStatus">状态：' + e.status + '</div>',
                    '</div>'
                );
            });
            $('#stu-dutyState').append(domArr.join(''));
        },
        error: function(){
            console.log('/student/getAttendence fail');
            alert('后台错误');
        }
    });
}

/**
* 加载成绩
*/
function loadGrade () {
    var params = {username: username, role: role};
    $.ajax({
        type: 'POST',
        url: '/student/getGrade',
        data: params,
        dataType: 'json',
        success: function(data){
            var retData = eval('(' + data + ')');
            $('#stu-checkGrade').children().detach();
            var domArr = [];
            $.each(retData, function(i, e){
                domArr.push(
                    '<div class="checkGrade hvr-sweep-to-right">',
                        '<div class="checkGradeLab">' + e.stuGradeLab + '</div>',
                        '<div class="checkGradeContent">' + e.stuGrade + '</div>',
                    '</div>'
                );
            });
            $('#stu-checkGrade').append(domArr.join(''));
        },
        error: function(){
            console.log('/student/getGrade fail');
            alert('后台错误');
        }
    });
}

/**
* 加载页面事件
*/
function basicEvent(){

}

init();
