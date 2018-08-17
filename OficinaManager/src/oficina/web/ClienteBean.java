package oficina.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import oficina.cliente.Cliente;
import oficina.cliente.ClienteRN;
import oficina.pessoas.fisica.PessoaF;
import oficina.pessoas.fisica.PessoaFRN;


@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteBean {
	
	Cliente cli = new Cliente();
	Cliente cli2 = new Cliente();
	PessoaF pf = new PessoaF();
	PessoaF pf2 = new PessoaF();
	List<PessoaF>  cliFlist;
	
	
	
	public String salvar(){
		
		System.out.println("passando aqui em salvar inicio");
		
		
		ClienteRN cr = new ClienteRN();		
		PessoaFRN prn = new PessoaFRN();
		if(prn.chekCPF(pf.getCpf()) && pf.getId().getId()==null){
			FacesMessage faceMessage = new FacesMessage("Já existe um usuario com este CPF");			
			FacesContext.getCurrentInstance().addMessage(null, faceMessage);
			
			return null;
		}
		cr.salvar(cli);		
		prn.salvar(pf);
		onTabClose();//limpa os dados da aba enviar
		
		return "Cliente Salvo";
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

	
	
	public Cliente getCli2() {
		return cli2;
	}

	public void setCli2(Cliente cli2) {
		this.cli2 = cli2;
	}

	public PessoaF getPf() {
		return pf;
	}

	public void setPf(PessoaF pf) {
		this.pf = pf;
	}

	
	
	public PessoaF getPf2() {
		return pf2;
	}

	public void setPf2(PessoaF pf2) {
		this.pf2 = pf2;
	}

	public List<PessoaF> getCliFList() {
		return cliFlist;
	}

	public void setCliFList(List<PessoaF> clienteList) {
		this.cliFlist = clienteList;
	}
	
   
	
	
	public void onTabChange(TabChangeEvent event) {
        
        pf2.setCpf(pf.getCpf());
        pf2.setNome(pf.getNome());
        pf2.setRg(pf.getRg());
        
        
    }
	
	public void onTabClose() {
		pf2 = new PessoaF();
		
    }
 
   
     
   

}
