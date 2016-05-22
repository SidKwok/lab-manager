<%--
  Created by IntelliJ IDEA.
  User: xiaofeige
  Date: 2016/5/22
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>综合管理</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/hover-min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/content.css">
</head>
<body>
<!--导航栏-->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Lab-manager</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/html/info/index.html">门户网站</a></li>
                <li class="active"><a href="#">综合管理</a></li>
                <li><a href="/html/labmanage/index.html">实验管理</a></li>
                <li><a href="/html/promanage/index.html">资产管理</a></li>
                <li><a href="/html/dailyjob/index.html">日常办公</a></li>
                <li><a href="#">关于我们</a></li>
            </ul>
        </div>
    </div>
</nav>

<!--左侧菜单栏-->
<div id="menuLeft">
    <ul>
        <li class="active"><a href="#all-room"><span>实验室管理</span></a></li>
        <li><a href="#all-team"><span>实验队伍管理</span></a></li>
    </ul>
</div>

<!--内容块-->
<div class="content">
    <div id="all-room">
        <div class="card hvr-bounce-in" data-roomId="0001">
            <div class="all-roomId">0001</div>
            <div class="all-teacher">
                sid
            </div>
            <div class="all-buttonGroup">
                <button class="btn btn-primary" data-toggle="modal" data-target="#all-comment-modal" class="all-comment-btn">评论</button>
                <button class="btn btn-info" data-toggle="popover" title="机器人实验室" data-placement="top" data-content="非常美" class="all-info-btn">简介</button>
                <button class="btn btn-success" data-toggle="modal" data-target="#all-order-modal" class="all-order-btn">预约</button>
            </div>
        </div>
        <div class="card hvr-bounce-in" data-roomId="0002">
            <div class="all-roomId">0002</div>
            <div class="all-teacher">
                mingen
            </div>
            <div class="all-buttonGroup">
                <button class="btn btn-primary" data-toggle="modal" data-target="#all-comment-modal" class="all-comment-btn">评论</button>
                <button class="btn btn-info" data-toggle="popover" title="东区实验室" data-placement="top" data-content="很差" class="all-info-btn">简介</button>
                <button class="btn btn-success" data-toggle="modal" data-target="#all-order-modal" class="all-order-btn">预约</button>
            </div>
        </div>
    </div>

    <div id="all-team" style="display: none;">
        这是实验队伍管理
    </div>
</div>

<!-- 评论框 -->
<div class="modal fade" id="all-comment-modal" tabindex="-1" role="dialog" aria-labelledby="all-comment-modal-label">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="all-comment-modal-label">东区实验室</h4>
            </div>
            <div class="modal-body">
                <div class="modal-showComment">
                    <p>Good</p>
                    <p>Not bad</p>
                </div>
            </div>
            <div class="modal-footer">
                <span>输入你的评论</span>
                <textarea class="form-control" rows="3"></textarea>
                <br>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="post-comment">发表</button>
            </div>
        </div>
    </div>
</div>

<!-- 预约框 -->
<div class="modal fade" id="all-order-modal" tabindex="-1" role="dialog" aria-labelledby="all-order-modal-label">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="all-order-modal-label">001</h4>
            </div>
            <div class="modal-header">
                实验室预约情况
                <div id="order-state" style="margin-top: 12px;">
                    <p>实验名称 申请人 第几周 周几 第几节课</p>
                    <p>实验名称 申请人 第几周 周几 第几节课</p>
                    <p>实验名称 申请人 第几周 周几 第几节课</p>
                </div>
            </div>
            <div class="modal-body">
                <input type="text" class="form-control" id="input-labName" placeholder="实验名称">
                <input type="text" class="form-control" id="input-applicant" placeholder="申请人">
                <select class="form-control" id="input-week">
                    <option>第一周</option>
                    <option>第二周</option>
                    <option>第三周</option>
                    <option>第四周</option>
                    <option>第五周</option>
                    <option>第六周</option>
                    <option>第七周</option>
                    <option>第八周</option>
                    <option>第九周</option>
                    <option>第十周</option>
                    <option>第十一周</option>
                    <option>第十二周</option>
                    <option>第十三周</option>
                    <option>第十四周</option>
                    <option>第十五周</option>
                    <option>第十六周</option>
                    <option>第十七周</option>
                    <option>第十八周</option>
                </select>
                <select class="form-control" id="input-weekday">
                    <option>周一</option>
                    <option>周二</option>
                    <option>周三</option>
                    <option>周四</option>
                    <option>周五</option>
                    <option>周六</option>
                    <option>周日</option>
                </select>
                <select class="form-control" id="input-course">
                    <option>1、2节</option>
                    <option>3、4节</option>
                    <option>5、6节</option>
                    <option>7、8节</option>
                    <option>9、10节</option>
                </select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="post-labOrder">预约</button>
            </div>
        </div>
    </div>
</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/style.js"></script>
<script>
    $('[data-toggle="popover"]').popover();
</script>
</body>
</html>
