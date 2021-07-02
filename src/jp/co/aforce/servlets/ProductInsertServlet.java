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
import jp.co.aforce.models.AdShoppingDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/servlets/ProductInsertServlet" })
public class ProductInsertServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		HttpSession session =request.getSession();
		ShoppingBean shop = (ShoppingBean) session.getAttribute("shop");
		int count = 0;
		AdShoppingDAO dao = new AdShoppingDAO();
		
		try {
			count = dao.insert(shop);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		request.setAttribute("count", count);
		session.removeAttribute("shop");

		RequestDispatcher rd = request.getRequestDispatcher("../views/productInsertResult.jsp");
		rd.forward(request, response);
}
}
