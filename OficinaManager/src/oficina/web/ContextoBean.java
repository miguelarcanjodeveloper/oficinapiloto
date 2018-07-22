package oficina.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import oficina.usuario.Usuario;
import oficina.usuario.UsuarioRN;



@ManagedBean(name = "contextoBean")
@SessionScoped
public class ContextoBean {
	
	private Usuario usuarioLogado = null;
	private Locale localizacao = null;
	private List<Locale> idiomas;
	
	public Usuario getUsuarioLogado(){
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		if(this.usuarioLogado == null || !login.equals(this.usuarioLogado.getLogin())){
			if(login!=null){
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuarioLogado = usuarioRN.buscaPorLogin(login);
			}
		}
		return usuarioLogado;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuarioLogado=usuario;
	}



	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Locale getLocaleUsuario(){
		if(this.localizacao==null){
			Usuario usuario = this.getUsuarioLogado();
			String idioma = usuario.getIdioma();
			String info[] = idioma.split("_");
			this.localizacao = new Locale(info[0],info[1]);
			
			//estas linha abaixo n�o est�o no livro
			FacesContext context = FacesContext.getCurrentInstance();
			context.getViewRoot().setLocale(localizacao);
			//fim
		}
		return this.localizacao;
	}
	
	public List<Locale> getIdiomas(){
		FacesContext context = FacesContext.getCurrentInstance();
		Iterator<Locale> locales = context.getApplication().getSupportedLocales();
		this.idiomas = new ArrayList<Locale>();
		while(locales.hasNext()){
			this.idiomas.add(locales.next());
		}
		return idiomas;
	}

	public void setIdiomaUsuario(String idioma){
		UsuarioRN usuarioRN = new UsuarioRN();
		this.usuarioLogado = usuarioRN.carregar(this.getUsuarioLogado().getCodigo());
		this.usuarioLogado.setIdioma(idioma);
		usuarioRN.salvar(this.usuarioLogado);
		String info[] = idioma.split("_");
		Locale locale = new Locale(info[0],info[1]);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(locale);
	}

}
