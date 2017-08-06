/**
 * 
 */
package br.com.flightPlane.resource;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.flightPlane.model.Nave;
import br.com.flightPlane.model.Planeta;
import br.com.flightPlane.model.SWModelList;
import br.com.flightPlane.model.Tripulacao;

/**
 * @author Ramon Vieira
 *
 */


public class SwapiResource implements Serializable {

	private static final long serialVersionUID = 6738641615781405179L;

	public static final String BASE_URL = "http://swapi.co/api/";
	public static final String PEOPLE_URL = "people/";
	public static final String STARSHIPS_URL = "starships/";
	public static final String PLANETS_URL = "planets/";
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tripulacao> findAllPeople(){
		URI uri = URI.create(BASE_URL + PEOPLE_URL);
		int geraId = 1;
		
		Client client = ClientBuilder.newClient();		
		WebTarget wr = client.target(uri);
		
		Gson gson = new Gson();
		Type listType = new TypeToken<SWModelList<Tripulacao>>(){}.getType();
		
		SWModelList<Tripulacao> a = gson.fromJson(wr.request(MediaType.APPLICATION_JSON_TYPE).get(String.class), listType);
		
		List<Tripulacao> tripulacoes = a.getResults(); 
		
		for (Tripulacao tripulacao : tripulacoes) {
			tripulacao.setId(geraId++);
		}
		
		return tripulacoes;
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Nave> findAllStarShips(){
		URI uri = URI.create(BASE_URL + STARSHIPS_URL);
		int geraId = 1;
		
		Client client = ClientBuilder.newClient();		
		WebTarget wr = client.target(uri);
		
		Gson gson = new Gson();
		Type listType = new TypeToken<SWModelList<Nave>>(){}.getType();
		
		SWModelList<Nave> a = gson.fromJson(wr.request(MediaType.APPLICATION_JSON_TYPE).get(String.class), listType);

		List<Nave> naves = a.getResults(); 
		
		for (Nave nave : naves) {
			nave.setId(geraId++);
		}
		
		return naves;
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Planeta> findAllPlantets(){
		URI uri = URI.create(BASE_URL + PLANETS_URL);
		int geraId = 1;
		
		Client client = ClientBuilder.newClient();		
		WebTarget wr = client.target(uri);
		
		Gson gson = new Gson();
		Type listType = new TypeToken<SWModelList<Planeta>>(){}.getType();
		
		SWModelList<Planeta> a = gson.fromJson(wr.request(MediaType.APPLICATION_JSON_TYPE).get(String.class), listType);

		List<Planeta> planetas = a.getResults(); 
		
		for (Planeta planeta : planetas) {
			planeta.setId(geraId++);
		}
		
		return planetas;
		
	}
	
}
