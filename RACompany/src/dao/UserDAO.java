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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Admin;
import beans.Guest;
import beans.Host;
import beans.User;
import beans.UserRole;

public class UserDAO {
	
	private Map<String, User> users = new HashMap<String,User>();
	private String contextPath;
	
	public UserDAO() {
		
		
	}
	
	public UserDAO (String contextPath) {
		this.contextPath = contextPath;
		try {
			loadUsers();
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
	 * Matoda vraca jednog usera sa zadatim username-om i sifrom
	 * */
	public User find(String username, String password) {
		//ne postoji korisnik sa datim username-om
		if(!users.containsKey(username)) {
			return null;
		}
		//pogresna sifra
		User user = users.get(username);
		if(user == null || !user.getPassword().equals(password)) {
			return null;
		}
		
		return user;
	}
	
	public User findByUsername(String username) {
		User user = this.users.get(username);
		if(user == null) {
			return null;
		}
		return user;
	}
	
	
	
	/**
	 * Metoda vrace sve korisnike 
	 * */
	public Collection<User> findAll(){
		return users.values();
	}

	/**
	 * Metoda ucitava user-e iz fajla
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * */
	private void loadUsers() throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader br = null;
		/**
		 * TODO: ucitavanje admina 
		 * */
		File adminFile = new File(this.contextPath + "data/admin.json");
		StringBuilder json = new StringBuilder();
		String line;
		try {
			 br = new BufferedReader(new BufferedReader
					(new FileReader(adminFile)));
			while ((line = br.readLine())!=null) {
				json.append(line);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			br.close();
		}
		
		List<Admin> adminList = mapper.readValue(json.toString(),
				new TypeReference<ArrayList<Admin>>() {
				});
		this.users.clear();
		for(Admin admin : adminList) {
			this.users.put(admin.getUsername(),admin);
		}
		
		/**
		 * TODO : ucitavanje domacina
		 *  
		 * */
		File hostFile = new File(this.contextPath + "data/host.json");
		json.setLength(0);
		json = new StringBuilder();
		try {
			 br = new BufferedReader(new BufferedReader
					(new FileReader(hostFile)));
			while ((line = br.readLine())!=null) {
				json.append(line);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			br.close();
		}
		
		List<Host> hostList = mapper.readValue(json.toString(),
				new TypeReference<ArrayList<Host>>() {
				});
		for(Host host : hostList) {
			this.users.put(host.getUsername(), host);
		}
		
		/**
		 * TODO : ucitavanje gostiju
		 * */
		
		File guestFile = new File(this.contextPath + "data/guest.json");
		json.setLength(0);
		json = new StringBuilder();
		try {
			br = new BufferedReader(
					new FileReader(guestFile));
			while ((line = br.readLine()) != null) {
				json.append(line);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			br.close();
		}
		
		List<Guest> guestList = mapper.readValue(json.toString(),
				new TypeReference<ArrayList<Guest>>() {
				});
		for(Guest guest : guestList) {
			this.users.put(guest.getUsername(), guest);
		}
		
	}
	
	/**
	 * Metoda za uspis user-a u fajlove
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * */
	public void saveUsers()  throws JsonParseException, JsonMappingException, IOException  {
		ObjectMapper mapper = new ObjectMapper();
		// lista administratora
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		for(User iter : this.users.values()) {
			if(iter.getUserRole() == UserRole.ADMIN) {
				Admin temp = new Admin(iter);
				adminList.add(temp);
			}
		}
		//lista domacina
		ArrayList<Host> hostList = new ArrayList<Host>();
		for(User iter : this.users.values()) {
			if(iter.getUserRole() == UserRole.HOST) {
				Host temp = new Host(iter);
				hostList.add(temp);
			}
		}
		
		//lista gostiju
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		for(User iter : this.users.values()) {
			if(iter.getUserRole() == UserRole.GUEST) {
				Guest temp = new Guest(iter);
				guestList.add(temp);
			}
		}
		
		/**
		 * Upisivanje liste u fajl 
		 * */
		//System.out.println(adminList);
		
		//upisivanje administratora
		File adminFile = new File(this.contextPath+"data/admin.json");
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(adminFile, 
					adminList);
		}
		catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new JsonGenerationException("JSON generalizacija");
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new JsonMappingException("mapiranje JSON");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException();
		}
		
		//upisivanje domacina
		File hostFile = new File(this.contextPath + "data/host.json");
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(hostFile, 
					hostList);
		}
		catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new JsonGenerationException("JSON generalizacija");
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new JsonMappingException("mapiranje JSON");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException();
		}
		
		//upisivanje gosta
		File guestFile = new File(this.contextPath + "data/guest.json");
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(guestFile, 
					guestList);
		}
		catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new JsonGenerationException("JSON generalizacija");
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new JsonMappingException("mapiranje JSON");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException();
		}
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	/**
	 * Matoda za dodavanje korisnika u mapu korisnika
	 * @param beans.User user
	 * @throws Exception 
	 * */
	public void putUser(User user) throws Exception {
		// TODO Auto-generated method stub
		/*if(user.getUserRole() == UserRole.ADMIN) {
			Admin temp = new Admin(user);
			this.users.put(temp.getUsername(), temp);
			return;
		}
		if(user.getUserRole() == UserRole.HOST) {
			this.users.put(user.getUsername(), (Host)user);
			return;
		}
		if(user.getUserRole() == UserRole.GUEST) {
			this.users.put(user.getUsername(), (Guest)user);
			return;
		}*/
		this.users.put(user.getUsername(), user);
		
		//throw new Exception("Greska pri smjestanju u mapu korisnika sesije");
		
		
	}

	public boolean modifyUser(User modifiedUser, String username) {
		// TODO Auto-generated method stub
		User user = this.findByUsername(username);
		if(user.getUsername() != modifiedUser.getUsername()) {
			return false;
		}
		
		this.users.put(username, modifiedUser);
		return true;
		
		
	}

}
