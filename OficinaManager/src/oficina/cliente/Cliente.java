package oficina.cliente;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import oficina.contato.Contato;
import oficina.contato.Endereco;
import oficina.pessoas.fisica.PessoaF;
import oficina.pessoas.juridica.PessoaJ;

@Entity
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	private int tipo; // tipo do cliente fisica = 0 juridico =1
	@Transient
	private PessoaF pf;
	@Transient
	private PessoaJ pj;
	@Transient
	private Contato ct;
	@Transient
	private Endereco ed;
	
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cliente(Integer id, int tipo, PessoaF pf, Contato ct, Endereco ed) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.pf = pf;
		this.ct = ct;
		this.ed = ed;
	}
	
	
	
	public Cliente(Integer id, int tipo, PessoaJ pj, Contato ct, Endereco ed) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.pj = pj;
		this.ct = ct;
		this.ed = ed;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
	public PessoaF getPf() {
		return pf;
	}
	public void setPf(PessoaF pf) {
		this.pf = pf;
	}
	public PessoaJ getPj() {
		return pj;
	}
	public void setPj(PessoaJ pj) {
		this.pj = pj;
	}
	public Contato getCt() {
		return ct;
	}
	public void setCt(Contato ct) {
		this.ct = ct;
	}
	public Endereco getEd() {
		return ed;
	}
	public void setEd(Endereco ed) {
		this.ed = ed;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + tipo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
}
