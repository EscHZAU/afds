$(function() {
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		// Variables privadas
		var links = this.el.find('.link');
		// Evento
		links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
	}

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
			$this = $(this),
			$next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
		};
	}	

	var accordion = new Accordion($('#accordion'), false);
});


function classifyBioQuery(){
	/**
	 * 获取用户想要查询的数据表，即：想要查询的大类：
	 * 渔获物(BaseFish)、底栖生物(BaseBen)、浮游植物(BasePhy)、蜉蝣动物(BaseZooplan)
	 * @param ItemsSelected
	 */
	var accordion = parent.document.getElementById("accordion");
	var accordionItems = parent.document.getElementsByTagName("li");
	
	var itemsType = "";
	var itemsType_encode = "";
	
	for(var i = 0;i<accordionItems.length;i++){
		if(accordionItems[i].className == "open")
			{
				itemsType = accordionItems[i].getAttribute("id");
				itemsType_encode = encodeURI(encodeURI(itemsType)); 
			}
	}
	
	console.log(itemsType);
	
	/**
	 * 获取用户输入的查询字段、查询关键词
	 * @param field;keyWords
	 */
	
	var field = dijit.byId('propertySelect_DS').get('value');
	console.log(field);
	
	var keyWords = dijit.byId('textQuery_DS').get('displayedValue');
	var keyWords_encode = encodeURI(encodeURI(keyWords));
	console.log(keyWords);
	
	/**
	 * ItemsSelected/field/keyWords作为查询参数，发送到后台
	 */
	$.get("http://localhost:8080/testWeb/classifyBioQuery/"+itemsType_encode+"/"+keyWords_encode,null,
  			function(data){
    	  	var decodeData = decodeURIComponent(data);
			var bioBen = eval(decodeData);
  			
			var listLength = getJsonLength(bioBen);
  			//判断是否查到生物数据
  			if(bioBen[listLength-1] != null)
  			{
  			//生成生物信息栏
  				console.log(bioBen);
  			//隐藏的生物信息栏展开；
  				
  			}
  			else {
  				alert("对不起，您所提交的生物查询暂无数据！");
  			}
  			window.location.href = "http://localhost:8080/testWeb/classifyBioQuery/bioQueryInfo";
  			getBioInfo(bioBen,listLength);
  		});
		
}

//***********获取生物信息************
function getBioInfo(obj,objLength){
	//未能获取iframe中的DOM节点元素，待解决！！！
		var bioFrame = document.getElementById("classifyForm").contentWindow;
		var bioInfoTable = bioFrame.getElementById("bioInfoTable");
		
		if(bioInfoTable != null ){
			console.log("yes");
		}
		else{
			console.log("no");
		}
		
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


//***********获取JSON集合的JSON对象个数****************
function getJsonLength(json){
	var count = 0;
	for (var i in json){
		count++;
	}
	return count;
}

