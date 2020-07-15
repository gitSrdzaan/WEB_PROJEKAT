package beans;

import java.util.Date;

public class Reservations {

	private Apartment reservedAppatment;
	private Date startDate;
	private Integer nightNumber = 1;
	private Double price;
	private String message;
	private Guest guest;
	private Status status;
	
	public Reservations() {
		
	}
	
	

	public Apartment getReservedAppatment() {
		return reservedAppatment;
	}



	public void setReservedAppatment(Apartment reservedAppatment) {
		this.reservedAppatment = reservedAppatment;
	}



	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Integer getNightNumber() {
		return nightNumber;
	}
	public void setNightNumber(Integer nightNumber) {
		this.nightNumber = nightNumber;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
