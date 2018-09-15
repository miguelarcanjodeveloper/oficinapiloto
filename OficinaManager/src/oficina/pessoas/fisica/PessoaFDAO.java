package oficina.pessoas.fisica;

import java.util.List;

import oficina.cliente.Cliente;


public interface PessoaFDAO {
	public void salvar(PessoaF P);
	public void atualizar(PessoaF P);
	public void excluir(PessoaF P);
	public PessoaF carregar(Integer codigo);
	public PessoaF buscaPorNome(String NOME);
	public PessoaF buscaPorCPF(String CPF);
	public List<PessoaF> listar();
	public PessoaF buscarCliente(Cliente codigo);

}
