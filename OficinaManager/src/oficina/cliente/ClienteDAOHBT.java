package oficina.cliente;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import oficina.contato.Endereco;
import oficina.pessoas.fisica.PessoaF;

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
	@Override
	public List<Cliente> buscaAvancada(String tipo,String busca) {
		
		System.out.println("Tipo:"+tipo);
		System.out.println("Busca:"+busca);
		
		if(busca==""&&tipo=="")return null;
		
		switch (tipo) {
		case "pnome":
			
			List<Cliente> cli=new ArrayList<>();
			Cliente cliente=null;
			List<PessoaF> pe=null;
			String hql="select f,cli,ed,ct from PessoaF as f,  Cliente as cli, Endereco as ed, Contato as ct "
					+ "where f.nome like :pnome and cli.id = f.id.id and ed.cliente_id = f.id.id "
					+ "and ct.cliente_id = f.id.id";	
			Query consulta=this.session.createQuery(hql);
			consulta.setString("pnome", busca +"%");
			cli = consulta.list(Cliente.class);
			
			/***
			
			for (PessoaF pessoaF : pe) {
				String hcli="select c from Cliente as c where c.id = :id ";	
				Query consulta2=this.session.createQuery(hcli);
				consulta2.setInteger("id", pessoaF.getId().getId());
				cliente= (Cliente) consulta.uniqueResult();
				cliente.setPf(pessoaF);
				cli.add(cliente);
			}
			
			 * 
			 */
			System.out.println("**********imprimindo a lista de clientes***********");
			for (Cliente clie :cli ) {
				System.out.println("Nome:"+clie.getPf().getNome());
				System.out.println("Rua:"+clie.getEd().getRua());
				System.out.println("Fone:"+clie.getCt().getCelular());
				System.out.println("--------------------------------------------------");
			}
			
			return cli;
			
			
		case "unome":	
			
			break;
		case "CPF":
			
			break;
		case "FONE":
			
			break;
		case "cel":
			
			break;
		case "bairro":
			
			break;
		case "cidade":
			
			break;
		case "rua":
	
			break;
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

}
