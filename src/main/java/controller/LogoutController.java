package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	public LogoutController() {
		super();
		this.userService = new UserService();
	}

    /**
     * 
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String destPage = "login_jsp";
            HttpSession session = request.getSession();
            session.invalidate();
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                dispatcher.forward(request, response); 
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

}
