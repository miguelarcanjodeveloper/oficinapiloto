package testes;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PessoaHBT {
	
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
public void salvar(Pessoa p) {
		
		this.session.save(p);
	

	}
	
}
