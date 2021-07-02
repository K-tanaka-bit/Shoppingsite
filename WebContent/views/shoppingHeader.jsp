<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.header{
background-color: rgb(159,41,54);
color: white;
font-size:30px;
text-align: center;
}
.header a{
font-size:20px;
}
</style>
</head>
<body>
<div class="header">
土佐のおいしいもの　　　　　　　　　　　
<%String user_id=(String)session.getAttribute("user_id") ;%>
<% Map<String,String> namemap =(Map<String,String>)session.getAttribute("namemap");%>
<%for (Map.Entry<String, String> name : namemap.entrySet()) {
	if(user_id.equals(name.getKey())){%>
	ようこそ！<%=name.getValue() %>さん
	<%}}%>	
<a  href="../views/shoppingCart.jsp"><font color=white>カート</font></a>
<a href="../servlets/CartHistoryServlet"><font color=white>購入履歴</font></a>
<a href="../servlets/LogoutServlet"><font color=white>ログアウト</font></a>
</div>
</body>
</html>