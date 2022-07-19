package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Marque;
import beans.user;
import service.MarqueService;
import service.UserService;

@WebServlet(urlPatterns = "/add_marque")
public class AddMarqueController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private MarqueService marqueService;
	public AddMarqueController() {
		super();
		this.userService = new UserService();
		this.marqueService = new MarqueService();
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
		String code = request.getParameter("code");
        String libelle = request.getParameter("libelle");
        try {
            Marque marque  = new Marque(code, libelle);
            this.marqueService.create(marque);
            String destPage = "marques";
            String message = "Marque a été ajoutée avec succès";  
            response.sendRedirect(destPage);
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
			 	if(isLogged) {
			 		destPage = "add_marque_jsp";
			 	}
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
    }
}
