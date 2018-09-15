package oficina.pessoas.fisica;

import java.util.List;

import oficina.cliente.Cliente;
import oficina.util.DAOFactory;

public class PessoaFRN {
private PessoaFDAO pessoaDAO;
	
	public PessoaFRN(){
		this.pessoaDAO = DAOFactory.criaPessoaFDAO();
	}
	
	
	public void salvar(Cliente pf){
		Integer codigo = pf.getPf().getId_pessoa_f();
		
		
		if(codigo==null|| codigo==0){
					
			this.pessoaDAO.salvar(pf.getPf());		
			
		}else{				
			
			this.pessoaDAO.atualizar(pf.getPf());
		}		
	}
	
	public void deletePF(Cliente c){
		pessoaDAO.excluir(c.getPf());
	}
	
	public List<PessoaF> listar(){
		return this.pessoaDAO.listar();
	}
	
	public boolean chekCPF(String CPF){
		
		
		PessoaF f = this.pessoaDAO.buscaPorCPF(CPF);
		
		
		
		if(f==null){
			
			return false;
		}else{
			
			return true;
		}
		
	}
	
	public PessoaF buscarPorCliente(Cliente cli){
		return this.pessoaDAO.buscarCliente(cli);
		
	}
	
}
