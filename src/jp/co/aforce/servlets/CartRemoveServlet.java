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
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/servlets/CartRemoveServlet" })
public class CartRemoveServlet  extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		HttpSession session =request.getSession();
		
		int item_id = Integer.parseInt(request.getParameter("item_id"));
		
		List<ShoppingBean> cart=(List<ShoppingBean>)session.getAttribute("cart");
		for(ShoppingBean item :cart) {
			if(item.getItem_id()==item_id) {
				cart.remove(item);
				break;
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("../views/shoppingCart.jsp");
		rd.forward(request, response);
		

}
}
