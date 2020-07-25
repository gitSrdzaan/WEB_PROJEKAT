package services;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.User;
import dao.UserDAO;

/**
 * Servic klasa za registraciju, logovanje i izlogovanje korisnika aplkacije
 * */
@Path("/")
public class LoginService {

	@Context
	ServletContext ctx;
	
	public LoginService() {
		
	}
	
	
	@PostConstruct
	public void init() {
		if(ctx.getAttribute("userDAO") == null) {
			ctx.setAttribute("userDAO", new UserDAO(ctx.getRealPath("/")));
			
			System.out.println(ctx.getContextPath());
		}
	}
	
	@GET
	@Path("helloWorld")
	public Response helloWOrld(@Context HttpServletRequest request) {
		/*UserDAO dao = (UserDAO) this.ctx.getAttribute("userDAO");
		System.out.println(dao.findAll());*/
		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Hello World").build();
	}
	
	@GET
	@Path("currentUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User currentUser(@Context HttpServletRequest request) {
		return (User) request.getSession().getAttribute("user");
	}
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginMethod(User user, @Context HttpServletRequest request) {
		UserDAO dao = (UserDAO) this.ctx.getAttribute("userDAO");
		
		User currUser = dao.find(user.getUsername(), user.getPassword());
		if(currUser == null) {
			return Response.status(400).
					entity("invalid username or password").build();
		}
		
		request.getSession().setAttribute("user", currUser);
		return Response.status(200).build();
	}
	
	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerMethod(User user, @Context HttpServletRequest request) {
		UserDAO dao = (UserDAO) this.ctx.getAttribute("userDAO");
		
		/*System.out.println(user.getUsername());
		System.out.println(user.getUserRole());*/
		
		if(dao.find(user.getUsername(), user.getPassword())==null) {
			try {
				dao.putUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Response.status(500).entity("Greska pri dodavanju registrovanog korisnika").build();
			}
			try {
				dao.saveUsers();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Response.status(500).entity("Gresk pri cuvanju registrovanog korisnika").build();
			}
			return Response.status(200).build();
		}
		
		return Response.status(400).entity("Username already exists").build();
		
		
	}
	
	@POST
	@Path("logout")
	@Consumes(MediaType.APPLICATION_JSON)
	public void logoutMethod(@Context HttpServletRequest request) {
		request.getSession().invalidate();
	}
	
	
}
