package br.com.flightPlane.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.junit.runners.Parameterized.UseParametersRunnerFactory;
import org.primefaces.model.DualListModel;

import br.com.flightPlane.model.Nave;
import br.com.flightPlane.model.Planeta;
import br.com.flightPlane.model.PlanoDeVoo;
import br.com.flightPlane.model.Tripulacao;
import br.com.flightPlane.resource.SwapiResource;

/**
 * @author Ramon Vieira
 *
 */

@ViewScoped
@ManagedBean(name = "planoVooBean")
public class PlanoVooBean implements Serializable {

	private static final long serialVersionUID = -2854217700981455855L;

	private SwapiResource swapiResource;

	private List<PlanoDeVoo> listPlanosVoo;
	
	private List<Tripulacao> tripulacaoList;
	private List<Nave> naveList;
	private List<Planeta> planetaList;
	
	private DualListModel<Tripulacao> dualListTripulacoes;
	
	private Nave naveSelecionada;
	private Planeta	planetaSelecionado;

	@PostConstruct
	public void init(){
		swapiResource = new SwapiResource();
		listPlanosVoo = new ArrayList<PlanoDeVoo>();
		populaListas();
	}
	
	public void populaListas() {

		tripulacaoList = swapiResource.findAllPeople();
		naveList = swapiResource.findAllStarShips();
		planetaList = swapiResource.findAllPlantets();
		
        List<Tripulacao> tripulacaoTarget = new ArrayList<Tripulacao>();
         
        dualListTripulacoes = new DualListModel<Tripulacao>(tripulacaoList, tripulacaoTarget);
		
	}
	
	public void inserePlanoVoo(){
		
	}
	
	public void criarPlano() {
		
		System.out.println("Criando plano de voo");
		
		if(validaPlanoVoo()){
			
			PlanoDeVoo novo = new PlanoDeVoo();
			novo.setId(listPlanosVoo.size() == 0 ? 1 : listPlanosVoo.size() + 1);
			novo.setTripulacao(dualListTripulacoes.getTarget());
			novo.setNave(naveSelecionada);
			novo.setPlaneta(planetaSelecionado);
			
			listPlanosVoo.add(novo);
			System.out.println("Plano de Voo criado com sucesso!!!");
		}
		
	}
	
	public boolean validaPlanoVoo(){
		if(naveSelecionada == null || planetaSelecionado == null){
			System.out.println("Não foi possível criar Plano de Voo.");
			return false;
		}
		
		if(dualListTripulacoes == null || dualListTripulacoes.getTarget() == null || 
				dualListTripulacoes.getTarget().isEmpty() || dualListTripulacoes.getTarget().size() == 0){
			System.out.println("Não foi possível criar Plano de Voo.");
			return false;
		}
		
		return true;
	}

	public List<PlanoDeVoo> getListPlanosVoo() {
		return listPlanosVoo;
	}

	public void setListPlanosVoo(List<PlanoDeVoo> listPlanosVoo) {
		this.listPlanosVoo = listPlanosVoo;
	}

	public SwapiResource getSwapiResource() {
		return swapiResource;
	}

	public void setSwapiResource(SwapiResource swapiResource) {
		this.swapiResource = swapiResource;
	}

	public List<Tripulacao> getTripulacaoList() {
		return tripulacaoList;
	}

	public void setTripulacaoList(List<Tripulacao> tripulacaoList) {
		this.tripulacaoList = tripulacaoList;
	}

	public List<Nave> getNaveList() {
		return naveList;
	}

	public void setNaveList(List<Nave> naveList) {
		this.naveList = naveList;
	}

	public List<Planeta> getPlanetaList() {
		return planetaList;
	}

	public void setPlanetaList(List<Planeta> planetaList) {
		this.planetaList = planetaList;
	}

	public DualListModel getDualListTripulacoes() {
		return dualListTripulacoes;
	}

	public void setDualListTripulacoes(DualListModel dualListTripulacoes) {
		this.dualListTripulacoes = dualListTripulacoes;
	}

	public Nave getNaveSelecionada() {
		return naveSelecionada;
	}

	public void setNaveSelecionada(Nave naveSelecionada) {
		this.naveSelecionada = naveSelecionada;
	}

	public Planeta getPlanetaSelecionado() {
		return planetaSelecionado;
	}

	public void setPlanetaSelecionado(Planeta planetaSelecionado) {
		this.planetaSelecionado = planetaSelecionado;
	}
	
}
