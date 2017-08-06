/**
 * 
 */
package br.com.flightPlane.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * @author Ramon Vieira
 *
 */

public class Planeta implements Serializable {

	private static final long serialVersionUID = 1969368634328284303L;
	
	private int id;
	
	@SerializedName("name")
	private String nome;
	
	@SerializedName("diameter")
	private String diametro;
	
	@SerializedName("climate")
	private String clima;
	
	@SerializedName("terrain")
	private String terreno;
	
	@SerializedName("population")
	private String population;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiametro() {
		return diametro;
	}

	public void setDiametro(String diametro) {
		this.diametro = diametro;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

//	@Override
//	public String toString() {
//		return "\nPlaneta \n 		[id=" + id + "] nome=" + nome + "]\n		[ diametro=" + diametro + "]\n		[ clima=" + clima + "]\n		[ terreno="
//				+ terreno + "]\n		[ population=" + population + "]";
//	}

}
