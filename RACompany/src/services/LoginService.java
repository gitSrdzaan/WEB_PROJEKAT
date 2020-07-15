package services;

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

@Path("/login")
public class LoginService {

	@Context
	ServletContext ctx;
	
	public LoginService() {
		
	}
	
	@PostConstruct
	public void init() {
		if(ctx.getAttribute("userDAO") == null) {
			ctx.setAttribute("userDAO", new UserDAO());
		}
	}
	
	@GET
	@Path("/currentUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User currentUser(@Context HttpServletRequest request) {
		return (User) request.getSession().getAttribute("user");
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginMethod(User user, @Context HttpServletRequest request) {
		UserDAO dao = (UserDAO) this.ctx.getAttribute("userDAO");
		
		User retUser = dao.find(user.getUsername(), user.getPassword());
		if(retUser == null) {
			return Response.status(400).
					entity("invalid username or password").build();
		}
		
		request.getSession().setAttribute("user", retUser);
		return Response.status(200).build();
	}
}
