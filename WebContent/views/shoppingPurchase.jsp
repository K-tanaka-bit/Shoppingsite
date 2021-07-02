<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
      import="java.util.Map,java.util.List, jp.co.aforce.entity.ShoppingBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
	font-size:large;
	text-align:center;
	font-family:"MS明朝";
}
hr{
border-bottom:2px solid  rgb(159,41,54);
}
.wrapper {
    display: grid;
    grid-template-columns: 1fr 2fr 1fr;
    grid-template-rows: 100px 100px;
    grid-gap: 10px;
}

.item {
    grid-column: 2;
    grid-row: 1;
}
.total{
    font-size : 15pt;
	background :#FFFAF0;   
    grid-column: 3;
    grid-row: 2;
    padding-top:200 px;
    padding-bottom:150px;
    margin-left:50px;
     margin-right:50px;
}
.total a{
 color: rgb(27,88,124);     
}
.total li{
 list-style-type: none!important;
}
.item li{
list-style-type: none!important;
padding-left:50px;
}
.button1 {
  display       : inline-block; font-size : 17pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 10px; background    : rgb(159,41,54);   
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(159,41,54);  margin:10px 10px  
}
.button1:hover {
  color         :  rgb(159,41,54);     
   background    : #ffffff;   
}
.button2 {
  display       : inline-block;  font-size : 17pt; text-align    : center;      
  cursor        : pointer;   padding: 8px 55px; background    : rgb(27,88,124);
  color         : #ffffff;    line-height   : 1em;    transition    : .3s;      
  border        : 2px solid  rgb(27,88,124);  margin:10px 10px  
}
.button2:hover {
  color         :  rgb(27,88,124);  
   background    : #ffffff;   
}
.text {
  box-sizing  :  border-box;margin-left : 10px;vertical-align: middle;
 width : 300px; max-width : 500px;height : 30px;background    : #ffffff;   border : 2px solid  rgb(159,41,54); border-radius : 4px;font-size     : 15px; color : #333333; letter-spacing: .1em; 
}
</style>
</head>
<body>
<%@ include file="shoppingHeader.jsp"%>
	<%List<ShoppingBean> cart = (List<ShoppingBean>) session.getAttribute("cart"); 
		ShoppingBean user_info=(ShoppingBean)session.getAttribute("user_info");
		Map<Integer,String> paymentmap = (Map<Integer,String>)session.getAttribute("paymentmap");
      	ShoppingBean customer=(ShoppingBean)session.getAttribute("customer");%>
      	
      	<h2>購入確認</h2>
      	<div class="wrapper">
      	<div class="item">
      	<table><tr>
		
		<th>商品情報</th>
		<th></th>
		<th>個数</th>
		<th>価格</th></tr><hr><%
for(ShoppingBean item : cart){
%>
		
		<tr><td>
				<img src="../img/<%=item.getItem_id()%>.jpg" height="100"></td><td>
					<%=item.getItem_name()%>
					<%=item.getPrice()%>円</td><td>
					<%=item.getItem_count()%>個</td><td>
					小計<%=item.getSubtotal_price()%></td></tr>
		
		
		<%} %></table>
	<p>
		<form action="../servlets/CartPurchaseServlet" method="post">
		<div style="display:inline-flex">
		<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	}
	%>
		<table><caption><strong>お届け先情報　　　　　　　　　　　　　　　　　</strong></caption>
		<%String message1 = (String) request.getAttribute("message");
	if (message1 != null) {%><tr><td></td><td>
	<font color=red><%=(String) request.getAttribute("message")%></font></td></tr><%}%>
		<tr><td>お名前</td><td><input type="text" name="user_name" value="<%=user_info.getUser_name()%>" class="text"></td></tr>
		<tr><td>郵便番号</td><td><input type="text" name="adress_post" value="<%=user_info.getAdress_post()%>"class="text"></td></tr>
		<tr><td>住所</td><td><input type="text" name="adress"value="<%=user_info.getAdress()%>"class="text"></td></tr>
		<tr><td>支払方法</td><td><select name="payment_method_id"class="text">
			<%for (Map.Entry<Integer, String> payment : paymentmap.entrySet()) {%>
			<option value=<%=payment.getKey()%>><%=payment.getValue()%></option>
			<%}%></select></td></tr></table><P>
		<li>
		<br>
		<br>
		<input type="submit" value="注文を確定する"class="button1"><br>
		<input type="button" name="back" onclick="location.href='../views/shoppingCart.jsp'" value="戻　る"class="button2"></li>
	</form></div><br>
	<br></div>
	<div class="total"><br>
	<li>商品合計　<%=cart.size() %>点<br>
		<strong><%=customer.getTotal_price()%></strong>円<br>
		<a href="../views/shopping.jsp">ショッピングを続ける</a></li></div>
	
		
</body>
</html>