	/**
	 * 实现地图部分与生物信息栏部分的界线拖动，并更改相应的尺寸
	 * @author Eric
	 */
function leftDrag(){
	//right-drag
	
	//1、根据ID获取左边栏地图的容器、拖拽条以及右边栏生物信息容器
	var leftContent = document.getElementById("content");//地图容器
	var left = document.getElementById("left");//左边外盒
	var dragBar = document.getElementById("map_element_right");//拖拽bar
	var rightContent = document.getElementById("slide_right_monit");//右边外盒容器
	var mainContent = document.getElementById("mainarea");//整体区域
	
	//2、记录存放位置的初始变量
	var mouseStart = {};
	var rightStart = {};
	
	//3、在上述对象上发生鼠标事件后响应相应的动作，实现Style的宽度变化
	
	dragBar.onmousedown = function(ev){
		var oEvent = ev||event;
		mouseStart.x = oEvent.clientX;
		mouseStart.y = oEvent.clientY;
		rightStart.x = dragBar.offsetLeft;
		if(dragBar.setCapture)
			{
				dragBar.onmousemove=doDrag1;
				dragBar.onmouseup=stopDrag1;
				dragBar.setCapture();
			}
		else
			{
				document.addEventListener("mousemove",doDrag1,true);
				document.addEventListener("mouseup",stopDrag1,true);
			}
		};
		
		
		function doDrag1(ev){
			var oEvent = ev||event;
			var l = oEvent.clientX-mouseStart.x+rightStart.x;
			var w = l + dragBar.offsetWidth;
			
			if(w<dragBar.offsetWidth)
				{
					w = dragBar.offsetWidth;
				}
			else if(w>document.documentElement.clientWidth - leftContent.offsetLeft)
				{
					w = document.documentElement.clientWidth - leftContent.offsetLeft-2;
				}
			leftContent.style.width = w+"px";
			left.style.width = w+"px";
			rightContent.style.width = mainContent.offsetWidth - w - 10 + "px";
			
		};
		function stopDrag1(ev){
			if(dragBar.releaseCapture)
				{
					dragBar.onmousemove = null;
					dragBar.onmouseup = null;
					dragBar.releaseCapture();
				}
			else
			 	{
				   document.removeEventListener("mousemove",doDrag1,true);
				   document.removeEventListener("mouseup",stopDrag1,true);
				 }
			
		};
	
	
	//monitSite_Table
	/*var left = document.getElementById("slide_left");
	var img = document.getElementById("barImg");
	var right = document.getElementById("content");
	var map = document.getElementById("map_element");
	
	if(left.style.width == "0px"){
		left.style.width = "246px";
		img.src = "images/arrow-left.jpg";
		right.style.width = "486px";
		map.style.width = "100%";
		
	}
	else{
		left.style.width = "0px";
		img.src = "images/arrow-right.jpg";
		right.style.width = "732px";
		map.style.width = "100%";
	}*/
}


//构造函数生物数据侧边栏
function bioSideBar(){
	var bioBar = document.getElementById("slide_right_monit");
	var hideBar = document.getElementById("hideBioInfoButton");
	var img = document.getElementById("bioHide");
	
	if(bioBar.style.opacity == 0){
		
		bioBoxShow();
		
	}
	else{
		
		bioBoxHide();
	}
		
}


function bioBoxShow(){
	var bioBar = document.getElementById("slide_right_monit");
	var bioInfo = document.getElementById("bioInfoTable");
	var leftContent = document.getElementById("content");//地图容器
	var left = document.getElementById("left");//左边外盒
	var img = document.getElementById("bioBarIMG");
	var main = document.getElementById("mainarea");
	
	var verSlider = document.getElementById("vertSlider");//时间轴
	
	bioBar.style.width = "242px";
	leftContent.style.width = "740px";
	
	if(verSlider!=null){
		verSlider.style.left = "680px";
	}
	
	left.style.width = leftContent.style.width;
	bioBar.style.opacity = 1;
	img.src = "images/arrow-right.jpg";	
	
	
}

function bioBoxHide(){
	var bioBar = document.getElementById("slide_right_monit");
	var leftContent = document.getElementById("content");//地图容器
	var left = document.getElementById("left");//左边外盒
	var img = document.getElementById("bioBarIMG");
	
	var verSlider = document.getElementById("vertSlider");//时间轴
	
	bioBar.style.opacity = 0;
	leftContent.style.width = "982px";
	if(verSlider!=null){
		verSlider.style.left = "900px";
	}
	
	img.src = "images/arrow-left.jpg";
	
}

function monitSiteList(){
	var siteList = document.getElementById("left_up");
	
	if(siteList.style.opacity != 0)
		{
			siteList.style.opacity = 0;
			siteList.style.zIndex = 0;
			
		}
	else
		{
			siteList.style.opacity = 0.8;
			siteList.style.zIndex = 2001;
		}
}


	/**
	 * 基于属性的空间查询部分
	 */
function showAddMonitSiteBox(){
	var spatialQByProperty = document.getElementById("addMonitSite");
	spatialQByProperty.style.display = "";
}


function hideAddMonitSiteBox(){
	var spatialQByProperty = document.getElementById("addMonitSite");
	spatialQByProperty.style.display = "none";
}


function dragTheSpatialQBox(){
	
		
}
//*******图标提示栏：鼠标悬停在图标上，显示相关操作名称的文本框*********










