<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jp.co.aforce.entity.ShoppingBean,java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
font-family:"MS明朝";
}
.text{
 box-sizing    : border-box; margin-left : 1px;margin-right   : 2px;vertical-align: middle;
  width : 100%; max-width :450px; height: 30px; background    : #ffffff; border        : 2px solid rgb(159,41,54);  border-radius : 4px; font-size : 15px;color: #333333;  letter-spacing: .1em; 
}
.textarea{
 background    : #ffffff; border        : 2px solid rgb(159,41,54);;  border-radius : 4px; font-size : 15px;color: #333333; 
}
table{
margin:10px 400px 10px;
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
%>
	<h1>変更</h1>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
		%>
	<span><%=(String) request.getAttribute("message")%></span>
	<%} %><table>
	<form action="../servlets/ProductUpdateCheckServlet" method="post">
		<tr><td>商品名</td><td><input type="text" name="item_name"value="${shopget.item_name}" class="text"></td></tr>
		 <tr><td>価格</td><td><input type="text" min="0" name="price" value="${shopget.price}"class="text"></td></tr> 
		 <tr><td>カテゴリー</td><td> <select name="category_id"class="text">
		 <option value="${shopget.category_id}">
			<% for (Map.Entry<Integer, String> category : categorymap.entrySet()) {
				if(shopget.getCategory_id()==category.getKey()){%>
				<%=category.getValue()%>
				<% }}%>
		 </option>
			<%
			for (Map.Entry<Integer, String> category : categorymap.entrySet()) {
			%>
			<option value=<%=category.getKey()%>><%=category.getValue()%></option>
			<%
			}
			%>
		</select>
		</select></td></tr><tr><td>商品画像</td><td>
		<textarea cols="50" rows="1" name="item_img"  class="textarea">${shopget.item_img}</textarea></td></tr>
		<tr><td> 個数</td><td><input type="text" min="0" name="item_value" value="${shopget.item_value}" class="text"></td></tr></table>
		<input type="button" name="back"onclick="location.href='../views/adMenu.jsp'" value="戻る" class="button2">
		<input type="submit" value="変更" class="button1">
	</form>
</body>
</html>