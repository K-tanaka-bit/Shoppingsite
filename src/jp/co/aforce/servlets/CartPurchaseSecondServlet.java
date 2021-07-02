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
import jp.co.aforce.models.UserShoppingDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/servlets/CartPurchaseSecondServlet" })
public class CartPurchaseSecondServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		String url =null;
		UserShoppingDAO dao =new UserShoppingDAO();
		HttpSession session =request.getSession();
		List<ShoppingBean> cart =(List<ShoppingBean>)session.getAttribute("cart");
		ShoppingBean customer=(ShoppingBean)session.getAttribute("customer");
		
		try {
		if(cart==null||!dao.insert(cart, customer)||!dao.insert(customer)) {
			url="../views/shoppingError.jsp";
		}else {
			session.removeAttribute("cart");
			url="../views/shoppingDone.jsp";
		}
		}catch (Exception e) {
			url="../views/shoppingError.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

}
}
