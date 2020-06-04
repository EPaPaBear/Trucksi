package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.service.HystorytravelService;
import it.contrader.service.Service;
import it.contrader.dto.*;

public class HystorytravelServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HystorytravelServlet () {}
	public void updateList(HttpServletRequest request) {
		Service<HystorytravelDTO> service = new HystorytravelService();
		List<HystorytravelDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		Service<HystorytravelDTO> service = new HystorytravelService();
		String mode = request.getParameter("mode");
		HystorytravelDTO dto;
		int id;
		boolean ans;
		switch(mode.toUpperCase()) {
			case "HYSTORYTRAVELLIST":
				updateList(request);
				getServletContext().getRequestDispatcher("/hystorytravel/hystorytravelmanager.jsp").forward(request, response);
				break;
			case "READ":
				id = Integer.parseInt(request.getParameter("id"));
				dto = service.read(id);
				request.setAttribute("dto", dto);
				
				if (request.getParameter("update")==null) {
					getServletContext().getRequestDispatcher("/hystorytravel/readhystorytravel.jsp").forward(request, response);
				}
				
				else {
					getServletContext().getRequestDispatcher("/hystorytravel/updateystorytravel.jsp").forward(request, response);
				}
				break;
			case "INSERT":
				int idcity =  Integer.parseInt(request.getParameter("idcity"));
				int idtravel = Integer.parseInt(request.getParameter("idtravel"));
				String datetime = request.getParameter("datetime");
				int travelindex = Integer.parseInt(request.getParameter("travelindex"));
				dto = new HystorytravelDTO(idcity,idtravel,datetime, travelindex);
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/hystorytravel/hystorytravelmanager.jsp").forward(request, response);
				break;
			case "UPDATE":
				 idcity =  Integer.parseInt(request.getParameter("idcity"));
				 idtravel = Integer.parseInt(request.getParameter("idtravel"));
				 datetime = request.getParameter("datetime");
				 travelindex = Integer.parseInt(request.getParameter("travelindex"));
				 dto = new HystorytravelDTO(idcity,idtravel,datetime, travelindex);
				 
				 id = Integer.parseInt(request.getParameter("id"));
				 ans = service.update(dto);
				 request.setAttribute("ans", ans);
				 updateList(request);
				 getServletContext().getRequestDispatcher("/hystorytravel/hystorytravelmanager.jsp").forward(request, response);
				 break;
			case "DELETE":
				 id = Integer.parseInt(request.getParameter("id"));
				 ans = service.delete(id);
				 request.setAttribute("ans", ans);
				 updateList(request);
				 getServletContext().getRequestDispatcher("/hystorytravel/hystorytravelmanager.jsp").forward(request, response);
				 break;
				
				
				
						
		}
	}

}
