package oficina.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import oficina.contato.Endereco;

public class BuscaCep {

	private String lougradouro="";
	private String bairro="";
	private String cidade="";
	private String uf="";
	private Endereco ende;
	
	public Endereco buscarCep(String cep) 
    {
        String json;        

        /**
         * remove formatação
         */
        if(cep != null || cep != "") {
        	cep = cep.toString().replaceAll("[- /.]", "");
        	cep = cep.toString().replaceAll("[-()]", ""); 
			
	  }
        
        
        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
            
            
                             
            lougradouro = array[7];            
            bairro = array[15];
            cidade = array[19]; 
            uf = array[23];
            
            ende = new Endereco();
            ende.setBairro(bairro);
            ende.setCidade(cidade);
            ende.setRua(lougradouro);
            ende.setUf(uf);                        
            
           return ende;
            
        } catch (Exception e) {
            //throw new RuntimeException(e);
          return null;
        }
    }
	
}
