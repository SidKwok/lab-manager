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
                    $('.db-table').val(domArr.join(''));
                }
            },
            error: function(){
                console.log('db_post_ajax fail');
            }
        });
    });
}
