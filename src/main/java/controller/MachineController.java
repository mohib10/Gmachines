package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import beans.Machine;
import beans.Marque;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MachineService;
import service.MarqueService;
import service.UserService;

/**
 *
 * @author Lachgar
 */
@WebServlet(urlPatterns = {"/machines"})
public class MachineController extends HttpServlet {

	private MachineService machineService;
	private MarqueService marqueService;
	private UserService userService;
	public MachineController() {
		super();
		this.machineService = new MachineService();
		this.marqueService = new MarqueService();
		this.userService = new UserService();
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
			 		destPage = "machines_jsp";
			 		List<Marque> marques = this.marqueService.findAll();
				 	request.setAttribute("marques", marques);
			 		List<Machine> machines = this.machineService.findAll();
				 	request.setAttribute("machines", machines);
			 	}
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
    }
}
