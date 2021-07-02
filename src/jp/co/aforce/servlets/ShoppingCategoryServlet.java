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

@WebServlet(urlPatterns = { "/servlets/ShoppingCategoryServlet" })
public class ShoppingCategoryServlet extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		UserShoppingDAO dao = new UserShoppingDAO();
		List<ShoppingBean> categoryList =new ArrayList<ShoppingBean>();
		int category_id=Integer.parseInt(request.getParameter("category_id"));
		try {
			categoryList=dao.searchCategory(category_id);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session =request.getSession();
		session.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher("../views/shoppingCategory.jsp");
		rd.forward(request, response);
		
		

}}
