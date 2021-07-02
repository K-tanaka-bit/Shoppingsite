package jp.co.aforce.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.entity.ShoppingBean;
import jp.co.aforce.models.AdShoppingDAO;
import jp.co.aforce.models.UserShoppingDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/servlets/MenuServlet" })
public class MenuServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);

		HttpSession session = request.getSession();
		String url = null;
		String user_id = (String) session.getAttribute("user_id");
		
		if (user_id.contains("A")) {
			url = "../views/adMenu.jsp";
		} else {
			url = "../views/shopping.jsp";
		}
		AdShoppingDAO adDao = new AdShoppingDAO();
		UserShoppingDAO userDao =new UserShoppingDAO();
		Map<String,String> namemap = null;
		Map<Integer,String> categorymap = null;
		List<ShoppingBean> listAll =null;
		List<ShoppingBean> cart =new ArrayList<ShoppingBean>();
		Map<Integer,String> itemmap = null;
		Map<Integer,String> paymentmap = null;
		try {
			namemap= adDao.selectName();
			categorymap = adDao.selectCategory();
			 listAll =userDao.search();
			 itemmap=adDao.selectItem();
			 paymentmap=userDao.paymentmap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("cart", cart);
		session.setAttribute("namemap", namemap);
		session.setAttribute("categorymap", categorymap);
		session.setAttribute("listAll", listAll);
		session.setAttribute("itemmap", itemmap);
		session.setAttribute("paymentmap", paymentmap);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
