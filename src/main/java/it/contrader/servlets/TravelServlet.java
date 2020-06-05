package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.TravelDTO;
import it.contrader.service.Service;
import it.contrader.service.TravelService;

public class TravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TravelServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<TravelDTO> service = new TravelService();
		List<TravelDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<TravelDTO> service = new TravelService();
		String mode = request.getParameter("mode");
		TravelDTO dto;
		int id;
		int idusername;
		int idtruck;
		int idcity;
		int idhistory;
		boolean ans;
		
		switch (mode.toUpperCase()) {

		case "TRAVELLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/travel/travelmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/travel/readtravek.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/travel/updatetravel.jsp").forward(request, response);
			
			break;

		case "INSERT":
			idusername = Integer.parseInt(request.getParameter("idusername").toString());
			idtruck = Integer.parseInt(request.getParameter("idtruck").toString());
			idcity = Integer.parseInt(request.getParameter("idcity").toString());
			idhistory = Integer.parseInt(request.getParameter("idhistory").toString());
			
			dto = new TravelDTO (idusername, idtruck, idcity,idhistory);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/travel/travelmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			idusername = Integer.parseInt(request.getParameter("idusername"));
			idtruck = Integer.parseInt(request.getParameter("idtruck"));
			idcity = Integer.parseInt(request.getParameter("idcity"));
			idhistory = Integer.parseInt(request.getParameter("idhistory"));
			
			dto = new TravelDTO (id, idusername, idtruck, idcity,idhistory);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/travel/travelmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans); 
			updateList(request);
			getServletContext().getRequestDispatcher("/travel/travelmanager.jsp").forward(request, response);
			break;
		}
	}
}