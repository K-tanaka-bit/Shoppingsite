<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<style>
*{
text-align: center;
font-family:"MS明朝";
}
.button1 {
  display       : inline-block;  font-size : 15pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 17px; background    : rgb(159,41,54);   
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid rgb(159,41,54);  margin:10px 10px  
}
.button1:hover {
  color         : rgb(159,41,54);     
   background    : #ffffff;   
}
.inText {
  box-sizing    : border-box;margin-left : 5px;vertical-align: middle;
 width : 80%; max-width : 250px;height : 30px;background    : #ffffff;   border : 2px solid rgb(159,41,54); border-radius : 4px;font-size     : 15px; color :rgb(159,41,54); letter-spacing: .1em; 
}
.login{
margin:100px;
}
table{
margin:10px 400px 10px;
 font-size : 15pt;
}
</style>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="login"><h2>ログイン</h2>
	<%
	String message = (String) request.getAttribute("message");
	String user_id = (String) session.getAttribute("user_id");
	if (message != null) {
	%>

	<font color=red><%=(String) request.getAttribute("message")%></font>
	<%
	}
	%>
	
	<form action="../servlets/LoginCheckServlet" method="post">
	
	<table><tr><td>
		ユーザID：</td><td><input class="inText" type="text" size="10" name="user_id"
			value=
			<% if(user_id!=null){%>
			<%=session.getAttribute("user_id")%>
			<%}else{} %>></td></tr> <p>
			<tr><td>パスワード： </td><td><input type="password" name="password"class="inText"></td></tr></table>
			<input type="submit" value="ログイン" class="button1"></div>
	</form>
</body>
</html>