/**
 * 
 */
package br.com.flightPlane.bean;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.flightPlane.model.Nave;
import br.com.flightPlane.model.Planeta;
import br.com.flightPlane.model.PlanoDeVoo;
import br.com.flightPlane.model.Tripulacao;
import br.com.flightPlane.service.PlanoVooService;

/**
 * @author Ramon Vieira
 *
 */
public class PlanoVooBeanTest {
	
	private List<PlanoDeVoo> planoDeVooList;
	
	private PlanoVooService service;
	
	@Before
	public void setUp() {
		service = new PlanoVooService();
		planoDeVooList = new ArrayList<PlanoDeVoo>();
	}
	
	public PlanoDeVoo planoBuildRandom(String nome1, String nome2, String nome3, String planeta, int qtdPassageiros){
		
		PlanoDeVoo planoDeVoo = new PlanoDeVoo();
		
		List<Tripulacao> tripulacaoList = new ArrayList<Tripulacao>();
		
		tripulacaoList.add(new Tripulacao(nome1, null));
		tripulacaoList.add(new Tripulacao(nome2,null));
		tripulacaoList.add(new Tripulacao(nome3,null));
		planoDeVoo.setTripulacao(tripulacaoList);
		
		planoDeVoo.setNave(new Nave("Millennium Falcon", qtdPassageiros));
		
		planoDeVoo.setPlaneta(new Planeta(planeta));
		
		return planoDeVoo;
	}

	@Test
	public void validaDestino() {
		
		PlanoDeVoo plano = planoBuildRandom("João", "Maria", "jose", "Malte", 10);
		planoDeVooList.add(plano);
		
		PlanoDeVoo plano2 = planoBuildRandom("João", "Maria", "jose", "terra", 10);
		
		boolean planoValido2 = service.validaPlanoVoo(planoDeVooList, plano2);
		
		assertEquals(true,planoValido2);
		
		planoDeVooList.add(plano2);
		
		PlanoDeVoo plano3 = plano2;
		
		boolean planoValido3 = service.validaPlanoVoo(planoDeVooList, plano3);
		
		assertEquals(false,planoValido3);
		
	}
	
	@Test
	public void validaQuantidadePassageiros() {
		
		PlanoDeVoo plano = planoBuildRandom("João", "Maria", "jose", null, 2);
		PlanoDeVoo plano2 = planoBuildRandom("João", "Maria", "jose", "terra", 10);
		
		planoDeVooList.add(plano);
		
		boolean planoValido = service.validaPlanoVoo(planoDeVooList, plano);
		
		assertEquals(false,planoValido);
		
		boolean planoValido2 = service.validaPlanoVoo(planoDeVooList, plano2);
		
		assertEquals(true,planoValido2);
		
	}

}
