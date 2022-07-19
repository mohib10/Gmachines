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
@WebServlet(urlPatterns = "/machines_between_dates")
public class MachinesBetweenDatesController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private MachineService machineService;
	
	public MachinesBetweenDatesController() {
		super();
		this.userService = new UserService();
		this.machineService = new MachineService();
	}

    /**
     * 
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		 try {	
			 	String destPage = "login_jsp";
			 	boolean isLogged = this.userService.checkIfLogged(request);
			 	if(isLogged) {
			 		destPage = "machines_between_dates_jsp";
			 		String dateDebutParameter = request.getParameter("dateDebut");
			 		String dateFinParameter = request.getParameter("dateFin");
			 		if(dateDebutParameter != null &&  dateFinParameter != null) {
			 			Date dateDebut = new Date();
			 			Date dateFin = new Date();
			 			System.out.println(dateDebutParameter);
				 		System.out.println(dateFinParameter);
			 			try {
			 				dateDebut = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebutParameter);
			 				dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(dateFinParameter);
			 			} catch (ParseException e) {
			 				// TODO Auto-generated catch block
			 				e.printStackTrace();
			 			}  
			 			List<Machine> machines = this.machineService.findMachineByDateDebut_dateFin(dateDebut, dateFin);
			 			request.setAttribute("machines", machines);
			 		}
			 		else {
			 			destPage = "machines_jsp";
			 		}
			 	}
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
    }
}