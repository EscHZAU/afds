<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0031)http://www.hzau.edu.cn/2014/ch/ -->
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
  	<title>新疆跨境河流水生生态及鱼类资源数据库系统</title>
  	
  	 <link href="css/global.css" rel="stylesheet" type="text/css" />
    <link href="css/nav.css" rel="stylesheet" type="text/css" />
	<link href="css/font.css" rel="stylesheet" type="text/css" /> 
	<link href="css/resultdiv.css" rel="stylesheet" type="text/css"/>
	
	<!-- DOJO's style-->
	<link href="./js/dojo_1.10.4/dijit/themes/claro/claro.css" rel="stylesheet" type="text/css"/>
	
	
	<script type="text/javascript" src="js/jQuery/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/openLayers/OpenLayers.js"></script>
  	<script type="text/javascript" src="js/LoadGeoWMS.js" charset="GB2312"></script>
  	<script type="text/javascript" src="js/footTableControl.js" charset="GB2312"></script>
  	<script type="text/javascript" src="js/leftTableControl.js"></script>
  	
</head>

<body class = "claro" onload="init();leftDrag();">
	<div id="bgeffect">    
  	<div id="layout">
    <!-- 头部开始-->
    	<div id="header">
  		<div id="logo" onclick="location.href=&#39;./&#39;"></div>
  		<div id="loginStatus">
    		<a href="#">登陆</a> | <a href="#">注册</a> | <a href="#">帮助</a> |
  		</div>
        <div id="search">
            <form id="cse-search-box" action="http://www.google.com/cse">
              <input type="hidden" name="cx" value="008612931508023110545:jzxwx8vnj6e">
              <input type="hidden" name="ie" value="UTF-8">
              <input type="text" id="s" name="q" class="swap_value">
              <input type="image" src="images/btn_search_box.png" width="27" height="24" id="go" alt="Search" title="Search">
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
        <!-- <div class="dropdown_2columns">
          <div class="col_2">
          <ul class="simple">
            <li><a href="#">1</a></li>
          
          </ul>
        </div>
      </div> -->
    </li>
    
    <li>
      <a href="/monitSite/HydroData?SiteName=" class="drop">监测数据上传与下载</a>
      <!-- <div class="dropdown_1column">
        <div class="col_1">
          <ul class="simple">
            <li><a href="#">1</a></li>
            
          </ul>
        </div>
      </div> -->
    </li>
    
    <li>
      <a href="statisticsChart/index" class="drop">数据统计与分析</a>
        <!-- <div class="dropdown_1column">
          <div class="col_1">
          <ul class="simple">
            <li><a href="#">1</a></li>
          </ul>
        </div>
      </div> --> 
    </li>
    
    <li>
      <a href="#" class="drop">空间分析与制图</a>
     <!--    <div class="dropdown_1column">
          <div class="col_1">
          <ul class="simple">
            <li><a href="#">1</a></li>
          </ul>
        </div>
      </div> -->
    </li>
    
    </ul>

    <!--导航目录结束-->
    <!--主体开始-->
      <div id="maintop"></div>
      <div id="ma_tc"></div>
   <div id="mainarea" >
    <!--   <div id="left" style="width:744px;height:auto;float:left;"> -->
    <div id="left" style="width:744px;height:auto;float:left;">
       <div id="left_up">
        	<div class="caption">
           		<h3>监测地点</h3>     
       		</div>

        	<div id="toolbar" style="height:10%;">
     			<ul>
     			<li><a href="#">添加</a></li>
     			<li><a href="#">删除</a></li>
     			<li><a href="#">选择</a></li>
     			<li><a href="#">显示</a></li>
     			</ul>  
			</div> 
     	<div style="width:100%;height:90%;">
        	<div id="leftTable" style="height:100%;width:100%; overflow:scroll; float:left">
				<table class="imagetableSite" style="height:100%;width:100%;border-bottom:3px;" border="1px solid" cellpadding="5PX;" cellspacing="3px;">
				<tr>
					<th>ID</th>
					<th>地点</th>
					<th>所属流域</th>
				</tr>
				<tr>
				<c:forEach var="monitSite" items="${allMonitSite}" varStatus="i">
                	<c:if test="${(i.index+1) mod 1 == 0}">
                	<tr class="initTr">
                		<td class="initTr" style="display:none;">
                		<input type="checkbox" name="all" value="${i.index}"> 
                		</td>
                	<td>
                	<span id = "monitSiteid">
                	${i.index}
                	</span>
                	</td>
                	<td>${monitSite.name}</td>
                	<td>${monitSite.sectRive}</td>
                	</tr>
                	</c:if>
                </c:forEach>   
				</tr>
		</table>
       </div>
     </div> 
	<!-- end left_up -->
  </div>
  

        <div id="content">
          	<div class="caption">
          	  <h3>地图</h3>
          	<div id = "mapTool">
          		<table class="mapToolbar">
          			<tr>
          			<td>
              			<div class = "mapToolButton" onclick="monitSiteList();">
              				<a><img  id="monitSite" src="images/markList_smallsize.png" ></a>
              			</div>
              			<div class = "tips" id="monitSiteTips">
              				监测地点列表	
              			</div>
              		</td>
              		<td style="width:3px;"></td>
          			<td>
              			<div class = "mapToolButton">
              				<a href="../testWeb/NewFile.jsp">
              					<img id="fullScreenMAP" src="images/fullScreen.png" >
              				</a>
              			</div>
              			<div class = "tips" id="fullScreenTips"></div>
              		</td>
              		<td style="width: 3px;"></td>
          	  		<td>
          	  			<div class = "mapToolButton" onclick="bioSideBar();">
            				<img id="bioBarIMG" src="images/arrow-left.jpg"  >
              			</div>
              			<div class = "tips" id="bioBarTips"></div>
              		</td>
              		</tr>
                 </table> 
           </div>
     </div>  
        <div  id="map_element" class="google_map" ></div>
        
           <!-- dojo Start -->
          <%-- <div class="monitDataBySite">
          	<div class="caption">
           		<h3>监测数据</h3>     
       		</div>
    		<div dojoType = "dijit.layout.TabContainer" style="height: 100%;">
 	 		<div dojoType="dijit.layout.ContentPane" title="CatchFishObj" id="table_1">
                  <table id ="CatchFishObj" class="imagetableSite"  style="TABLE-LAYOUT: fixed;width:100%;" 
                  border="1px solid " cellpadding="5PX;" cellspacing="3px;">
                        <thead align="center" valign="bottom">
                        	<tr>
                        	<th width="20px" height="10px" style="WORD-WRAP: break-word" abbr="id">编号</th>   	
                        	<th width="auto" abbr="fishName">渔获物</th> 
                        	<th width="auto" abbr="beginTime">开始时间</th>
                        	<th width="auto" abbr="endTime">结束时间</th> 
                        	<th width="auto" abbr="netTimes">作业网次</th>
                        	<th width="auto" abbr="totalLeng">全长</th>
                        	<th width="auto" abbr="bodyWeigh">体重</th>
                        	<th width="auto" abbr="quantity">数量</th>
                        	<th width="auto" abbr="remark">备注</th> 
                        	</tr>
                 	    </thead>
                        	<tr>
                 			<c:forEach var = "allFishCatch" items="${fishCatchList}" varStatus="i">
                 				<tr class="initTr" ondblclick="mouseOver(this)" onclick="mouseOut(this)">
                 					<td></td>
                 					<td></td>
                 					<td width="auto"></td>
                 					<td width="auto"></td>
                 					<td></td>
                 					<td></td>
                 					<td></td>
                 					<td></td>
                 					<td><a href=""></a></td>
                 					</tr>
                 			</c:forEach>	       
                	</table>
                </div>
                <div dojoType="dijit.layout.ContentPane" title="MonitBen" id="table_2">
                	<table id="MonitBen" class="imagetableSite" style="width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">
                    <thead align="center" valign="bottom">
                     <tr>
                        <th width="auto" abbr="id">编号</th>   
                        <th width="auto" abbr="benName">名称</th> 
                        <th width="auto" abbr="monitSiteName">监测地点</th> 
                        <th width="auto" abbr="quantity">数量</th> 
                        <th width="auto" abbr="biomass">生物量</th>
                        <th width="auto" abbr="">更多信息</th> 
                     </tr>
                    </thead>
                    </table>
                </div>
                
                <div dojoType="dijit.layout.ContentPane" title="MonitPhy" id="table_3">
                	<table id="MonitPhy" class="imagetableSite" style="width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">
                        <thead align="center" valign="bottom">
                        	<tr>
                        	<th width="auto" abbr="id">编号</th>   
                        	<th width="auto" abbr="phyName">名称</th>  
                        	<th width="auto" abbr="monitSiteName">监测地点</th>   
                        	<th width="auto" abbr="quantity">数量</th>   
                        	<th width="auto" abbr="biomass">生物量</th>
                        	<th width="auto" abbr="transparen">透明度</th>
                        	<th width="auto" abbr="waterDep">水深</th>
                        	<th width="auto" abbr="id">备注</th>   
                        </tr>
                        </thead>
                     </table>
                </div>
                
                <div dojoType="dijit.layout.ContentPane" title="MonitZooplan" id="table_4">
                 	<table id = "MonitZooplan" class="imagetableSite" style="width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">
                        <thead align="center" valign="bottom">
                        <tr>
                        <th width="auto" abbr="id">编号</th>   
                        <th width="auto" abbr="zooplanName">名称</th>  
                        <th width="auto" abbr="monitSiteName">监测地点</th>   
                        <th width="auto" abbr="quantity">数量</th>   
                        <th width="auto" abbr="biomass">生物量</th>
                        <th width="auto" abbr="transparen">透明度</th>
                        <th width="auto" abbr="waterDep">水深</th>
                        <th width="auto" abbr="id">备注</th>   
                        </tr>
                        </thead>
                     </table>
                 </div>
                
              </div> 
        	</div> --%>
        	<!-- end dojo -->
        
        	<div id="map_element_right"></div>
        	<div id="dragIcon"></div>              	  
        <!-- </div>  -->
        </div>
      </div>
      
      
      
      <div id="right" style="width:auto;height:auto;float:right;">
     	 <div id="slide_right_monit">
          <div class="block noBg" >
            <div style="width:100%;height:261px;">
            <div class="caption">
            	<h3>生物学信息</h3>
            </div> 
            <!--内容-->
            <div style="height:228px;width:100%; overflow:auto; float:left">
            	<table id = "bioInfoTable" class="imagetable" style="height:100%;width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">  
                    <tr>
                       <th width="30px">门</th>   
                       <td width="30px"></td> 
                        
                     </tr>
                     <tr>
                       	<th width="auto">亚门</th>   
                        <td width="auto"></td> 
                     </tr>
                     <tr>
                        <th width="auto">纲</th>   
                        <td width="auto"></td> 
                     </tr>
                     <tr>
                       	<th width="auto">目</th>   
                        <td width="auto"></td> 
                     </tr>
                     <tr>
                       	<th width="auto">科</th>   
                        <td width="auto" height="50px"></td> 
                     </tr>
                     <tr>
                       	<th width="auto">属</th>   
                        <td width="auto"></td> 
                     </tr>
                      <tr>
                       	<th width="auto">种</th>   
                        <td width="auto"></td> 
                     </tr>
                     
                      <tr>
                       	<th width="auto">more</th>   
                        <td width="auto">
                        	<a href="">click for more information</a>
                        </td> 
                     </tr>  
                </table> 
            </div>  
            </div>    
          </div>
          <div class="block" style="height:45%">
          	<div class="caption">
            	<h3>图片</h3>
            </div>
            <div id="bioImg">
            	
            </div>
            <!-- <div style="height:190px;width:246px; overflow:auto; float:left">
            </div> -->
          </div>
        </div>
      </div>
      
      
      <div id="top_bottom_Drag"></div>
      </div>
      <script language="javascript" type="text/javascript">			
			function setTab(name,cursel,n){
			 for(i=0;i<n;i++){
			  var menu=document.getElementById(name+i);
			  var con=document.getElementById("con_"+name+"_"+i);
			  menu.className=i==cursel?"hover":"";
			  con.style.display=i==cursel?"block":"none";
			 }
			}			
	</script>
				
      <div id="jianjie" class="jianjie" style="background: #FFFFFF; padding-top:10px;  float:left; width:992px;height:240px;position:relative;">

		<div id="timeLine" >
			<ol dojoType = "dijit.form.HorizontalRuleLabels"
					data-dojo-props = "
						container:'topDecoration',
						count:9
						"
					style="height:1.2em; font-weight:bold">
					<li></li>
					<li value="1">2007</li>
					<li>2007</li>
					<li>2008</li>
					<li>2009</li>
					<li>2010</li>
					<li>2011</li>
					<li>2012</li>
					<li>2013</li>
					<li>2014</li>
					<li></li>
			</ol>
			
			<div data-dojo-type = "dijit.form.HorizontalRule"
					data-dojo-props="
					container:'topDecoration',
					count:11"
					style="height: 5px; margin:0 8px;">
			</div>
		
		<div  id="hslider" type="range" 
			dojoType = "dijit.form.HorizontalSlider"
				data-dojo-props = "
					minimum:0,
					maximum:10,
					showButtons:true,
					discreteValues:11,
					intermediateChanges:true">
			<script type="dojo/method" event="onChange" args="label">
				<!--content-->
				selectedFeatureByDate();
			</script>
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
	<script type="text/javascript" src="./js/dojo_1.10.4/dojo/dojo.js" djConfig = "parseOnLoad:true,isDebug:true">
	</script>
	
		<script type="text/javascript">
			//Add Dijit components you are using here using dojo.require
			 require([
			 		"dijit/layout/TabContainer",
				 	"dijit/layout/ContentPane", 
			 		"dijit/form/HorizontalSlider",
			 		"dijit/form/HorizontalRuleLabels", 
			 		"dijit/form/HorizontalRule",
			 		"dojo/parser"
			 		]);	
		</script>
		

    <script type="text/javascript">
	$.each($('#subnav li'),function(){
		if ($(this).find('a').attr('href')=='./') {
			$(this).addClass('select')
		}
	})
	</script>
	
	</div>
  </div>
</div>

<script type="text/javascript" src=""></script>
</body>
</html>