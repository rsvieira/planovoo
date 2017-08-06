/**
 * 
 */
package br.com.flightPlane.model;

/**
 * @author Ramon Vieira
 *
 */

public class PlanoDeVoo {

	private int id;
	private Nave nave;
	private Tripulacao tripulacao;
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

	public Tripulacao getTripulacao() {
		return tripulacao;
	}

	public void setTripulacao(Tripulacao tripulacao) {
		this.tripulacao = tripulacao;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

}
