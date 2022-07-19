package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.user;
import service.UserService;


@WebServlet(urlPatterns = "/login")
public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	public UserController() {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {
            user userModel = this.userService.checkLogin(email, password);
            String destPage = "login_jsp";
            if (userModel != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", userModel);
                destPage = "marques";
                response.sendRedirect(destPage);
            } else {
                String message = "Invalid email/password";  
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                dispatcher.forward(request, response);
            }   
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		 try {	
			 	String destPage = "login_jsp";
			 	boolean isLogged = this.userService.checkIfLogged(request);
			 	System.out.println(isLogged);
			 	if(isLogged) {
			 		destPage = "marques";
			 		response.sendRedirect(destPage);
			 	}
			 	else {
			 		RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
		            dispatcher.forward(request, response); 
			 	}
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
    }
	
}
