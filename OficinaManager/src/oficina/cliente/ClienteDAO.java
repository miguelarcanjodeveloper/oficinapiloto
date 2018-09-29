package oficina.cliente;

import java.util.List;

public interface ClienteDAO {

	public void salvar(Cliente cliente);
	public void atualizar(Cliente usuario);
	public void excluir(Cliente usuario);
	public Cliente carregar(Integer codigo);
	public List<Cliente> buscaAvancada(String tipo,String busca);
	public List<Cliente> listar();
	
}
