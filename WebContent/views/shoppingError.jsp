<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
	text-align:center;
	font-family:"MS明朝";
}
.text{
margin-top:100px;
font-size:20pt;
}
.button2 {
  display       : inline-block;  font-size : 17pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 40px; background    : rgb(27,88,124);
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(27,88,124);  margin:10px 10px  
}
.button2:hover {
  color         :  rgb(27,88,124);  
   background    : #ffffff;   
}
</style>
</head>
<body>
<%@ include file="shoppingHeader.jsp"%>

<div class="text">購入処理に失敗しました。<br>最初からやり直してください。<br></div>
<input type="button" name="back" onclick="location.href='../views/shopping.jsp'" value="トップへ"class="button2">
</body>
</html>