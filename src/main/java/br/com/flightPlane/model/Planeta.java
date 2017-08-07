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
	
	public Planeta(){
		
	}
	
	public Planeta(String nome){
		this.nome = nome;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clima == null) ? 0 : clima.hashCode());
		result = prime * result + ((diametro == null) ? 0 : diametro.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((population == null) ? 0 : population.hashCode());
		result = prime * result + ((terreno == null) ? 0 : terreno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planeta other = (Planeta) obj;
		if (clima == null) {
			if (other.clima != null)
				return false;
		} else if (!clima.equals(other.clima))
			return false;
		if (diametro == null) {
			if (other.diametro != null)
				return false;
		} else if (!diametro.equals(other.diametro))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (population == null) {
			if (other.population != null)
				return false;
		} else if (!population.equals(other.population))
			return false;
		if (terreno == null) {
			if (other.terreno != null)
				return false;
		} else if (!terreno.equals(other.terreno))
			return false;
		return true;
	}
	
//	@Override
//	public String toString() {
//		return "\nPlaneta \n 		[id=" + id + "] nome=" + nome + "]\n		[ diametro=" + diametro + "]\n		[ clima=" + clima + "]\n		[ terreno="
//				+ terreno + "]\n		[ population=" + population + "]";
//	}

}
