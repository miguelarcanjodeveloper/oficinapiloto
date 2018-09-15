package oficina.contato;

import java.util.List;

public interface ContatoDAO {
	
	public void salvar(Contato contato);
	public void atualizar(Contato contato);
	public void excluir(Contato contato);
	public Contato buscaPorCliente(Integer codigo);
	public Contato buscaPorEmail(String login);
	public List<Contato> listar();

}
