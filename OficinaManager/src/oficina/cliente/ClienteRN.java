package oficina.cliente;

import java.util.List;

import oficina.util.DAOFactory;

public class ClienteRN {

private ClienteDAO clienteDAO;
	
	public ClienteRN(){
		this.clienteDAO = DAOFactory.criaClienteDAO();
	}
	
	public void salvar(Cliente cli){
		Integer codigo = cli.getId();
		
		if(codigo==null|| codigo==0){
					
			this.clienteDAO.salvar(cli);			
		}else{			
			this.clienteDAO.atualizar(cli);
		}		
	}
	
	public List<Cliente> listar() {
		return this.clienteDAO.listar();
	}
	
}
