/**
 * author:Eric_Liu
 */

var map;

function init(){
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
		'map_element_index',
		{
			controls:controls_array,
			projection:new OpenLayers.Projection("EPSG:900913"),
			//数据采用的坐标系 
			displayProjection:new OpenLayers.Projection("EPSG:4326"),
			resolutions: [1.40625,0.703125,0.3515625,0.17578125,0.087890625,0.0439453125],
            minScale: 50000000,
            maxResolution: "auto",
            maxExtent: new OpenLayers.Bounds(-180, -90, 180, 90),
            maxResolution: 0.17578125,
            maxScale: 10000000,
            minResolution: "auto",
            minExtent: new OpenLayers.Bounds(-1, -1, 1, 1),
            minResolution: 0.0439453125,
			numZoomLevels:30,
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
			minZoomLevel: 0, numZoomLevels: 40,
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
        new OpenLayers.Control.NavToolbar(),
        new OpenLayers.Control.NavigationHistory(),
        new OpenLayers.Control.KeyboardDefaults(),
        new OpenLayers.Control.LayerSwitcher()
        
    ]);
    
    map.addLayers([osm]);
    
    map.setCenter(new OpenLayers.LonLat(9636569, 5787649), 6);
    
}