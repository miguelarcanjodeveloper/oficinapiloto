package oficina.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("telefoneConverter")
public class TelefoneConverter implements Converter{

	public String getAsString(FacesContext context, UIComponent component, Object valor) {
		
		
		return valor.toString();
	}
		  
		  public Object getAsObject(FacesContext context, UIComponent component, String valor) {
			  Integer i = new Integer(0);
			  if(valor != null || valor != "") {
					valor = valor.toString().replaceAll("[- /.]", "");
					valor = valor.toString().replaceAll("[-()]", ""); 
					
			  }
			  return valor;
		  }

}
