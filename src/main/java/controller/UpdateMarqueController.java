package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Marque;
import service.MarqueService;
import service.UserService;

@WebServlet(urlPatterns = "/update_marque")
public class UpdateMarqueController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private MarqueService marqueService;
	
	public UpdateMarqueController() {
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
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Marque marque  = new Marque(id, code, libelle);
            this.marqueService.update(marque);
            String destPage = "marques";
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
			 		destPage = "update_marque_jsp";
			 		String idParameter = request.getParameter("id");
			 		if(idParameter != null) {
			 			int id = Integer.parseInt(idParameter);
			 			Marque marque = this.marqueService.findById(id);
			 			request.setAttribute("marque", marque);
			 		}
			 		else {
			 			destPage = "add_marque_jsp";
			 		}
			 	}
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
    }
}
