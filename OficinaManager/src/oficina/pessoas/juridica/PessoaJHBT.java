package oficina.pessoas.juridica;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import oficina.pessoas.fisica.PessoaF;

public class PessoaJHBT implements PessoaJDAO {
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	@Override
	public void salvar(PessoaJ P) {
		
		this.session.save(P);

	}

	@Override
	public void atualizar(PessoaJ P) {
		
		this.session.merge(P);

	}

	@Override
	public void excluir(PessoaJ P) {
		
		this.session.clear();
		this.session.delete(P);

	}

	@Override
	public PessoaJ carregar(Integer codigo) {
		if(codigo == null)return null;
		PessoaJ p=null;
		String hql="select f from PessoaJ as f where f.id = :id ";	
		Query consulta=this.session.createQuery(hql);
		consulta.setInteger("id", codigo);
		p=(PessoaJ) consulta.uniqueResult();
		return p;
	}

	@Override
	public PessoaJ buscaPorRazao(String NOME) {
		if(NOME =="")return null;
		PessoaJ p=null;
		String hql="select f from PessoaJ as f where f.rs = :rs ";	
		Query consulta=this.session.createQuery(hql);
		consulta.setString("rs", NOME);
		p=(PessoaJ) consulta.uniqueResult();
		return p;
	}

	@Override
	public PessoaJ buscaPorCNPJ(String CNPJ) {
		if(CNPJ =="")return null;
		PessoaJ p=null;
		String hql="select f from PessoaJ as f where f.cnpj = :rs ";	
		Query consulta=this.session.createQuery(hql);
		consulta.setString("rs", CNPJ);
		p=(PessoaJ) consulta.uniqueResult();
		return p;
	}

	@Override
	public PessoaJ buscaAvancada(String tipo, String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PessoaJ> listar() {
		
		return this.session.createCriteria(PessoaJ.class).list();
	}

}
