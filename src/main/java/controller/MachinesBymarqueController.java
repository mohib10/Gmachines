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
@WebServlet(urlPatterns = "/machine_by_marque")
public class MachinesBymarqueController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private MachineService machineService;
	
	public MachinesBymarqueController() {
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
			 		destPage = "machines_by_marque_jsp";
			 		String marqueIdParameter = request.getParameter("marqueId");
			 		if(marqueIdParameter != null) {
			 			List<Machine> machines = this.machineService.findMachineByMarqueId(Integer.parseInt(marqueIdParameter));
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