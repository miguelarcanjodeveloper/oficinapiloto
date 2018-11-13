package oficina.pessoas.juridica;

import java.util.List;

import oficina.cliente.Cliente;
import oficina.pessoas.fisica.PessoaF;
import oficina.util.DAOFactory;

public class PessoaJRN {

private PessoaJDAO pessoaDAO;
	
	public PessoaJRN(){
		this.pessoaDAO = DAOFactory.criaPessoaJDAO();
	}
	
	public void salvar(Cliente pj){
		Integer codigo = pj.getPj().getId_pessoa_j();
		
		
		if(codigo==null|| codigo==0){
					
			this.pessoaDAO.salvar(pj.getPj());		
			
		}else{				
			
			this.pessoaDAO.atualizar(pj.getPj());
		}		
	}
	
	public void deletePJ(Cliente c){
		pessoaDAO.excluir(c.getPj());
	}
	
	public List<PessoaJ> listar(){
		return this.pessoaDAO.listar();
	}
	
	public boolean chekCNPJ(String CNPJ){
		
		
		PessoaJ j = this.pessoaDAO.buscaPorCNPJ(CNPJ);
		
		
		
		if(j==null){
			
			return false;
		}else{
			
			return true;
		}
		
	}
	
	
	
	
}
