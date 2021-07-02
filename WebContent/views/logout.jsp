<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{

text-align: center;
font-family:"MS明朝";
}
a{
 color: rgb(27,88,124);     
}
.logout{
margin:100px;
font-size:24pt;
}
</style>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="logout">
ログアウトしました。<br>
<a href="../views/login.jsp">ログイン画面</a></div>
</body>
</html>