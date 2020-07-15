package beans;

public class Comment {

	private Guest guest;
	private Apartment apparment;
	private String text;
	private ApartmentGrade grade;
	public Comment() {
		
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	public Apartment getApparment() {
		return apparment;
	}
	public void setApparment(Apartment apparment) {
		this.apparment = apparment;
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
	
	
	
}
