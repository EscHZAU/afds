<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>  
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
  <title>新疆跨境河流水生生态及鱼类资源数据库系统</title>
  
      	<link href="../css/global.css" rel="stylesheet" type="text/css" />
      	<link href="../css/nav.css" rel="stylesheet" type="text/css" />
		<link href="../css/font.css" rel="stylesheet" type="text/css" />
		<link href="../css/classifyBioQuery.css" rel="stylesheet" type="text/css" />
		
		<!-- DOJO's style-->
		<link href="../js/dojo_1.10.4/dijit/themes/claro/claro.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="../js/dojo_1.10.4/dojo/dojo.js" 
				djConfig = "parseOnLoad:true,isDebug:true"></script>
				
		<script type="text/javascript" src="../js/jquery.js"></script>
		
 
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

<body>

  <div id="bgeffect" class="claro">    
  	<div id="layout">
    <!-- 头部开始-->
    	<div id="header">
  		<div id="logo" onclick="location.href=&#39;./&#39;"></div>
  		<div id="loginStatus">
    		<a href="#">登陆</a> | <a href="#">注册</a> | <a href="#">帮助</a> |
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
    <!--导航目录开始-->
   		<ul id="nav">
      <li class="nosub">
        <a href="#" class="drop">主&nbsp;&nbsp;页</a>
      </li>
      <li>
      <a href="../classifyBioQuery/index" class="drop">调查生物名录检索</a>
        <div class="dropdown_1column">
          <div class="col_1">
          <ul class="simple">
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li> 
          </ul>
        </div>
      </div>
      </li>
    <li>
      <a href="../queryMonitData/index" class="drop">监测数据查询</a>
        <div class="dropdown_2columns">
          <div class="col_2">
          <ul class="simple">
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
          </ul>
        </div>
      </div>
    </li>
    
    <li>
      <a href="水生生态及鱼类资源名录检索.html" class="drop">监测数据的上传与下载</a>
      <div class="dropdown_1column">
        <div class="col_1">
          <ul class="simple">
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
          </ul>
        </div>
      </div>
      
    </li>
    
    <li>
      <a href="../statisticsChart/index" class="drop">数据统计分析</a>
        <div class="dropdown_1column">
          <div class="col_1">
          <ul class="simple">
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
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
    <!--导航目录结束-->
    <!--主体开始-->
      <div id="maintop_directorySearch"></div>
      <div id="ma_tc"></div>
      <div id="mainarea">
        <div id="slide_left_classify">
        	<div class="caption">
            	<h3>检索表导航</h3>     
            </div>
           <!--  <div id="accordionMenu"> -->
            	<ul id="accordion" class="accordion">
					<li id="BaseFish">
						<div class="link">渔获物</div>
						<ul class="submenu">
							<c:forEach var = "fishBioInfo" items="${fishBioDirectory}" varStatus="i">
								<li>
									${fishBioInfo.species}
								</li>
							</c:forEach>
						</ul>
					</li>
					<li id="BaseBen">
						<div class="link">底栖生物  </div>
						<ul class="submenu">
							<c:forEach var = "benBioInfo" items="${benBioDirectory}" varStatus="i">
								<li>
									${benBioInfo.species}
								</li>
							</c:forEach>
						</ul>
					</li>
					<li id="BasePhy">
						<div class="link">蜉蝣植物</div>
						<ul class="submenu">
							<c:forEach var = "phyBioInfo" items="${phyBioDirectory}" varStatus="i">
								<li>
									${phyBioInfo.species}
								</li>
							</c:forEach>
						</ul>
					</li>
					<li id="BaseZooplan">
						<div class="link">蜉蝣动物</div>
						<ul class="submenu">
							<c:forEach var = "zooBioInfo" items="${zooBioDirectoryy}" varStatus="i">
								<li>
									${zooBioInfo.species}
								</li>
							</c:forEach>
				
						</ul>
					</li>
				</ul>
         <!--  </div> -->

        </div>
        
        <!-- queryCondition start -->
       <div id="classifyQueryContent"> 
       	 <div class="caption">
            	<h3>新疆跨境河流水生及鱼类数据库名录查询</h3>     
         </div>
         
       	 <div class="block noBg" style="height:476px;">
          	
          	<!-- decorations (Fish Photo)-->
            <!--内容-->
            <iframe width="726" height="476" id="classifyForm" name="classifyForm" src="../jsp/classifyBioForm.jsp">
            </iframe>
  			
          </div>

        </div>
        <!-- queryCondition end -->
          
      </div>
      

      
      <!--主题结束-->
      <div id="ma_bc"></div>    
    <!--footer开始-->
      	<div id="footer">
      <p> 中国·湖北·武汉 南湖狮子山街一号430070 Tel:+86-27-87282027 Fax:+86-27-87384670&nbsp;</br>
CopyRight©2001-2014 华中农业大学版权所有&nbsp;鄂ICP备13013419号</p>
    </div>
    <!--footer结束-->
	
   <!--  <script type="text/javascript">
	$.each($('#subnav li'),function(){
		if ($(this).find('a').attr('href')=='./') {
			$(this).addClass('select')
		}
	})
	</script> -->
	</div>
</div>
	<script type="text/javascript" src="../js/classifyBioQuery_js.js"></script>
	<script>
		require([
				"dijit/form/CheckBox",
				"dijit/form/Button",
		         "dijit/form/FilteringSelect",
		         "dijit/form/TextBox",
		         "dijit/form/SimpleTextarea",
		         "dojo/parser",
		         "dojo/domReady!"]);
	</script>
</body>

</html>