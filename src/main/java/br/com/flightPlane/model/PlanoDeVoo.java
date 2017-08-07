/**
 * 
 */
package br.com.flightPlane.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ramon Vieira
 *
 */

public class PlanoDeVoo implements Serializable{

	private int id;
	private Nave nave;
	private List<Tripulacao> tripulacao;
	private Planeta planeta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public List<Tripulacao> getTripulacao() {
		return tripulacao;
	}

	public void setTripulacao(List<Tripulacao> tripulacao) {
		this.tripulacao = tripulacao;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

	public String getNomesTripulacoes(){
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		if(tripulacao.size() > 0){
			for (Tripulacao pessoa : tripulacao) {
				if((tripulacao.size()-1) == count){
					sb.append(pessoa.getNome());
				} else {
					sb.append(pessoa.getNome() + ", ");
				}
				count++;
			}
			return sb.toString();
		}
		
		return "";	
	}
	
}
