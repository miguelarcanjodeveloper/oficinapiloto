package oficina.contato;

import java.util.List;

public interface EnderecoDAO {

	public void salvar(Endereco endereco);
	public void atualizar(Endereco endereco);
	public void excluir(Endereco endereco);
	public Endereco  buscaPorCliente(Integer codigo);
	public List<Endereco>  buscaPorRua(String rua);
	public List<Endereco>  buscaPorCep(int cep);
	public List<Endereco> listar();
	
}
