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

@WebServlet(urlPatterns = { "/servlets/ProductGetServlet" })
public class ProductGetServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);

		HttpSession session = request.getSession();
		int item_id=Integer.parseInt(request.getParameter("item_id"));
		session.setAttribute("item_id", item_id);
		List<ShoppingBean> listAll = (List<ShoppingBean>) session.getAttribute("listAll");
		int count = 0;
		for (ShoppingBean shop : listAll) {
			if (Integer.parseInt(request.getParameter("item_id")) == shop.getItem_id()) {
				break;
			}
			count++;
		}
		ShoppingBean shopget = listAll.get(count);
		String url = null;
		String page = request.getParameter("page");
		
		if(page.equals("編集")) {
			url = "../views/productUpdate.jsp";
		} else if (page.equals("削除")) {
			url = "../views/productDelete.jsp"; 
		}
		session.setAttribute("shopget", shopget);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}