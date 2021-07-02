package jp.co.aforce.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.entity.ShoppingBean;
import jp.co.aforce.models.UserShoppingDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/servlets/CartPurchaseCheckServlet" })
public class CartPurchaseCheckServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		int subtotal_price=0;
		int total_price=0;
		HttpSession session=request.getSession();
		List<ShoppingBean> cart = (List<ShoppingBean>) session.getAttribute("cart"); 
		for(ShoppingBean item : cart){
			subtotal_price=item.getPrice()*item.getItem_count();
			item.setSubtotal_price(subtotal_price);
			total_price+=subtotal_price;
		}
		ShoppingBean customer=new ShoppingBean();
		customer.setTotal_price(total_price);
		session.setAttribute("customer", customer);
		String user_id=(String)session.getAttribute("user_id");
		UserShoppingDAO userDao =new UserShoppingDAO();
		ShoppingBean user_info= new ShoppingBean();
		
		
		try {
			user_info=userDao.user_info(user_id);
			session.setAttribute("user_info", user_info);
		}catch( Exception e){
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("../views/shoppingPurchase.jsp");
		rd.forward(request, response);
		}
	
}
