package jp.co.aforce.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet(urlPatterns = { "/servlets/CartInServlet" })
public class CartInServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);

		int item_id = Integer.parseInt(request.getParameter("item_id"));
		String url ="../servlets/CartInSecondServlet";
		HttpSession session = request.getSession();
		List<ShoppingBean> cart = (List<ShoppingBean>) session.getAttribute("cart");
		if(cart==null) {
			cart =new ArrayList<ShoppingBean>();
			session.setAttribute("cart", cart);
		}

		for (ShoppingBean s : cart) {
 			if (s.getItem_id() == item_id) {
				s.setItem_count(s.getItem_count() + 1);
				url="../views/shoppingCart.jsp";
			}
		}

		request.setAttribute("item_id", item_id);
		session.setAttribute("cart", cart);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}
