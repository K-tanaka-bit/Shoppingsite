package jp.co.aforce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.entity.ShoppingBean;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/servlets/ProductInsertCheckServlet" })
public class ProductInsertCheckServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);

		String url = null;

		if (request.getParameter("item_name").equals("") || request.getParameter("price").equals("") ||
				request.getParameter("category_id").equals("") || request.getParameter("item_img").equals("") ||
				request.getParameter("item_value").equals("")) {
			url = "../views/productInsert.jsp";
			request.setAttribute("message", "入力されていない項目があります。");
		} else {
			url = "../views/productInsertCheck.jsp";
			ShoppingBean shop = new ShoppingBean();
		
			shop.setItem_name(request.getParameter("item_name"));
			shop.setPrice(Integer.parseInt(request.getParameter("price")));
			shop.setCategory_id(Integer.parseInt(request.getParameter("category_id")));
			shop.setItem_img(request.getParameter("item_img"));
			shop.setItem_value(Integer.parseInt(request.getParameter("item_value")));
			HttpSession session =request.getSession();
			session.setAttribute("shop", shop);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
