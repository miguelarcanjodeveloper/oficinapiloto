package oficina.pessoas.fisica;

import java.util.List;


public interface PessoaFDAO {
	public void salvar(PessoaF P);
	public void atualizar(PessoaF P);
	public void excluir(PessoaF P);
	public PessoaF carregar(Integer codigo);
	public PessoaF buscaPorNome(String NOME);
	public PessoaF buscaPorCPF(Integer CPF);
	public List<PessoaF> listar();

}
