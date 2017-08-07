/**
 * 
 */
package br.com.flightPlane.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
public class PlanoVooService {
	
	private SwapiResource swapiResource;
	
	public PlanoVooService(){
		swapiResource = new SwapiResource();
	}
	
	public void populaListas(List<Tripulacao> tripulacaoList, List<Nave> naveList, List<Planeta> planetaList,
			DualListModel<Tripulacao> dualListTripulacoes, List<Tripulacao> tripulacaoTarget) {

		tripulacaoList.addAll(swapiResource.findAllPeople()); 
		
		naveList.addAll(swapiResource.findAllStarShips());
		planetaList.addAll(swapiResource.findAllPlantets());
         
        dualListTripulacoes.setSource(tripulacaoList);
        dualListTripulacoes.setTarget(tripulacaoTarget);
		
	}
	
	public boolean validaCampos(Nave naveSelecionada, Planeta planetaSelecionado,
			DualListModel<Tripulacao> dualListTripulacoes){
		
		if(naveSelecionada == null || planetaSelecionado == null){
			System.out.println("Não foi possível criar Plano de Voo.");
			erroMessage();
			return false;
		}
		
		if(dualListTripulacoes == null || dualListTripulacoes.getTarget() == null || 
				dualListTripulacoes.getTarget().isEmpty() || dualListTripulacoes.getTarget().size() == 0){
			System.out.println("Não foi possível criar Plano de Voo.");
			erroMessage();
			return false;
		}
		
		return true;
	}
	
	public boolean validaPlanoVoo(List<PlanoDeVoo> planoDeVooList, PlanoDeVoo planoDeVoo){

		if(planoDeVooList == null || planoDeVoo == null){
			return false;
		}
		
		if(planoDeVoo != null && planoDeVoo.getTripulacao().size() > planoDeVoo.getNave().getPassageiros()){
				return false;
		}
		
		if(planoDeVooList != null && planoDeVooList.size() >= 1){
			if(planoDeVooList.get(planoDeVooList.size() - 1).getPlaneta().equals(planoDeVoo.getPlaneta())){
				return false;
			}
		}
		
		return true;
	}
	
    public void erroMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",  "Não foi possível criar Plano de Voo.") );
    }
    
    public void sucessMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso",  "Plano de Voo criado com sucesso.") );
    }

}
