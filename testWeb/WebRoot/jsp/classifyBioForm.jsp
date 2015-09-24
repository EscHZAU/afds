<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'classifyBioForm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link href="css/global.css" rel="stylesheet" type="text/css" />
    <link href="css/nav.css" rel="stylesheet" type="text/css" />
	<link href="css/font.css" rel="stylesheet" type="text/css" />
	<link href="css/classifyBioQuery.css" rel="stylesheet" type="text/css" />
		
	<!-- DOJO's style-->
	<link href="./js/dojo_1.10.4/dijit/themes/claro/claro.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/dojo_1.10.4/dojo/dojo.js" 
			djConfig = "parseOnLoad:true,isDebug:true"></script>
				
	<script type="text/javascript" src="js/jquery.js"></script>
  </head>
  
  <body class="claro">
    <div style="height:476px;width:446px; float:left;margin-left:180px;margin-top:150px;">
            		
            		<div id="textArea_DS">
               			<select id="propertySelect_DS" name="propertySelect" data-dojo-type="dijit/form/FilteringSelect"
               			data-dojo-props="
               			value: '',
               			placeHolder: '选择查询方式'" 
               			style="
               			width:120px;
               			float:left;
               			margin-right:5px;
               			margin-bottom:25px;
               			">
               			<option value="name">名称</option>
               			<option value="latinName">拉丁名</option>
               			<option value=""></option>
               			</select>
               	
               		<div style="float:left;width:180px;margin-bottom: 50px;">
               			<input type="text" id="textQuery_DS" data-dojo-type = "dijit/form/TextBox"
               			data-dojo-props = "placeHolder:'请输入关键词'"/>
               		</div>
               		
               		<div id="queryButton_DS" style="float:left;">
                		<button type="submit" id="submitButton" value="单项检索" data-dojo-type="dijit/form/Button"
                			onclick="classifyBioQuery();">单项检索</button>
                				
                		<button type="submit" id="advancedQuery" value="高级检索" data-dojo-type="dijit/form/Button"
                			data-dojo-props="
                				onClick:function(){console.log('Advanced query');}"
                			style="">高级检索</button>
                	</div>
                
                
               		<div id="notice_DS" style="float:left;">
          				检索说明：<br/>
          				1、检索方式分为单项检索与多项检索，检索对象为存储在新疆跨境河流水生资源数据库中的所有数据；<br />
          				2、在输入关键词检索之前，请先在页面的左边框中选取检索表类型；
          			</div>  
              	</div>
            	</div>
            	
    <script type="text/javascript" src="js/classifyBioQuery_js.js" charset="UTF-8"></script>
	<script>
		require([
				"dijit/form/CheckBox",
				"dijit/form/Button",
		        "dijit/form/FilteringSelect",
		        "dijit/form/TextBox",
		        "dijit/form/SimpleTextarea",
		        "dojo/parser",
		        "dojo/domReady!"]);
	</script>

  </body>
</html>
