package services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Apartment;
import beans.Host;
import dao.ApartmentDAO;
import dao.UserDAO;


/**
 * Servise sa dodavanje, brisanje i mijenjanje apartmana
 * Ucitavanje i izlistavanje apartmana
 * @path /apartment 
 * */
@Path("/apartment")
public class ApartmentService {
	
	@Context
	ServletContext ctx;
	
	public ApartmentService() {
		
	}
	
	@PostConstruct
	public void init() {
		if(ctx.getAttribute("apartmentDAO") == null) {
			this.ctx.setAttribute("apartmentDAO", new ApartmentDAO(this.ctx.getRealPath("/")));
		}
	}
	
	@GET
	@Path("/helloWorld")
	public Response helloWOrld(@Context HttpServletRequest request) {
		/*UserDAO dao = (UserDAO) this.ctx.getAttribute("userDAO");
		System.out.println(dao.findAll());*/
		return Response.status(200).entity("Hello World").build();
	}
	
	
	@GET
	@Path("/hostAll/{hostUsername}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Apartment> getAllHostApartments(@Context HttpServletRequest request, 
			@PathParam("hostUsername") String hostUsername) {
		UserDAO dao = (UserDAO)request.getSession().getAttribute("userDAO");
		Host host = (Host)dao.findByUsername(hostUsername);
		
		if(host == null) {
			return null;
		}
		
		ApartmentDAO apDAO = (ApartmentDAO) request.getSession().getAttribute("apartmentDAO");
		
		return (ArrayList<Apartment>) apDAO.findAllHostApartments(host);
		
	}
	
	@GET
	@Path("/allActive")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Apartment> getAllActive(@Context HttpServletRequest request){
		
		ApartmentDAO apDAO = (ApartmentDAO) request.getSession().getAttribute("apartmentDAO");
		return (ArrayList<Apartment>) apDAO.getAllActive();
		
	}
	
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewApartment(Apartment apartment, @Context HttpServletRequest request) {
		ApartmentDAO apDAO = (ApartmentDAO) request.getSession().getAttribute("apartmentDAO");
		apDAO.putApartment(apartment);
		try {
			apDAO.saveApartments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity("Greska pri cuvanja apartmana").build();
		}
		
		return Response.status(200).build();
			
	}
	
	@PUT
	@Path("/modify/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifyApartment(Apartment modifiedApartment ,@PathParam("id") Long id, @Context HttpServletRequest request) {
		ApartmentDAO apDAO = (ApartmentDAO) request.getSession().getAttribute("apartmentDAO");
		apDAO.modifyApartment(modifiedApartment,id);
		try {
			apDAO.saveApartments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity("Greska pri cuvanju modifikovanog apartmana").build();
		}
		
		return Response.status(200).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteApartment(@PathParam("id") Long id, @Context HttpServletRequest request) {
		ApartmentDAO apDAO = (ApartmentDAO) request.getSession().getAttribute("apartmentDAO");
		apDAO.deleteApartment(id);
		try {
			apDAO.saveApartments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity("Greska pri cuvanju obrisanog apartmana").build();
		}
		
		return Response.status(200).build();
		
	}

}
