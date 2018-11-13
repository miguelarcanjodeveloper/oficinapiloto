package oficina.pessoas.juridica;

import java.util.List;

public interface PessoaJDAO {
	
	public void salvar(PessoaJ P);
	public void atualizar(PessoaJ P);
	public void excluir(PessoaJ P);
	public PessoaJ carregar(Integer codigo);
	public PessoaJ buscaPorRazao(String NOME);
	public PessoaJ buscaPorCNPJ(String CNPJ);
	public PessoaJ buscaAvancada(String tipo,String busca);//busca avaçada permite realizar varias buscas com um so metodo
	public List<PessoaJ> listar();

}
