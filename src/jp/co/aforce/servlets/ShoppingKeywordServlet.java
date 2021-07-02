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

@WebServlet(urlPatterns = { "/servlets/ShoppingKeywordServlet" })
public class ShoppingKeywordServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		

		UserShoppingDAO dao = new UserShoppingDAO();
		List<ShoppingBean> keywordList =new ArrayList<ShoppingBean>();
		String keyword=request.getParameter("keyword");
		try {
			keywordList=dao.searchKeyword(keyword);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("keyword", keyword);
		HttpSession session =request.getSession();
		session.setAttribute("keywordList", keywordList);
		RequestDispatcher rd = request.getRequestDispatcher("../views/shoppingKeyword.jsp");
		rd.forward(request, response);
		
		


}}
