<!DOCTYPE html>
<html>
    <head>
      <meta charset="utf-8">
      <title>日常办公</title>
      <link rel="stylesheet" href="../static/css/bootstrap.min.css">
      <link rel="stylesheet" href="../static/css/style.css">
      <link rel="stylesheet" href="../static/css/content.css">
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
                      <li><a href="../info/index.html">门户网站</a></li>
                      <li><a href="../allmanage/index.html">综合管理</a></li>
                      <li><a href="../labmanage/index.html">实验管理</a></li>
                      <li><a href="../promanage/index.html">资产管理</a></li>
                      <li class="active"><a href="#">日常办公</a></li>
                      <li><a href="#">关于我们</a></li>
                  </ul>
              </div>
            </div>
        </nav>

        <!--左侧菜单栏-->
        <div id="menuLeft">
            <ul>
                <li class="active"><a href="#daily-post"><span>公告管理</span></a></li>
                <li><a href="#daily-qa"><span>在线答疑</span></a></li>
            </ul>
        </div>

        <!--内容块-->
        <div class="content">
            <div id="daily-post">
                这是公告管理
            </div>

            <div id="daily-qa" style="display: none;">
                这是在线答疑
            </div>
        </div>

        <script src="../static/js/jquery.min.js"></script>
        <script src="../static/js/bootstrap.min.js"></script>
        <script src="../static/js/style.js"></script>
    </body>
</html>
