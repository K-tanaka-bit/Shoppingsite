<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
font-size:15pt;
text-align: center;
margin:150px 400px 
}
.button{
  display : inline-block;width  : 35%;font-size     : 14pt; text-align    : center;cursor : pointer; padding : 12px 12px;
  background : #00b300;   color   : #ffffff;  line-height   : 8px;transition    : .3s;  border: 2px solid #00b300;  
}
.button:hover {
  color         : #00b300;  background    : #ffffff;   
}
.button1{
  display : inline-block;width  : 35%;font-size     : 14pt; text-align    : center;cursor : pointer; padding : 12px 12px;
  background : #ff4d4d;   color   : #ffffff;  line-height   : 8px;transition    : .3s;  border: 2px solid #ff4d4d;  
}
.button1:hover{
  color         : #ff4d4d;  background    : #ffffff;   
}
</style>
</head>
<body>
<%@ include file="adHeader.jsp"%><br>
該当する商品情報が見つかりません。<P>
<form action="../jsp/update.jsp" method="post">
		<input type="submit" value="変更画面に戻る"class="button"><br><P>
		<input type="button" name="back" onclick="location.href='../jsp/menu.jsp'" value="メニューに戻る"class="button1">
	</form>
</body>
</html>