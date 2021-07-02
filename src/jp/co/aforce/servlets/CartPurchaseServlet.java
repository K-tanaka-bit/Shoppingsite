package jp.co.aforce.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.entity.ShoppingBean;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/servlets/CartPurchaseServlet" })
public class CartPurchaseServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		String url=null;

		HttpSession session =request.getSession();
		String custmer_name = request.getParameter("user_name");
		String adress_post=request.getParameter("adress_post");
		String adress=request.getParameter("adress");
		String user_id=(String)session.getAttribute("user_id");
		int payment_method_id =Integer.parseInt(request.getParameter("payment_method_id"));
		if(custmer_name.isEmpty()||adress_post.isEmpty()||adress.isEmpty()||request.getParameter("payment_method_id").isEmpty()) {
			request.setAttribute("message", "*入力していない項目があります");
			url="../views/shoppingPurchase.jsp";
		}else {
			ShoppingBean customer=(ShoppingBean)session.getAttribute("customer");
			ShoppingBean order = new ShoppingBean();
			customer.setUser_id(user_id);;
			customer.setCustomer_name(custmer_name);
			customer.setAdress_post(adress_post);
			customer.setAdress(adress);
			customer.setPayment_method_id(payment_method_id);
			
			String order_no = order.getOrder_no();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String str = sdf.format(timestamp);
			order_no = "A" + str;
			customer.setOrder_no(order_no);
			session.setAttribute("customer", customer);
			url="../servlets/CartPurchaseSecondServlet";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
}
}
