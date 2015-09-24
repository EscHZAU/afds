	/**
	 * ʵ�ֵ�ͼ������������Ϣ�����ֵĽ����϶�����������Ӧ�ĳߴ�
	 * @author Eric
	 */
function leftDrag(){
	//right-drag
	
	//1������ID��ȡ�������ͼ����������ק���Լ��ұ���������Ϣ����
	var leftContent = document.getElementById("content");//��ͼ����
	var left = document.getElementById("left");//������
	var dragBar = document.getElementById("map_element_right");//��קbar
	var rightContent = document.getElementById("slide_right_monit");//�ұ��������
	var mainContent = document.getElementById("mainarea");//��������
	
	//2����¼���λ�õĳ�ʼ����
	var mouseStart = {};
	var rightStart = {};
	
	//3�������������Ϸ�������¼�����Ӧ��Ӧ�Ķ�����ʵ��Style�Ŀ�ȱ仯
	
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


//���캯���������ݲ����
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
	var leftContent = document.getElementById("content");//��ͼ����
	var left = document.getElementById("left");//������
	var img = document.getElementById("bioBarIMG");
	var main = document.getElementById("mainarea");
	
	var verSlider = document.getElementById("vertSlider");//ʱ����
	
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
	var leftContent = document.getElementById("content");//��ͼ����
	var left = document.getElementById("left");//������
	var img = document.getElementById("bioBarIMG");
	
	var verSlider = document.getElementById("vertSlider");//ʱ����
	
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
	 * �������ԵĿռ��ѯ����
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
//*******ͼ����ʾ���������ͣ��ͼ���ϣ���ʾ��ز������Ƶ��ı���*********










