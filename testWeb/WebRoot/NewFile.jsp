<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新疆跨境河流水生生态及鱼类资源数据库系统全屏模式</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	 <link rel="stylesheet" href="./js/openLayers/theme/default/style.css" type="text/css" />
	 <link rel="stylesheet" href="./css/fullScreen.css" type="text/css" />

	<script type="text/javascript" src="js/openLayers/OpenLayers.js"></script>
	<script type="text/javascript" src="js/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="js/jQuery/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/LoadGeoWMS.js"></script>
	
	<script type="text/javascript">
	/* 	function init(){
		var map = new OpenLayers.Map("map_element");
		var layer = new OpenLayers.Layer.OSM("OpenStreetMap");
		map.addLayer(layer);
		map.addControl(new OpenLayers.Control.LayerSwitcher());
		map.setCenter(new OpenLayers.LonLat(0,0),2);
		
		//Create a vector layer and add some features
		var pointLayer = new OpenLayers.Layer.Vector("Features",
										{projection:"EPSG:900913"
			});
		
		map.addLayer(pointLayer);
		
		
		//add some random features to the vector layer
		var pointFeatures = [];
		for(var i=0; i< 150; i++) {
			var icon = Math.floor(Math.random());
			var px = Math.random() * 360 - 180;
			var py = Math.random() * 170 - 85;
			// Create a lonlat instance and transform it to
			// the map projection.
			var lonlat = new OpenLayers.LonLat(px, py);
			lonlat.transform(new OpenLayers.Projection("EPSG:4326"), new OpenLayers.Projection("EPSG:900913"));
			var pointGeometry = new OpenLayers.Geometry.Point(lonlat.lon,
			lonlat.lat);
			var pointFeature = new OpenLayers.Feature.Vector(pointGeometry,
			null, {
			pointRadius: 16,
			fillOpacity: 0.7,
			});
			
			pointFeatures.push(pointFeature);
	}
		pointLayer.addFeatures(pointFeatures);
		
		//Add select feature control required to trigger events on the vector layer
		var selectControl = new OpenLayers.Control.SelectFeature(pointLayer,{
			hover:true,
			onSelect:function(feature){
				var layer = feature.layer;
				feature.style.fillOpacity = 1;
				feature.style.pointRadius = 20;
				layer.drawFeature(feature);
				
				var content = "<div><strong>Feature:</strong><br/>" + feature.id +
					"<br/><br/><strong>Location:</strong><br/>" + feature.geometry +"</div>";
					
				var popup = new OpenLayers.Popup.FramedCloud(
						feature.id+"_popup",
						feature.geometry.getBounds().
						getCenterLonLat(),
						new OpenLayers.Size(250, 100),
						content,
						null,
						false,
						null);
				feature.popup = popup;
				map.addPopup(popup);
							},
				onUnselect: function(feature) {
						var layer = feature.layer;
						feature.style.fillOpacity = 0.7;
						feature.style.pointRadius = 16;
						feature.renderIntent = null;
						layer.drawFeature(feature);
						map.removePopup(feature.popup);
						}
				});
			map.addControl(selectControl);
			selectControl.activate();
		
} */
	</script>
	
  </head> 
  
  <body onload="init();">
  	 <div id = "map_element">
  	 	<div id ="spatialToolBar">
  	 		<a href="../testWeb/queryMonitData/index">
  	 			<img  id = "returnButton" src="images/return_smallsize.png">
  	 		</a>
  	 	</div>
  	 </div> 
  	 
  	<!-- CKEditor -->
  	<!--  <form action="../NewFile/fileUpload">
  	 	<textarea id = "editorTest" name = "editorTest">
  	 	请在此输入内容
  	 	</textarea>
  	 	<script type="text/javascript">
		CKEDITOR.replace('editorTest',
				{
			toolbar : 'Basic',
			uiColor : '#9AB8F3',
			height:'300px',
			width:'auto',
			//向下面的URL发送图片上传请求
			filebrowserUploadUrl:'http://lzj-pc:8080/testWeb/NewFile/fileUpload'
				});
    	</script>
    	<input type="submit" value="提交" />
    </form> -->
    <!-- End -->
  	
  </body>
</html>


