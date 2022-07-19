package controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import beans.Machine;
import beans.Marque;
import service.MachineService;
import service.MarqueService;
import service.UserService;
@WebServlet(urlPatterns = "/update_machine")
public class UpdateMachineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private MarqueService marqueService;
	private MachineService machineService;
	
	public UpdateMachineController() {
		super();
		this.userService = new UserService();
		this.marqueService = new MarqueService();
		this.machineService = new MachineService();
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
		String reference = request.getParameter("reference");
		String stringDateAchat = request.getParameter("dateAchat");
		Date dateAchat = new Date();
		try {
			dateAchat = new SimpleDateFormat("yyyy-MM-dd").parse(stringDateAchat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        Double prix = Double.parseDouble(request.getParameter("prix"));
        int marqueId = Integer.parseInt(request.getParameter("marqueId"));
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Machine machine  = new Machine(id, reference, dateAchat, prix,marqueId);
            this.machineService.update(machine);
            String destPage = "machines";
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
			 		destPage = "update_machine_jsp";
			 		String idParameter = request.getParameter("id");
			 		List<Marque> marques = this.marqueService.findAll();
			 		request.setAttribute("marques", marques);
			 		if(idParameter != null) {
			 			int id = Integer.parseInt(idParameter);
			 			Machine machine = this.machineService.findById(id);
			 			System.out.println(machine.getDateAchat());
			 			request.setAttribute("machine", machine);
			 		}
			 		else {
			 			destPage = "add_machine_jsp";
			 		}
			 	}
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
    }
}