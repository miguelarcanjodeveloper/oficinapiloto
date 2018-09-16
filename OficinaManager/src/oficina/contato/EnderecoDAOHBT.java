package oficina.contato;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class EnderecoDAOHBT implements EnderecoDAO {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Endereco endereco) {
		this.session.save(endereco);

	}

	@Override
	public void atualizar(Endereco endereco) {
		this.session.merge(endereco);

	}

	@Override
	public void excluir(Endereco endereco) {
		this.session.delete(endereco);

	}

	@Override
	public Endereco buscaPorCliente(Integer codigo) {
		if(codigo ==null)return null;
		Endereco c=null;
		String hql="select c from Endereco as c where c.cliente_id = :id ";	
		Query consulta=this.session.createQuery(hql);
		consulta.setInteger("id", codigo);
		c=(Endereco) consulta.uniqueResult();
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> buscaPorRua(String rua) {
		
		if(rua =="")return null;
		List<Endereco> c=null;
		String hql="select c from Endereco as c where c.rua like :id ";	
		Query consulta=this.session.createQuery(hql);
		consulta.setString("id", rua+"%");
		c= consulta.list();
		
		return c;
	}

	@Override
	public List<Endereco> buscaPorCep(int cep) {
		if(cep ==0)return null;
		List<Endereco> c=null;
		String hql="select c from Endereco as c where c.cep like :id ";	
		Query consulta=this.session.createQuery(hql);
		consulta.setString("id", cep+"%");
		c= consulta.list();
		
		return c;
	}

	@Override
	public List<Endereco> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
