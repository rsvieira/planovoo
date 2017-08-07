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

public class Tripulacao implements Serializable {

	private static final long serialVersionUID = 6745333258376367190L;

	private Integer id;

	@SerializedName("name")
	private String nome;

	@SerializedName("gender")
	private String genero;
	
	public Tripulacao (){
		
	}
	
	public Tripulacao (String nome, String genero){
		this.nome = nome;
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Tripulacao other = (Tripulacao) obj;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
//
//	@Override
//	public String toString() {
//		return "\nTripulacao \n		[id=" + id + "]\n		[nome=" + nome + "]\n		[genero=" + genero + "]";
//	}
	
}
