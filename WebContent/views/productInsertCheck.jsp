<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
      import="java.util.Map,jp.co.aforce.entity.ShoppingBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
<%	ShoppingBean shop = (ShoppingBean) session.getAttribute("shop"); 
		Map<Integer,String> categorymap =(Map<Integer,String>)session.getAttribute("categorymap");%>
		<%@ include file="adHeader.jsp"%><br>
<h1>登録画面</h1>
<span>以下の内容で登録します。よろしいですか？</span>
<table><tr><td>
商品名</td><td>${shop.item_name}</td></tr>
<tr><td>価格</td><td>${shop.price}</td></tr>
<tr><td>カテゴリー </td><td><%
			for (Map.Entry<Integer, String> category : categorymap.entrySet()) {
				if(shop.getCategory_id()==category.getKey()){%>
				<%=category.getValue()%><% 
			}}
			%></td></tr>
<tr><td>商品画像</td><td>${shop.item_img}</td></tr>
<tr><td>在庫数</td><td>${shop.item_value}</td></tr></table>
<form action="../servlets/ProductInsertServlet" method="post">
<input type="button" name="back"onclick="location.href='../views/productInsert.jsp'" value="戻る" class ="button2">
		<input type="submit" value="登録" class="button1">
	</form>
</body>
</html>