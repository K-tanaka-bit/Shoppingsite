<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="java.util.Map,java.util.List, jp.co.aforce.entity.ShoppingBean,jp.co.aforce.models.UserShoppingDAO,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
	font-size:large;
	text-align:center;
	font-family:"serif";
}
table{
 width: 90%; margin: 0 auto; max-width: 700px;background    : 	#FFE4B5;  border        : 2px solid #FFFFEE;
}
.order{
background    : 	#FFE4B5;
margin: 0 auto;
max-width: 700px;
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
.empty{
font-size:24pt;
margin:20px ;
}
</style>
</head>
<body>
<%@ include file="shoppingHeader.jsp"%>
<h1>購入履歴</h1>
	<%
	List<ShoppingBean> orderList = (List<ShoppingBean>) session.getAttribute("orderList");
	Map<Integer,String> itemmap =(Map<Integer,String>)session.getAttribute("itemmap");
	Map<Integer,String> paymentmap =(Map<Integer,String>)session.getAttribute("paymentmap");
	String user_id1=(String)session.getAttribute("user_id");
		List<ShoppingBean> historyNumList = new ArrayList<>();
		UserShoppingDAO dao=new UserShoppingDAO();%>	
		<% if(orderList.size()==0){%>
		<div class="empty">
		購入履歴がありません。<br>
		<input type="button" name="back" onclick="location.href='../views/shopping.jsp'" value="戻る"class="button2"></div>
		<% }else{%>
			
			<% 
		for(ShoppingBean order : orderList) {
			if(user_id1.equals(order.getUser_id())){
			try{
		historyNumList=dao.searchHistory_no(order.getOrder_no());
			}catch(Exception e){
				e.printStackTrace();
			}%>
			<div class="order">
			注文番号：<%=order.getOrder_no() %>　注文日：<%=order.getBuy_date() %><br>
			注文者：<strong><%=order.getCustomer_name() %></strong><br>
			お届け先住所：<%=order.getAdress_post() %><%=order.getAdress() %>
			</div>
			<%for(ShoppingBean historyNum : historyNumList){
		%><%for (Map.Entry<Integer, String> item : itemmap.entrySet()) {
			if(historyNum.getItem_id()==(item.getKey())){%>
				<table><tr><td><img src="../img/<%=historyNum.getItem_id()%>.jpg" height="80"></td><td><%=item.getValue()%><br>
				価格：<%=historyNum.getPrice() %>円
				数量：<%=historyNum.getItem_count() %>　小計<%=historyNum.getSubtotal_price() %>円</td></tr></table>
			<% }}}%>
			<%for (Map.Entry<Integer, String> payment : paymentmap.entrySet()) {
			if(order.getPayment_method_id()==(payment.getKey())){%>
				<div class="order">お支払方法：<strong><%=payment.getValue()%></strong>
		<% }}%>
		　　合計<strong><%=order.getTotal_price() %></strong>円<br></div><br>
		<%} }%>
		<p><input type="button" name="back" onclick="location.href='../views/shopping.jsp'" value="ショッピングに戻る"class="button2">
		<% } %>
</body>
</html>