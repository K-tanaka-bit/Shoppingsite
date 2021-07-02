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
import jp.co.aforce.models.AdShoppingDAO;

@WebServlet(urlPatterns = { "/servlets/ProductUpdateServlet" })
public class ProductUpdateServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		ShoppingBean shopUpdate = (ShoppingBean) session.getAttribute("shopUpdate");
		int count = 0;
		AdShoppingDAO dao = new AdShoppingDAO();
		try {
			count = dao.update(shopUpdate);
			request.setAttribute("count", count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("count", count);

		RequestDispatcher rd = request.getRequestDispatcher("../views/productUpdateResult.jsp");
		rd.forward(request, response);
	}

}
