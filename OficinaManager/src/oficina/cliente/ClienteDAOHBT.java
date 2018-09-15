package oficina.cliente;

import java.util.List;

import org.hibernate.Session;

public class ClienteDAOHBT implements ClienteDAO {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Cliente cliente) {
		
		this.session.save(cliente);

	}

	@Override
	public void atualizar(Cliente cliente) {
		this.session.clear();
		this.session.update(cliente);

	}

	@Override
	public void excluir(Cliente cliente) {
		this.session.clear();
		this.session.delete(cliente);
		
	}

	@Override
	public Cliente carregar(Integer cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscaPorNome(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() {
		
		return this.session.createCriteria(Cliente.class).list();
	}

}
