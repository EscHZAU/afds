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

function init() 
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
		'map_element',
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

//*********Layer Management #FFB90F*********
function selectedFeatureByDate(){
	var layer = map.getLayersByName("AFDS:monitSitePoints");
	
	var monitSiteSelected_Style = new OpenLayers.Style({
    	fillColor: "red",
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
	
	 var monitSiteUnselected_Style_Map_2 = new OpenLayers.StyleMap({
	    	'default':monitSiteSelected_Style
	    });

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
	    		+"<a onclick='zoomToDataTable();'>>>>点击这里<<<</a>"
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
	    
	    //Editing the Vector-Layer
	    var editingToolbarControl = new OpenLayers.Control.EditingToolbar(baseLayer);
	    map.addControl(editingToolbarControl);
	    
	    selectControl.activate();
	    editingToolbarControl.activate();
	    
}
//***********popup end**************



//*****简单实现基于属性的空间查询******
var tempLayer;
function clearFeatures(){
	if(tempLayer != null){
		tempLayer.removeAllFeatures();
		map.removeLayer(tempLayer);
	}
}


function queryBasedProperty(){
	//***判断查询关键字是否为空****
	searchstr = document.getElementById("monitSiteSelected").value;  
    if (searchstr == null || searchstr == "") {  
    	tempLayer.removeAllFeatures();
        alert("请输入搜索关键字！");
        return;  
    }
    
    else{
    	//***若关键字不为空，则继续进行查询****
    	if(tempLayer != null){
    		tempLayer.removeAllFeatures();
    		map.removeLayer(tempLayer);
    	}
	 
	    
	  //*************查询图层的要素样式配置*************
    	var monitSitePoints_Style = new OpenLayers.Style({
			fillColor: "#FFB90F",
			fillOpacity: .8,
			strokeColor: "#FFB90F",
			strokeWidth: 3,
			pointRadius: 9,
				//label properties
			/*label:"${Name}",
			labelSelect:false,
			labelAlign:"rb",
			fontFamily:"sans-serif",
			fontColor:"#FFFFFF",
			fontWeight:"bold",
			fontSize:"15px"*/
		});
    	
		/*var monitSitePoints_Style_selected = new OpenLayers.Style({
			fillColor: "#669933",
			fillOpacity: .8,
			strokeColor: "#aaee77",
			strokeWidth: 3,
			pointRadius: 9,
				//label properties
			label:"${Name}",
			labelSelect:true,
			//labelAlign:"bl",
			fontFamily:"sans-serif",
			fontColor:"#FFFFFF",
			fontWeight:"bold",
			fontSize:"15px"
		});*/

		var monitSitePoints_Style_Map = new OpenLayers.StyleMap({
			'default':monitSitePoints_Style,
			/*"select": monitSitePoints_Style_selected*/
		});

		
	    
	    tempLayer = new OpenLayers.Layer.Vector("monitSiteSelected",{
	    	transparent:"true",
	    	strategies : [new OpenLayers.Strategy.BBOX()],
	    	projection:new OpenLayers.Projection("EPSG:4326"),
	    	protocol : new OpenLayers.Protocol.WFS({
	    		version:"1.0.0",
	   	     	url:"http://localhost:8080/geoserver/wfs",
	   	     	featureType:"monitSitePoints",
	   	     	featurePrefix:"AFDS",
	   	     	featureNS1:"http://localhost:8080/AFDS/spatialData",
	   	     	srsName:"EPSG:4326",
	   	     	geometryName:"the_geom"
	    	}),
	    	styleMap:monitSitePoints_Style_Map,
	    	filter : new OpenLayers.Filter.Comparison({  
	             type : OpenLayers.Filter.Comparison.LIKE,  
	             property : "Name",  
	             value : "*" + searchstr + "*"  
	        })  	
	    });
	    
	    
	    /*
	     * 哈哈，我终于可以拿到图上的那个新增point要素了！！！！！
	     * 备注：OpenLayers.Layer.Vector.onFeatureInsert:当有新的要素插入的时候，执行函数；
	     */
	    tempLayer.onFeatureInsert = function(feature){
	    	map.zoomTo(6,feature.geometry.getBounds().getCenterLonLat());
    		map.setCenter(feature.geometry.getBounds().getCenterLonLat(),7);
    		map.setLayerZIndex(tempLayer,1);
    		/*var selectControl_queryForName = new OpenLayers.Control.SelectFeature(tempLayer,{
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
    	    		+ "  ,  " + feature.attributes.NorthLa + "°N"+"<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
    	    		+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
    	    		+"<a href = ''>获取更多信息>>></a>"
    	    		+"</div>";
    	                        
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
        			
        			document.getElementById("monitSiteSelected").value = "";
    	                    },
    	      onUnselect: function(feature) {
    	            var layer = feature.layer;
    	            //feature.style.fillOpacity = 0.7;
    	            //feature.style.pointRadius = 5;
    	            feature.renderIntent = null;
    	            layer.drawFeature(feature);
    	            map.removePopup(feature.popup);
    	            
    	            //map.setLayerZIndex(tempLayer,1);
    	            //map.removeLayer(tempLayer);
    	           }
    	        });
    	    map.addControl(selectControl_queryForName);*/
    	    
    	    //Editing the Vector-Layer
    	    var editingToolbarControl = new OpenLayers.Control.EditingToolbar(tempLayer);
    	    map.addControl(editingToolbarControl);
    	    
    	    /*selectControl_queryForName.activate();*/
    	    editingToolbarControl.activate();	
//    		var content = "<div><strong>编号</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + feature.attributes.ID +
//	        "<br/><br/><strong>采样地点</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.Name +"</div>"+
//	        "<br/><strong>地理位置</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.EarthLo + "°E"
//	        + "  ,  " + feature.attributes.NorthLa + "°N"
//	        +"</div>";
//
//    		
//    		var popup = new OpenLayers.Popup.FramedCloud(
//    				feature.id+"_popup",
//    				feature.geometry.getBounds().getCenterLonLat(),
//    				new OpenLayers.Size(250,100),
//    				content,
//    				null,
//    				true,
//    				null);
//    		popup.setBorder("#999999 solid 1px");
//   	        feature.popup = popup;
//   	        popup.addCloseBox();
//   	        
//   	        map.addPopup(popup);
	    }
	    
	    map.addLayer(tempLayer);
	    //
    }
	  
}


//************获取选中监测点中的监测数据*************
/**
 * 问题：有些地点名称是带括号的，比如：托洪台水库(沿岸)，但在监测点的矢量数据上并不包括括号以及括号内的内容，
 * 导致很多地点的数据无法查询
 * 
 */

function getMonitDataBySite(monitSiteName){
	//---选中单点要素，自动读取该监测点的监测数据---
	var monitSiteName = encodeURI(encodeURI(monitSiteName));
	
	 //2、将文本框中的数据以路径参数的形式发送到服务器端
	$.get("http://localhost:8080/testWeb/queryMonitData/query/"+monitSiteName,null,
	function(data){
		//3、回调函数接收并解析数据
		//3-1、获取对象	
			//解决中文乱码问题：后台将数据以UTF-8编码发送，前端解码
		var decodeData = decodeURIComponent(data);
		
		var obj = eval(decodeData);
		var objLength = getJsonLength(obj);
		console.log(objLength);
		
		if(objLength != 1){	//判断查询数据的所属表格，清空相应表格，填入数据
		//循环读入后台发送的查询结果，并填充到数据表中
			$("#MonitBen").html("<tr><th width='auto' abbr='id'>编号</th><th width='auto' abbr='benName'>名称</th><th width='auto' abbr='monitSiteName'>监测地点</th><th width='auto' abbr='quantity'>数量</th><th width='auto' abbr='biomass'>生物量</th><th width='auto'>more</th></tr>");
			
			var monitItem;
		
			for(var i = 0; i<objLength-1;i++)
			{
				monitItem = "<tr class='initTr' ondblclick='mouseOver(this)' onclick='mouseOut(this)'><td>"+i+"</td><td>"
				+obj[i].benName+"</td><td>"+obj[i].monitSiteName+"</td><td>"+obj[i].quantity+"</td><td>"+obj[i].biomass+
				"</td><td>"+"<a href=''>more</a></td></tr>";
		
				$("#MonitBen").append(monitItem);
			};
		}
		
	});
	//---单点要素 end---
	
}   









