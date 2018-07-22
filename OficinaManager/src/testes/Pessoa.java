package testes;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id_pessoa_f;
	private String nome;
	private String sexo;
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="pessoa_endereco",joinColumns={@JoinColumn(name="id_pessoa_f")}, inverseJoinColumns={@JoinColumn(name="id_endereco")})
	private Set<Endereco>  ende = new HashSet<Endereco>() ;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	public Set<Endereco> getEnde() {
		return ende;
	}
	public void setEnde(Set<Endereco> ende) {
		this.ende = ende;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ende == null) ? 0 : ende.hashCode());
		result = prime * result + ((id_pessoa_f == null) ? 0 : id_pessoa_f.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (ende == null) {
			if (other.ende != null)
				return false;
		} else if (!ende.equals(other.ende))
			return false;
		if (id_pessoa_f == null) {
			if (other.id_pessoa_f != null)
				return false;
		} else if (!id_pessoa_f.equals(other.id_pessoa_f))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}
	
	

}
