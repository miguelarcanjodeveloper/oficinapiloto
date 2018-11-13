package oficina.cliente;

import java.util.List;
import oficina.contato.ContatoRN;
import oficina.contato.EnderecoRN;
import oficina.pessoas.fisica.PessoaFRN;
import oficina.pessoas.juridica.PessoaJRN;
import oficina.util.DAOFactory;

public class ClienteRN {

	private ClienteDAO clienteDAO;
	
	PessoaFRN PFRN = new PessoaFRN();
	PessoaJRN PJRN = new PessoaJRN();
	ContatoRN crn = new ContatoRN();
	EnderecoRN end = new EnderecoRN();

	public ClienteRN(){
		this.clienteDAO = DAOFactory.criaClienteDAO();
	}
	
	public void salvar(Cliente cli){
		Integer codigo = cli.getId();
		
		if(codigo==null|| codigo==0){
					
			this.clienteDAO.salvar(cli);
			
				cli.getPf().setId(cli);// seta o id_cliente para o cliente fisico
				cli.getCt().setCliente_id(cli);//seta o id_cliente para o contato
				cli.getEd().setCliente_id(cli);
				PFRN.salvar(cli);//salva o cliente fisico				
				crn.salvar(cli);//salva o contato
				end.salvar(cli);//salva endereço
				
			
		}else{	
			//Neste caso so atualiza não atribui outro ID CLIENTE
			crn.salvar(cli);
			PFRN.salvar(cli);
			end.salvar(cli);
		}		
	}
	
	public void salvarJURIDICO(Cliente cli){
		Integer codigo = cli.getId();
		
		if(codigo==null|| codigo==0){
					
			this.clienteDAO.salvar(cli);
			
			cli.getPj().setId_cliente(cli);// seta o id_cliente para o cliente juridico
			cli.getCt().setCliente_id(cli);//seta o id_cliente para o contato
			cli.getEd().setCliente_id(cli);
			PJRN.salvar(cli);//salva o cliente fisico				
			crn.salvar(cli);//salva o contato
			end.salvar(cli);//salva endereço
		}else{	
			//Neste caso so atualiza não atribui outro ID CLIENTE
			crn.salvar(cli);
			PJRN.salvar(cli);
			end.salvar(cli);
		}		
	}
	
	public void deleteCliente(Cliente c){
		if(c.getPf()!=null)PFRN.deletePF(c);		
		if(c.getCt()!=null)crn.deleteContato(c);
		if(c.getEd()!=null)end.deleteContato(c);
		
	}
	
	public void deleteClienteJURIDICO(Cliente c){
		if(c.getPj()!=null)PJRN.deletePJ(c);		
		if(c.getCt()!=null)crn.deleteContato(c);
		if(c.getEd()!=null)end.deleteContato(c);
		
	}
	
	
	public List<Cliente> listarFisicos(String tipo,String pesquisa) {
		List<Cliente> cli = this.clienteDAO.buscaAvancadaF(tipo, pesquisa);		
		return cli;
	}
	
	public List<Cliente> listarPj(String tipo,String pesquisa) {
		List<Cliente> cli = this.clienteDAO.buscaAvancadaJ(tipo, pesquisa);		
		return cli;
	}
	
}
