<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script >
	function login(){
	window.location.href("http://localhost:8080/Blog/dologin.jsp");
//	alert("12");
      }
    function register(){
	   window.location.href("http://localhost:8080/Blog/register.jsp");
	   alert("qqreqfegew");
      }
	</script>
  </head>
  
  <body>
    <form action="/src/com.login/dologin,java" method="post">
			<table>
		        <tr>
				   <td><label>用户名: </label></td>
				   <td><input name="username" value=""></td>
		        </tr>
		        <tr>
				   <td><label>密码: </label></td>
				   <td><input type="password" name="password" value=""></td>	
		        </tr>
		        <tr>
			       <td colspan="2"> <input type="radio" name="身份类型" value="管理员"  >管理员
			                        <input type="radio" name="身份类型" value="用户" >用户
			                        <input type="radio" name="身份类型" value="游客" >游客
			       </td>
		       </tr>
			
	            <tr>
			       <td><input type="button" value="登录" class="login"  onclick="login()"></td>
			       <td><input type="button" value="注册" class="login"  onclick="register()"></td>
		       </tr>
		       
			 </table>
		    </form>
		</div>
  </body>
</html>
