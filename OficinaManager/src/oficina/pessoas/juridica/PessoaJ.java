package oficina.pessoas.juridica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PessoaJ implements Serializable{

	private static final long serialVersionUID = -5275301959679149634L;
	
	@Id
	@GeneratedValue
	private Integer id_pessoa;
	private String nomeFantasia; // 
	private String rs;//razao social
	private Date abertura; //
	private Integer cnpj; //
	private Integer ie; //inscrição estadual
	private Integer im; //inscrição municipal

}
