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

@WebServlet(urlPatterns = { "/servlets/CartBranchServlet" })
public class CartBranchServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		HttpSession session = request.getSession();
		List<ShoppingBean> cart = (List<ShoppingBean>) session.getAttribute("cart");
		List<ShoppingBean> listAll = (List<ShoppingBean>) session.getAttribute("listAll");
		String url = null;
		String page = request.getParameter("Page");

		if (page.equals("削除")) {
			int item_id=Integer.parseInt(request.getParameter("item_id"));
			request.setAttribute("item_id", item_id);
			url = "../servlets/CartRemoveServlet";
		} else if (page.equals("注文する")) {
			url = "../servlets/CartPurchaseCheckServlet";
			for (int i = 1; i <= listAll.size(); i++) {
				for (ShoppingBean s : cart) {
					if (s.getItem_id() == i) {
						int item_count = Integer.parseInt(request.getParameter(i + "Item_count"));
						s.setItem_count(item_count);
					}
				}
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}
