package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Machine;
import service.MachineService;

@WebServlet(urlPatterns = "/delete_machine")
public class DeleteMachineController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MachineService machineService;
	public DeleteMachineController() {
		super();
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
		int id = Integer.parseInt(request.getParameter("id"));
        try {
        	Machine machine = this.machineService.findById(id);
            this.machineService.delete(machine);
            String destPage = "machines";
            response.sendRedirect(destPage);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

}