package oficina.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.util.DigestUtils;


import oficina.usuario.Usuario;
import oficina.usuario.UsuarioRN;



@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private String confirmaSenha;
	private List<Usuario> lista;
	private String destinoSalvar ;
	private String senhaCriptografada;

	public UsuarioBean(){
		
	}
    	
	public String getSenhaCriptografada() {
		return senhaCriptografada;
	}

	public void setSenhaCriptografada(String senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}

	public String novo(){
		this.destinoSalvar = "usuarioSucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "usuario";
	}
	
	public String editar(){
		this.senhaCriptografada = this.usuario.getSenha();	
		
		return "/publico/usuario.jsf";
	}
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();
		
		if(!senha.equals(this.confirmaSenha)){
			FacesMessage faceMessage = new FacesMessage("A senha n�o foi confirmada corretamente");
			context.addMessage(null, faceMessage);
			return null;
		}
		if(senha!=null && senha.trim().length()==0){
			this.usuario.setSenha(this.senhaCriptografada);
		}else{
			String senhaCripto = DigestUtils.md5DigestAsHex(senha.getBytes());
			this.usuario.setSenha(senhaCripto);
		}
		
		
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		
		
		return this.destinoSalvar;
		//return "/publico/usuario";
	}
	
	public String excluir(){
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}
	
	public String ativar(){
		if(this.usuario.isAtivo()){
			this.usuario.setAtivo(false);			
		}else{
			this.usuario.setAtivo(true);
		}
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return null;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public List<Usuario> getLista() {
		if(this.lista==null){
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return lista;
	}

	public String atribuiPermissao(Usuario usuario,String permissao){
		
		this.usuario=usuario;
		java.util.Set<String> permissoes = this.usuario.getPermissao();
		if(permissoes.contains(permissao)){
			permissoes.remove(permissao);
		}else{
			permissoes.add(permissao);
		}
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return null;
					
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
	
}
