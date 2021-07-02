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
import jp.co.aforce.models.UserShoppingDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/servlets/CartHistoryServlet" })
public class CartHistoryServlet extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		List<ShoppingBean> orderList = new ArrayList<>();
		List<ShoppingBean> historyList = new ArrayList<>();
		UserShoppingDAO dao=new UserShoppingDAO();		
		try {
			orderList =dao.searchOrder();
			historyList=dao.searchHistory();
		}catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session =request.getSession();
		session.setAttribute("orderList", orderList);
		session.setAttribute("historyList", historyList);
		RequestDispatcher rd = request.getRequestDispatcher("../views/shoppingHistory.jsp");
		rd.forward(request, response);


}}
