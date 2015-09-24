<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <title>新疆跨境河流水生及鱼类资源数据库系统登陆</title>
  

  <link href="../css/lostyle.css" rel="stylesheet" type="text/css">
  
  <script type="text/javascript" src="../js/jQuery/jquery-1.4.2.js"></script>
  
  
  
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
	<div id = "background" style="position: absolute;z-index: -1;width: 100%;height: 100%;top: 0px;left:0px;">
		<img width="100%" height="100%" src="../images/background.jpg">
	</div>
	<div id="loginBox_title" >
		<img src="../images/logo_College.png" width="120px" height = "120px">
		<p>
			<label>A F D S</label>
		</p>
	</div>
	 <!-- Login -->
   
     <div id="loginBox_Login">
		<%-- <form:form method="post">
			User Name:<form:input path="name"/><br>
			Password:<form:password path="password"/><br>
			department:<form:select path="department">
					<form:option value="0" label="Please select the department"></form:option>
					<form:options items="${departmentList}" itemValue="departmentId" itemLabel="departmentName"></form:options>
			</form:select>
		</form:form>   --%> 
      <%-- 	<form method="post" action="index.jsp">
      		<img id="loginBox_Icon_User" class="loginIcon" src="../images/user.jpg" width="30px" height="30px">
        		<input type="text" name="login" placeholder="Username or Email">
        	<img id="loginBox_Icon_PassWord" class="loginIcon" src="../images/passWord.png" width="30px" height="30px">
        		<input type="password" name="password" placeholder="Password">
          		<input id = "loginBox_Button_Login" type="submit" name="commit" value="Login">
          		<input id = "loginBox_Button_SignUp" type="submit" name="signUp" value="sign up">
      	</form> --%>
      </div>
      <div class="loginBox-help">
      		<div id="loginBox_rememberMe">
          		<label>
            		<input type="checkbox" name="remember_me" id="remember_me">
					自动登陆
        		</label>
          	</div>
      Forgot your password? <a href="index.html">Click here to reset it</a>.
    </div>
 
    <!-- End login -->
</body>
</html>
