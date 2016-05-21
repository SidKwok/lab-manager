<!DOCTYPE html>
<html>
    <head>
      <meta charset="utf-8">
      <title>资产管理</title>
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
                      <li class="active"><a href="#">资产管理</a></li>
                      <li><a href="../dailyjob/index.html">日常办公</a></li>
                      <li><a href="#">关于我们</a></li>
                  </ul>
              </div>
            </div>
        </nav>

        <!--左侧菜单栏-->
        <div id="menuLeft">
            <ul>
                <li class="active"><a href="#pro-eq"><span>设备仪器管理</span></a></li>
                <li><a href="#pro-consume"><span>物资耗材管理</span></a></li>
            </ul>
        </div>

        <!--内容块-->
        <div class="content">
            <div id="pro-eq">
                设备仪器管理
            </div>

            <div id="pro-consume" style="display: none;">
                物资耗材管理
            </div>
        </div>

        <script src="../static/js/jquery.min.js"></script>
        <script src="../static/js/bootstrap.min.js"></script>
        <script src="../static/js/style.js"></script>
    </body>
</html>
