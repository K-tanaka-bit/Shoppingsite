<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Map,java.util.List, jp.co.aforce.entity.ShoppingBean,java.util.ArrayList"%>
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
table{
 width: 90%; margin: 0 auto; max-width: 700px;
}
hr{
border-bottom:2px solid  rgb(159,41,54);
}
.button1 {
  display       : inline-block;  font-size : 10pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 17px; background    : rgb(27,88,124);   
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(27,88,124);  margin:10px 10px  
}
.button1:hover {
  color         :  rgb(27,88,124);     
   background    : #ffffff;   
}
.wrapper {
    display: grid;
    grid-template-columns: 1fr 2fr 1fr;
    grid-template-rows: 100px 100px;
    grid-gap: 10px;
}

.table {
    grid-column: 2;
    grid-row: 0;
}

.page {
	 font-size : 15pt;
	background :#FFFAF0;
    grid-column: 3;
    grid-row: 2;
    padding-top:200 px;
    padding-bottom:150px;
    margin-left:50px;
     margin-right:50px;
}
.page a{
 color: rgb(27,88,124);     
}
.page li{
 list-style-type: none!important;
}
.button2 {
  display       : inline-block;  font-size : 17pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 17px; background    : rgb(159,41,54);   
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(159,41,54);  margin:10px 10px  
}
.button2:hover {
  color         :  rgb(159,41,54);     
   background    : #ffffff;   
}
.empty{
font-size:24pt;
margin:20px ;
}
.button3 {
  display       : inline-block;  font-size : 17pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 40px; background    : rgb(27,88,124);
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(27,88,124);  margin:10px 10px  
}
.button3:hover {
  color         :  rgb(27,88,124);  
   background    : #ffffff;   
}

</style>
</head>
<body>
<%@ include file="shoppingHeader.jsp"%>
<h1>ショッピングカート</h1>
	<%
		List<ShoppingBean> cart = (List<ShoppingBean>) session.getAttribute("cart");
			if(cart==null) {
				cart =new ArrayList<ShoppingBean>();
				session.setAttribute("cart", cart);
			}
		if(cart.size()==0){
			%>
			<div class="empty">
			<br>カートに商品がありません。
			<br><input type="button" name="back" onclick="location.href='../views/shopping.jsp'" value="戻る"class="button3"></div>
		<%
		}else{
			%><div class="wrapper">	<div class="table">
			<table><tr>
			
			<th>商品情報</th>
			<th></th>
			<th>価格</th>
			<th>個数</th><hr>
		</tr>
		
			<%
		for (ShoppingBean item : cart) {
		%>
		<form action="../servlets/CartBranchServlet"method="post" >
		<tr><td>
		<img src="../img/<%=item.getItem_id()%>.jpg" height="100"></td><td>
			<%=item.getItem_name()%></td><td>
			<%=item.getPrice()%>円</td><td>
			<select name="<%=item.getItem_id()%>Item_count">
			<option value ="<%=item.getItem_count()%>"><%=item.getItem_count()%></option>
			<% for(int i=1;i<=item.getItem_value();i++){ %>
			<option value="<%=i %>"><%=i %></option>
			<%} %></select><br><p>
			<input type="hidden" name="item_id" value="<%=item.getItem_id()%>">
			<input type="submit" name ="Page" value="削除"class="button1"></td>
</tr>
		<%
		}
		%></table></div><div class="page"><li>
		商品合計　<%=cart.size() %>点
		<input type="submit" name ="Page"value="注文する"class="button2"><br>
			<a href="../views/shopping.jsp">ショッピングを続ける</a></li></div>
			</form></div>
		<%} %>
		
</body>
</html>