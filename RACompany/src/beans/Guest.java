package beans;

public class Guest extends User {

	
	public Guest() {
		super();
		this.setUserRole(UserRole.GUEST);
	}
}
