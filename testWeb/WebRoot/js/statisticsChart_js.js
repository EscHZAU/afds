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
		  			
		  		//��ȡͼ������
		  		var chartType = dijit.byId('chartTypeSelect').get('displayedValue');
		  		
		  		//��ȡ����ԴData Series���
		  		var seriesTab = document.getElementById("seriesTable");
		  		
		  		//��ȡ��������
		  		var bioSelect = document.getElementById("bioSelect");
		  		
		  		//��ȡ�û����õ�����Դ
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
		  			/*if(chartType == '�ѵ����ͼ')
		  			{
		  				stackedAreasChart(site[1],site[2]);
		  			}
		  			else{  				
		  				pieChart(site[1]);
		  			}*/
		  		switch(chartType){
		  			case '�ѵ����ͼ':
		  				stackedAreasChart(site[1], site[2])
		  				break;
		  			case '��״ͼ':
		  				pieChart(site[1])
		  				break;
		  			case '����ͼ':
		  				lineChart(bioName)
		  				break;
		  			}
		  			
		  		}
		  		else{
		  			/*pieChart(site);*/
		  			/*if(chartType == '�ѵ����ͼ')
		  			{
		  				stackedAreasChart(site[1],site[2]);
		  			}
		  			else{  				
		  				pieChart(site[1]);
		  			}*/
		  			switch(chartType){
		  				case '�ѵ����ͼ':
		  					stackedAreasChart(site[1], site[2])
		  					break;
		  				case '��״ͼ':
		  					pieChart(site[1])
		  					break;
		  				case '����ͼ':
			  				lineChart(bioName)
			  				break;
		  			}
		  		}
		  			
		  	});
}
			
//************ɾ�����ɵ�ͼ��DOM�ڵ㣨�����ӽڵ㣩************
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

//*******************���ɶѵ����ͼ********************
//**********�Աȶ������֮�����������������������**********
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
	//---ѡ�е���Ҫ�أ��Զ���ȡ�ü���ļ������---
	var monitSiteNameA = encodeURI(encodeURI(monitSiteName1));
	
	var monitSiteNameB = encodeURI(encodeURI(monitSiteName2));
	
	$.get("http://localhost:8080/testWeb/statisticsChart/stackedAreasChart/"+monitSiteNameA+"/"+monitSiteNameB,
			null,function(data){
			//3���ص��������ղ���������
			//3-1����ȡ����	
				//��������������⣺��̨��������UTF-8���뷢�ͣ�ǰ�˽���
			var decodeData = decodeURIComponent(data);
			var obj = eval("("+decodeData+")");
			
			console.log(obj);
			//3-2�����ƶѵ����ͼ
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
				
				//����һ���µ�ͼ��
		 		var chart1 = new Chart("staChart",{
		 			title:"Stacked Areas Chart("+dijit.byId('fieldSelect').get('value')+")",
		 			titlePos:top,
		 			titleGap:25,
		 			titleFont:"normal normal bold 12pt Tahoma",
		 			
		 		});
		 		
		 		//Ϊͼ����ӻ��������ȷ��ͼ������
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
		 			//��ȡX���ϵ�labels���������ࣩ
		 			for(var i = 0; i <= benNameB.length; i++){
			 			benNameFunc[i] = {value:i,text:benNameB[i]};
			 		}
			 		
			 		console.log(benNameFunc);
			 		
			 		//��ӱ��
			 		chart1.addAxis("x",{
			 						/*labelFunc:benNameFunc,*/
			 						labels:benNameFunc,
			 						font:"normal normal bold 10pt Tahoma",
			 						maxLabelSize:50,
			 						labelSizeChange:true
			 					});
			 		
		 		}
		 		else{
		 			//��ȡX���ϵ�labels����������
		 			for(var i = 0; i <= benNameA.length; i++){
			 			benNameFunc[i] = {value:i,text:benNameA[i]};
			 		}
		 			
		 			console.log(benNameFunc);
		 			console.log("A");
		 			//��ӱ��
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

//********************���ɱ�״ͼ*********************
//*******��ѯ����������ݲ���ȡ������/��������0������*******
function pieChart(monitSiteName){
	require([
	     	"dojo/dom-construct",
	     	"dojo/dom",
	     	"dojo/domReady!"], function(domConstruct, dom, on){
	     		domConstruct.place("<div id='staChart' style='width:300px;height:200px;margin-top:5px;" +
	     				"position:absolute;z-index:2001;'>" +
	     				"</div>","map_element_statisticsChart","before");
	     	});
	
		
	//---ѡ�أ��Զ���ȡ�ü���ļ������---
	var monitSiteName = encodeURI(encodeURI(monitSiteName));
	
	 //2�����ı����е�������·����������ʽ���͵���������
	$.get("http://localhost:8080/testWeb/statisticsChart/pieChart/"+monitSiteName,null,
	function(data){
		//3���ص��������ղ���������
		//3-1����ȡ����	
			//��������������⣺��̨��������UTF-8���뷢�ͣ�ǰ�˽���
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
				//����һ���µ�ͼ��
		 		var chart1 = new Chart("staChart",{
		 			title:"Pie Chart("+dijit.byId('fieldSelect').get('value')+")",
		 			titlePos:top,
		 			titleGap:25,
		 			titleFont:"normal normal bold 15pt Tahoma",
		 			
		 		});
		 		
		 		//Ϊͼ����ӻ��������ȷ��ͼ������
		 		chart1.addPlot("default", {
		 				type: Pie,
		 				font: "normal normal bold 8pt Tahoma",
		 				fontColor:"black",
		 				markers: true,
		 				labelStyle:"columns",
		 				labelOffset:0
		 			});
		 		chart1.setTheme(Claro);
		 		//��ӱ��
		 		chart1.addAxis("x");
		 		chart1.addAxis("y", {
		 						min: 5000, 
		 						max: 30000, 
		 						vertical: true, 
		 						fixLower: "major", 
		 						fixUpper: "major"});
		 		//�½�ͼ��
		 		
		 		//�������ݣ����������ɺ�̨����SQL��ѯ�󣬽�����������������Ŀ���͵���ҳ��
		 		//��ȡJSON���ݼ��е�ÿһ�����ݵ�IDֵ������µļ���
		 		
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

//********************��������ͼ*********************
//*******��ѯ�������ĳһ���ֲ�ͬʱ���������/����ֵ*******
function lineChart(bioName){
	require([
		     	"dojo/dom-construct",
		     	"dojo/dom",
		     	"dojo/domReady!"], function(domConstruct, dom, on){
		     		domConstruct.place("<div id='staChart' style='width:300px;height:200px;margin-top:5px;" +
		     				"position:absolute;z-index:2000;'>" +
		     				"</div>","map_element_statisticsChart","before");
		     	});
		
			
		//---ѡ�أ��Զ���ȡ�ü���ļ������---
		var bioName = encodeURI(encodeURI(bioName));
		
		
		//2�����ı����е�������·����������ʽ���͵���������
		$.get("http://localhost:8080/testWeb/statisticsChart/lineChart/"+bioName,null,
		function(data){
			//3���ص��������ղ���������
			//3-1����ȡ����	
				//��������������⣺��̨��������UTF-8���뷢�ͣ�ǰ�˽���
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
				
				
				//�������ݣ����������ɺ�̨����SQL��ѯ�󣬽�����������������Ŀ���͵���ҳ��
		 		//��ȡJSON���ݼ��е�ÿһ�����ݵ�IDֵ������µļ���
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
		 		
		 		//��ȡX���ϵ�labels�����ص㣩
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



//******************��ʾ���������Դ******************
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
//***************�������ϵ��(Data Series)****************
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

//***************ɾ������ϵ��(Data Series)*****************
function deleteSeries(){
	var seriesTab = document.getElementById("seriesTable");

	//���⣺ÿ��ѭ������ɾ��һ��<tr>����ʱʣ�µ�<tr>�������ͷ����˱仯��
	//���磺һ�����������ݣ�������һ�б�ͷ���ڵ�һ��ѭ����delete tr[1],tr[2]-->tr[1],tr[3]-->tr[2]
	//����һ�����ڶ���ѭ����tr[2]�Ĳ������ǶԳ�ʼ�����tr[3]�Ĳ�����ֱ�������˳�ʼ��tr[2]
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

//***************REST API ���ص�JSON����ת��������ת��Ϊchart�ܹ����ܵ�����ϵ�У�****************
function _valTrans(){
	
}



/**
 * Author: zhangke
 * Version: 1.0.0
 
OpenLayers.ProxyHost="Proxy.jsp?url=";
OpenLayers.Lang.setCode("zh-CN");
*/

/**
 * Author��Eric
 * Log��
 * 	13th Aug,2014:
 * 		��ɲ��֣�����Geoserver�Ϸ��������ݣ������Geoserver��������ʱTomcat�ڴ���������⣻
 * 		����1����ͼ��Ĭ������ϵ��ʵ�ʾ�γ��֮��Ĺ�ϵ��
 * 		����2��������Ƴ���Ϊ���۵�ͼ�㣬������Geoserver��
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
			//���ݲ��õ�����ϵ 
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
        value : "�½�ά���������"  
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
	        
	    		var content = "<div><strong>���</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + feature.attributes.ID +
	    		"<br/><br/><strong>�����ص�</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.Name +"</div>"+
	    		"<br/><strong>����λ��</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.EarthLo + "��E"
	    		+ "  ,  " + feature.attributes.NorthLa + "��N"+"<br/><br/><strong>�������</strong>"
	    		+"&nbsp;&nbsp;&nbsp;"
	    		+"<a href='../queryMonitData/index'>>>>>�������<<<</a>"
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



//*****��ʵ�ֻ������ԵĿռ��ѯ******



//************��ȡѡ�м����еļ������*************
/**
 * ���⣺��Щ�ص������Ǵ����ŵģ����磺�к�̨ˮ��(�ذ�)�����ڼ����ʸ�������ϲ������������Լ������ڵ����ݣ�
 * ���ºܶ�ص�������޷���ѯ
 * 
 */


	//---����Ҫ�� end---
	   









