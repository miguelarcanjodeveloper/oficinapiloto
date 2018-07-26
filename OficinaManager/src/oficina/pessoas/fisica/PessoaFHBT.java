package oficina.pessoas.fisica;

import java.util.List;

import org.hibernate.Session;

import oficina.cliente.Cliente;


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
		this.session.clear();
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
		
		return (PessoaF) this.session.get(PessoaF.class,CPF);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PessoaF> listar() {
		
		return this.session.createCriteria(PessoaF.class).list();
	}

	@Override
	public Cliente buscarCliente(Integer codigo) {
		
		return (Cliente) this.session.get(Cliente.class,codigo);
	}

	

}
