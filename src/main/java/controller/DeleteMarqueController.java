package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Marque;
import service.MarqueService;


@WebServlet(urlPatterns = "/delete_marque")
public class DeleteMarqueController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MarqueService marqueService;
	public DeleteMarqueController() {
		super();
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
		int id = Integer.parseInt(request.getParameter("id"));
        try {
        	Marque marque = this.marqueService.findById(id);
            this.marqueService.delete(marque);
            String destPage = "marques";
            response.sendRedirect(destPage);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}
