package it.contrader.servlets;

import javax.servlet.http.HttpServlet;
import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.CityDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.UserService;
import it.contrader.service.CityService;


public class CityServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public CityServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<CityDTO> service = new CityService();
		List<CityDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CityDTO> service = new CityService();
		String mode = request.getParameter("mode");
		CityDTO dto;
		int id;
		String cityname;
		boolean ans;
		
		switch (mode.toUpperCase()) {

		case "CITYLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/city/citymanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/city/readcity.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/city/updatecity.jsp").forward(request, response);
			
			break;

		case "INSERT":
			cityname = request.getParameter("cityname").toString();
			dto = new CityDTO (cityname);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/city/citymanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			cityname = request.getParameter("cityname");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new CityDTO (id, cityname);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/city/citymanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/city/citymanager.jsp").forward(request, response);
			break;
		}
	}
}
