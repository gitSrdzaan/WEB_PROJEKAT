package beans;

public class Admin extends User {
	
	public Admin() {
		super();
		this.setUserRole(UserRole.ADMIN);
	}
	
	public Admin(User user) {
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setFirstname(user.getFirstname());
		this.setLastname(user.getLastname());
		this.setSex(user.getSex());
		this.setUserRole(UserRole.ADMIN);
		
		
	}
	
	

}
