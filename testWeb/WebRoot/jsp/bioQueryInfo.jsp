<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bioQueryInfo.jsp' starting page</title>
    
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
		
	<script type="text/javascript" src="js/jquery.js"></script>



  </head>
  
  <body>
    <div id="bioInfo">  	
    	<table id = "bioInfoTable" class="imagetable" style="height:50%;width:50%;" border="2px solid " cellpadding="10PX;" cellspacing="3px;">  
                    <tr>
                       <th width="30px">门</th>   
                       <td width="30px"></td> 
                        
                     </tr>
                     <tr>
                       	<th width="auto">亚门</th>   
                        <td width="auto"></td> 
                     </tr>
                     <tr>
                        <th width="auto">纲</th>   
                        <td width="auto"></td> 
                     </tr>
                     <tr>
                       	<th width="auto">目</th>   
                        <td width="auto"></td> 
                     </tr>
                     <tr>
                       	<th width="auto">科</th>   
                        <td width="auto" height="50px"></td> 
                     </tr>
                     <tr>
                       	<th width="auto">属</th>   
                        <td width="auto"></td> 
                     </tr>
                      <tr>
                       	<th width="auto">种</th>   
                        <td width="auto"></td> 
                     </tr>
                     
                      <tr>
                       	<th width="auto">more</th>   
                        <td width="auto">
                        	<a href="">click for more information</a>
                        </td> 
                     </tr>  
                </table> 
    </div>
  
  <script type="text/javascript" src="js/classifyBioQuery_js.js" charset="UTF-8"></script>
  
  </body>
  
</html>
