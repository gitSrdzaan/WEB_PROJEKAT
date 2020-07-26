package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Amenities;
import beans.Apartment;
import beans.ApartmentType;
import beans.Host;

public class ApartmentDAO {

	private Map<Long , Apartment> apartments = new HashMap<Long, Apartment>();
	private String contextPath;
	
	public ApartmentDAO() {
		
	}
	
	public ApartmentDAO(String contextPath) {
		this.contextPath = contextPath;
		try {
			loadApartments();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Matoda za ucitavanje apartmana
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * */
	private void loadApartments() throws JsonParseException, JsonMappingException ,IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader br = null;
		File apartmentFile = new File(this.contextPath + "data/apartment.json");
		StringBuilder json = new StringBuilder();
		String line;
		try {
			 br  = new BufferedReader(
					new FileReader(apartmentFile) );
			while((line = br.readLine()) != null) {
				json.append(line);
			}
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			br.close();
		}
		
		List<Apartment> apartmentList = mapper.readValue(json.toString(),
				new TypeReference<ArrayList<Apartment>>() {
				});
		this.apartments.clear();
		for(Apartment iter : apartmentList) {
			this.apartments.put(iter.getId(), iter);
		}
		
		
	}

	/**
	 * Metoda za upisisavanje aparamtana u json file-ove
	 * @throws Exception 
	 * */
	public void saveApartments() throws Exception {
	
		ObjectMapper mapper = new ObjectMapper();
		File apartmentFile = new File(this.contextPath + "data/apartment.json");
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(apartmentFile,
					this.apartments.values());
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Greska pri upisivanju apartmana u fajlove");
		}
	}
	/**
	 * Matoda za pronalazenje apartmana
	 * */
	public Apartment find(Long Id) {
		Apartment retAp = this.apartments.get(Id);
		if(retAp == null) {
			return null;
		}
		return retAp;
	}
	
	
	
	/**
	 * Metoda za dodavanje apartmana u mapu apartmana
	 * */
	public void putApartment(Apartment apartment) {
		
		List<Apartment> allApartments = (List<Apartment>) this.apartments.values();
		
		/**
		 * Java Lambda funckija za sortiranje liste apartmana po id-u 
		 * u opadajucem redosljedu
		 * */
		allApartments.sort((a,b) -> Long.compare(b.getId(), a.getId()));
		
		Long maxId = allApartments.get(0).getId(); //id prvog u sortiranoj listi je najveci
		apartment.setId(++maxId); //uvecavanjem za jedan dobijamo da se vrijednost kljuca nece ponoviti
		
		//System.out.println(maxId);
		apartment.setApartmentStatus(false);//inicijalno stanje apartmana je neaktivno
		this.apartments.put(apartment.getId(), apartment);
	}
	/**
	 * Metoda za dobavljanje svih ucitanih apartmana mape
	 * */
	public Collection<Apartment> findAll(){
		return this.apartments.values();
	}
	
	
	/**
	 * Metoda za pronalazenje svih apartmana odredjenog domacina
	 * @param beans.Host host
	 * */
	public Collection<Apartment> findAllHostApartments(Host host){
		ArrayList<Apartment> apArrayList = new ArrayList<Apartment>();
		for(Apartment iter : this.apartments.values()) {
			if(iter.getApartmentHost().getUsername() == host.getUsername()) {
				apArrayList.add(iter);
			}
		}
		
		return apArrayList;
		
	}
	/**
	 * Metoda za pronalazenje svih apartmana odredjenog tipa
	 * @param beans.ApartmentType type
	 * */
	public Collection<Apartment> findAllTypeApartments(ApartmentType type){
		ArrayList<Apartment> retApList = new ArrayList<Apartment>();
		for(Apartment iter : this.apartments.values()) {
			if(iter.getType() == type) {
				retApList.add(iter);
			}
		}
		
		return retApList;
	}
	
	
	/**
	 * Metoda za pronalazenje svih aktivnih apartmana
	 * */
	public Collection<Apartment> getAllActive(){
		ArrayList<Apartment> retApList = new ArrayList<Apartment>();
		for(Apartment iter : this.apartments.values()) {
			if(iter.isApartmentStatus()) {
				retApList.add(iter);
			}
		}
		
		return retApList;
	}
	
	
	
	
	/**
	 * Getter-i i setter-i
	 * */
	public Map<Long, Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(Map<Long, Apartment> apartments) {
		this.apartments = apartments;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	/**
	 * Metoda za modifikaciju apartmana
	 * @param beans.Apartment modifedApartment
	 * @param Long id
	 * */
	public void modifyApartment(Apartment modifiedApartment, Long id) {
		// TODO Auto-generated method stub
		Apartment apartment = this.find(id);
		apartment = modifiedApartment;
		this.apartments.put(id, apartment);
		
		
	}

	public void deleteApartment(Long id) {
		// TODO Auto-generated method stub
		//this.apartments.get(id).setApartmentStatus(false);//postavljanje statusa apartmana na neaktivan
		
		this.apartments.remove(id);
		
	}

	public void modifyApartmentsWithAmenity(Amenities amenities) {
		// TODO Auto-generated method stub
		ArrayList<Apartment> list = (ArrayList<Apartment>) this.apartments.values();
		//lista svih apartmana
		for(Apartment iter : list) {
			if(iter.getAmenities() != null) {
				//lista svih sadrzaja apartmana za odredjeni apartman
				ArrayList<Amenities> iterAmenities = (ArrayList<Amenities>) iter.getAmenities();
				for(Amenities amenIter : iterAmenities) {
					if(amenIter.getId() == amenities.getId()) {
						//ako se poklapaju samo modifikovati vrijednosti i prekinuti petlju,
						//jer znamo da postoji samo jedan sa tim id
						amenIter = amenities;
						this.apartments.put(iter.getId(), iter);
						break;
					}
				}
			}
		}
		
		
	}

	public void deleteAmenityFromApartment(Amenities amenity) {
		// TODO Auto-generated method stub
		ArrayList<Apartment> list = (ArrayList<Apartment>) this.apartments.values();
		//lista svih apartmana
		for(Apartment iter : list) {
			if(iter.getAmenities() != null) {
				//lista svih sadrzaja apartmana za odredjeni apartman
				ArrayList<Amenities> iterAmenities = (ArrayList<Amenities>) iter.getAmenities();
				for(Amenities amenIter : iterAmenities) {
					if(amenIter.getId() == amenity.getId()) {
						//ako se poklapaju kljucevi treba ga obrisati
						//jer znamo da postoji samo jedan sa tim id
						iterAmenities.remove(amenIter);
						this.apartments.put(iter.getId(), iter);
						break;
					}
				}
			}
		}
	}
}
