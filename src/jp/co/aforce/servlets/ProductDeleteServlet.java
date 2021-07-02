package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.models.AdShoppingDAO;

@WebServlet(urlPatterns = { "/servlets/ProductDeleteServlet" })
public class ProductDeleteServlet  extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		HttpSession session =request.getSession();
		int item_id=(int) session.getAttribute("item_id");
		int count = 0;
		AdShoppingDAO dao = new AdShoppingDAO();
		try {
			count=dao.delete(item_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("count", count);

		RequestDispatcher rd = request.getRequestDispatcher("../views/productDeleteResult.jsp");
		rd.forward(request, response);

}}
