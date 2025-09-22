package ndtt.controllers;

import java.io.IOException;
import java.lang.constant.Constable;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ndtt.services.UserService;
import ndtt.services.impl.UserServiceImpl;


public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			resp.sendRedirect(req.getContextPath() + "/admin");
			return;
		}

		
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/admin");
					return;
				}
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
		rd.forward(req, resp);
	}

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse
	resp) throws ServletException, IOException {
	resp.setCharacterEncoding("UTF-8");
	req.setCharacterEncoding("UTF-8");
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	String email = req.getParameter("email");
	String fullname = req.getParameter("fullname");
	String phone = req.getParameter("phone");
	UserService service = new UserServiceImpl();
	String alertMsg = "";
	
	

	if(service.checkExistEmail(email))

	{
		alertMsg = "Email đã tồn tại!";
		req.setAttribute("alert", alertMsg);
		RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
		rd.forward(req, resp);
		return;
	}if(service.checkExistUsername(username))
	{
		alertMsg = "Tài khoản đã tồn tại!";
		boolean isSuccess = service.register(username, password, email,
				fullname, phone);
				if (isSuccess) { 
					alertMsg = "Đăng ký thành công. Please login to use service. Thanks !..";

				req.setAttribute("alert", alertMsg);
				resp.sendRedirect(req.getContextPath() + "/login");
				} else {
				alertMsg = "System error!";
				req.setAttribute("alert", alertMsg);
				RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
				rd.forward(req, resp);
				}
				}
				}
public static final String REGISTER = "/views/register.jsp";
}
