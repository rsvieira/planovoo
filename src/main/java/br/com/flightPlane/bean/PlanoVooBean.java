package br.com.flightPlane.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import br.com.flightPlane.model.Nave;
import br.com.flightPlane.model.Planeta;
import br.com.flightPlane.model.PlanoDeVoo;
import br.com.flightPlane.model.Tripulacao;
import br.com.flightPlane.service.PlanoVooService;

/**
 * @author Ramon Vieira
 *
 */

@ViewScoped
@ManagedBean(name = "planoVooBean")
public class PlanoVooBean implements Serializable {

	private static final long serialVersionUID = -2854217700981455855L;
	
	private PlanoVooService planoVooService;
	
	List<Tripulacao> tripulacaoTarget;

	private List<PlanoDeVoo> listPlanosVoo;
	
	private List<Tripulacao> tripulacaoList;
	private List<Nave> naveList;
	private List<Planeta> planetaList;
	
	private DualListModel<Tripulacao> dualListTripulacoes;
	
	private Nave naveSelecionada;
	private Planeta	planetaSelecionado;
	
	private PlanoDeVoo planoSelecionado;
	
	private List<Tripulacao> tripulacaoDetalhe;
	private Nave naveDetalhe;
	private Planeta	planetaDetalhe;

	@PostConstruct
	public void init(){
		instanciasList();
		planoVooService.populaListas(tripulacaoList, naveList, planetaList, dualListTripulacoes, tripulacaoTarget);
	}
	
	public void instanciasList(){
		planoVooService = new PlanoVooService();
		
		listPlanosVoo = new ArrayList<PlanoDeVoo>();
		
		tripulacaoList = new ArrayList<Tripulacao>();
		naveList = new ArrayList<Nave>();
		planetaList = new ArrayList<Planeta>();
		
		dualListTripulacoes = new DualListModel<>();
		tripulacaoTarget = new ArrayList<Tripulacao>();
		
	}
	
	public void criarPlano() {
		
		System.out.println("Criando plano de voo");
		
		if(planoVooService.validaCampos(naveSelecionada, planetaSelecionado, dualListTripulacoes)){
			
			PlanoDeVoo novo = new PlanoDeVoo();
			novo.setId(listPlanosVoo.size() == 0 ? 1 : listPlanosVoo.size() + 1);
			novo.setTripulacao(dualListTripulacoes.getTarget());
			novo.setNave(naveSelecionada);
			novo.setPlaneta(planetaSelecionado);

			if(planoVooService.validaPlanoVoo(listPlanosVoo, novo)){
				listPlanosVoo.add(novo);
				System.out.println("Plano de Voo criado com sucesso!!!");
				planoVooService.sucessMessage();
			} else {
				planoVooService.erroMessage();
			}
		} 
	}
	
	public void criaDetalhe(PlanoDeVoo plano){
		planoSelecionado = plano;
		tripulacaoDetalhe = planoSelecionado.getTripulacao();
		naveDetalhe = plano.getNave();
		planetaDetalhe = plano.getPlaneta();
	}

	public List<PlanoDeVoo> getListPlanosVoo() {
		return listPlanosVoo;
	}

	public void setListPlanosVoo(List<PlanoDeVoo> listPlanosVoo) {
		this.listPlanosVoo = listPlanosVoo;
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

	public List<Tripulacao> getTripulacaoDetalhe() {
		return tripulacaoDetalhe;
	}

	public void setTripulacaoDetalhe(List<Tripulacao> tripulacaoDetalhe) {
		this.tripulacaoDetalhe = tripulacaoDetalhe;
	}

	public PlanoDeVoo getPlanoSelecionado() {
		return planoSelecionado;
	}

	public void setPlanoSelecionado(PlanoDeVoo planoSelecionado) {
		this.planoSelecionado = planoSelecionado;
	}

	public Nave getNaveDetalhe() {
		return naveDetalhe;
	}

	public void setNaveDetalhe(Nave naveDetalhe) {
		this.naveDetalhe = naveDetalhe;
	}

	public Planeta getPlanetaDetalhe() {
		return planetaDetalhe;
	}

	public void setPlanetaDetalhe(Planeta planetaDetalhe) {
		this.planetaDetalhe = planetaDetalhe;
	}
	
}
