package beans;

public class Comment {

	private Guest guest;
	private Apartment aparment;
	private String text;
	private ApartmentGrade grade;
	
	private boolean visible;
	
	public Comment() {
		
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	public Apartment getApparment() {
		return aparment;
	}
	public void setAparment(Apartment aparment) {
		this.aparment = aparment;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ApartmentGrade getGrade() {
		return grade;
	}
	public void setGrade(ApartmentGrade grade) {
		this.grade = grade;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
	
}
