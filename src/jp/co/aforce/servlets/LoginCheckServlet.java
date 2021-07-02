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

import jp.co.aforce.models.AdShoppingDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/servlets/LoginCheckServlet" })
public class LoginCheckServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		Page.header(out);

		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String url = null;
		HttpSession session = request.getSession();
		session.setAttribute("user_id", user_id);

		try {
			AdShoppingDAO dao = new AdShoppingDAO();

			if (dao.select(user_id, password)) {
				url = "/servlets/MenuServlet";
			} else {
				url = "../views/login.jsp";
				request.setAttribute("message", "*エラー IDもしくはパスワードが違います");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
