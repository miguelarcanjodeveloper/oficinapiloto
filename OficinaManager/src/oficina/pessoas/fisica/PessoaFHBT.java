package oficina.pessoas.fisica;

import java.util.List;

import org.hibernate.Query;
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
		
		this.session.merge(P);
		
		
	}

	@Override
	public void excluir(PessoaF P) {
		this.session.clear();
		this.session.delete(P);
		
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
	public PessoaF buscaPorCPF(String cpf) {
		
		if(cpf =="")return null;
		PessoaF p=null;
		String hql="select f from PessoaF as f where f.cpf = :cpf ";	
		Query consulta=this.session.createQuery(hql);
		consulta.setString("cpf", cpf);
		p=(PessoaF) consulta.uniqueResult();
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PessoaF> listar() {
		
		return this.session.createCriteria(PessoaF.class).list();
	}

	@Override
	public PessoaF buscarCliente(Cliente codigo) {
		
		if(codigo.getId() == null)return null;
		PessoaF p=null;
		String hql="select f from PessoaF as f where f.id = :id ";	
		Query consulta=this.session.createQuery(hql);
		consulta.setInteger("id", codigo.getId());
		p=(PessoaF) consulta.uniqueResult();
		return p;
					
	}

	

}
