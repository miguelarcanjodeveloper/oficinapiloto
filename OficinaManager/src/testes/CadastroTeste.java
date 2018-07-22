package testes;

import org.hibernate.Session;

public class CadastroTeste {
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
public void salvar(Cliente_teste cliente) {
		
		this.session.save(cliente);	
		

	}

}
