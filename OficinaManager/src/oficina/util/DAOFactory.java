package oficina.util;

import oficina.cliente.ClienteDAO;
import oficina.cliente.ClienteDAOHBT;
import oficina.contato.ContatoDAO;
import oficina.contato.ContatoDAOHBT;
import oficina.contato.EnderecoDAO;
import oficina.contato.EnderecoDAOHBT;
import oficina.pessoas.fisica.PessoaFDAO;
import oficina.pessoas.fisica.PessoaFHBT;
import oficina.pessoas.juridica.PessoaJDAO;
import oficina.pessoas.juridica.PessoaJHBT;
import oficina.usuario.UsuarioDAO;
import oficina.usuario.UsuarioDAOHibernate;

/**
 * @author Miguel Arcanjo.
 */
public class DAOFactory {
	
	
	
	public static UsuarioDAO criaUsuarioDAO(){

		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(Hibernateutil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
	
	/***
	 * Cliente_teste 
	 * @return
	 */
	public static ClienteDAO criaClienteDAO(){

		ClienteDAOHBT clienteDAO = new ClienteDAOHBT();
		clienteDAO.setSession(Hibernateutil.getSessionFactory().getCurrentSession());
		return clienteDAO;
	}
	
	/***
	 * Pessoa fisica
	 * @return
	 */
	
	public static PessoaFDAO criaPessoaFDAO(){

		PessoaFHBT pessoaFDAO = new PessoaFHBT();
		pessoaFDAO.setSession(Hibernateutil.getSessionFactory().getCurrentSession());
		return pessoaFDAO;
	}
	/***
	 * Pessoa juridica
	 * @return
	 */
	
	public static PessoaJDAO criaPessoaJDAO(){

		PessoaJHBT pessoaJDAO = new PessoaJHBT();
		pessoaJDAO.setSession(Hibernateutil.getSessionFactory().getCurrentSession());
		return pessoaJDAO;
	}
	
	/***
	 * Contato
	 * @return
	 */
	
	public static ContatoDAO criaContatoDAO(){

		ContatoDAOHBT contato = new ContatoDAOHBT();
		contato.setSession(Hibernateutil.getSessionFactory().getCurrentSession());
		return contato;
	}
	
	/***
	 * Endereço
	 * @return
	 */
	
	public static EnderecoDAO criaEnderecoDAO(){

		EnderecoDAOHBT end = new EnderecoDAOHBT();
		end.setSession(Hibernateutil.getSessionFactory().getCurrentSession());
		return end;
	}
	
	
	
	
	
		

}
