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

import beans.Admin;
import beans.Apartment;
import beans.Comment;
import beans.Guest;
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
		if(ctx.getAttribute("userDAO") == null) {
			this.ctx.setAttribute("userDAO", new UserDAO(this.ctx.getRealPath("/")));
		}
	}
	
	@GET
	@Path("/helloWorld")
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloWOrld(@Context HttpServletRequest request) {
		ApartmentDAO apDAO = (ApartmentDAO)this.ctx.getAttribute("apartmentDAO");
		
		return Response.ok().entity(apDAO.findAll()).build();
		//return Response.status(200).entity("Hello World").build();
	}
	/**
	 * Metoda za izlistavanje svih apartmana
	 * Moze koristi samo admin
	 * */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllApartments(@Context HttpServletRequest request) {
		
		ApartmentDAO apDAO = (ApartmentDAO)this.ctx.getAttribute("apartmentDAO");
		Admin admin = (Admin) request.getSession().getAttribute("user");
		
		if(admin == null) {
			return Response.status(403).build();
		}
		
		return Response.ok().entity(apDAO.findAll()).build();
	}
	
	
	@GET
	@Path("/hostAll/{hostUsername}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllHostApartments(@Context HttpServletRequest request, 
			@PathParam("hostUsername") String hostUsername) {
		UserDAO dao = (UserDAO)this.ctx.getAttribute("userDAO");
		Host host = (Host)dao.findByUsername(hostUsername);
		
		if(host == null) {
			return Response.status(400).entity("Pogresan korisnika").build();
		}
		
		ApartmentDAO apDAO = (ApartmentDAO)this.ctx.getAttribute("apartmentDAO");
		
		return Response.status(200).entity(apDAO.findAllHostApartments(host)).build(); 
		
	}
	
	@GET
	@Path("/allActive")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Apartment> getAllActive(@Context HttpServletRequest request){
		
		ApartmentDAO apDAO = (ApartmentDAO) this.ctx.getAttribute("apartmentDAO");
		return (ArrayList<Apartment>) apDAO.getAllActive();
		
	}
	
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewApartment(Apartment apartment, @Context HttpServletRequest request) {
		ApartmentDAO apDAO = (ApartmentDAO)this.ctx.getAttribute("apartmentDAO");
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
	public Response modifyApartment(Apartment modifiedApartment ,@PathParam("id") Long id, 
			@Context HttpServletRequest request) {
		ApartmentDAO apDAO = (ApartmentDAO)this.ctx.getAttribute("apartmentDAO");
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
		ApartmentDAO apDAO = (ApartmentDAO) this.ctx.getAttribute("apartmentDAO");
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

	@PUT
	@Path("addComment/{guest}/{apartment}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCommentToApartment(Comment comment, @Context HttpServletRequest request,
			@PathParam("guest") String username, @PathParam("apartment") Long id) {
		UserDAO userDAO = (UserDAO) this.ctx.getAttribute("userDAO");
		Guest guest = (Guest) userDAO.findByUsername(username);
		
		ApartmentDAO apDAO = (ApartmentDAO) this.ctx.getAttribute("apartmentDAO");
		Apartment apartment = apDAO.find(id);
		
		comment.setGuest(guest);
		comment.setAparment(apartment);
		apartment.getComments().add(comment);
		
		apDAO.putApartment(apartment);
		
		try {
			apDAO.saveApartments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}
		
		return Response.status(200).build();	
	}
	
	
}
