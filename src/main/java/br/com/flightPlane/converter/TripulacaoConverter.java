/**
 * 
 */
package br.com.flightPlane.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.flightPlane.model.Tripulacao;

/**
 * @author Ramon Vieira
 *
 */
@FacesConverter(forClass=Tripulacao.class, value="tripulacaoConverter")
public class TripulacaoConverter implements Converter{

	    @Override
	    public Object getAsObject(FacesContext context, UIComponent component, String value) {                

	        if(value == null || value.isEmpty()){
	            return null;

	        }
	        
	        Tripulacao tripulacao = new Tripulacao();
	        tripulacao.setId(Integer.parseInt(value));
	        return tripulacao;
	        
	    }    

	    @Override
	    public String getAsString(FacesContext context, UIComponent component,
	            Object value) {
	    	Tripulacao tripulacao = (Tripulacao)value;
	        if(tripulacao != null){
	            return tripulacao.getId().toString();
	        }else{
	            return null;
	        }

	    }
	
}
