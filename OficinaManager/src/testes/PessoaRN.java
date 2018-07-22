package testes;

import oficina.util.DAOFactory;

public class PessoaRN {

private PessoaHBT usuarioDAO;
	
	public PessoaRN(){
		this.usuarioDAO = DAOFactory.criaPessoaTeste();
	}
	
	
	public void salvar(Pessoa p){
		
		this.usuarioDAO.salvar(p);
		
	}
	
}
