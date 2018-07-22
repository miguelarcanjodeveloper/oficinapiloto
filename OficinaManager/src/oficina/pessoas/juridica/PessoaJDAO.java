package oficina.pessoas.juridica;

import java.util.List;

public interface PessoaJDAO {
	
	public void salvar(PessoaJ P);
	public void atualizar(PessoaJ P);
	public void excluir(PessoaJ P);
	public PessoaJ carregar(Integer codigo);
	public PessoaJ buscaPorRazao(String NOME);
	public PessoaJ buscaPorCNPJ(Integer CNPJ);
	public List<PessoaJ> listar();

}
