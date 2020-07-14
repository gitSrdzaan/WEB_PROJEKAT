package beans;

public class Comment {

	private Guest guest;
	private Appartman apparment;
	private String text;
	private AppartmentGrade grade;
	public Comment() {
		
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public Appartman getApparment() {
		return apparment;
	}
	public void setApparment(Appartman apparment) {
		this.apparment = apparment;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public AppartmentGrade getGrade() {
		return grade;
	}
	public void setGrade(AppartmentGrade grade) {
		this.grade = grade;
	}
	
	
	
	
}
