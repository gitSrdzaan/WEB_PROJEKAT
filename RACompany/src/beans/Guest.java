package beans;

public class Guest extends User {

	
	public Guest() {
		super();
		this.setUserRole(UserRole.GUEST);
	}
	
	public Guest(User user) {
		this.setFirstname(user.getFirstname());
		this.setLastname(user.getLastname());
		this.setPassword(user.getPassword());
		this.setSex(user.getSex());
		this.setUsername(user.getUsername());
		this.setUserRole(user.getUserRole());
	}
}
