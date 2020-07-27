package beans;

public class Host extends User {
	
	public Host() {
		super();
		this.setUserRole(UserRole.HOST);
	}
	public Host(User user) {
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setFirstname(user.getFirstname());
		this.setLastname(user.getLastname());
		this.setSex(user.getSex());
		this.setUserRole(user.getUserRole());
		
	}

}
