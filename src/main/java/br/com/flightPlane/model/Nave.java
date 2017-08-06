package br.com.flightPlane.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * @author Ramon Vieira
 *
 */

public class Nave implements Serializable{

	private static final long serialVersionUID = -4613367302591441494L;

	private int id;
	
	@SerializedName("name")
	private String nome;
	
	@SerializedName("model")
	private String modelo;
	
	@SerializedName("passengers")
	private int passageiros;

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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}
	
//	@Override
//	public String toString() {
//		return "\nNave \n		[id=" + id + "]\n		[nome=" + nome + "]\n		[modelo=" + modelo + "]\n"
//				+ "		[passageiros=" + passageiros + "]\n";
//	}

}
