<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.Map,java.util.List, jp.co.aforce.entity.ShoppingBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
*{
	text-align:center;
	font-family:"MS明朝";
}
.item{ margin-top: 40px ; font-size:15pt; text-align: center; flex-wrap: wrap; justify-content: flex-start; display: flex;}
ul.product {
    border: 1px solid white;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    list-style-type: none;
    margin: 0 0 0 0em;
    padding: 0;
    width: 250px;
}
ul.product li {
    border: 1px solid white;
    display: table;
    height: 6em;
    line-height: 110%;
    margin: 0.2em;
    padding: 0.5em;
    text-align: center;
    width: 3em;
}
 
ul.product span {
    display: table-cell;
    vertical-align: middle;
}
.sideArea{margin-top: 40px ;width: 198px; flex-basis: 198px; margin-right: 5.2%;}
.button {
  display       : inline-block;
  border-radius : 5%;          /* 角丸       */
  font-size     : 12pt;        /* 文字サイズ */
  text-align    : center;      /* 文字位置   */
  cursor        : pointer;     /* カーソル   */
  padding       : 2px 4px;   /* 余白       */
  background    : #ff7f00;     /* 背景色     */
  color         : #ffffff;     /* 文字色     */
  line-height   : 1em;         /* 1行の高さ  */
  transition    : .3s;         /* なめらか変化 */
  border        : 2px solid #ff7f00;    /* 枠の指定 */
}
.button:hover {
  color         : #ff7f00;     /* 背景色     */
  background    : #ffffff;     /* 文字色     */
}
ul.category{
padding: 0;
  position: relative;
}
ul.category li{
color: black;
  border-left: solid 8px orange;/*左側の線*/
  background: whitesmoke;/*背景色*/
  margin-bottom: 5px;/*下のバーとの余白*/
  line-height: 1.5;
  border-radius: 0 15px 15px 0;/*右側の角だけ丸く*/
  padding: 0.5em;
  list-style-type: none!important;
}
.link a{
text-decoration: none;
 color: black;
}
.price{
border        : 2px solid  #FF9900; 
width: 50px;
}
.research{
border        : 2px solid  #FF9900; 
width: 100px;
}
</style>
</head>
<body>
<%@ include file="shoppingHeader.jsp"%><br>
<%Map<Integer,String> categorymap =(Map<Integer,String>)session.getAttribute("categorymap");%>
<div style="display:inline-flex">
<div class="sideArea">
<ul class="category">
<li><form action="../servlets/ShoppingKeywordServlet" method="post">
<div style="display:inline-flex"><input type="text" name="keyword" class="research"><input type="submit" value="検索"class="button"></div></form></li>
<div class="link">
<%for (Map.Entry<Integer, String> category : categorymap.entrySet()) {%>
<li><a href="../servlets/ShoppingCategoryServlet?category_id=<%=category.getKey()%>"><%=category.getValue()%></a></li>
<%}%></div>
<li>
価格
<form action="../servlets/ShoppingPriceServlet" method="post">
<div style="display:inline-flex"><input type="number" min="0" name="minPrice"class="price">~<input type="number" min="0" name="maxPrice"class="price">
</div><input type="submit" value="OK"class="button">
</form></li></ul></div>
<div class="item">
		<%
		List<ShoppingBean> listAll = (List<ShoppingBean>) session.getAttribute("listAll");
		for (ShoppingBean list : listAll) {
		%>
		<ul class="product">
		<li><span>
		<img src="../img/<%=list.getItem_id()%>.jpg" height="150"><br>
			<%=list.getItem_name()%><br>
			<div style="display:inline-flex"><%=list.getPrice()%>円
			<form action="../servlets/CartInServlet"method="post" >
			<input type="hidden" name="item_id" value="<%=list.getItem_id()%>">	
			<input type="submit" name="Page"value="カートに追加"class="button"></div>
			</form></span>
		</li></ul>
		<%
		}
		%></div></div>
</body>
</html>