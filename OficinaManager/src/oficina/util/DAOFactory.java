package oficina.util;

import oficina.cliente.ClienteDAO;
import oficina.cliente.ClienteDAOHBT;
import oficina.contato.ContatoDAO;
import oficina.contato.ContatoDAOHBT;
import oficina.pessoas.fisica.PessoaFDAO;
import oficina.pessoas.fisica.PessoaFHBT;
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
	 * Contato
	 * @return
	 */
	
	public static ContatoDAO criaContatoDAO(){

		ContatoDAOHBT contato = new ContatoDAOHBT();
		contato.setSession(Hibernateutil.getSessionFactory().getCurrentSession());
		return contato;
	}
	
	
	
	
	
		

}
