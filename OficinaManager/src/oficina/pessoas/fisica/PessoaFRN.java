package oficina.pessoas.fisica;

import java.util.List;

import oficina.util.DAOFactory;

public class PessoaFRN {
private PessoaFDAO pessoaDAO;
	
	public PessoaFRN(){
		this.pessoaDAO = DAOFactory.criaPessoaFDAO();
	}
	
	public void salvar(PessoaF pf){
		Integer codigo = pf.getId_pessoa_f();
		
		if(codigo==null|| codigo==0){
					
			this.pessoaDAO.salvar(pf);			
		}else{			
			this.pessoaDAO.atualizar(pf);
		}		
	}
	
	public List<PessoaF> listar(){
		return this.pessoaDAO.listar();
	}
}
