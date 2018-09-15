package oficina.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cpfConverter")
public class CpfConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		if(valor != null || valor != "") {
			valor = valor.toString().replaceAll("[- /.]", "");
			valor = valor.toString().replaceAll("[-()]", "");
		}
		return valor;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		// TODO Auto-generated method stub
		return valor.toString();
	}

}
