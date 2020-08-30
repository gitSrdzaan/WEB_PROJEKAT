package services;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Reservation;
import dao.ReservationDAO;

@Path("/reservation")
public class ReservationService {

	@Context
	public ServletContext ctx;
	
	public ReservationService() {
		
	}
	
	@PostConstruct
	public void init() {
		if(ctx.getAttribute("reservationDAO") == null ) {
			this.ctx.setAttribute("reservationDAO", new ReservationDAO(this.ctx.getRealPath("/")));
			
		}
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@Context HttpServletRequest request) {
		ReservationDAO dao = (ReservationDAO) this.ctx.getAttribute("reservationDAO");
		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(dao.findAll()).build();
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReservation (@PathParam("id") Long id, @Context HttpServletRequest request) {
		
		ReservationDAO dao = (ReservationDAO) this.ctx.getAttribute("reservationDAO");
		
		Reservation reservation = dao.findById(id);
		if(reservation == null) {
			return Response.status(400).entity("GRESKA: Rezervacija ne postoji").header("Allow-Control-Allow-Origin", "*").build();
		}
		
		return Response.status(200).entity(reservation).header("Allow-Control-Allow-Origin", "*").build();

		
		
	}
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createReservation(Reservation reservation,@Context HttpServletRequest request) {
		ReservationDAO dao = (ReservationDAO) this.ctx.getAttribute("reservationDAO");
		
		dao.putReservation(reservation);
		
		try {
			dao.saveReservation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).header("Access-Control-Allow-Origin", "*").build();
		}
		
		
		
		return Response.status(200).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@PUT
	@Path("/modify/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifyReservation(Reservation reservation,@PathParam("id") Long id
			,@Context HttpServletRequest request) {
		ReservationDAO dao = (ReservationDAO) this.ctx.getAttribute("reservationDAO");
		dao.modifyReservation(reservation,id);
		
		try {
			dao.saveReservation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity("Greska pri modifikaciji rezervacije").build();
		}

		
		
		
		return Response.ok().build();
	
	}
	
	
	
	
}
