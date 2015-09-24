<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新疆跨境河流数据库平台-数据统计与分析</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/global.css" rel="stylesheet" type="text/css" />
    <link href="css/nav.css" rel="stylesheet" type="text/css" />
	<link href="css/font.css" rel="stylesheet" type="text/css" /> 
	<link href="css/resultdiv.css" rel="stylesheet" type="text/css"/>
	<link href="css/statisticsChart.css" rel="stylesheet" type="text/css"/>
	
	<!-- DOJO's style-->
	<link href="js/dojo_1.10.4/dijit/themes/claro/claro.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/dojo_1.10.4/dojo/dojo.js" djConfig = "parseOnLoad:true,isDebug:true"></script>
	<!-- Scripts -->
	<script type="text/javascript" src="js/openLayers/OpenLayers.js"></script>
	<!-- <script type="text/javascript" src="js/dojo-release-1.10.4/dojo/dojo.js"></script> -->
  	<script type="text/javascript" src="js/LoadGeoWMS.js" charset="GB2312"></script>
	

  </head>
  
  <body onload="init_SC();" class="claro">
	<div id="bgeffect">
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
              		<input type="hidden" name="ie" value="GB2312">
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
      <a href="../monitSite/HydroData?SiteName=" class="drop">监测数据上传与下载</a>
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
       <!-- chart start -->
		<div id="statisticsChart">
			<table id = "statisticsChart_Select">
				<tr>
					<td>
						<div class="caption" style="width:100%;">
           					<h3>统计图表</h3>     
       					</div>	
						图表类型：
						<select id="chartTypeSelect" name="chartTypeSelect" data-dojo-type="dijit/form/FilteringSelect"
               				data-dojo-props="
               			value: '',
               			placeHolder: '选择图表类型'">
               			<option value="pieChart">饼状图</option>
               			<option value="Chart">折线图</option>
               			<option value="stackedAreaChart">堆叠面积图</option>
               			<option value="columnsChart">柱状图</option>	
        				</select>	
        			</td>
        		</tr>
        		<tr>
        			<td>
       					监测数据源选择：
       					<select id="monitSiteSelect" name="monitSiteSelect" data-dojo-type="dijit/form/FilteringSelect"
               				data-dojo-props="
               				value: '',
               				placeHolder: '请选择数据来源【监测地点】'" >
               				<c:forEach var="monitSite" items="${allMonitSite}" varStatus="i">
                				<c:if test="${(i.index+1) mod 1 == 0}">
                					<option value=${i.index}>${monitSite.name}</option>
               					</c:if>
                			</c:forEach> 
         				</select>
         				<div id="addSeries" onclick="addDataSeries();">
         					<img id="showDataSeries" src="images/arrow-down.jpg">
         				</div>
         				
         				鱼类及水生生物选择:
         				<select id="bioSelect" name="bioSelect" data-dojo-type="dijit/form/FilteringSelect"
							data-dojo-props="
							value:'',
							placeHolder:'请选择目标生物【生物种类】'">
							<option>扁蜉属</option>
						</select>
         				
        			</td>
        		</tr>
        		<tr id="dataSeriesTable" style="display: none;">
        			<td>
        			<div style="height: auto;width:100%;">
        				<div class="caption" style="width:96%;">
           					<h3>Data Series</h3>     
       					</div>
        			<!-- 工具栏：对监测点数据的增加、删除 -->
        				<div id="toolbar" style="height:28px;">
     						<ul>
     						<li onclick="addSeries();"><a>添加</a></li>
     						<li onclick="deleteSeries();"><a>删除</a></li>
     						<li onclick=""><a>清空</a></li>
     						<li onclick=""><a>关闭</a></li>
     						</ul>  
						</div>
					<!-- 定位查询监测点 -->	
					<!-- 	<div id="searchByPointName">
							<input id="monitSiteSelected" type = "text" placeholder = "Search Text" name = "monitSiteSelected" style="height:28px;width:182px;float: left;margin:0,0,0,0;padding:0,0,0,0;"></input>
							<button id = "searchStr" type = "submit" style="height:30px;width:58px;cursor: pointer;position: relative;float: left;margin-left: 0;background-color:#73C4D1;border: 1px #616161;" onclick="queryBasedProperty()">
								<img src="images/queryIcon.png">
							</button>	
						</div> -->
        			<!-- 已经添加的数据源 -->
     					<div style="width:100%;height:90%;">
        					<div id="leftTable" style="height:100%;width:100%; overflow:scroll; float:left">
							<table id="seriesTable" class="imagetableSite" style="height:100%;width:100%;" border="1px solid #000" cellpadding="5PX;" cellspacing="3px;">
							<tr id="seriesHead">
								<th></th>
								<th>编号</th>
								<th>监测地点</th>
							</tr>
							
							</table>
       						</div>
     					</div>
     				</div>
        		</td>
        	</tr>
			</table>
			
			<!-- 选择统计指标 -->
			监测数据统计指标(y轴)选择：
       		<select id="fieldSelect" name="fieldSelect" data-dojo-type="dijit/form/FilteringSelect"
               		data-dojo-props="
               		value: '',
               		placeHolder: '选择查询指标'" >
               		<option value="quantity">数量</option>
               		<option value="biomass">生物量</option>
         	</select>
			
			<div id="commitButton_Draw" onclick="drawChart();">
               <button id="drawQuery" data-dojo-type="dijit/form/Button">确认</button> 	
			</div>
		</div>
	<!-- chart end --> 	
      
      
    <!--   <div id="left" style="width:744px;height:auto;float:left;"> -->
   		<div id="left" style="width:720px;height:auto;float:left;">
    	
    	<div id="content_statisticsChart">
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
        	<div  id="map_element_statisticsChart" class="google_map" ></div>
        		
        	<div id="dragIcon"></div>              	  
        <!-- </div>  -->
     </div>
        
   </div>
</div>
      
	
<!-- table start -->
<!-- 	<div dojoType = "dijit.layout.TabContainer"
		style="width:300px;height: 300px;margin:5px;border:solid 1px;">
 	 <div dojoType="dijit.layout.ContentPane" title="CatchFishObj" id="table_1">
                  <table id ="CatchFishObj" class="imagetable" style="TABLE-LAYOUT: fixed;width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">
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
                	<table id="MonitBen" class="imagetable" style="width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">
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
                	<table id="MonitPhy" class="imagetable" style="width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">
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
                 	<table id = "MonitZooplan" class="imagetable" style="width:100%;" border="1px solid " cellpadding="5PX;" cellspacing="3px;">
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
                
              </div> -->
              
              <!-- table end 
              "dijit/layout/TabContainer",
				 		"dijit/layout/ContentPane",-->
                
          	
          	 <!--主题结束-->
      		<div id="ma_bc"></div>    
    		<!--footer开始-->
      		<div id="footer">
      			<p>中国  湖北 武汉 洪山区狮子山街特1号  430070 Tel:+86-27-87282027 Fax:+86-27-87384670&nbsp;<br>
      			CopyRight&copy2014-2018 华中农业大学水产学院版权所有&nbsp;鄂ICP备13013419号</p>
    		</div>
    		<!--footer结束-->
          	
          	
			<script type="text/javascript" src="js/jquery.js"></script>
			<script type="text/javascript" src="js/footTableControl.js"></script>
			<script type="text/javascript" src="js/statisticsChart_js.js" charset="GB2312"></script>
			
		</div>	
	</div>	
</body>
</html>
