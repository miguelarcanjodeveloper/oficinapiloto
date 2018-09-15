package oficina.contato;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import oficina.pessoas.fisica.PessoaF;

public class ContatoDAOHBT implements ContatoDAO{

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Contato contato) {
		
		this.session.save(contato);
		
	}

	@Override
	public void atualizar(Contato contato) {
		this.session.clear();
		this.session.update(contato);
	}

	@Override
	public void excluir(Contato contato) {
		
		this.session.delete(contato);
	}

	@Override
	public Contato buscaPorCliente(Integer codigo) {
		if(codigo ==null)return null;
		Contato c=null;
		String hql="select c from Contato as c where c.cliente_id = :id ";	
		Query consulta=this.session.createQuery(hql);
		consulta.setInteger("id", codigo);
		c=(Contato) consulta.uniqueResult();
		return c;
		
	}

	@Override
	public Contato buscaPorEmail(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
