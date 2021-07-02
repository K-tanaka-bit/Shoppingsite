package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.entity.ShoppingBean;

@WebServlet(urlPatterns = { "/servlets/ProductUpdateCheckServlet" })
public class ProductUpdateCheckServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		String url = null;
		if (request.getParameter("item_name").equals("") || 
				request.getParameter("price").equals("")
				|| request.getParameter("category_id").equals("") ||
				request.getParameter("item_img").equals("") || 
				request.getParameter("item_value").equals("")) {
			url = "../views/productUpdate.jsp";
			request.setAttribute("message", "入力されていない項目があります。");
			

		} else {
			HttpSession session =request.getSession();
			int item_id=(int) session.getAttribute("item_id");
			ShoppingBean shopUpdate = new ShoppingBean();
			shopUpdate.setItem_id(item_id);
			shopUpdate.setItem_name(request.getParameter("item_name"));
			shopUpdate.setPrice(Integer.parseInt(request.getParameter("price")));
			shopUpdate.setCategory_id(Integer.parseInt(request.getParameter("category_id")));
			shopUpdate.setItem_img(request.getParameter("item_img"));
			shopUpdate.setItem_value(Integer.parseInt(request.getParameter("item_value")));
			
			
			session.setAttribute("shopUpdate", shopUpdate);
			url = "../views/productUpdateCheck.jsp";

		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
