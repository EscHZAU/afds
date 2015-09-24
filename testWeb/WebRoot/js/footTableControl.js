/*
 * @Author:Eric
 * @Date:05.24.2014
 * @description:数据表操作工具
 */


//********点击表格某一行，高亮显示，并获取选择监测数据的生物信息**********
function mouseOver(obj){
      if (obj.className="initTr")
        	obj.className="mouseOverTr";
      
      var listofTable = document.getElementById("listOfTable");
      var table = listofTable.getElementsByTagName("li");
      
      var bioName = obj.cells[1].innerHTML;
      var monitTable = "";
      
      //获取选中的表格以及需要查询生物数据的生物名称
      for(var i = 0; i< table.length; i++)
    	  {
    	  	if(table[i].className == "hover")
    	  	{
    	  		monitTable = table[i].getAttribute("value");
    	  		var fieldTable = document.getElementById("con_one_"+i);
    	  		var theadTable = fieldTable.getElementsByTagName("table").item(0);
    	  		var trTable = theadTable.getElementsByTagName("tr")[0];
    	  		var nameTd = trTable.cells[1].abbr; 	  		
 
    	  	}
    	  	
    	  	//需要将监测表名称与生物信息名录表一一映射（将该部分工作放到后台由Java代码执行）
    	  	
    	  }
      //将参数发送到以下URL，并通过回调函数实现生物数据栏的动态生成
    		  var tableStr = encodeURI(encodeURI(monitTable));
    		  var fieldStr = encodeURI(encodeURI(nameTd));
    		  var connStr = encodeURI(encodeURI("="));
    		  var valueStr = encodeURI(encodeURI(bioName));
    		  
    		  //$.get("http://localhost:8080/testWeb/queryMonitData/query/"+tableStr+"/"+fieldStr+"/"
    		  $.get("http://localhost:8080/testWeb/queryMonitData/query/"+tableStr+"/"+valueStr,null,
    		  			function(data){
    		    	  	var decodeData = decodeURIComponent(data);
		  				var bioBen = eval(decodeData);
    		  			var listLength = getJsonLength(bioBen);
    		  			//判断是否查到生物数据
    		  			if(bioBen[listLength-1] != null)
    		  			{
    		  			//生成生物信息栏
    		  				getBioInfo(bioBen,listLength);
    		  			//隐藏的生物信息栏展开；
    		  				bioBoxShow();
    		  			}
    		  			else {
    		  				alert("对不起，您所提交的生物查询暂无数据！");
    		  			}
    		  			
    	  });
    		  
    	     
}
     

function mouseOut(obj){
      if (obj.className="mouseOverTr")
        	obj.className="initTr";
      
      $("#bioInfoTable").html("<tr><th width = '80px'>门</th><td width ='80px'></td></tr><tr><th>亚门</th><td></td></tr><tr><th>纲</th><td></td></tr><tr><th>目</th><td></td></tr><tr><th>科</th><td></td></tr><tr><th>属</th><td></td></tr><tr><th>种</th><td></td></tr>");
	  $("#bioImg").html("");
	  
	  bioBoxHide();

    }
	
//**************底栖监测数据查询*************
	
function bendataQuery(){
    	//1、获取文本框中的内容_Jquery
    	//	var jqueryObj = $("#tName");
    	//	var stringQuery = encodeURI(encodeURI(jqueryObj.val()));
	var jqueryTable = $("#tName");
	var index1 = tName.selectedIndex;//get the one selected;
	var tSelected = tName.options[index1].value;
	var tableStr = encodeURI(encodeURI(tSelected));
	
    var jqueryField = $("#fName");
    var index2 = fName.selectedIndex;
    var fSelected = fName.options[index2].value;
    var fieldStr = encodeURI(encodeURI(fSelected));
    	
    var jqueryField = $("#conn");
    var index3 = conn.selectedIndex;
	var cSelected = conn.options[index3].value;
	var connStr = encodeURI(encodeURI(cSelected));
	
	/**conditions**/
	var condition = document.getElementById("conditionTable");
	var conditionTr = condition.getElementsByTagName("tr");
	var conditionValue = "";
	
	for(var i = 1; i<=conditionTr.length-1;i++)
		{
			if(i<(conditionTr.length-1))
				conditionValue += getInnerText(conditionTr[i].cells[1]) +" and ";
			else
				conditionValue += getInnerText(conditionTr[i].cells[1]);
	}
	
	alert(conditionValue);

	var valueStr = encodeURI(encodeURI(conditionValue));
	/*var value = document.getElementById("fValue").value;
	var valueStr = encodeURI(encodeURI(value));*/
	
	//alert(tableStr+","+fieldStr+","+connStr+","+valueStr);
    //2、将文本框中的数据以路径参数的形式发送到服务器端
	$.get("http://localhost:8080/testWeb/queryMonitData/query/"+tableStr+"/"+fieldStr+"/"
			+connStr+"/"+valueStr,null,
	function(data){
    	//3、回调函数接收并解析数据
    		//3-1、获取对象	
    			//解决中文乱码问题：后台将数据以UTF-8编码发送，前端解码
    		var decodeData = decodeURIComponent(data);
    		
    		var obj = eval(decodeData);
    		var objLength = getJsonLength(obj);
    		//3-2、将数据更新到表格中
    	if(objLength != 1)
    	{	//判断查询数据的所属表格，清空相应表格，填入数据
    		if(tSelected == "MonitBen")
    		{
    			$("#MonitBen").html("<tr><th width='auto' abbr='id'>编号</th><th width='auto' abbr='benName'>名称</th><th width='auto' abbr='monitSiteName'>监测地点</th><th width='auto' abbr='quantity'>数量</th><th width='auto' abbr='biomass'>生物量</th><th width='auto'>more</th></tr>");
    			$("#bioInfoTable").html("<tr><th width = '80px'>门</th><td width ='80px'></td></tr><tr><th>亚门</th><td></td></tr><tr><th>纲</th><td></td></tr><tr><th>目</th><td></td></tr><tr><th>科</th><td></td></tr><tr><th>属</th><td></td></tr><tr><th>种</th><td></td></tr>");
    			$("#bioImg").html("");
    			//循环读入后台发送的查询结果，并填充到数据表中
    			var monitItem;
    			//$.each(obj,function(i,result){
    		
    			for(var i = 0; i<objLength-1;i++)
    			{
    				monitItem = "<tr class='initTr' ondblclick='mouseOver(this)' onclick='mouseOut(this)'><td>"+i+"</td><td>"
    				+obj[i].benName+"</td><td>"+obj[i].monitSiteName+"</td><td>"+obj[i].quantity+"</td><td>"+obj[i].biomass+
    				"</td><td>"+"<a href=''>more</a></td></tr>";
    			
    				$("#MonitBen").append(monitItem);
    			};
    			
    		}
    		else if(tSelected == "MonitPhy")
    			{
    				$("#MonitPhy").html("<tr><th width='auto' abbr='id'>编号</th><th width='auto' abbr = 'phyName'>名称</th> <th width='auto' abbr = 'monitSiteName'>监测地点</th><th width='auto' id='quantity'>数量</th><th width='auto' id='biomass'>生物量</th><th width='auto'>more</th></tr>");
    				$("#bioInfoTable").html("<tr><th width = '80px'>门</th><td width ='80px'></td></tr><tr><th>亚门</th><td></td></tr><tr><th>纲</th><td></td></tr><tr><th>目</th><td></td></tr><tr><th>科</th><td></td></tr><tr><th>属</th><td></td></tr><tr><th>种</th><td></td></tr>");
    				$("#bioImg").html("");
    				
    				var monitItem;
        			//$.each(obj,function(i,result){
        		
        			for(var i = 0; i<objLength-1;i++)
        			{
        				monitItem = "<tr class='initTr' ondblclick='mouseOver(this)' onclick='mouseOut(this)'><td>"+i+"</td><td>"
        				+obj[i].phyName+"</td><td>"+obj[i].monitSiteName+"</td><td>"+obj[i].quantity+"</td><td>"+obj[i].biomass+
        				"</td><td>"+"<a href=''>more</a></td></tr>";
        			
        				$("#MonitPhy").append(monitItem);
        			};
        			
    			}
    		
    	}
    		//此处剥离了生物信息展示的功能，添加到“双击数据表格中的数据项实现生物信息查询”，使得功能的组合使用更加灵活
    		//getBioInfo(obj,objLength);
    			
    	});
	//在查询数据返回后，提示成功
	
}
    
//***********获取生物信息************
    function getBioInfo(obj,objLength){
    	
    		$("#bioInfoTable").html("");
    		bioItem = "<tr><th width = '80px'>门</th><td width ='80px'>"+obj[objLength-1].phylum+"</td></tr>"
    		+"<tr><th>亚门</th><td>"+obj[objLength-1].subphylum+"</td></tr>"
    		+"<tr><th>纲</th><td>"+obj[objLength-1].class1+"</td></tr>"
    		+"<tr><th>目</th><td>"+obj[objLength-1].order1+"</td></tr>"
    		+"<tr><th>科</th><td>"+obj[objLength-1].family+"</td></tr>"
    		+"<tr><th>属</th><td>"+obj[objLength-1].genus+"</td></tr>"
    		+"<tr><th>种</th><td>"+obj[objLength-1].species+"</td></tr>"
    		+"<tr><th>More</th><td><a href=''>Click for more information</a></td></tr>";
    		$("#bioInfoTable").append(bioItem);
		
    		//生物图像信息的获取
    		//bioImg = "<img src="+obj[objLength-1].picture+"/>";
    		bioImg = "<img src='"+obj[objLength-1].picture+"'style = 'width:65%;height:90%;padding-top:3%;padding-left:15%;'/>";
    		$("#bioImg").append(bioImg);
    		
    	
    }
    
    //*****刷新表格，获取所有数据****
    function getAllData(){
    	//获取当前正选中的表格Tab的值
    	 var listofTable = document.getElementById("listOfTable");
         var table = listofTable.getElementsByTagName("li");
    	 var monitTable = "";
    	 
    	 //将获取的Tab值传送到后台，初始化选中Tab表格的数据内容
    	 for(var i = 0; i< table.length; i++){ 
    		 if(table[i].className == "hover"){
  	  		monitTable = table[i].getAttribute("value");	  
  	  		}
    		 
    	 }
    	
    	 //传送参数前的准备，将参数编码，以防格式不统一
    	 var tableStr = encodeURI(encodeURI(monitTable));
    	 
    	 $.get("http://localhost:8080/testWeb/queryMonitData/index/"+tableStr,null,
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
    }

  
    //***********获取JSON集合的JSON对象个数****************
    function getJsonLength(json){
    	var count = 0;
    	for (var i in json){
    		count++;
    	}
    	return count;
    }
    
    //*****创建SQL查询界面*********
    function createQuery(){
	    //get the page-height and page-width
		var sHeight = document.documentElement.scrollHeight;
		var sWidth = document.documentElement.scrollWidth;
		
		//Show Login dialog
		if(document.getElementById("queryBox").style.display == "none")
			{
				document.getElementById("queryBox").style.display = "";
				
				initCombox();
				}
		//Create a mask
		var oMask = document.createElement("div");
		oMask.id = "mask";
		oMask.style.height=sHeight+"px";
		oMask.style.width=sWidth+"px";
		document.body.appendChild(oMask);
		
		
		oMask.onclick = function(){
			document.body.removeChild(oMask);
			document.getElementById("queryBox").style.display = "none";
		}
}
    
    
    //**************初始化Select combox*************
    function initCombox(){
    	var tableObj = document.getElementById("tName");
		var index = tableObj.selectedIndex;//get the one selected;
		var tabelSelected = tableObj.options[index].value;
		
		var table = document.getElementById(tabelSelected);
		var th = table.getElementsByTagName("th");
		
		//Question
		document.getElementById("fName").options.length = 0;
		//$("#fName").val("");
		
			for(var i = 0; i<th.length;i++)
			{
				var fNameSelect = document.getElementById("fName");
				fNameSelect.options.add(new Option(th[i].innerHTML,th[i].abbr));
			}
			
    	
    }
    

    //*********根据用户选择条件生成SQL语句并添加到相应的表格中**********
	function generateHQL() {
	var hqlState = "";
	// get the value selected;
	/*var tName = document.getElementById("tName");
	var index1 = tName.selectedIndex;// get the one selected;
	var tSelected = tName.options[index1].value;*/

	var fName = document.getElementById("fName");
	var index2 = fName.selectedIndex;// get the one selected;
	var fSelected = fName.options[index2].value;

	var conn = document.getElementById("conn");
	var index3 = conn.selectedIndex;
	var cSelected = conn.options[index3].value;

	var value = document.getElementById("fValue").value;

	// generate SQL Statement
	//hqlState =fSelected + cSelected + ": " + value;
	hqlState =fSelected + cSelected +"'"+value+"'";
	return hqlState;

}
    
	//**************添加到条件合集中*************
    function addToList(){
    	var hqlState = generateHQL();
    	
    	//add to list
		alert(hqlState);
		
		var addToList = "<tr><td id='conNum'>条件</td>"+"<td id='conState'>"
			+hqlState+"</td></tr>"
		
		$("#conditionTable").append(addToList);
    	
    }

    
    //**********清除条件框***********
    function clearList(){
    	
    	$("#conditionTable").html("<tr><th>编号</th><th>条件</th></tr>");
    	
    }
    
    //**********右侧生物框**********
    function bioBoxShow(){
    	var bioBar = document.getElementById("slide_right_monit");
    	var bioInfo = document.getElementById("bioInfoTable");
    	var leftContent = document.getElementById("content");//地图容器
    	var left = document.getElementById("left");//左边外盒
    	var img = document.getElementById("bioBarIMG");
    	var main = document.getElementById("mainarea");
    	
    	
    	bioBar.style.width = "242px";
    	leftContent.style.width = "740px";
    	left.style.width = leftContent.style.width;
    	bioBar.style.opacity = 1;
    	img.src = "images/arrow-right.jpg";	
    	
    	
    }

    function bioBoxHide(){
    	var bioBar = document.getElementById("slide_right_monit");
    	var leftContent = document.getElementById("content");//地图容器
    	var left = document.getElementById("left");//左边外盒
    	var img = document.getElementById("bioBarIMG");
    	
    	bioBar.style.opacity = 0;
    	leftContent.style.width = "982px";
    	img.src = "images/arrow-left.jpg";
    	
    }
    
    	//**********浏览器兼容设置**************
    	//innerText与textContent
    	function getInnerText(element) {
			return (typeof element.textContent == "string")?element.textContent:element.innerText
		}


