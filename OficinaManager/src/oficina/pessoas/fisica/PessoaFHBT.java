package oficina.pessoas.fisica;

import java.util.List;

import org.hibernate.Session;


public class PessoaFHBT implements PessoaFDAO {
private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(PessoaF P) {
		
		this.session.save(P);
		
	}

	@Override
	public void atualizar(PessoaF P) {
		
		this.session.update(P);
		
	}

	@Override
	public void excluir(PessoaF P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PessoaF carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PessoaF buscaPorNome(String NOME) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PessoaF buscaPorCPF(Integer CPF) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PessoaF> listar() {
		
		return this.session.createCriteria(PessoaF.class).list();
	}

	

}
