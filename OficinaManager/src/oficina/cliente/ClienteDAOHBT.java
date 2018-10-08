package oficina.cliente;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import oficina.contato.Contato;
import oficina.contato.Endereco;
import oficina.pessoas.fisica.PessoaF;

public class ClienteDAOHBT implements ClienteDAO {

	private Session session;
	private java.awt.List list;
	private List<Cliente> cli=new ArrayList<>();
	private Cliente cliente=null;
	private PessoaF pessoaF=null;
	private Endereco endereco=null;
	private List<Endereco> enderecoList=null;
	private Contato contato=null;
	private List<Contato> contatoList=null;
	private List<PessoaF> pe=null;
	private String hql;
	private Query consulta;
	
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

	
	/***
	 * O parametros da pesquisa segue abaixo
	 * <f:selectItem itemLabel="Primeiro nome" itemValue="pnome" />
	 * <f:selectItem itemLabel="Último nome" itemValue="unome" />
	 * <f:selectItem itemLabel="CPF" itemValue="CPF" />
	 * <f:selectItem itemLabel="Telefone" itemValue="fone" />
	 * <f:selectItem itemLabel="Celular" itemValue="cel" />
	 * <f:selectItem itemLabel="Bairro" itemValue="bairro" />
	 * <f:selectItem itemLabel="Cidade" itemValue="cidade" />
	 * <f:selectItem itemLabel="Rua" itemValue="rua" />
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscaAvancada(String tipo,String busca) {
		
		
		
		if(busca==""&&tipo=="")return null;
		
		switch (tipo) {
		case "pnome":
			
			
			hql="select f from PessoaF f where nome like :pnome";
		    consulta=this.session.createQuery(hql);
			consulta.setString("pnome", busca +"%");
			pe = consulta.list();
			
			carregaPorPf(pe);
			
			return cli;
			
			
		case "unome":	
			
			hql="select f from PessoaF f where nome like :pnome";
			consulta=this.session.createQuery(hql);
			consulta.setString("pnome", "%"+busca);
			pe = consulta.list();
			carregaPorPf(pe);
			
			return cli;
			
		case "CPF":
			
			hql="select f from PessoaF f where cpf = :cpf";
			consulta=this.session.createQuery(hql);
			consulta.setString("cpf", busca);
			pe = consulta.list();
			carregaPorPf(pe);
			
			return cli;
			
		case "FONE":
			
			hql="select f from Contato f where fone = :fone";
			consulta=this.session.createQuery(hql);
			consulta.setString("fone", busca);
			contatoList = consulta.list();
			carregaPorCt(contatoList);
			return cli;
			
		case "cel":
			
			hql="select f from Contato f where celular = :fone";
			consulta=this.session.createQuery(hql);
			consulta.setString("fone", busca);
			contatoList = consulta.list();
			carregaPorCt(contatoList);
			return cli;
			
		case "bairro":
			
			hql="select f from Endereco f where bairro like :b";
			consulta=this.session.createQuery(hql);
			consulta.setString("b",busca+"%");
			enderecoList = consulta.list();
			carregaPorEd(enderecoList);			
			return cli;
			
		case "cidade":
			
			hql="select f from Endereco f where cidade = :b";
			consulta=this.session.createQuery(hql);
			consulta.setString("b", busca);
			enderecoList = consulta.list();
			carregaPorEd(enderecoList);			
			return cli;
			
		case "rua":
			
			hql="select f from Endereco f where rua like :b";
			consulta=this.session.createQuery(hql);
			consulta.setString("b", busca+"%");
			enderecoList = consulta.list();
			carregaPorEd(enderecoList);			
			return cli;
			
		default://se nao atende nenhuma busca pelo nome
			break;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() {
		
		return this.session.createCriteria(Cliente.class).list();
	}
	
private void carregaPorPf(List<PessoaF> p){
		
		for (PessoaF clie :p ) {
			
			hql="select c from Cliente c where c.id = :id";
			consulta = this.session.createQuery(hql);
			consulta.setInteger("id", clie.getId().getId());
			cliente = (Cliente) consulta.uniqueResult();
			cliente.setPf(clie);
							
			hql="select e from Endereco e where e.cliente_id.id = :id";
			consulta = this.session.createQuery(hql);
			consulta.setInteger("id", clie.getId().getId());
			endereco = (Endereco)consulta.uniqueResult();
			cliente.setEd(endereco);
			
			hql="select e from Contato e where e.cliente_id.id = :id";
			consulta = this.session.createQuery(hql);
			consulta.setInteger("id", clie.getId().getId());
			contato = (Contato)consulta.uniqueResult();
			cliente.setCt(contato);
			
			cli.add(cliente);
		}
		
	}

private void carregaPorCt(List<Contato> c){
	
	for (Contato con :c ) {
		
		hql="select c from Cliente c where c.id = :id";
		consulta = this.session.createQuery(hql);
		consulta.setInteger("id", con.getCliente_id().getId());
		cliente = (Cliente) consulta.uniqueResult();
		cliente.setCt(con);
						
		hql="select e from Endereco e where e.cliente_id.id = :id";
		consulta = this.session.createQuery(hql);
		consulta.setInteger("id", con.getCliente_id().getId());
		endereco = (Endereco)consulta.uniqueResult();
		cliente.setEd(endereco);
		
		hql="select e from PessoaF e where e.id.id = :id";
		consulta = this.session.createQuery(hql);
		consulta.setInteger("id", con.getCliente_id().getId());
		pessoaF = (PessoaF)consulta.uniqueResult();
		cliente.setPf(pessoaF);
		
		cli.add(cliente);
	}
	
}

private void carregaPorEd(List<Endereco> c){
	
	for (Endereco con :c ) {
		
		hql="select c from Cliente c where c.id = :id";
		consulta = this.session.createQuery(hql);
		consulta.setInteger("id", con.getCliente_id().getId());
		cliente = (Cliente) consulta.uniqueResult();
		cliente.setEd(con);
						
		hql="select e from Endereco e where e.cliente_id.id = :id";
		consulta = this.session.createQuery(hql);
		consulta.setInteger("id", con.getCliente_id().getId());
		endereco = (Endereco)consulta.uniqueResult();
		cliente.setEd(endereco);
		
		hql="select e from PessoaF e where e.id.id = :id";
		consulta = this.session.createQuery(hql);
		consulta.setInteger("id", con.getCliente_id().getId());
		pessoaF = (PessoaF)consulta.uniqueResult();
		cliente.setPf(pessoaF);
		
		cli.add(cliente);
	}
	
}

}
