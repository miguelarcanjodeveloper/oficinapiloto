package oficina.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import oficina.cliente.Cliente;
import oficina.cliente.ClienteRN;
import oficina.pessoas.fisica.PessoaF;
import oficina.pessoas.fisica.PessoaFRN;

@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteBean {
	
	Cliente cli = new Cliente();
	PessoaF pf = new PessoaF();
	List<PessoaF>  cliFlist;
	
	
	public void salvar(){
		ClienteRN cr = new ClienteRN();
		cr.salvar(cli);
		
		PessoaFRN prn = new PessoaFRN();
		pf.setId(cli);
		prn.salvar(pf);
		
	}
	
	public List<PessoaF> getCliFLista() {
		this.cliFlist = null;
		PessoaFRN pfr = new PessoaFRN();
				
		this.cliFlist = pfr.listar();
						
		return cliFlist;
	}

	//gets e sets
	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}

	public PessoaF getPf() {
		return pf;
	}

	public void setPf(PessoaF pf) {
		this.pf = pf;
	}

	public List<PessoaF> getCliFList() {
		return cliFlist;
	}

	public void setCliFList(List<PessoaF> clienteList) {
		this.cliFlist = clienteList;
	}
	
	

}
