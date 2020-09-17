package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apartment {
	
	private Long id;
	
	private ApartmentType type;
	private Integer roomNumber;
	private Integer guestNumber;
	private Location apartmentLocation;
	private Host apartmentHost;
	
	private List<DateStatus> apartmentResevartionDates;
	private List<Comment> comments;
	
	private Double pricePerNight;
	
	private Date checkInTime;
	private Date checkOutTime;
	
	
	
	private boolean apartmentStatus;
	
	private List<Amenities> amenities;
	private List<Reservation> reservations;
	
	private List<String> imageSource;
	
	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
		this.apartmentResevartionDates = new ArrayList<DateStatus>();
		this.comments = new ArrayList<Comment>();
		this.amenities = new ArrayList<>();
		this.reservations = new ArrayList<>();
		this.imageSource = new ArrayList<>();
	}
	
	
	
	

	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public ApartmentType getType() {
		return type;
	}



	public void setType(ApartmentType type) {
		this.type = type;
	}



	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Integer getGuestNumber() {
		return guestNumber;
	}
	public void setGuestNumber(Integer guestNumber) {
		this.guestNumber = guestNumber;
	}
	public Location getApartmentLocation() {
		return apartmentLocation;
	}
	public void setApartmentLocation(Location appartmentLocation) {
		this.apartmentLocation = appartmentLocation;
	}
	public Host getApartmentHost() {
		return apartmentHost;
	}
	public void setApartmentHost(Host appartmentHost) {
		this.apartmentHost = appartmentHost;
	}
	public List<DateStatus> getApartmentResevartionDates() {
		return apartmentResevartionDates;
	}
	public void setApartmentResevartionDates(List<DateStatus> appartmentResevartionDates) {
		this.apartmentResevartionDates = appartmentResevartionDates;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(Double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Date getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public boolean isApartmentStatus() {
		return apartmentStatus;
	}
	public void setApartmentStatus(boolean appartmentStatus) {
		this.apartmentStatus = appartmentStatus;
	}
	public List<Amenities> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<Amenities> amenities) {
		this.amenities = amenities;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}





	public List<String> getImageSource() {
		return imageSource;
	}





	public void setImageSource(List<String> imageSource) {
		this.imageSource = imageSource;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
