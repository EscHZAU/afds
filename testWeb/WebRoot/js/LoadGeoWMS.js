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
	        
	    		var content = "<div><strong>���</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + feature.attributes.ID +
	    		"<br/><br/><strong>�����ص�</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.Name +"</div>"+
	    		"<br/><strong>����λ��</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.EarthLo + "��E"
	    		+ "  ,  " + feature.attributes.NorthLa + "��N"+"<br/><br/><strong>�������</strong>"
	    		+"&nbsp;&nbsp;&nbsp;"
	    		+"<a onclick='zoomToDataTable();'>>>>�������<<<</a>"
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



//*****��ʵ�ֻ������ԵĿռ��ѯ******
var tempLayer;
function clearFeatures(){
	if(tempLayer != null){
		tempLayer.removeAllFeatures();
		map.removeLayer(tempLayer);
	}
}


function queryBasedProperty(){
	//***�жϲ�ѯ�ؼ����Ƿ�Ϊ��****
	searchstr = document.getElementById("monitSiteSelected").value;  
    if (searchstr == null || searchstr == "") {  
    	tempLayer.removeAllFeatures();
        alert("�����������ؼ��֣�");
        return;  
    }
    
    else{
    	//***���ؼ��ֲ�Ϊ�գ���������в�ѯ****
    	if(tempLayer != null){
    		tempLayer.removeAllFeatures();
    		map.removeLayer(tempLayer);
    	}
	 
	    
	  //*************��ѯͼ���Ҫ����ʽ����*************
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
	     * �����������ڿ����õ�ͼ�ϵ��Ǹ�����pointҪ���ˣ���������
	     * ��ע��OpenLayers.Layer.Vector.onFeatureInsert:�����µ�Ҫ�ز����ʱ��ִ�к�����
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
    	        
    	    		var content = "<div><strong>���</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + feature.attributes.ID +
    	    		"<br/><br/><strong>�����ص�</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.Name +"</div>"+
    	    		"<br/><strong>����λ��</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.EarthLo + "��E"
    	    		+ "  ,  " + feature.attributes.NorthLa + "��N"+"<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
    	    		+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
    	    		+"<a href = ''>��ȡ������Ϣ>>></a>"
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
//    		var content = "<div><strong>���</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + feature.attributes.ID +
//	        "<br/><br/><strong>�����ص�</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.Name +"</div>"+
//	        "<br/><strong>����λ��</strong>&nbsp;&nbsp;&nbsp;" + feature.attributes.EarthLo + "��E"
//	        + "  ,  " + feature.attributes.NorthLa + "��N"
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


//************��ȡѡ�м����еļ������*************
/**
 * ���⣺��Щ�ص������Ǵ����ŵģ����磺�к�̨ˮ��(�ذ�)�����ڼ����ʸ�������ϲ������������Լ������ڵ����ݣ�
 * ���ºܶ�ص�������޷���ѯ
 * 
 */

function getMonitDataBySite(monitSiteName){
	//---ѡ�е���Ҫ�أ��Զ���ȡ�ü���ļ������---
	var monitSiteName = encodeURI(encodeURI(monitSiteName));
	
	 //2�����ı����е�������·����������ʽ���͵���������
	$.get("http://localhost:8080/testWeb/queryMonitData/query/"+monitSiteName,null,
	function(data){
		//3���ص��������ղ���������
		//3-1����ȡ����	
			//��������������⣺��̨��������UTF-8���뷢�ͣ�ǰ�˽���
		var decodeData = decodeURIComponent(data);
		
		var obj = eval(decodeData);
		var objLength = getJsonLength(obj);
		console.log(objLength);
		
		if(objLength != 1){	//�жϲ�ѯ���ݵ�������������Ӧ�����������
		//ѭ�������̨���͵Ĳ�ѯ���������䵽���ݱ���
			$("#MonitBen").html("<tr><th width='auto' abbr='id'>���</th><th width='auto' abbr='benName'>����</th><th width='auto' abbr='monitSiteName'>���ص�</th><th width='auto' abbr='quantity'>����</th><th width='auto' abbr='biomass'>������</th><th width='auto'>more</th></tr>");
			
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
	//---����Ҫ�� end---
	
}   









