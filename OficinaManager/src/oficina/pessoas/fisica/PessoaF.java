package oficina.pessoas.fisica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NaturalId;

import oficina.cliente.Cliente;




/*
 * 
 * 
PessoaF Física

CPF:	
Nome:	
R.G.:		

PessoaF Jurídica 

CNPJ:	
Razão Social:	nome completo da empresa.
Nome Fantasia:	
Insc. Estadual:	

 * 
 */

@Entity
public class PessoaF implements Serializable{

	private static final long serialVersionUID = -324736609926029079L;
	
	@Id
	@GeneratedValue
	private Integer id_pessoa_f;
	private String nome;
	private String sexo;
	private String rg;
	@NaturalId(mutable=true)
	@Column(name = "cpf", unique = true, nullable = true)
	private Integer cpf;
	private Date nascimento;
	@OneToOne(cascade=CascadeType.ALL)
	private Cliente id;
	
	
	/***
	 * get and set
	 * @return
	 */
	public Integer getId_pessoa_f() {
		return id_pessoa_f;
	}
	public void setId_pessoa_f(Integer id_pessoa_f) {
		this.id_pessoa_f = id_pessoa_f;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public Date getNascimento() {
		return nascimento;
	}
	
	public Cliente getId() {
		return id;
	}
	public void setId(Cliente id) {
		this.id = id;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	

}
