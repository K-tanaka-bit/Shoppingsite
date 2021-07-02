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
.button1 {
  display       : inline-block;  font-size : 18pt; text-align    : center;      
  cursor        : pointer;   padding: 10px 36px; background    : rgb(96,72,120);   
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid rgb(96,72,120);  margin:10px 10px  
}
.button1:hover {
  color         : rgb(96,72,120);
   background    : #ffffff;   
}
.button2 {
  display       : inline-block;  font-size : 18pt;  text-align    : center;   cursor : pointer;    
  padding       : 10px 36px;   background    :  rgb(78,133,66);     color         : #ffffff;    
  line-height   : 1em;   transition    : .3s;       border        : 2px solid rgb(78,133,66);    margin:10px 10px  
}
.button2:hover {
  color         : rgb(78,133,66);   
  background    : #ffffff;   
}
.menu{
margin: 100px 400px;
}
</style>
</head>
<body>
<%@ include file="adHeader.jsp"%><br>
<div class ="menu">
<h1>メニュー</h1>
	<form action="../views/productInsert.jsp" method="POST">
		<input type="submit" value="商品登録" class="button1">
	</form>
	

<form action="../servlets/ProductAllServlet"method="post">
<input type="submit" value="商品一覧" class="button2">
</form></div>
</body>
</html>