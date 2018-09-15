package oficina.web;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;
import oficina.cliente.Cliente;
import oficina.cliente.ClienteRN;
import oficina.contato.Contato;
import oficina.pessoas.fisica.PessoaF;
import oficina.pessoas.fisica.PessoaFRN;


@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteBean {
	
	Cliente cli = new Cliente();
	Cliente cli2 = new Cliente();
	PessoaF pf = new PessoaF();
	PessoaF pf2 = new PessoaF();
	Contato contato = new Contato();
	List<PessoaF>  cliFlist;
	
	
	
	public ClienteBean() {
		super();
	}

	public String salvar(){
		
		FacesMessage faceMessage;
		
		
		ClienteRN cr = new ClienteRN();		
		PessoaFRN prn = new PessoaFRN();
		if(prn.chekCPF(pf.getCpf()) && pf.getId_pessoa_f()==null){
						
			faceMessage = new FacesMessage("J� existe um usuario com este CPF!");			
			FacesContext.getCurrentInstance().addMessage(null, faceMessage);
			
			return faceMessage.getDetail();
		}else{
			
		//cli.setPf(getPf());	
		cr.salvar(cli);	//os demais clientes fisico juridico contato e endere�o continua sendo salvo em clienteRN
		onTabClose();//limpa os dados da aba enviar
		faceMessage = new FacesMessage("Salvo com sucesso!");			
		FacesContext.getCurrentInstance().addMessage(null, faceMessage);
		return faceMessage.getDetail();
		}
	}
	
	public void novo(){
		cli = new Cliente();
		cli.setTipo(0);		
		pf = new PessoaF();
		contato = new Contato();
		cli.setPf(pf);
		cli.setCt(contato);
		onTabClose();
		
	}
	
	public void delete(){
		ClienteRN cl = new ClienteRN();
		
		cl.deleteCliente(cli);
	}
	
	public List<Cliente> getCliFLista() {
		
		ClienteRN crn = new ClienteRN();
		return crn.listarFisicos();
		
	}

	public void validaCpf(){
		PessoaFRN prn = new PessoaFRN();
		
		FacesMessage faceMessage;
		
		
		if(prn.chekCPF(pf.getCpf())){
			
			
			faceMessage = new FacesMessage("J� existe um usuario com este CPF!");			
			FacesContext.getCurrentInstance().addMessage(null, faceMessage);
			
		}else{
			faceMessage = new FacesMessage("CPF n�o cadastrado.");			
			FacesContext.getCurrentInstance().addMessage(null, faceMessage);
		}
		
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
		
        pf2.setCpf(cli.getPf().getCpf());
        pf2.setNome(cli.getPf().getNome());
        pf2.setRg(cli.getPf().getRg());
        pf2.setRg(cli.getPf().getRg());
        pf2.setNascimento(cli.getPf().getNascimento());                       
        pf2.setSexo(cli.getPf().getSexo());
        cli.getCt().getCelular();
    }
	
	public void onTabClose() {
		pf2 = new PessoaF();
			
    }
	
     
   

}



