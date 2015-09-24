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
	 * ��ȡ�û���Ҫ��ѯ�����ݱ�������Ҫ��ѯ�Ĵ��ࣺ
	 * �����(BaseFish)����������(BaseBen)������ֲ��(BasePhy)����������(BaseZooplan)
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
	 * ��ȡ�û�����Ĳ�ѯ�ֶΡ���ѯ�ؼ���
	 * @param field;keyWords
	 */
	
	var field = dijit.byId('propertySelect_DS').get('value');
	console.log(field);
	
	var keyWords = dijit.byId('textQuery_DS').get('displayedValue');
	var keyWords_encode = encodeURI(encodeURI(keyWords));
	console.log(keyWords);
	
	/**
	 * ItemsSelected/field/keyWords��Ϊ��ѯ���������͵���̨
	 */
	$.get("http://localhost:8080/testWeb/classifyBioQuery/"+itemsType_encode+"/"+keyWords_encode,null,
  			function(data){
    	  	var decodeData = decodeURIComponent(data);
			var bioBen = eval(decodeData);
  			
			var listLength = getJsonLength(bioBen);
  			//�ж��Ƿ�鵽��������
  			if(bioBen[listLength-1] != null)
  			{
  			//����������Ϣ��
  				console.log(bioBen);
  			//���ص�������Ϣ��չ����
  				
  			}
  			else {
  				alert("�Բ��������ύ�������ѯ�������ݣ�");
  			}
  			window.location.href = "http://localhost:8080/testWeb/classifyBioQuery/bioQueryInfo";
  			getBioInfo(bioBen,listLength);
  		});
		
}

//***********��ȡ������Ϣ************
function getBioInfo(obj,objLength){
	//δ�ܻ�ȡiframe�е�DOM�ڵ�Ԫ�أ������������
		var bioFrame = document.getElementById("classifyForm").contentWindow;
		var bioInfoTable = bioFrame.getElementById("bioInfoTable");
		
		if(bioInfoTable != null ){
			console.log("yes");
		}
		else{
			console.log("no");
		}
		
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


//***********��ȡJSON���ϵ�JSON�������****************
function getJsonLength(json){
	var count = 0;
	for (var i in json){
		count++;
	}
	return count;
}

