<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jp.co.aforce.entity.ShoppingBean"%>
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
font-size:36pt;
}
.order{
font-size:24pt;
}
.all{
margin:100px ;
}
.all a{
 color: #ff7f00;  
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
<div class="all">
<div class="text">ご注文ありがとうございました！<br></div>
<% ShoppingBean customer=(ShoppingBean)session.getAttribute("customer");%>
<div class="order">注文番号：<a href="../servlets/CartHistoryServlet"><%=customer.getOrder_no() %></a></div>
<input type="button" name="back" onclick="location.href='../views/shopping.jsp'" value="ショッピングを続ける"class="button2"></div>
</body>
</html>