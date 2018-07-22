package oficina.usuario;

import oficina.util.DAOFactory;



import java.util.List;

public class UsuarioRN {

	private UsuarioDAO usuarioDAO;
	
	public UsuarioRN(){
		this.usuarioDAO = DAOFactory.criaUsuarioDAO();
	}
	
	public Usuario carregar(Integer codigo){
		return this.usuarioDAO.carregar(codigo);
	}
	
	public Usuario buscaPorLogin(String login){
		return this.usuarioDAO.buscaPorLogin(login);
	}
	
	public void salvar(Usuario usuario){
		Integer codigo = usuario.getCodigo();
		
		if(codigo==null|| codigo==0){
			usuario.getPermissao().add("ROLE_USUARIO");			
			this.usuarioDAO.salvar(usuario);			
		}else{			
			this.usuarioDAO.atualizar(usuario);
		}		
	}
	
	public void excluir(Usuario usuario){	
		this.usuarioDAO.excluir(usuario);		
	}
	
	public List<Usuario> listar(){
		return this.usuarioDAO.listar();
	}
}
