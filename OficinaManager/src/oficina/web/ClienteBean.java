package oficina.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
	
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		ClienteRN cr = new ClienteRN();		
		PessoaFRN prn = new PessoaFRN();
		if(prn.chekCPF(pf.getCpf())){
			FacesMessage faceMessage = new FacesMessage("Já existe um usuario com este CPF");
			context.addMessage(null, faceMessage);
			return null;
		}
		cr.salvar(cli);		
		prn.salvar(pf);
		return "cliente";
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
