function drawChart(){	
	require([
	         "dijit/registry",
	         "dojo/dom-construct",
	         "dojo/dom",
	         "dojo/domReady!"
		  	   ],function(dom){
		  		var chart1 = dom.byId("staChart");
		  			//test: chart1
		  			console.log(chart1);
		  			
		  		//获取图表类型
		  		var chartType = dijit.byId('chartTypeSelect').get('displayedValue');
		  		
		  		//获取数据源Data Series表格
		  		var seriesTab = document.getElementById("seriesTable");
		  		
		  		//获取生物类型
		  		var bioSelect = document.getElementById("bioSelect");
		  		
		  		//获取用户设置的数据源
		  		var site = new Array();
		  		for(var i = 0; i<=seriesTab.rows.length-1;i++){
		  			site[i] = seriesTab.getElementsByTagName("tr")[i].cells[2].innerHTML;
		  		}
		  		if(bioSelect != null){
		  			var bioName = dijit.byId('bioSelect').get('displayedValue');
		  			console.log(bioName);
		  		}
		  		
		  		console.log(site);
		  		
		  		if(document.getElementById("staChart")){
		  			destroyChart();
		  			/*if(chartType == '堆叠面积图')
		  			{
		  				stackedAreasChart(site[1],site[2]);
		  			}
		  			else{  				
		  				pieChart(site[1]);
		  			}*/
		  		switch(chartType){
		  			case '堆叠面积图':
		  				stackedAreasChart(site[1], site[2])
		  				break;
		  			case '饼状图':
		  				pieChart(site[1])
		  				break;
		  			case '折线图':
		  				lineChart(bioName)
		  				break;
		  			}
		  			
		  		}
		  		else{
		  			/*pieChart(site);*/
		  			/*if(chartType == '堆叠面积图')
		  			{
		  				stackedAreasChart(site[1],site[2]);
		  			}
		  			else{  				
		  				pieChart(site[1]);
		  			}*/
		  			switch(chartType){
		  				case '堆叠面积图':
		  					stackedAreasChart(site[1], site[2])
		  					break;
		  				case '饼状图':
		  					pieChart(site[1])
		  					break;
		  				case '折线图':
			  				lineChart(bioName)
			  				break;
		  			}
		  		}
		  			
		  	});
}
			
//************删除生成的图表DOM节点（包括子节点）************
function destroyChart(){
	require([
	         "dijit/registry",
	         ],
		function(){
	  		/*var chart1 = dijit.registry.byId("pieChart");*/
	  		var chart2 = document.getElementById("staChart");
	  		
	  		
	  		chart2.parentNode.removeChild(chart2);
	  		
	  		
	  		//chart.destroyRecursive();
		
	  	});
}

//*******************生成堆叠面积图********************
//**********对比多个监测点之间的物种生物量、数量差异**********
function stackedAreasChart(monitSiteName1,monitSiteName2){
	require([
		     	"dojo/dom-construct",
		     	"dojo/dom",
		     	"dojo/domReady!"], function(domConstruct, dom, on){
		     		domConstruct.place("<div id='staChart' style='width:300px;height:200px;margin-top:5px;" +
		     				"position:absolute;z-index:2000;background-color:#FFFFFF'>" +
		     				"<div id ='legend1'></div>" +
		     				"</div>","map_element_statisticsChart","before");
		     	});
	//---选中单点要素，自动读取该监测点的监测数据---
	var monitSiteNameA = encodeURI(encodeURI(monitSiteName1));
	
	var monitSiteNameB = encodeURI(encodeURI(monitSiteName2));
	
	$.get("http://localhost:8080/testWeb/statisticsChart/stackedAreasChart/"+monitSiteNameA+"/"+monitSiteNameB,
			null,function(data){
			//3、回调函数接收并解析数据
			//3-1、获取对象	
				//解决中文乱码问题：后台将数据以UTF-8编码发送，前端解码
			var decodeData = decodeURIComponent(data);
			var obj = eval("("+decodeData+")");
			
			console.log(obj);
			//3-2、绘制堆叠面积图
			require(["dojox/charting/Chart",
			         "dojox/charting/themes/Dollar",
			         "dojox/charting/widget/Legend",
			         "dojox/charting/plot2d/StackedAreas",
			         "dojox/charting/plot2d/Markers",
			         "dojox/charting/axis2d/Default",
			         "dojox/charting/action2d/Tooltip",
			         "dojox/charting/action2d/Magnify",
				 	 "dojox/charting/action2d/MoveSlice",
			         "dojo/domReady"
			         ],function(Chart,theme){
				
				//创建一个新的图表
		 		var chart1 = new Chart("staChart",{
		 			title:"Stacked Areas Chart("+dijit.byId('fieldSelect').get('value')+")",
		 			titlePos:top,
		 			titleGap:25,
		 			titleFont:"normal normal bold 12pt Tahoma",
		 			
		 		});
		 		
		 		//为图表添加基础组件，确认图表类型
		 		chart1.addPlot("default", {
		 				type: "StackedAreas",
		 				markers:true,
		 				tension:"S",
		 				//show lines
		 				lines:true
		 			});
		 		
		 		chart1.setTheme(theme);
		 		
				//get the Data Series
				var benSeriesA = [];
				var benSeriesB = [];
		 		var benNameA = [];
		 		var benNameB = [];
		 		
		 		if(dijit.byId('fieldSelect').get('value') == "quantity"){
		 		
			 			for(var j = 0;j <= obj.seriesA.length-1;j++){
			 				console.log(obj.seriesA[j]);
			 				benSeriesA[j] = obj.seriesA[j].quantity;
				 			benNameA[j] = obj.seriesA[j].benName;
			 				
				 		}
			 			for(var j = 0;j <= obj.seriesB.length-1;j++){
			 				benSeriesB[j] = obj.seriesB[j].quantity;
			 				benNameB[j] = obj.seriesB[j].benName;
			 				
			 			}
			 			
			 		
				 		console.log(benSeriesA);
				 		console.log(benSeriesB);
				 		console.log(benNameA);
				 		console.log(benNameB);
		 		}
		 			
		 		else{
		 			for(var j = 0;j <= obj.seriesA.length-1;j++){
		 				console.log(obj.seriesA[j]);
		 				benSeriesA[j] = obj.seriesA[j].biomass;
			 			benNameA[j] = obj.seriesA[j].benName;	
			 		}
		 			for(var j = 0;j <= obj.seriesB.length-1;j++){
		 				benSeriesB[j] = obj.seriesB[j].biomass;
		 				benNameB[j] = obj.seriesB[j].benName;
		 			}
		 			
				}
		 		
		 		/*var benNameFunc = function(text,value,precision){
		 				 			
		 			return text;
		 		}*/
		 		var benNameFunc = new Array();
		 		
		 		if(benNameB.length >= benNameA.length){
		 			//获取X轴上的labels（生物种类）
		 			for(var i = 0; i <= benNameB.length; i++){
			 			benNameFunc[i] = {value:i,text:benNameB[i]};
			 		}
			 		
			 		console.log(benNameFunc);
			 		
			 		//添加标尺
			 		chart1.addAxis("x",{
			 						/*labelFunc:benNameFunc,*/
			 						labels:benNameFunc,
			 						font:"normal normal bold 10pt Tahoma",
			 						maxLabelSize:50,
			 						labelSizeChange:true
			 					});
			 		
		 		}
		 		else{
		 			//获取X轴上的labels，生物种类
		 			for(var i = 0; i <= benNameA.length; i++){
			 			benNameFunc[i] = {value:i,text:benNameA[i]};
			 		}
		 			
		 			console.log(benNameFunc);
		 			console.log("A");
		 			//添加标尺
			 		chart1.addAxis("x",{
			 					/*labelFunc:benNameFunc,*/
 								labels:benNameFunc,
 								font:"normal normal bold 10pt Tahoma",
 								maxLabelSize:50,
 								labelSizeChange:true
			 					});
			 		
		 		}
		 		chart1.addAxis("y", {
						vertical: true, 
						fixLower: "major", 
						fixUpper: "major"});
		 		
		 		
				chart1.addSeries(monitSiteName1,benSeriesA);
				chart1.addSeries(monitSiteName2,benSeriesB);
				
				//Add the legend
				/*var legend = new dojox.charting.widget.Legend({chart:chart1 },"legend1");*/
				
				// Add the animation
				var toolTip = new dojox.charting.action2d.Tooltip(chart1,"default");
		 		var magnify = new dojox.charting.action2d.Magnify(chart1,"default");
				
				// Render the chart
				chart1.render();
				
			});
		
	});
	
}

//********************生成饼状图*********************
//*******查询单监测点的数据并获取生物量/数量大于0的物种*******
function pieChart(monitSiteName){
	require([
	     	"dojo/dom-construct",
	     	"dojo/dom",
	     	"dojo/domReady!"], function(domConstruct, dom, on){
	     		domConstruct.place("<div id='staChart' style='width:300px;height:200px;margin-top:5px;" +
	     				"position:absolute;z-index:2001;'>" +
	     				"</div>","map_element_statisticsChart","before");
	     	});
	
		
	//---选素，自动读取该监测点的监测数据---
	var monitSiteName = encodeURI(encodeURI(monitSiteName));
	
	 //2、将文本框中的数据以路径参数的形式发送到服务器端
	$.get("http://localhost:8080/testWeb/statisticsChart/pieChart/"+monitSiteName,null,
	function(data){
		//3、回调函数接收并解析数据
		//3-1、获取对象	
			//解决中文乱码问题：后台将数据以UTF-8编码发送，前端解码
		var decodeData = decodeURIComponent(data);
		
		var obj = eval(decodeData);
		var objLength = getJsonLength(obj);
		console.log(objLength);
		console.log(obj);
			require([
		 		"dojox/charting/Chart",
		 		"dojox/charting/axis2d/Default",
		 		"dojox/charting/plot2d/Pie",
		 		"dojox/charting/themes/PlotKit/blue",
		 		"dojox/charting/action2d/Tooltip",
		 		"dojox/charting/action2d/MoveSlice",
		 		"dojox/charting/themes/Claro",
		 		"dojo/ready",
		 		"dojo/domReady!",
		 		"dojo/dom",
		 		"dojo/parser"
		 		],
		 	function(Chart,Default,Pie,Claro,MoveSlice,ready){
				//创建一个新的图表
		 		var chart1 = new Chart("staChart",{
		 			title:"Pie Chart("+dijit.byId('fieldSelect').get('value')+")",
		 			titlePos:top,
		 			titleGap:25,
		 			titleFont:"normal normal bold 15pt Tahoma",
		 			
		 		});
		 		
		 		//为图表添加基础组件，确认图表类型
		 		chart1.addPlot("default", {
		 				type: Pie,
		 				font: "normal normal bold 8pt Tahoma",
		 				fontColor:"black",
		 				markers: true,
		 				labelStyle:"columns",
		 				labelOffset:0
		 			});
		 		chart1.setTheme(Claro);
		 		//添加标尺
		 		chart1.addAxis("x");
		 		chart1.addAxis("y", {
		 						min: 5000, 
		 						max: 30000, 
		 						vertical: true, 
		 						fixLower: "major", 
		 						fixUpper: "major"});
		 		//新建图例
		 		
		 		//填入数据，数据内容由后台经过SQL查询后，将符合条件的数据条目发送到该页面
		 		//获取JSON数据集中的每一个数据的ID值，组成新的集合
		 		
		 		var benSeries = [];
		 		var benName = [];
		 		if(dijit.byId('fieldSelect').get('value') == "quantity"){
		 			for(var i = 0;i<objLength-1;i++){
			 			benSeries[i] = obj[i].quantity;
			 			benName[i] = obj[i].benName;
			 		}
			 		console.log(benSeries+","+benName);
		 		}
		 		else{
		 			for(var i = 0;i<objLength-1;i++){
			 			benSeries[i] = obj[i].biomass;
			 			benName[i] = obj[i].benName;
			 		}
			 		console.log(benSeries+","+benName);
		 		}
		 		
		 		
		 		chart1.addSeries(benName, benSeries);
		 		var mag = new dojox.charting.action2d.Tooltip(chart1,"default");
		 		var mag1 = new dojox.charting.action2d.MoveSlice(chart1,"default");
		 		chart1.render();
		 		
			});
		});

}

//********************生成折线图*********************
//*******查询单监测点的某一物种不同时间的生物量/数量值*******
function lineChart(bioName){
	require([
		     	"dojo/dom-construct",
		     	"dojo/dom",
		     	"dojo/domReady!"], function(domConstruct, dom, on){
		     		domConstruct.place("<div id='staChart' style='width:300px;height:200px;margin-top:5px;" +
		     				"position:absolute;z-index:2000;'>" +
		     				"</div>","map_element_statisticsChart","before");
		     	});
		
			
		//---选素，自动读取该监测点的监测数据---
		var bioName = encodeURI(encodeURI(bioName));
		
		
		//2、将文本框中的数据以路径参数的形式发送到服务器端
		$.get("http://localhost:8080/testWeb/statisticsChart/lineChart/"+bioName,null,
		function(data){
			//3、回调函数接收并解析数据
			//3-1、获取对象	
				//解决中文乱码问题：后台将数据以UTF-8编码发送，前端解码
			var decodeData = decodeURIComponent(data);
			
			var obj = eval(decodeData);
			var objLength = getJsonLength(obj);
			console.log(objLength);
			console.log(obj);
			
			require([
			         "dojox/charting/Chart",
			         "dojox/charting/themes/Claro",
			         "dojox/charting/plot2d/Lines",
			         "dojox/charting/plot2d/Markers",
			         "dojox/charting/axis2d/Default",
			         "dojox/charting/action2d/Tooltip",
				 	 "dojox/charting/action2d/MoveSlice",
				 	 "dojox/charting/action2d/Magnify",
			         "dojo/domReady!"
			         ],function(Chart,theme,Lines,Markers,Default,MoveSlice,ready){
				//Data series = obj
				var lineChart = new Chart("staChart",{
					fill:'white',
		 			title:"Line Chart("+dijit.byId('bioSelect').get('value')+")",
		 			titlePos:top,
		 			titleGap:25,
		 			titleFont:"normal normal bold 15pt Tahoma",
		 			
		 		});
				//set the theme
				lineChart.setTheme(theme);
				//Add the default plot
				lineChart.addPlot("default",{
					type:Lines,
					markers:true
				});
				
				
				//填入数据，数据内容由后台经过SQL查询后，将符合条件的数据条目发送到该页面
		 		//获取JSON数据集中的每一个数据的ID值，组成新的集合
				var benSeries = [];
		 		var monitSiteName = [];
		 		if(dijit.byId('fieldSelect').get('value') == "quantity"){
		 			for(var i = 0;i<objLength-1;i++){
			 			benSeries[i] = obj[i].quantity;
			 			monitSiteName[i] = obj[i].monitSiteName;
			 		}
			 		console.log(benSeries+","+monitSiteName);
		 		}
		 		else{
		 			for(var i = 0;i<objLength-1;i++){
			 			benSeries[i] = obj[i].biomass;
			 			monitSiteName[i] = obj[i].monitSiteName;
			 		}
			 		console.log(benSeries+","+monitSiteName);
		 		}
		 		
		 		//获取X轴上的labels（监测地点）
		 		var siteNameFunc = new Array();
		 		for(var i = 0; i <= monitSiteName.length; i++){
			 			siteNameFunc[i] = {value:i,text:monitSiteName[i]};
			 		}
			 		console.log(siteNameFunc);
				
				
			 	//Add axes
				lineChart.addAxis("x",{
						labels:siteNameFunc,
						font:"normal normal bold 10pt Tahoma",
						maxLabelSize:50,
						labelSizeChange:true
 					});
				lineChart.addAxis("y",{vertical:true,fixLower:"major",fixUpper:"major"});
				
				//Add series of data
				lineChart.addSeries("years of monit",benSeries);
				// Add the animation
				var toolTip = new dojox.charting.action2d.Tooltip(lineChart,"default");
		 		var magnify = new dojox.charting.action2d.Magnify(lineChart,"default");
				
				
				//Render the chart
				lineChart.render();
				
	
			});
			
		});		
}



//******************显示已添加数据源******************
function addDataSeries(){
	//show or hide the Data Series Table
	var dataSeries = document.getElementById("dataSeriesTable");
	var dataSeriesICON = document.getElementById("showDataSeries");
	
	if(dataSeries.style.display == "none"){
			dataSeries.style.display = "";
			dataSeriesICON.src = "images/arrow-up.jpg";	
		}
	else{
			dataSeries.style.display = "none";
			dataSeriesICON.src = "images/arrow-down.jpg";	
		}
}
//***************添加数据系列(Data Series)****************
function addSeries(){
	require([
		     	"dojo/dom-construct",
		     	"dojo/dom",
		     	"dojo/domReady!"], function(domConstruct, dom, on){
					var site = dijit.byId('monitSiteSelect').get('displayedValue');
		
		     		domConstruct.place("<tr><td><input type='checkbox' name='checkbox'></td>" +
		     				"<td>A</td><td>"+site+"</td></tr>","seriesHead","after");
		     	});
}

//***************删除数据系列(Data Series)*****************
function deleteSeries(){
	var seriesTab = document.getElementById("seriesTable");

	//问题：每次循环都会删除一行<tr>，此时剩下的<tr>的行数就发生了变化。
	//比如：一共有四行数据，跳过第一行表头，在第一次循环后，delete tr[1],tr[2]-->tr[1],tr[3]-->tr[2]
	//这样一来，第二次循环对tr[2]的操作就是对初始表格中tr[3]的操作，直接跳过了初始的tr[2]
	for(var i = seriesTab.rows.length-1; i>= 1; i--){
		var seriesTabTr = seriesTab.getElementsByTagName("tr")[i];
		/*console.log(seriesTabTr);*/
		var checkBox = seriesTabTr.childNodes[0].childNodes[0];
		/*console.log(checkBox);*/
		if(checkBox.checked){
			seriesTabTr.parentNode.removeChild(seriesTabTr);
			
		}
	}
	
}

//***************REST API 返回的JSON数据转换函数（转换为chart能够接受的数据系列）****************
function _valTrans(){
	
}



/**
 * Author: zhangke
 * Version: 1.0.0
 
OpenLayers.ProxyHost="Proxy.jsp?url=";
OpenLayers.Lang.setCode("zh-CN");
*/

/**
 * Author：Eric
 * Log：
 * 	13th Aug,2014:
 * 		完成部分：调用Geoserver上发布的数据；解决了Geoserver发布数据时Tomcat内存溢出的问题；
 * 		问题1：底图的默认坐标系与实际经纬度之间的关系；
 * 		问题2：尽快绘制出较为美观的图层，发布到Geoserver上
 */

var map;


function init_SC() 
{
/*	var navigation_Control = new OpenLayers.Control.Navigation({});
	
	var control_panel = new OpenLayers.Control.Panel({
		div:document.getElementById("ol_ToolPanel")
		
	});*/
	
	var controls_array = [
	     //new OpenLayers.Control.Attribution(),
	     new OpenLayers.Control.Navigation({}),
	     //new OpenLayers.Control.ZoomPanel(),
		 new OpenLayers.Control.Permalink(),
		 //new OpenLayers.Control.ZoomBox({keyMask}),
		 new OpenLayers.Control.Zoom(),
		
		 //new OpenLayers.Control.ZoomToMaxExtent(),
		 new OpenLayers.Control.MousePosition({})
	];
	
	
	map =new OpenLayers.Map
	(
		'map_element_statisticsChart',
		{
			controls:controls_array,
			projection:new OpenLayers.Projection("EPSG:900913"),
			//数据采用的坐标系 
			displayProjection:new OpenLayers.Projection("EPSG:4326"),
			resolutions: [1.40625,0.703125,0.3515625,0.17578125,0.087890625,0.0439453125],
            minScale: 50000000,
            maxResolution: "auto",
            maxExtent: new OpenLayers.Bounds(-180, -90, 180, 90),
            //maxResolution: 0.17578125,
            maxScale: 10000000,
            minResolution: "auto",
            minExtent: new OpenLayers.Bounds(-1, -1, 1, 1),
            minResolution: 0.0439453125,
			numZoomLevels:19,
			//maxExtent:new OpenLayers.Bounds(73.44696044921875, 6.318641185760498, 135.08583068847656, 53.557926177978516),
			units:"degrees",
			
		}
	);
	
	//OpenStreetMap
	var osm=new OpenLayers.Layer.OSM();
	
	//new Bing Map 
	var apiKey="AiCFlqRDRZfAVfA5kpqSsUcecocDIseUSrtU5hMGzpvsS4gd3D8noxpda4zl4wbY";
	var aerial=new OpenLayers.Layer.Bing
	(
		{
			key:apiKey,
			type:"AerialWithLabels",
			minZoomLevel: 0, numZoomLevels: 8,
		}
		
	);
	
	/**
	 * Add tools based on controls
	 */

	map.addControl(new OpenLayers.Control.ScaleLine());
    var overview_map = new OpenLayers.Control.OverviewMap({
    	size:new OpenLayers.Size(200,120),
    	minRectSize:10,
    	autoPan:true,
    	minRatio:6,
    	maxRatio:20
    });
    map.addControls([
        overview_map,
        //new OpenLayers.Control.NavToolbar(),
        new OpenLayers.Control.NavigationHistory(),
        new OpenLayers.Control.KeyboardDefaults(),
        new OpenLayers.Control.LayerSwitcher()
        
    ]);
		            
    
    //*****STYLE OF FEATURE*****
    //monitSite-Style
    var monitSiteUnselected_Style = new OpenLayers.Style({
    	fillColor: "#6699FF",
		fillOpacity: .8,
		strokeColor: "#66CCFF",
		strokeWidth: 3,
		pointRadius: 4,
		
		//label properties
		label:"${Name}",
		labelSelect:false,
		labelAlign:"bl",
		fontFamily:"sans-serif",
		fontColor:"#FFFFFF",
		fontWeight:"bold",
		fontSize:"12px"
    });
    
    var monitSiteSelected_Style = new OpenLayers.Style({
    	fillColor: "#FFB90F",
		fillOpacity: .8,
		strokeColor: "#FFB90F",
		strokeWidth: 3,
		pointRadius: 9,
			//label properties
		label:"${Name}",
		labelSelect:false,
		labelAlign:"bl",
		fontFamily:"sans-serif",
		fontColor:"#FFFFFF",
		fontWeight:"bold",
		fontSize:"15px"
    });
    
    
    //river-Style
    var river_Style = new OpenLayers.Style({
    	
		strokeColor: "#0000FF",
		strokeWidth: 2,
			//label properties
		//label:"${name}",
		//labelSelect:false,
		//labelAlign:"bl",
		//fontFamily:"sans-serif",
		//fontColor:"#FFFFFF",
		//fontWeight:"bold",
		//fontSize:"10px"
    });
    
    //boundOfProvince_Style
    var boundOfProvince_Style = new OpenLayers.Style({
    	fillColor: "#B3EE3A",
		fillOpacity: 0.3,
		strokeColor: "#FFFFFF",
		strokeWidth: 3,
		strokeOpacity:0
    });
    
    
    var river_Style_Map = new OpenLayers.StyleMap({
		'default':river_Style
		
	});
    
    var monitSiteUnselected_Style_Map = new OpenLayers.StyleMap({
    	'default':monitSiteUnselected_Style,
    	'select':monitSiteSelected_Style
    });
    
    var boundOfProvince_Style_Map = new OpenLayers.StyleMap({
    	'default':boundOfProvince_Style
    });
    
    
    //*****END-SYTLE*****
	
	 //********WFS:MonitSite-Points Layer*********  
	 var monitSitePoints = new OpenLayers.Layer.Vector("AFDS:monitSitePoints",{
		 styleMap:monitSiteUnselected_Style_Map,
	     strategies:[new OpenLayers.Strategy.Fixed()],
	     projection:new OpenLayers.Projection("EPSG:4326"),
	     protocol:new OpenLayers.Protocol.WFS({
	     version:"1.0.0",
	     url:"http://localhost:8080/geoserver/wfs",
	     featureType:"monitSitePoints",
	     featurePrefix:"AFDS",
	     featureNS1:"http://localhost:8080/AFDS/spatialData",
	     srsName:"EPSG:4326",
	     geometryName:"the_geom"
	    })
	});	
	 
	 
	var riverOfSinKiang = new OpenLayers.Layer.Vector("AFDS:riverSinKiang",{
		 styleMap:river_Style_Map,
		 strategies:[new OpenLayers.Strategy.Fixed()],
	     projection:new OpenLayers.Projection("EPSG:4326"),
	     protocol:new OpenLayers.Protocol.WFS({
	     version:"1.0.0",
	     url:"http://localhost:8080/geoserver/wfs",
	     featureType:"riverSinKiang",
	     featurePrefix:"AFDS",
	     featureNS1:"http://localhost:8080/AFDS/spatialData",
	     srsName:"EPSG:4326",
	     geometryName:"the_geom"
	    })
	});
	 
	
	var boundOfProvince = new OpenLayers.Layer.Vector("AFDS:boundOfProvince",{
		 styleMap:boundOfProvince_Style_Map,
		 strategies:[new OpenLayers.Strategy.Fixed()],
	     projection:new OpenLayers.Projection("EPSG:4326"),
	     protocol:new OpenLayers.Protocol.WFS({
	     version:"1.0.0",
	     url:"http://localhost:8080/geoserver/wfs",
	     featureType:"province",
	     featurePrefix:"AFDS",
	     featureNS1:"http://localhost:8080/AFDS/spatialData",
	     srsName:"EPSG:4326",
	     geometryName:"the_geom"
	    }),
	    filter : new OpenLayers.Filter.Comparison({  
        type : OpenLayers.Filter.Comparison.EQUAL_TO,  
        property : "NAME",  
        value : "新疆维吾尔自治区"  
   })  	
		
	});
	
    //********WMS:set test layer:province*********
//    var boundOfProvince = new OpenLayers.Layer.WMS(
//            "AFDS:province - Tiled", "http://localhost:8080/geoserver/AFDS/wms",
//            {
//                "LAYERS": 'AFDS:province',
//                transparent: "true",
//                "STYLES": '',
//                format: "image/png"
//            },
//            {
//                buffer: 0,
//                displayOutsideMaxExtent: true,
//                isBaseLayer: false,
//                yx : {'EPSG:900913' : true}
//            } 
//        );
    

        var secondRiver = new OpenLayers.Layer.WMS(
                "AFDS:secondRivers", "http://localhost:8080/geoserver/AFDS/wms",
                {
                    "LAYERS": 'AFDS:secondRiver',
                    transparent: "true",
                    "STYLES": '',
                    format: "image/png"
                },
                {
                	buffer: 0,
                    displayOutsideMaxExtent: true,
                    isBaseLayer: false,
                   yx : {'EPSG:900913' : true}
                } 
            ); 
       	 
	createPopup(monitSitePoints);
	
    map.addLayers([aerial,boundOfProvince,secondRiver,riverOfSinKiang,monitSitePoints]);
    
    map.setCenter(new OpenLayers.LonLat(9636569, 5787649), 6);
    //map.zoomToMaxExtent();
    //map.setCenter(new OpenLayers.LonLat(86.01292, 41.14358), 3); 
}



//*********Popup*********   
function createPopup(baseLayer){
	  //Add select feature control required to trigger events on the vector layer
	    var selectControl = new OpenLayers.Control.SelectFeature(baseLayer,{
	    	hover:false,
	    	clickout:true,
	    	onSelect:function(feature){
	    		var layer = feature.layer;
	    		layer.drawFeature(feature);
	    		map.zoomTo(6,feature.geometry.getBounds().getCenterLonLat());
	    		map.setCenter(feature.geometry.getBounds().getCenterLonLat(),7);
	        
	    		var content = "<div><strong>编号</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + feature.attributes.ID +
	    		"<br/><br/><strong>采样地点</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.Name +"</div>"+
	    		"<br/><strong>地理位置</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.EarthLo + "°E"
	    		+ "  ,  " + feature.attributes.NorthLa + "°N"+"<br/><br/><strong>监测数据</strong>"
	    		+"&nbsp;&nbsp;&nbsp;"
	    		+"<a href='../queryMonitData/index'>>>>>点击这里<<<</a>"
	    		+"</div>";
	    		
	    		
	    		getMonitDataBySite(feature.attributes.Name);
	    		
	    		var popup = new OpenLayers.Popup.FramedCloud(
	        		feature.id+"_popup",
    				feature.geometry.getBounds().getCenterLonLat(),
    				new OpenLayers.Size(250,100),
    				content,
    				null,
    				true,
    				function(){selectControl.unselectAll();});
    			popup.setBorder("#6699FF solid 2px");
    			popup.setBackgroundColor("#CCDDFF");
    			popup.setOpacity(0.9);
    			popup.addCloseBox();
    			
    			feature.popup = popup;
    			
    			map.addPopup(popup);
	                    },
	      onUnselect: function(feature) {
	            var layer = feature.layer;
	            //feature.style.fillOpacity = 0.7;
	            //feature.style.pointRadius = 5;
	            feature.renderIntent = null;
	            layer.drawFeature(feature);
	            map.removePopup(feature.popup);
	            document.getElementById("monitSiteSelected").innerHTML = "";
	           
	           }
	        });
	    map.addControl(selectControl);
	    
	    selectControl.activate();
	   
	    
}
//***********popup end**************



//*****简单实现基于属性的空间查询******



//************获取选中监测点中的监测数据*************
/**
 * 问题：有些地点名称是带括号的，比如：托洪台水库(沿岸)，但在监测点的矢量数据上并不包括括号以及括号内的内容，
 * 导致很多地点的数据无法查询
 * 
 */


	//---单点要素 end---
	   









