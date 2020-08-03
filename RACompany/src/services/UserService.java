package services;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.User;
import beans.UserRole;
import dao.UserDAO;

/**
 * Servise sa manipulaciju korisnicima aplikacije
 * */
@Path("/users")
public class UserService {

	@Context
	public ServletContext ctx;
	
	public UserService() {
		
	}
	
	@PostConstruct
	public void init() {
		if(ctx.getAttribute("userDAO") == null) {
			this.ctx.setAttribute("userDAO", new UserDAO(this.ctx.getRealPath("/")));
		}
		
	}
	
	@GET
	@Path("/helloWorld")
	public Response helloWOrld(@Context HttpServletRequest request) {
		/*UserDAO dao = (UserDAO) this.ctx.getAttribute("userDAO");
		System.out.println(dao.findAll());*/
		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Hello World").build();
	}
	
	@GET
	@Path("/currentUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User currentUser(@Context HttpServletRequest request) {
		return (User) request.getSession().getAttribute("user");
	}
	
	@POST
	@Path("/modify")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifyUser(User modifiedUser , @Context HttpServletRequest request) {
		UserDAO dao = (UserDAO) this.ctx.getAttribute("userDAO");
		
		if(!dao.modifyUser(modifiedUser,modifiedUser.getUsername())) {
			return Response.status(400).header("Access-Control-Allow-Origin", "*").entity("Korisnicko ime je mijenjano").build();
		}
		
		try {
			dao.saveUsers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("greska pri cuvanju modifikovanog korisnika").build();
		}
		
		return Response.status(200).header("Access-Control-Allow-Origin", "*").build();
		
	}
	
	@GET
	@Path("/allUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers(@Context HttpServletRequest request){
		User admin = (User) request.getSession().getAttribute("user");
		if(admin.getUserRole() != UserRole.ADMIN) {
			return Response.status(403).header("Access-Control-Allow-Origin", "*").build();
		}
		
		
		
		UserDAO dao = (UserDAO) this.ctx.getAttribute("userDAO");
		
		
		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(dao.findAll()).build();
		
		
	}
	
	
	/**
	 * TODO: lista gostiju koji su rezervisali apartman odredjenog domacina
	 * */
	
	
	
	
	
	
	
	
	
	
	
	
}
