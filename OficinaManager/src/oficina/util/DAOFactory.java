package oficina.util;

import oficina.cliente.ClienteDAO;
import oficina.cliente.ClienteDAOHBT;
import oficina.pessoas.fisica.PessoaFDAO;
import oficina.pessoas.fisica.PessoaFHBT;
import oficina.usuario.UsuarioDAO;
import oficina.usuario.UsuarioDAOHibernate;
import testes.CadastroTeste;
import testes.PessoaHBT;

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
	
	
	
	/*
	 * classes de testes para endereços
	 * em pasta testes
	 */
	public static CadastroTeste criaClinteTeste(){

		CadastroTeste cad = new CadastroTeste();
		cad.setSession(Hibernateutil.getSessionFactory().getCurrentSession());
		return cad;
	}
	
	public static PessoaHBT criaPessoaTeste(){

		PessoaHBT cad = new PessoaHBT();
		cad.setSession(Hibernateutil.getSessionFactory().getCurrentSession());
		return cad;
	}
	
	
	
	
		

}
