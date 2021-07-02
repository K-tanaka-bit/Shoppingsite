<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.Map,java.util.List, jp.co.aforce.entity.ShoppingBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
font-family:"MS明朝";
}
table{
font-size:20px;
margin: auto 150px;
 border        : 2px solid rgb(159,41,54);
}
th,td {
    border:  1px solid rgb(159,41,54);  
    padding: 3px;   
}
.button5 {
  display       : inline-block; font-size : 12pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 17px; background    : rgb(96,72,120);   
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(96,72,120);  margin:10px 10px;   border-radius : 8%;
}
.button5:hover {
  color         : rgb(96,72,120);    
   background    : #ffffff;   
}
.button6 {
  display       : inline-block;  font-size : 12pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 17px; background    : rgb(240,127,9);
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(240,127,9); margin:10px 10px ;  border-radius : 8%;
}
.button6:hover {
  color         :   rgb(240,127,9);
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
</style>
</head>
<body>
<%@ include file="adHeader.jsp"%><br>
	<%
	Map<Integer,String> categorymap =(Map<Integer,String>)session.getAttribute("categorymap");
	List<ShoppingBean> listAll = (List<ShoppingBean>) session.getAttribute("listAll");
		if (listAll.size()!=0) {
	%>
	<input type="button" name="back" onclick="location.href='../views/adMenu.jsp'" value="メニューに戻る"class="button4">
	<div class="">
	<table>
		<tr>
			<th>商品ID</th>
			<th>商品名</th>
			<th>価格</th>
			<th>カテゴリー</th>
			<th>商品画像</th>
			<th>在庫数</th>
			<th></th>
			<th></th>
		</tr>

	<%
		for (ShoppingBean shop : listAll) {
	%>

		<tr>
		<form action = "../servlets/ProductGetServlet" method ="post">
			<td><%=shop.getItem_id()%></td>
			<td><%=shop.getItem_name()%></td>

			<td><%=shop.getPrice()%></td>

			<td><%
			for (Map.Entry<Integer, String> category : categorymap.entrySet()) {
				if(shop.getCategory_id()==( category.getKey())){%>
				<%=category.getValue()%>
			<%
				}}
				%></td>

			<td><%=shop.getItem_img()%></td>

			<td><%=shop.getItem_value() %></td>
			<td>
				
				<input type = "submit"  name= "page" value = "編集" class="button5">
				<input type="hidden" name="item_id" value="<%=shop.getItem_id()%>">		
			</td><td>
				<input type = "submit" name ="page"  value = "削除" class="button6"></form>
			</td>

			</tr>
		<% } %>
	</table>

	<%
		} else {
	%>
	<p>タスクデータがありません。<br>
	メニューに戻り、タスクを新たに登録してください。

	<% } %>
</div>
	
</body>
</html>