package oficina.contato;


import oficina.cliente.Cliente;
import oficina.util.DAOFactory;

public class ContatoRN {

	
	private ContatoDAO contatoDAO;
	
	public ContatoRN(){		
		this.contatoDAO = DAOFactory.criaContatoDAO();
	}
	
	public void salvar(Cliente c){
		Integer codigo = c.getCt().getId();
		
		if(codigo==null|| codigo==0){//se for contato novo salva caso contrario so atualiza o mesmo
					
			this.contatoDAO.salvar(c.getCt());
			
		}else{				
			
			this.contatoDAO.atualizar(c.getCt());			
			
		}		
	}

	public void deleteContato(Cliente c){
		contatoDAO.excluir(c.getCt());
	}
	
	public Contato buscaPorCliente(Cliente cli){
		
		return this.contatoDAO.buscaPorCliente(cli.getId());
	}
	
}
