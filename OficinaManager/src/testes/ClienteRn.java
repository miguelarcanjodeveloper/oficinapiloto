package testes;

import oficina.util.DAOFactory;

public class ClienteRn {
	
private CadastroTeste usuarioDAO;
	
	public ClienteRn(){
		this.usuarioDAO = DAOFactory.criaClinteTeste();
	}
	
	
	public void salvar(Cliente_teste cli){
		
		this.usuarioDAO.salvar(cli);
		
	}

}
