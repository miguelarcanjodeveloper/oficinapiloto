package oficina.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import testes.Cliente_teste;
import testes.ClienteRn;
import testes.Endereco;
import testes.Pessoa;

@ManagedBean(name="clienteTesteBean")
@SessionScoped
public class ClienteTesteBean {
	
	private Cliente_teste cli = new Cliente_teste();
			
	private Pessoa pessoa = new Pessoa();
	private Endereco endereco = new Endereco();
	
	public ClienteTesteBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		cli.setEndereco(endereco);
		cli.setPessoa(pessoa);
		ClienteRn cliRn = new ClienteRn();
		
		cliRn.salvar(cli);
		
		System.out.println("Cadastro Salvo");
		
	}

	public Cliente_teste getCli() {
		return cli;
	}

	public void setCli(Cliente_teste cli) {
		this.cli = cli;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}
