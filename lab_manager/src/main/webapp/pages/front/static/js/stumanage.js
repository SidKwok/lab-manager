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
    $($('.nav-location')[2]).attr('href', '../teamanage/index.html?' + userInfo + '?');
    $($('.nav-location')[3]).attr('href', '../promanage/index.html?' + userInfo + '?');
    $($('.nav-location')[4]).attr('href', '../dailyjob/index.html?' + userInfo + '?');
    $($('.nav-location')[5]).attr('href', '../aboutus/index.html?' + userInfo + '?');

    loadDutyState();
    loadGrade();
}

/**
* 加载出勤状态
*/
function loadDutyState () {
    var params = {username: username, role:role};
    $.ajax({
        type: 'POST',
        url: '_stu_dutyState',
        data: params,
        dataType: 'json',
        success: function(retData){
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
            console.log('stu_dutyState fail');
            alert('后台错误');

            // /***************************************
            // * 用于前端test 测试状态：
            // */
            // /*ajax返回的数据*/
            // var retData = [
            //   {
            //     "stuDutyLab": "机器人实验",
            //     "stuDutyPos": "信工805",
            //     "stuDutyWeek": "第一周",
            //     "stuDutyWeekday": "周一",
            //     "stuDutyCourse": "第1、2节",
            //     "status": "未到"
            //   },
            //   {
            //     "stuDutyLab": "足球实验",
            //     "stuDutyPos": "信工806",
            //     "stuDutyWeek": "第二周",
            //     "stuDutyWeekday": "周二",
            //     "stuDutyCourse": "第3、4节",
            //     "status": "已到"
            //   }
            // ];
            // /**************/
            // $('#stu-dutyState').children().detach();
            // var domArr = [];
            // $.each(retData, function(i, e){
            //     domArr.push(
            //         '<div class="dutyState hvr-sweep-to-right">',
            //             '<div class="dutyStateContent">' + e.stuDutyLab + ' ' + e.stuDutyPos + ' ' + e.stuDutyWeek + ' ' + e.stuDutyWeekday + ' ' + e.stuDutyCourse+ '</div>',
            //             '<div class="dutyStateStatus">状态：' + e.status + '</div>',
            //         '</div>'
            //     );
            // });
            // $('#stu-dutyState').append(domArr.join(''));
            //
            // /***************************************/
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
        url: '_stu_grade',
        data: params,
        dataType: 'json',
        success: function(retData){
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
            console.log('stu_grade fail');
            alert('后台错误');

            // /***************************************
            // * 用于前端test 测试状态：
            // */
            // /*ajax返回的数据*/
            // var retData = [
            //   {
            //     "stuGradeLab": "足球实验",
            //     "stuGrade": "成绩未出"
            //   },
            //   {
            //     "stuGradeLab": "机器人实验",
            //     "stuGrade": "93"
            //   }
            // ];
            // /**************/
            // $('#stu-checkGrade').children().detach();
            // var domArr = [];
            // $.each(retData, function(i, e){
            //     domArr.push(
            //         '<div class="checkGrade hvr-sweep-to-right">',
            //             '<div class="checkGradeLab">' + e.stuGradeLab + '</div>',
            //             '<div class="checkGradeContent">' + e.stuGrade + '</div>',
            //         '</div>'
            //     );
            // });
            // $('#stu-checkGrade').append(domArr.join(''));
            // /***************************************/
        }
    });
}

/**
* 加载页面事件
*/
function basicEvent(){

}

init();
