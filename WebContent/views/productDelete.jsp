<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jp.co.aforce.entity.ShoppingBean,java.util.Map"%>
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
  display       : inline-block; font-size : 17pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 17px; background    : rgb(159,41,54);   
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(159,41,54);  margin:10px 10px  
}
.button1:hover {
  color         :  rgb(159,41,54);     
   background    : #ffffff;   
}
.button2 {
  display       : inline-block;  font-size : 17pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 17px; background    : rgb(27,88,124);
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(27,88,124);  margin:10px 10px  
}
.button2:hover {
  color         :  rgb(27,88,124);  
   background    : #ffffff;   
}
table{
font-size : 17pt;
 width: 80%; margin: 0 auto; max-width: 500px;
}
span{
font-size:17pt;
}
</style>
</head>
<body>
<%@ include file="adHeader.jsp"%><br>
<% 
Map<Integer,String> categorymap =(Map<Integer,String>)session.getAttribute("categorymap");
ShoppingBean shopget = (ShoppingBean)session.getAttribute("shopget");
request.setAttribute("shopget", shopget);
%>
<h1>削除画面</h1>
<span>以下の商品を削除します。よろしいですか？</span>
<table><tr><td>
商品名</td><td>${shopget.item_name}</td></tr>
<tr><td>価格</td><td>${shopget.price}</td></tr>
<tr><td>カテゴリー </td><td><%
			for (Map.Entry<Integer, String> category : categorymap.entrySet()) {
				if(shopget.getCategory_id()==category.getKey()){%>
				<%=category.getValue()%><% 
			}}
			%></td></tr>
<tr><td>商品画像</td><td>${shopget.item_img}</td></tr>
<tr><td>在庫数</td><td>${shopget.item_value}</td></tr></table>
<form action="../servlets/ProductAllServlet" method="post">
<input type="submit" value="戻る"class="button2">
<input type="button" name="back"onclick="location.href='../servlets/ProductDeleteServlet'" value="削除" class="button1">
		
	</form>


</body>
</html>