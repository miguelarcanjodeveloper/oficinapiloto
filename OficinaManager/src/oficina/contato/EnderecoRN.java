package oficina.contato;

import oficina.cliente.Cliente;
import oficina.util.DAOFactory;

public class EnderecoRN {


private EnderecoDAO endDao;

	public EnderecoRN(){
		this.endDao = DAOFactory.criaEnderecoDAO();
	}
		
	public void salvar(Cliente c){
		Integer codigo = c.getCt().getId();
		
		if(codigo==null|| codigo==0){//se for endereço novo salva caso contrario so atualiza o mesmo
					
			this.endDao.salvar(c.getEd());
			
		}else{				
			
			this.endDao.atualizar(c.getEd());		
			
		}		
	}

	public void deleteContato(Cliente c){
		endDao.excluir(c.getEd());
	}
	
	public Endereco buscaPorCliente(Cliente cli){
		
		return this.endDao.buscaPorCliente(cli.getId());
	}
	
}
