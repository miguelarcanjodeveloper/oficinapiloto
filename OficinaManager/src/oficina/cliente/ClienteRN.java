package oficina.cliente;

import java.util.ArrayList;
import java.util.List;

import com.sun.security.ntlm.Client;

import oficina.contato.ContatoRN;
import oficina.pessoas.fisica.PessoaFDAO;
import oficina.pessoas.fisica.PessoaFRN;
import oficina.util.DAOFactory;

public class ClienteRN {

	private ClienteDAO clienteDAO;
	
	PessoaFRN PFRN = new PessoaFRN();
	ContatoRN crn = new ContatoRN();

	public ClienteRN(){
		this.clienteDAO = DAOFactory.criaClienteDAO();
	}
	
	public void salvar(Cliente cli){
		Integer codigo = cli.getId();
		
		if(codigo==null|| codigo==0){
					
			this.clienteDAO.salvar(cli);
			
			if (cli.getTipo()==0){//se for 0 então é cliente fisico
				cli.getPf().setId(cli);// seta o id_cliente para o cliente fisico
				cli.getCt().setCliente_id(cli);//seta o id_cliente para o contato
				PFRN.salvar(cli);//salva o cliente fisico				
				crn.salvar(cli);//salva o contato
			}else{
				
			}
		}else{	
			//Neste caso so atualiza não atribui outro ID CLIENTE
			crn.salvar(cli);
			PFRN.salvar(cli);
		}		
	}
	
	public void deleteCliente(Cliente c){
		if(c.getPf()!=null){
			
			PFRN.deletePF(c);
		}
		if(c.getCt()!=null)crn.deleteContato(c);
		
	}
	
	/***
	 * dentro da lista de cliente existe as pessoas fisicas, pj e endereços
	 * contato. que serão manipulados o preenchimento dela aqui
	 * @return
	 */
	public List<Cliente> listarFisicos() {
		List<Cliente> cli = this.clienteDAO.listar();
		//List<Cliente> cli2 =  new ArrayList<>();
		
		for (Cliente cliente : cli) {
			cliente.setPf(this.PFRN.buscarPorCliente(cliente));
			cliente.setCt(crn.buscaPorCliente(cliente));
			if(cliente.getPf()!=null && cliente.getTipo()==1)
			cli.remove(cliente);
		}
		
		return cli;
	}
	
	public List<Cliente> listarPj() {
		List<Cliente> cli = this.clienteDAO.listar();
		List<Cliente> cli2 =  new ArrayList<>();
		
		for (Cliente cliente : cli) {
			cliente.setPf(this.PFRN.buscarPorCliente(cliente));
			if(cliente.getPf()!=null && cliente.getTipo()==1)//se houver o cliente e for do tipo pj juridico
			cli2.add(cliente);
		}
		
		return cli2;
	}
	
}
