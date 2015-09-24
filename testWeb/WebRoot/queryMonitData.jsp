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
	<script type="text/javascript" src="js/dojo_1.10.4/dojo/dojo.js" 
				djConfig = "parseOnLoad:true,isDebug:true"></script>
	
	<script type="text/javascript" src="js/jQuery/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/openLayers/OpenLayers.js"></script>
	<!-- <script type="text/javascript" src="js/dojo-release-1.10.4/dojo/dojo.js"></script> -->
  	<script type="text/javascript" src="js/LoadGeoWMS.js" charset="GB2312"></script>
  	<script type="text/javascript" src="js/footTableControl.js" charset="GB2312"></script>
  	<script type="text/javascript" src="js/leftTableControl.js"></script>
  	<script type="text/javascript" src="js/rightToolsControl.js"></script>
  	
  	
  	
	<script type="text/javascript">
	var doc = document;
		$(doc).ready(function(){
			$("#monitSiteLIST").mouseover(function(){
				$("#monitSiteTips").show("slow");
				$("#monitSiteLIST").mouseout(function(){
					$(".tips").hide("slow");
				});
			});
			
			$("#fullScreenMAP").mouseover(function(){
				$("#fullScreenTips").show("slow");
				$("#fullScreenMAP").mouseout(function(){
					$(".tips").hide("slow");
				});
			});
			
			$("#timeLineDOJO").mouseover(function(){
				$("#timeLineTips").show("slow");
				$("#timeLineDOJO").mouseout(function(){
					$(".tips").hide("slow");
				});
			});
			$("#bioBarIMG").mouseover(function(){
				$("#bioBarTips").show("slow");
				$("#bioBarIMG").mouseout(function(){
					$(".tips").hide("slow");
				});
			});	
		})
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
  
  <!-- Author:XiangDian -->
  <script language=JavaScript type=text/javascript>
	function show_whomenu(who3) {
		for (var i = 0; i < 4; i++) { document.getElementById("a_" + i).style.display = "none"; }
        for (var i = 0; i < 4; i++) { document.getElementById("menu_" + i).className = "s1"; }
		document.getElementById("menu_" + who3).className = "s2";
		document.getElementById("a_" + who3).style.display = "block";
		}	
	var color_picker_div=false;
	var _table=false;
	var MSIE = navigator.userAgent.indexOf('MSIE')>=0?true:false;
	var navigatorVersion = navigator.appVersion.replace(/.*?MSIE (\d\.\d).*/g,'$1')/1;
	function showColorPicker(inputObj)
	{
		if(!color_picker_div){
			color_picker_div = document.createElement('DIV');
			color_picker_div.id = 'dhtmlgoodies_colorPicker';
			color_picker_div.style.display='none';
			<!--标题栏-->
			createColorPickerTopRow(color_picker_div);
			<!--填充table-->
			var contentDiv = document.createElement('DIV'); 
			contentDiv.id = 'color_picker_content';
			contentDiv.style.height="100px";
			contentDiv.style.overflow="auto";
			color_picker_div.appendChild(contentDiv);
			init_table(contentDiv);
			
			document.body.appendChild(color_picker_div);
		}		
		if(color_picker_div.style.display=='none' )color_picker_div.style.display='block'; else color_picker_div.style.display='none';		
		color_picker_div.style.left = colorPickerGetLeftPos(document.getElementById('content')) + 'px';
		color_picker_div.style.top = colorPickerGetTopPos(document.getElementById('content')) + document.getElementById('content').offsetHeight - 446 + 'px';
		color_picker_active_input = inputObj;				
}

<!--标题栏-->
	function createColorPickerTopRow(inputObj){
		var tabs = '检索结果';
		var tabWidths = [37,90,70];
		var div = document.createElement('DIV');
		div.className='colorPicker_topRow';
	
		inputObj.appendChild(div);	
		var currentWidth = 0;
			
			var tabDiv = document.createElement('DIV');
			tabDiv.onselectstart = cancelColorPickerEvent;
			tabDiv.ondragstart = cancelColorPickerEvent;
			suffix = 'active';
			color_picker_active_tab = this;

			
			tabDiv.id = 'colorPickerTab';
			tabDiv.onclick = showHideColorOptions;
			tabDiv.style.zIndex = 50;
			tabDiv.style.left = currentWidth + 'px';
			tabDiv.style.position = 'absolute';
			tabDiv.className='colorPickerTab_' + suffix;
			var tabSpan = document.createElement('SPAN');
			tabSpan.innerHTML = tabs;
			tabDiv.appendChild(tabSpan);
			var tabImg = document.createElement('IMG');
			tabImg.src = "images/tab_right_" + suffix + ".gif";
			tabDiv.appendChild(tabImg);
			if(navigatorVersion<6 && MSIE){	/* Lower IE version fix */
				tabSpan.style.position = 'relative';
				tabImg.style.position = 'relative';
				tabImg.style.left = '-3px';		
				tabDiv.style.cursor = 'hand';	
			}			
			div.appendChild(tabDiv);
			currentWidth = currentWidth + tabWidths[0];
		
		var closeButton = document.createElement('DIV');
		closeButton.className='colorPickerCloseButton';
		closeButton.innerHTML = 'x';
		closeButton.onclick = closeColorPicker;
		closeButton.onmouseover = toggleCloseButton;
		closeButton.onmouseout = toggleOffCloseButton;
		div.appendChild(closeButton);
		
	}
	function closeColorPicker()
	{
		color_picker_div.style.display='none';
	}
	function cancelColorPickerEvent(){
		return false;
	}
	function showHideColorOptions()
	{
		var parentNode = this.parentNode;
		var subDiv = parentNode.getElementsByTagName('DIV')[0];
		counter=0;		
		var contentDiv = document.getElementById('color_picker_content').getElementsByTagName('DIV')[0];
		do{			
			if(subDiv.tagName=='DIV' && subDiv.className!='colorPickerCloseButton'){
				if(subDiv==this){
					this.className='colorPickerTab_active';
					this.style.zIndex = 50;
					var img = this.getElementsByTagName('IMG')[0];
					img.src = "images/tab_right_active.gif"
					img.src = img.src.replace(/inactive/,'active');							
					contentDiv.style.display='block';
					self.status = counter;					
				}else{
					subDiv.className = 'colorPickerTab_inactive';	
					var img = subDiv.getElementsByTagName('IMG')[0];
					img.src = "images/tab_right_inactive.gif"
					self.status = img.src;
					subDiv.style.zIndex = 10 - counter;
					contentDiv.style.display='none';
				}
				counter++;
			}
			subDiv = subDiv.nextSibling;
			contentDiv = contentDiv.nextSibling;
		}while(subDiv);
		
		document.getElementById('colorPicker_statusBarTxt').innerHTML = ' ';


	}

	function toggleCloseButton()
	{
		this.style.color='#FFF';
		this.style.backgroundColor = '#317082';	
	}
	
	function toggleOffCloseButton()
	{
		this.style.color='';
		this.style.backgroundColor = '';			
		
	}
	
	function colorPickerGetTopPos(inputObj)
	{
		
	  var returnValue = inputObj.offsetTop;
	  while((inputObj = inputObj.offsetParent) != null){
	  	returnValue += inputObj.offsetTop;
	  }
	  return returnValue;
	}
	
	function colorPickerGetLeftPos(inputObj)
	{
	  var returnValue = inputObj.offsetLeft;
	  while((inputObj = inputObj.offsetParent) != null)returnValue += inputObj.offsetLeft;
	  return returnValue;
	}
	/**/
	function init_table(inputObj){
		if(!_table){
			var _table=document.createElement("table");
			var _tbody=document.createElement("tbody");
			_table.style.display='none';
			//_table.id='result_table';
			_table.appendChild(_tbody);
			inputObj.appendChild(_tbody);
			var row;
            for (var i = 1; i < 10; i++) {
                row = document.createElement("tr");
                row.id = i;
                var cell;
                for (var j = 1; j < 6; j++) {
                    cell = document.createElement("td");
                    cell.id = i + "/" + j;
                    cell.appendChild(document.createTextNode("第" + cell.id + "列"));
                    row.appendChild(cell);
                }
                _tbody.appendChild(row);
            }
		}
	}
			
        </script>
  
</head>
<body onload="init();leftDrag();" class="claro">
  <div id="bgeffect">
  
  	<div id ="returnToMap">
  	 		<a>
  	 			<img  id = "returntoMap" src="images/returnMapView_smallsize.png"
  	 			onclick="returnToMap();">
  	 		</a>
  	</div>
      
  	<div id="layout">
    <!-- 头部开始-->
    	<div id="header">
  		<div id="logo" onclick="location.href=&#39;./&#39;"></div>
  		<div id="loginStatus">
    		<a href="../testWeb/jsp/login.jsp">登陆</a> | <a href="#">注册</a> | <a href="#">帮助</a> |
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
     			<li onclick="showAddMonitSiteBox();"><a>添加</a></li>
     			<li><a href="">删除</a></li>
     			<li onclick="clearFeatures();"><a>清空</a></li>
     			<li onclick="monitSiteList();"><a>关闭</a></li>
     			</ul>  
			</div>
			
			<div id="searchByPointName">
				<input id="monitSiteSelected" type = "text" placeholder = "Search Text" name = "monitSiteSelected" style="height:28px;width:182px;float: left;margin:0,0,0,0;padding:0,0,0,0;"></input>
				<button id = "searchStr" type = "submit" style="height:30px;width:58px;cursor: pointer;position: absolute;float: left;margin-left: 0;background-color:#73C4D1;border: 1px #616161;" onclick="queryBasedProperty()">
					<img src="images/queryIcon.png">
				</button>	
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
     
     <div id="addMonitSite" style="display:none;">
            <table id = "addBox" cellspacing = "0" cellpadding = "0" border = "0" >
				<tbody>
				<tr>
					<td id = "addpropertyTitle">--新增监测点位--</td>
				</tr>
				
				<tr>
					<td>
						<table class="addpropertyTable" id = "addpropertyTable">
							<tbody>
							<tr>
								<td>监测点名称:</td>
								<td>
									<input id="addMonitSite_Name" type = "text" name = "addMonitSite_Name" style="width:120px;"></input>
								</td>
								<td>位置：</td>
								<td>
									<input id = "addMonitSite_Location_lati_degree" style="width:30px;"/>
									°
									<input id = "addMonitSite_Location_lati_min" style="width:30px;"/>
									'
									<input id = "addMonitSite_Location_lati_second" style="width:30px;"/>
									''
								</td>
								<td>N</td>
								
								<td>
									<input id = "addMonitSite_Location_lati_degree" style="width:30px;"/>
									°
									<input id = "addMonitSite_Location_lati_min" style="width:30px;"/>
									'
									<input id = "addMonitSite_Location_lati_second" style="width:30px;"/>
									''
								</td>
								<td>E</td>		
								<td>
									<input id = "submit" type = "submit" value = "添加"/>
								</td>
								
								<td>
									<input id = "cancel" type = "submit" value = "取消" onclick="hideAddMonitSiteBox();"/>
								</td>
							</tr>
						</tbody>
					</table>
					</td>
				</tr>
				</tbody>
			</table>
	</div>
     
</div>

	

        <div id="content">
          	<div class="caption">
          	  <h3>地图</h3>
          	<div id = "mapTool">
          		<table class="mapToolbar">
          			<tr>
          			<td>
              			<div class = "mapToolButton" id="monitSite" onclick="monitSiteList();">
              				<a><img  id="monitSiteLIST" src="images/markList_smallsize.png" ></a>
              			</div>
              			<div class = "tips" id="monitSiteTips">
              				监测地点列表	
              			</div>
              		</td>
              		<td style="width:3px;"></td>
          			<td>
              			<div class = "mapToolButton" id="fullScreen">
              				<a href="../testWeb/NewFile.jsp">
              					<img id="fullScreenMAP" src="images/fullScreen.png" >
              				</a>
              			</div>
              			<div class = "tips" id="fullScreenTips">全屏模式</div>
              		</td>
              		<td style="width: 3px;"></td>
              		<td>
              			<div class = "mapToolButton" id="timeLine" onclick="controlTimeline();">
              					<img id="timeLineDOJO" src="images/timeLine.png"> 				
              			</div>
              			<div class = "tips" id="timeLineTips">时间轴</div>
              		</td>
              		<td style="width: 3px;"></td>
          	  		<td>
          	  			<div class = "mapToolButton" id="bioBar" onclick="bioSideBar();">
            				<img id="bioBarIMG" src="images/arrow-left.jpg"  >
              			</div>
              			<div class = "tips" id="bioBarTips">生物信息栏</div>
              		</td>
              		</tr>
                 </table> 
           </div>
          </div>
            <!-- <div id="ribbon_menu">
            	<div class = "ribbon_menuPanel">
            		<div class = "ribbon_menu_map">
            			<div class = "ribMap" id="Map_"></div>
            			<div class = "ribMap" id="Map_property"></div>
            			<div class = "ribMap" id="Map_refresh"></div>
            		</div>
            		<div class = "ribbon_menu_operation">
            			<div class = "ribOpt" id="addLayers"></div>
            			<div class = "ribOpt" id="removeLayers"></div>
            			<div class = "ribOpt" id="addMarks"></div>
            			<div class = "ribOpt" id="undo"></div>
            		</div>
            		<div class = "ribbon_menu_styleControl">
            			<div class = "ribStyle" id="style"></div>
            		</div>
            	</div>
            </div>   -->
        	
        	<div  id="map_element" class="google_map" ></div>

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
            <div id="lib_Tab1" style="float:left;width:990px;float:left;height:240px;">
              <!-----------------标签--------------->
              <div class="lib_Menubox lib_tabborder">
                <ul id="listOfTable">
                  <li id="one0" onclick="setTab('one',0,4)" class="hover" value="CatchFishObj">渔获物</li>
                  <li id="one1" onclick="setTab('one',1,4)" value="MonitBen">底栖生物</li>
                  <li id="one2" onclick="setTab('one',2,4)" value="MonitPhy">浮游植物</li>
                  <li id="one3" onclick="setTab('one',3,4)" value="MonitZooplan">浮游动物</li>
                </ul>
                <table class = "queryToolbar">
                	<tr>
                		<td>
                			<img src="images/queryIcon.png" onclick="createQuery();">
                		</td>
                		<td style="width: 3px;"></td>
                		<td>
                			<img src="images/retry.png" onclick="getAllData();">		
                		</td>
                	</tr>
                </table>
              </div>
              <!-----------------标签--------------->
              <div class="lib_Contentbox lib_tabborder" style="overflow:auto; height:220px;width:990px;">
                <div id="con_one_0">
                  <table id ="CatchFishObj" class="imagetable" style="TABLE-LAYOUT: fixed;height:100%;width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">
                        <thead align="center" valign="bottom">
                        	<tr>
                        	<th width="100px" style="WORD-WRAP: break-word" abbr="id">编号</th>   	
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
                 					<td>${i.index}</td>
                 					<td>${allFishCatch.fishName}</td>
                 					<td width="auto">${allFishCatch.beginTime}</td>
                 					<td width="auto">${allFishCatch.endTime}</td>
                 					<td>${allFishCatch.netTimes}</td>
                 					<td>${allFishCatch.totalLeng}</td>
                 					<td>${allFishCatch.bodyWeigh}</td>
                 					<td>${allFishCatch.quantity}</td>
                 					<td><a href="">more</a></td>
                 					</tr>
                 			</c:forEach>
							</tr>         
                	</table>
                </div>
                
                <div id="con_one_1" style="display:none; ">
                  <table id="MonitBen" class="imagetable" style="height:100%;width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">
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
                 <tr>
                 <c:forEach var = "allBenData" items="${benList}" varStatus="i">
                 	<tr class="initTr" ondblclick="mouseOver(this);" onclick="mouseOut(this);">
                 	<td>${i.index}</td>
                 	<td>${allBenData.benName}</td>
                 	<td>${allBenData.monitSiteName}</td>
                 	<td>${allBenData.quantity}</td>
                 	<td>${allBenData.biomass}</td>
                 	<td>
                 	<a href="">more</a></td>
                 	</tr>
                 </c:forEach>
				</tr>   
                  </table>
                </div>
                
                <div id="con_one_2" style="display:none; ">
                  <table id="MonitPhy" class="imagetable" style="height:100%;width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">
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
                        <tr>
                        <c:forEach var="allPhyData" items="${phyList}" varStatus="i">
                        <tr class="initTr" ondblclick="mouseOver(this)" onclick="mouseOut(this)">
                        	<td>${i.index}</td>
                        	<td>${allPhyData.phyName}</td>
                        	<td>${allPhyData.monitSiteName}</td>
                        	<td>${allPhyData.quantity}</td>
                        	<td>${allPhyData.biomass}</td>
                        	<td>${allPhyData.transparen}</td>
                        	<td>${allPhyData.waterDep}</td>
                        	<td>${allPhyData.ownerUnit}</td>
                        </tr>
                        </c:forEach>
                        </tr>
                       
                </table>
                </div>
                <div id="con_one_3" style="display:none; ">
                  <table id = "MonitZooplan" class="imagetable" style="height:100%;width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">
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
                        <tr>
                        <c:forEach var="allZooplanData" items="${zooplanList}" varStatus="i">
                        <tr class="initTr" ondblclick="mouseOver(this)" onclick="mouseOut(this)">
                        	<td>${i.index}</td>
                        	<td>${allZooplanData.zooplanName}</td>
                        	<td>${allZooplanData.monitSiteName}</td>
                        	<td>${allZooplanData.quantity}</td>
                        	<td>${allZooplanData.biomass}</td>
                        	<td>${allZooplanData.transparen}</td>
                        	<td>${allZooplanData.waterDep}</td>
                        	<td>${allZooplanData.ownerUnit}</td>
                        </tr>
                        </c:forEach>
                        </tr> 
                </table>
                </div>
              </div>
            </div>
            
            <div class="queryBox" id="queryBox" style="display: none;">
            <table id = "mainBox" cellspacing = "0" cellpadding = "0" border = "0" >
				<tbody>
				<tr>
					<td id = "tTitle">--监测数据查询--</td>
				</tr>

				<tr>
					<td>
					<fieldset id = "queryCondition">
						<legend>自定义查询条件</legend>
						<table class="queryTable" id = "queryTable">
							<tbody>
							<tr>
								<td>表</td>
									<td>
									<select id = "tName"  onchange="initCombox();">
										<option value = "CatchFishObj">渔获物</option>
										<option value = "MonitBen">底栖生物</option>
										<option value = "MonitPhy">浮游植物</option>
										<option value = "MonitZooplan">浮游动物</option>
									</select>
									</td>
								<td width="auto">字段</td>
									<td>
									<select id = "fName"></select>
									</td>
								<td width="auto">关系</td>
									<td>
									<select id = "conn">
										<option value = "&#62;">大于</option>
										<option value = "&#62;=">大于等于</option>
										<option value = "&#60;">小于</option>
										<option value = "&#60;=">小于等于</option>
										<option value = "=">等于</option>
										<option value = "is null">为空</option>
										<option value = "is not null">不为空</option>
										<option value = "like">包含</option>
									</select>
									</td>
								<td>值</td>
									<td>
									<input  id = "fValue" type ="text" name = "fvalue"></input>
									</td>
								<td>
									<input id = "submit" type = "submit" value = "添加" onclick="generateHQL();addToList();"/>
								</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td>
				<fieldset id = "conditionBox">
					<legend>条件集合</legend>
					<table id = "conditionTable" class = "imagetable">
						<tr>
							<th>NO</th>
							<th>Condition</th>
						</tr>
					</table>
				</fieldset>
				</td>
				</tr>

			<tr>
				<td>
				<input id = "submit" type = "submit" value = "提交查询" onclick="bendataQuery();"/>
				<input id = "clear" type = "submit" value = "清空" onclick="clearList();"/>
				</td>
			</tr>
		</tbody>
	</table>
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
</div>
</body>
</html>