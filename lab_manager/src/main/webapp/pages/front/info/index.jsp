<!DOCTYPE html>
<html>
    <head>
      <meta charset="utf-8">
      <title>门户网站</title>
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
                      <li class="active"><a href="#">门户网站</a></li>
                      <li><a href="../allmanage/index.html">综合管理</a></li>
                      <li><a href="../labmanage/index.html">实验管理</a></li>
                      <li><a href="../promanage/index.html">资产管理</a></li>
                      <li><a href="../dailyjob/index.html">日常办公</a></li>
                      <li><a href="#">关于我们</a></li>
                  </ul>
              </div>
            </div>
        </nav>

        <!--左侧菜单栏-->
        <div id="menuLeft">
            <ul>
                <li class="active"><a href="#info-page"><span>首页</span></a></li>
                <li><a href="#info-info"><span>中心概况</span></a></li>
                <li><a href="#info-teach"><span>教学实践</span></a></li>
                <li><a href="#info-manage"><span>管理体制</span></a></li>
                <li><a href="#info-equit"><span>设备和环境</span></a></li>
                <li><a href="#info-res"><span>网上资源</span></a></li>
            </ul>
        </div>

        <!--内容块-->
        <div class="content">
            <div id="info-page">
                这是首页
            </div>

            <div id="info-info" style="display: none;">
                这是中心概况
            </div>

            <div id="info-teach" style="display: none;">
                这是教学实践
            </div>

            <div id="info-manage" style="display: none;">
                这是管理体制
            </div>

            <div id="info-equit" style="display: none;">
                这是设备和环境
            </div>

            <div id="info-res" style="display: none;">
                这是网上资源
            </div>
        </div>

        <script src="../static/js/jquery.min.js"></script>
        <script src="../static/js/bootstrap.min.js"></script>
        <script src="../static/js/style.js"></script>
    </body>
</html>
