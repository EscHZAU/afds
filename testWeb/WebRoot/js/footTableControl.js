/*
 * @Author:Eric
 * @Date:05.24.2014
 * @description:���ݱ��������
 */


//********������ĳһ�У�������ʾ������ȡѡ�������ݵ�������Ϣ**********
function mouseOver(obj){
      if (obj.className="initTr")
        	obj.className="mouseOverTr";
      
      var listofTable = document.getElementById("listOfTable");
      var table = listofTable.getElementsByTagName("li");
      
      var bioName = obj.cells[1].innerHTML;
      var monitTable = "";
      
      //��ȡѡ�еı���Լ���Ҫ��ѯ�������ݵ���������
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
    	  	
    	  	//��Ҫ������������������Ϣ��¼��һһӳ�䣨���ò��ֹ����ŵ���̨��Java����ִ�У�
    	  	
    	  }
      //���������͵�����URL����ͨ���ص�����ʵ�������������Ķ�̬����
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
    		  			//�ж��Ƿ�鵽��������
    		  			if(bioBen[listLength-1] != null)
    		  			{
    		  			//����������Ϣ��
    		  				getBioInfo(bioBen,listLength);
    		  			//���ص�������Ϣ��չ����
    		  				bioBoxShow();
    		  			}
    		  			else {
    		  				alert("�Բ��������ύ�������ѯ�������ݣ�");
    		  			}
    		  			
    	  });
    		  
    	     
}
     

function mouseOut(obj){
      if (obj.className="mouseOverTr")
        	obj.className="initTr";
      
      $("#bioInfoTable").html("<tr><th width = '80px'>��</th><td width ='80px'></td></tr><tr><th>����</th><td></td></tr><tr><th>��</th><td></td></tr><tr><th>Ŀ</th><td></td></tr><tr><th>��</th><td></td></tr><tr><th>��</th><td></td></tr><tr><th>��</th><td></td></tr>");
	  $("#bioImg").html("");
	  
	  bioBoxHide();

    }
	
//**************���ܼ�����ݲ�ѯ*************
	
function bendataQuery(){
    	//1����ȡ�ı����е�����_Jquery
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
    //2�����ı����е�������·����������ʽ���͵���������
	$.get("http://localhost:8080/testWeb/queryMonitData/query/"+tableStr+"/"+fieldStr+"/"
			+connStr+"/"+valueStr,null,
	function(data){
    	//3���ص��������ղ���������
    		//3-1����ȡ����	
    			//��������������⣺��̨��������UTF-8���뷢�ͣ�ǰ�˽���
    		var decodeData = decodeURIComponent(data);
    		
    		var obj = eval(decodeData);
    		var objLength = getJsonLength(obj);
    		//3-2�������ݸ��µ������
    	if(objLength != 1)
    	{	//�жϲ�ѯ���ݵ�������������Ӧ�����������
    		if(tSelected == "MonitBen")
    		{
    			$("#MonitBen").html("<tr><th width='auto' abbr='id'>���</th><th width='auto' abbr='benName'>����</th><th width='auto' abbr='monitSiteName'>���ص�</th><th width='auto' abbr='quantity'>����</th><th width='auto' abbr='biomass'>������</th><th width='auto'>more</th></tr>");
    			$("#bioInfoTable").html("<tr><th width = '80px'>��</th><td width ='80px'></td></tr><tr><th>����</th><td></td></tr><tr><th>��</th><td></td></tr><tr><th>Ŀ</th><td></td></tr><tr><th>��</th><td></td></tr><tr><th>��</th><td></td></tr><tr><th>��</th><td></td></tr>");
    			$("#bioImg").html("");
    			//ѭ�������̨���͵Ĳ�ѯ���������䵽���ݱ���
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
    				$("#MonitPhy").html("<tr><th width='auto' abbr='id'>���</th><th width='auto' abbr = 'phyName'>����</th> <th width='auto' abbr = 'monitSiteName'>���ص�</th><th width='auto' id='quantity'>����</th><th width='auto' id='biomass'>������</th><th width='auto'>more</th></tr>");
    				$("#bioInfoTable").html("<tr><th width = '80px'>��</th><td width ='80px'></td></tr><tr><th>����</th><td></td></tr><tr><th>��</th><td></td></tr><tr><th>Ŀ</th><td></td></tr><tr><th>��</th><td></td></tr><tr><th>��</th><td></td></tr><tr><th>��</th><td></td></tr>");
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
    		//�˴�������������Ϣչʾ�Ĺ��ܣ���ӵ���˫�����ݱ���е�������ʵ��������Ϣ��ѯ����ʹ�ù��ܵ����ʹ�ø������
    		//getBioInfo(obj,objLength);
    			
    	});
	//�ڲ�ѯ���ݷ��غ���ʾ�ɹ�
	
}
    
//***********��ȡ������Ϣ************
    function getBioInfo(obj,objLength){
    	
    		$("#bioInfoTable").html("");
    		bioItem = "<tr><th width = '80px'>��</th><td width ='80px'>"+obj[objLength-1].phylum+"</td></tr>"
    		+"<tr><th>����</th><td>"+obj[objLength-1].subphylum+"</td></tr>"
    		+"<tr><th>��</th><td>"+obj[objLength-1].class1+"</td></tr>"
    		+"<tr><th>Ŀ</th><td>"+obj[objLength-1].order1+"</td></tr>"
    		+"<tr><th>��</th><td>"+obj[objLength-1].family+"</td></tr>"
    		+"<tr><th>��</th><td>"+obj[objLength-1].genus+"</td></tr>"
    		+"<tr><th>��</th><td>"+obj[objLength-1].species+"</td></tr>"
    		+"<tr><th>More</th><td><a href=''>Click for more information</a></td></tr>";
    		$("#bioInfoTable").append(bioItem);
		
    		//����ͼ����Ϣ�Ļ�ȡ
    		//bioImg = "<img src="+obj[objLength-1].picture+"/>";
    		bioImg = "<img src='"+obj[objLength-1].picture+"'style = 'width:65%;height:90%;padding-top:3%;padding-left:15%;'/>";
    		$("#bioImg").append(bioImg);
    		
    	
    }
    
    //*****ˢ�±�񣬻�ȡ��������****
    function getAllData(){
    	//��ȡ��ǰ��ѡ�еı��Tab��ֵ
    	 var listofTable = document.getElementById("listOfTable");
         var table = listofTable.getElementsByTagName("li");
    	 var monitTable = "";
    	 
    	 //����ȡ��Tabֵ���͵���̨����ʼ��ѡ��Tab������������
    	 for(var i = 0; i< table.length; i++){ 
    		 if(table[i].className == "hover"){
  	  		monitTable = table[i].getAttribute("value");	  
  	  		}
    		 
    	 }
    	
    	 //���Ͳ���ǰ��׼�������������룬�Է���ʽ��ͳһ
    	 var tableStr = encodeURI(encodeURI(monitTable));
    	 
    	 $.get("http://localhost:8080/testWeb/queryMonitData/index/"+tableStr,null,
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
    }

  
    //***********��ȡJSON���ϵ�JSON�������****************
    function getJsonLength(json){
    	var count = 0;
    	for (var i in json){
    		count++;
    	}
    	return count;
    }
    
    //*****����SQL��ѯ����*********
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
    
    
    //**************��ʼ��Select combox*************
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
    

    //*********�����û�ѡ����������SQL��䲢��ӵ���Ӧ�ı����**********
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
    
	//**************��ӵ������ϼ���*************
    function addToList(){
    	var hqlState = generateHQL();
    	
    	//add to list
		alert(hqlState);
		
		var addToList = "<tr><td id='conNum'>����</td>"+"<td id='conState'>"
			+hqlState+"</td></tr>"
		
		$("#conditionTable").append(addToList);
    	
    }

    
    //**********���������***********
    function clearList(){
    	
    	$("#conditionTable").html("<tr><th>���</th><th>����</th></tr>");
    	
    }
    
    //**********�Ҳ������**********
    function bioBoxShow(){
    	var bioBar = document.getElementById("slide_right_monit");
    	var bioInfo = document.getElementById("bioInfoTable");
    	var leftContent = document.getElementById("content");//��ͼ����
    	var left = document.getElementById("left");//������
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
    	var leftContent = document.getElementById("content");//��ͼ����
    	var left = document.getElementById("left");//������
    	var img = document.getElementById("bioBarIMG");
    	
    	bioBar.style.opacity = 0;
    	leftContent.style.width = "982px";
    	img.src = "images/arrow-left.jpg";
    	
    }
    
    	//**********�������������**************
    	//innerText��textContent
    	function getInnerText(element) {
			return (typeof element.textContent == "string")?element.textContent:element.innerText
		}


