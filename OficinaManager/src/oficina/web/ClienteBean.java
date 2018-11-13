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
import oficina.contato.Endereco;
import oficina.pessoas.fisica.PessoaF;
import oficina.pessoas.fisica.PessoaFRN;
import oficina.pessoas.juridica.PessoaJ;
import oficina.pessoas.juridica.PessoaJRN;
import oficina.util.BuscaCep;


@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteBean {
	
	Cliente cli = new Cliente();
	Cliente cli2 = new Cliente();
	PessoaF pf = new PessoaF();
	PessoaF pf2 = new PessoaF();
	private PessoaJ pj = new PessoaJ();
	private PessoaJ pj2 = new PessoaJ();
	Contato contato = new Contato();
	Endereco endereco = new Endereco();
	//List<PessoaF>  cliFlist;
	private List<Cliente> cliFlist;
	private List<Cliente> cliJlist;
	String buscarCliente;
	private String pesquisaTipo;
	private String selCli="fisico";//seleciona cliente
	private boolean panel1=true;
	private boolean panel2=false;
	
	
	public ClienteBean() {
		super();
		setBuscarCliente("");
		setPesquisaTipo("");
		
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
				
		cr.salvar(cli);	//os demais clientes fisico juridico contato e endere�o continua sendo salvo em clienteRN
		onTabClose();//limpa os dados da aba enviar
		faceMessage = new FacesMessage("Salvo com sucesso!");			
		FacesContext.getCurrentInstance().addMessage(null, faceMessage);
		return faceMessage.getDetail();
		}
	}

public String salvarPJ(){
	
	FacesMessage faceMessage;
	
	
	ClienteRN cr = new ClienteRN();		
	PessoaJRN pjn = new PessoaJRN();
	if(pjn.chekCNPJ(pj.getCnpj()) && pj.getId_pessoa_j()==null){
					
		faceMessage = new FacesMessage("J� existe um usuario com este CNPJ!");			
		FacesContext.getCurrentInstance().addMessage(null, faceMessage);
		
		return faceMessage.getDetail();
	}else{
			
	cr.salvarJURIDICO(cli);	//os demais clientes fisico juridico contato e endere�o continua sendo salvo em clienteRN
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
	endereco = new Endereco();
	cli.setPf(pf);
	cli.setCt(contato);
	cli.setEd(endereco);
	onTabClose();
	
}

public void novoPJ(){
	cli = new Cliente();
	cli.setTipo(1);		
	pj = new PessoaJ();
	contato = new Contato();
	endereco = new Endereco();
	cli.setPj(pj);
	cli.setCt(contato);
	cli.setEd(endereco);	
	
}
	
public void delete(){
	ClienteRN cl = new ClienteRN();
	
	cl.deleteCliente(cli);
}

public void deletePJ(){
	ClienteRN cl = new ClienteRN();
	
	cl.deleteClienteJURIDICO(cli);
}
	
public void bscliFisico(){
	
	ClienteRN crn = new ClienteRN();
	cliFlist = crn.listarFisicos(getPesquisaTipo(),getBuscarCliente());
	
	
}

public void bscliJuridico(){
	
	ClienteRN crn = new ClienteRN();
	
	cliJlist = crn.listarPj(getPesquisaTipo(),getBuscarCliente());
	
	
	
}
	


	public List<Cliente> getCliJlist() {
	return cliJlist;
}



public void setCliJlist(List<Cliente> cliJlist) {
	this.cliJlist = cliJlist;
}



	public List<Cliente> getCliFLista() {
		
	
		return cliFlist;
		
	}

	public void setBuscarCliente(String buscarCliente) {
		this.buscarCliente = buscarCliente;
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
	
	public void validaCnpj(){
		
		PessoaJRN prn = new PessoaJRN();
		FacesMessage faceMessage;
		
		
		if(prn.chekCNPJ(pj.getCnpj())){
			
			
			faceMessage = new FacesMessage("J� existe um cliente com este CNPJ!");			
			FacesContext.getCurrentInstance().addMessage(null, faceMessage);
			
		}else{
			faceMessage = new FacesMessage("CNPJ n�o cadastrado.");			
			FacesContext.getCurrentInstance().addMessage(null, faceMessage);
		}
		
	}
	
	
	
	//gets e sets
	
	
	public Cliente getCli() {
		return cli;
	}

	public boolean isPanel1() {
		return panel1;
	}



	public void setPanel1(boolean panel1) {
		this.panel1 = panel1;
	}



	public boolean isPanel2() {
		return panel2;
	}



	public void setPanel2(boolean panel2) {
		this.panel2 = panel2;
	}



	public String getSelCli() {
		return selCli;
	}



	public void setSelCli(String selCli) {
		if(selCli.equals("fisico")){
			setPanel1(true);
			setPanel2(false);
		}else{
			setPanel1(false);
			setPanel2(true);
		}
	
		this.selCli = selCli;
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

	
	
	public PessoaJ getPj2() {
		return pj2;
	}



	public void setPj2(PessoaJ pj2) {
		this.pj2 = pj2;
	}



	public List<Cliente> getCliFList() {
		return cliFlist;
	}
	
   
	
	public String getBuscarCliente() {
		return buscarCliente;
	}
	
	
	public String getPesquisaTipo() {
		return pesquisaTipo;
	}



	public void setPesquisaTipo(String pesquisaTipo) {
		this.pesquisaTipo = pesquisaTipo;
	}



public void onTabChange(TabChangeEvent event) {
		
        cli2=cli;
    }
	
	public void onTabClose() {
		pf2 = new PessoaF();
			
    }
	
   public void buscaCep(){
   
	   BuscaCep b = new BuscaCep();	  	   
	   
	   Endereco edc = b.buscarCep(cli.getEd().getCep());
	   
	   FacesMessage faceMessage;
	   if(edc==null){
	   faceMessage = new FacesMessage("CEP n�o encontrado!");	
	   faceMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, faceMessage);
	   }else{
		   
		   cli.getEd().setBairro(edc.getBairro());
		   cli.getEd().setRua(edc.getRua());
		   cli.getEd().setCidade(edc.getCidade());
		   cli.getEd().setUf(edc.getUf());
		   
	   }
	   
	   
	   
     }
   

}



