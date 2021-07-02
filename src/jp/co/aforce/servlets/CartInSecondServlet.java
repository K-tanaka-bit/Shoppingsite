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
import jp.co.aforce.models.AdShoppingDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/servlets/CartInSecondServlet" })
public class CartInSecondServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		int item_id = Integer.parseInt(request.getParameter("item_id"));
		HttpSession session =request.getSession();
		List<ShoppingBean> cart = (List<ShoppingBean>) session.getAttribute("cart");
		List<ShoppingBean> listAll = (List<ShoppingBean>) session.getAttribute("listAll");
		
		for (ShoppingBean list : listAll) {
			if (list.getItem_id() == item_id) {
				ShoppingBean purchase = new ShoppingBean();
					try {
						AdShoppingDAO dao = new AdShoppingDAO();
						purchase = dao.selectItem(item_id);
					} catch (Exception e) {
						e.printStackTrace();
					}
					purchase.setItem_count(1);
					cart.add(purchase);

		}
	}
		session.setAttribute("cart", cart);
		RequestDispatcher rd = request.getRequestDispatcher("../views/shoppingCart.jsp");
		rd.forward(request, response);
}
}
