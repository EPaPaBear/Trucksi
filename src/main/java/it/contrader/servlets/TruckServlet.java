package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.TruckDTO;
import it.contrader.service.Service;
import it.contrader.service.TruckService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class TruckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TruckServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<TruckDTO> service = new TruckService();
		List<TruckDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<TruckDTO> service = new TruckService();
		String mode = request.getParameter("mode");
		TruckDTO dto;
		int id;
		int howManyPeople;
		String licensePlate;
		int peopleBooking;
		boolean ans;
		
		switch (mode.toUpperCase()) {

		case "TRUCKLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/truck/truckmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/truck/readtruck.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/truck/updatetruck.jsp").forward(request, response);
			
			break;

		case "INSERT":
			howManyPeople = Integer.parseInt(request.getParameter("howmanypeople").toString());
			licensePlate = request.getParameter("licenseplate").toString();
			peopleBooking = Integer.parseInt(request.getParameter("peoplebooking").toString());
			
			dto = new TruckDTO (howManyPeople, licensePlate, peopleBooking);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/truck/truckmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			howManyPeople = Integer.parseInt(request.getParameter("howmanypeople"));
			licensePlate = request.getParameter("licenseplate");
			peopleBooking = Integer.parseInt(request.getParameter("peoplebooking"));
			
			dto = new TruckDTO (id, howManyPeople, licensePlate, peopleBooking);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/truck/truckmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans); 
			updateList(request);
			getServletContext().getRequestDispatcher("/truck/truckmanager.jsp").forward(request, response);
			break;
		}
	}
}