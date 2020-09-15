package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Amenities;

public class AmenitiesDAO {

	private Map<Long,Amenities> amnieties = new HashMap<>(); 
	private String contextPath;
	
	public AmenitiesDAO() {
		
	}
	
	public AmenitiesDAO(String contextPath) {
		this.contextPath = contextPath;
		
		try {
			loadAmenties();
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
	 * Metoda za ucitavanje sadrzaja apartmana
	 * @throws IOException 
	 * */
	private void loadAmenties() throws IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader br = null;
		File amenitiesFile = new File(this.contextPath + "data/amenities.json");
		StringBuilder json = new StringBuilder();
		String line;
		
		try {
			br = new BufferedReader(new FileReader(amenitiesFile));
			while ((line = br.readLine()) != null) {
				json.append(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			br.close();
		}
		
		List<Amenities> amenitiesList = mapper.readValue(json.toString(),
				new TypeReference<ArrayList<Amenities>>() {
				});
		this.amnieties.clear();
		for(Amenities iter : amenitiesList) {
			this.amnieties.put(iter.getId(), iter);
		}
		
	}
	
	/**
	 * Metoda za upisivanje u fajlove sadrzaje apartmana
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * */
	public  void saveAmenities() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		File amenitiesFile = new File(this.contextPath + "data/amenities.json");
		
		mapper.writerWithDefaultPrettyPrinter().writeValue(amenitiesFile, 
				this.amnieties.values());
	}
	
	
	public Amenities findById(Long id) {
		Amenities retAmen = this.amnieties.get(id);
		if(retAmen == null) {
			return null;
		}
		
		return retAmen;
	}
	
	public Collection<Amenities> findAll(){
		return this.amnieties.values();
	}
	
	
	/**
	 * Getter-i i Setter-i
	 * */
	public Map<Long, Amenities> getAmnieties() {
		return amnieties;
	}

	public void setAmnieties(Map<Long, Amenities> amnieties) {
		this.amnieties = amnieties;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public void putAmenities(Amenities amenities) {
		// TODO Auto-generated method stub
		List<Amenities> list = new ArrayList<Amenities>(this.findAll());
		
		list.sort((a,b) -> Long.compare(b.getId(), a.getId()));
		
		Long maxId = list.get(0).getId();
		amenities.setId(++maxId);
		
		this.amnieties.put(amenities.getId(), amenities);
		
	}

	public void modifyAmenity(Amenities amenities, Long id) {
		// TODO Auto-generated method stub
		Amenities temp = this.findById(id);
		temp = amenities;
		
		this.amnieties.put(id, amenities);
		
	}

	public void deleteAmenity(Long id) {
		// TODO Auto-generated method stub
		
		this.amnieties.remove(id);
		
	}
	
}
