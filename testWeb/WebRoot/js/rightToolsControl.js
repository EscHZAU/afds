/**
 * @author Eric
 * @date wednesday, 22th April
 */


/**
 * 功能名称：时间轴
 */


//*********control time line**********
function controlTimeline(){
	require([
	  	   "dijit/registry",
	  	   "dojo/dom-construct",
	  	   "dojo/dom",
	  	   "dojo/domReady!"
	  	   ],function(dom){
	  		var vertSlider = dom.byId("vertSlider");
	  		
	  		if(vertSlider != null){
	  			destroyTimeline();
	  		}
	  		else{
	  			generateTimeline();
	  		}
	
	  	});
		
}


//delete the time line
function destroyTimeline(){
	require([
	   "dijit/registry"],function(){
		console.log(dijit.registry.byId("vertSlider"));
		
		dijit.registry.byId("vertSlider").destroyRecursive();
		
		
	});
	
}


// generate the time line
function generateTimeline(){
	require([
	"dojo/dom-construct",
	"dojo/dom",
	"dojo/domReady!"], function(domConstruct, dom, on){
		domConstruct.place("<div id='vertSlider'></div>","map_element","before");
	});
	
	
	require([
	"dijit/form/VerticalSlider",
	"dijit/form/VerticalRuleLabels", 
	"dijit/form/VerticalRule",
	"dojo/dom-construct",
	"dojo/dom",
	"dojo/domReady!",
	"dojo/parser"], function(VerticalSlider,VerticalRuleLabels,VerticalRule,domConstruct,parser,dom){
		//Create the rules
		var rulesNode = domConstruct.create("div",{},dom.getElementById("vertSlider"),"first");
		var sliderRules = new VerticalRule({
			container:"leftDecoration",
			count: 8,
			ruleStyle:"width: 10px; color:#FFFFFF"
		},rulesNode);
		
		
		//Create the labels
		var labelNode = domConstruct.create("div",{},dom.getElementById("vertSlider"),"first");
		var sliderLabels = new VerticalRuleLabels({
			labels:["2009","2010","2011","2012","2013","2014","2015","2016"],
			count:8,
			container:"rightDecoration",
			labelStyle:"font-style:bold; font-size:1.25em; color:#FFFFFF",
		},labelNode);
		
		
		//Create the vertical slider programmatically
		var vertSlider = new VerticalSlider({
			minimum:0,
			maximum:7,
			showButtons:true,
			discreteValues:8,
			intermediateChanges:true,
			onChange:function(){
				vertSliderOnChange();
			},
			style:"height:300px; position:absolute; top:80px;left:900px;"
		},"vertSlider");
		
		//Strat up the widget
		vertSlider.startup();
		sliderRules.startup();
		sliderLabels.startup();
		
		var verSlider = dojo.byId("vertSlider");
		verSlider.style.zIndex = 2001;
		
	});
	
}


//********滑动栏的onChange事件，实现控制地图上监测点要素的Style********
function vertSliderOnChange(){
	/**
	 *get the Layer which was named AFDS:monitSitePoint
	 *
	 */
	var monitSitePoint = map.getLayer("OpenLayers.Layer.Vector_51");
	
	var featureSelected = monitSitePoint.features;
	
	console.log(featureSelected);
	
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
	
	featureSelected.style = monitSiteSelected_Style;
	
	/*featureSelected.renderIntent = "monitSiteSelected_Style";
	monitSitePoint.drawFeature(featureSelected);*/
	
	//monitSitePoint.drawFeature(featureSelected,"monitSiteSelected_Style");
	
}


/**
 * 功能名称：监测点单点数据查询
 */
function zoomToDataTable(){
	
	var returnMapView = document.getElementById("returnToMap");
	returnMapView.style.display = "inline";
	
	window.scrollTo(0,document.body.scrollHeight);
}

function returnToMap(){
	
	var returnMapView = document.getElementById("returnToMap");
	returnMapView.style.display = "none";
	window.scrollTo(0,0);
}


