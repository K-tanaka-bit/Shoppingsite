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

@WebServlet(urlPatterns = { "/servlets/ProductAllServlet" })
public class ProductAllServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);

		AdShoppingDAO dao = new AdShoppingDAO();
		HttpSession session=request.getSession();
		List<ShoppingBean> listAll = (List<ShoppingBean>) session.getAttribute("listAll");
		
		try {
			listAll = dao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();

		}
		session.setAttribute("listAll", listAll);
		RequestDispatcher rd = request.getRequestDispatcher("../views/productAll.jsp");
		rd.forward(request, response);
	}

}
