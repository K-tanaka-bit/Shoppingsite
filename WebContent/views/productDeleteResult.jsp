<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
font-family:"MS明朝";
}
.button3{
  display       : inline-block; font-size : 17pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 50px; background    : rgb(78,133,66);   
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(78,133,66);     margin:10px 10px  
}
.button3:hover {
  color         : rgb(78,133,66);       
   background    : #ffffff;   
}
.button4 {
  display       : inline-block;  font-size : 17pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 17px; background    : rgb(193,152,89);
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(193,152,89);  margin:10px 10px  
}
.button4:hover {
  color         : rgb(193,152,89); 
   background    : #ffffff;   
}
.result{
margin-top:100px;
}
span{
font-size:17pt;
}
</style>
</head>
<body>
<%@ include file="adHeader.jsp"%><br>
<div class ="result">
<%
	int count = (Integer) request.getAttribute("count");
	if (count > 0) {
	%>
	<span>削除しました。</span>
	<%
	} else {
	%>
	<span>削除に失敗しました。</span>
	<%
	}
	%>
	<form action="../servlets/ProductAllServlet" method="post">
		<input type="submit" value="商品一覧"class="button3"><br>
		<input type="button" name="back" onclick="location.href='../views/adMenu.jsp'" value="メニューに戻る"class="button4"></div>
	</form>
</body>
</html>