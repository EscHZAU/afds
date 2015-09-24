<%@page language="java" import="java.util.*"  pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">

	<title>新疆跨境河流水生生态及鱼类资源数据库系统</title>
      	<link href="css/global.css" rel="stylesheet" type="text/css" >
      	<link href="css/nav.css" rel="stylesheet" type="text/css" >
	  	<link href="css/font.css" rel="stylesheet" type="text/css" >
	  	<link href="css/lostyle.css" rel="stylesheet" type="text/css">

	<script type="text/javascript" src="js/openLayers/OpenLayers.js"></script>
	<script type="text/javascript" src="js/indexGeoDisplay.js"></script>

	<script type="text/javascript">
	    function createMask(){
	    //get the page-height and page-width
		var sHeight = document.documentElement.scrollHeight;
		var sWidth = document.documentElement.scrollWidth;
		
		//Show Login dialog
		if(document.getElementById("login").style.display == "none")
			document.getElementById("login").style.display = "";
		
		//Create a mask
		var oMask = document.createElement("div");
		oMask.id = "mask";
		oMask.style.height=sHeight+"px";
		oMask.style.width=sWidth+"px";
		document.body.appendChild(oMask);
		
		oMask.onclick = function(){
			document.body.removeChild(oMask);
			document.getElementById("login").style.display = "none";
			
		}
}
	    
	</script>

  <!--[if IE 6]>
  <link href="./style/ie6.css" type="text/css" rel="stylesheet" />
  <script src="./js/DD_belatedPNG_0.0.8a-min.js"></script>
  <script>
          DD_belatedPNG.fix('img, .sprite, .contact_field, .contact_question, a.ui-dialog-titlebar-close, #bgeffect, #header ,#logo ');
        </script>
  <![endif]-->

  <!--[if IE 7]>
  <link rel="stylesheet" href="./style/ie7.css" />
  <script src="../js/html5.js"></script>
  <![endif]-->
</head>
<body onload="init();">

  <div id="bgeffect">    
  	<div id="layout">
    <!-- 头部开始-->
    	<div id="header">
  		<div id="logo" onclick="location.href=&#39;./&#39;"></div>
  		<div id="loginStatus">
    		<a onclick="createMask();">登陆</a> | <a href="#">注册</a> | <a href="#">帮助</a> |
  		</div>
        <div id="search">
            <form id="cse-search-box" action="http://www.google.com/cse">
              <input type="hidden" name="cx" value="008612931508023110545:jzxwx8vnj6e"/>
              <input type="hidden" name="ie" value="UTF-8"/>
              <input type="text" id="s" name="q" class="swap_value"/>
              <input type="image" src="images/btn_search_box.png" width="27" height="24" id="go" alt="Search" title="Search"/>
            </form>
          </div>
      </div>
    <!--头部结束-->
    
    <!-- Login -->
    <div class="login" id="login" style="display: none;">
      <h1>登陆 </h1>
      <form method="post" action="index.html">
        <p>
        	<input type="text" name="login" placeholder="Username or Email">
        </p>
        <p>
        	<input type="password" name="password" placeholder="Password">
        </p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
			自动登陆
          </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="Login"></p>
        <p class="submit"><input type="submit" name="signUp" value="sign up"></p>
      </form>
      <div class="login-help">
      <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
    </div>
    </div>
    
    <!-- End login -->
    

    <!--导航目录开始-->
   		<ul id="nav">
      <li class="nosub">
        <a href="#" class="drop">主&nbsp;&nbsp;页</a>
      </li>
      <li>
      <a href="classifyBioQuery/index" class="drop">调查生物名录检索</a>
        <div class="dropdown_1column">
          <div class="col_1">
          <ul class="simple">
            <li><a href="#">1</a></li>
          </ul>
        </div>
      </div>
      </li>
    <li>
      <a href="queryMonitData/index" class="drop">监测数据查询</a>
        <div class="dropdown_2columns">
          <div class="col_2">
          <ul class="simple">
            <li><a href="#">1</a></li>
          </ul>
        </div>
      </div>
    </li>
    
    <li>
      <a href="Html/水生生态及鱼类资源名录检索.html" class="drop">监测数据的上传与下载</a>
      <div class="dropdown_1column">
        <div class="col_1">
          <ul class="simple">
            <li><a href="#">1</a></li>
          </ul>
        </div>
      </div>
      
    </li>
    
    <li>
      <a href="statisticsChart/index" class="drop">数据统计分析</a>
        <div class="dropdown_1column">
          <div class="col_1">
          <ul class="simple">
            <li><a href="#">1</a></li>
          </ul>
        </div>
      </div>
      
    </li>
    
    <li>
      <a href="#" class="drop">空间分析与制图</a>
        <div class="dropdown_1column">
          <div class="col_1">
          <ul class="simple">
            <li><a href="#">1</a></li>
          </ul>
        </div>
      </div>
      
    </li>
    
    </ul>
    <!-- Login -->
    
    <!-- Log-end -->
    
    <!--导航目录结束-->
    <!--主体开始-->
      <div id="maintop"></div>
      <div id="ma_tc"></div>
      <div id="mainarea">
        <div id="slide_left_Index">
        	<div class="block noBg">
        		<h2 class="titleBar">分类导航</h2>
        		<ul class = "hpcatnav">
        			<!-- <li>普通游客</li> -->
        			<li>数据库管理员</li>
        			<li>数据管理人员</li>
        			<li>数据录入人员</li>
        			<li>数据使用人员</li>
        		</ul>
        	</div>
      		
      		<div class="block">
      			<h2 class="titleBar">系统公告</h2>
      			<marquee behavior="scroll" direction="up" height="200px;" scrollamount="2"  scrolldelay="12" 
      			onmouseover=this.stop() onmouseout=this.start()>
      				&nbsp;&nbsp;&nbsp;&nbsp;2012年度：确认数据库的建设内容，并制定数据规范，设计系统的基础架构方案。
      				<br><br>&nbsp;&nbsp;&nbsp;&nbsp;2013年度：设计和开发数据一致性和完整性检验的存储过程，完成数据库管理系统和共享平台的需求分析、概要设计。
      				<br><br>&nbsp;&nbsp;&nbsp;&nbsp;2014年度：实现了结构调整和查询优化、基础地理数据的整饰、监测数据的录入规范设计、详细功能设计以及部分业务功能。
      			</marquee>
      		</div>
      		
      		<div class="block">
      			<h2 class="titleBar">常用链接</h2>
      			<ul class="hpcatnav">
              		<li><a href="http://www.most.gov.cn/">中华人民共和国科学技术部</a></li>
              		<li><a href="http://www.ihb.ac.cn/">中国科学院水生生物研究所</a></li>
              		<li><a href="http://www.hzau.edu.cn/">华中农业大学</a></li>
              		<li><a href="http://cf.hzau.edu.cn/">华中农业大学水产学院</a></li> 
              		<li><a href="http://www.xjfishery.cn/">新疆渔业科技服务网</a>
              		<li><a href="http://www.yfi.ac.cn/">长江水产研究所</a></li>
            	</ul>
      		</div>
          
        </div>  
        
        <div id="content_index">
          	<!-- <div class="caption">
          	  <h3>地图</h3>     
            </div>  --> 
       		<div id="map_element_index" class="google_map" ></div>              	  
        </div>
        
        <div id="slide_right" style="background:#FFFFFF;">
          <div class="block_right" style="height:50%">
          
            
          <div id="projectNews" class="newlist">
          	<h3>
          	新闻
          	<span>
          		<a>更多新闻>></a>
          	</span>
          	</h3>
            <ul class="list">
				<li>新疆跨境河流水生生态及鱼类资源调查</li>
            	<li>新疆跨境河流水生生态年度总结</li>
            	<li>新疆跨境河流水生生态及鱼类资源调查项目进行年度总结</li>
            	<li>科技基础性工作专项“新疆跨境河流水生生态及鱼类资源调查”正式启动</li>
            	<li>《新疆跨境河流水生生态及鱼类资源调查》项目今春野外调查工作顺利完成</li>
            	<li>华中农业大学首次获得国家基础性工作专项</li>
            </ul>
          </div>
          
          <div id="projectInfo" class="newlist">
          	<h3>
          	项目进展
          	<span>
          		<a>更多内容>></a>
          	</span>
          	</h3>
          	<ul class="list">
            	<li>新疆跨境河流水生生态及鱼类资源调查项目进行年度总结</li>
            	<li>科技基础性工作专项“新疆跨境河流水生生态及鱼类资源调查”正式启动</li>
            	<li>《新疆跨境河流水生生态及鱼类资源调查》项目今春野外调查工作顺利完成</li>
            	<li>华中农业大学首次获得国家基础性工作专项</li>
            </ul>
          </div>
          
         </div>
        </div>
        
        <div class="jianjie" style="background:#FFF; padding-top:5px;  float:left; width:992px;">
        </div>
      </div>
      <!--主题结束-->
      <div id="ma_bc"></div>    
    <!--footer开始-->
      	<div id="footer">
      <p> 中国·湖北·武汉 南湖狮子山街一号430070 Tel:+86-27-87282027 Fax:+86-27-87384670&nbsp;<br>
      CopyRight©2001-2014 华中农业大学版权所有&nbsp;鄂ICP备13013419号</p>
    </div>
    <!--footer结束-->

    <script type="text/javascript">
	$.each($('#subnav li'),function(){
		if ($(this).find('a').attr('href')=='./') {
			$(this).addClass('select')
		}
	})
	</script>
</div>
</div>
</body>

</html>

