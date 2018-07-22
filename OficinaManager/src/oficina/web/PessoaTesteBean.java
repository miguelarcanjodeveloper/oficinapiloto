package oficina.web;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hsqldb.lib.HashSet;

import testes.ClienteRn;
import testes.Endereco;
import testes.Pessoa;
import testes.PessoaRN;

@ManagedBean(name="pessoaTesteBean")
@ViewScoped
public class PessoaTesteBean {
	
	Pessoa pessoa = new Pessoa();
	Endereco end = new Endereco();
	private java.util.HashSet<Endereco> e = new java.util.HashSet<>();
	
	public PessoaTesteBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		PessoaRN pr = new PessoaRN();
		e.add(end);
		pessoa.setEnde(e);
		pessoa.setNome("João Paulo Antônio caça");
		pr.salvar(pessoa);
		
		
		
		System.out.println("Cadastro Salvo");
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}
	
	

}
