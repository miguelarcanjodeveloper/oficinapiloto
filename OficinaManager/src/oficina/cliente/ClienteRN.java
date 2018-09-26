package oficina.cliente;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.sql.SelectExpression;

import com.sun.security.ntlm.Client;

import oficina.contato.ContatoRN;
import oficina.contato.Endereco;
import oficina.contato.EnderecoRN;
import oficina.pessoas.fisica.PessoaFDAO;
import oficina.pessoas.fisica.PessoaFRN;
import oficina.util.DAOFactory;

public class ClienteRN {

	private ClienteDAO clienteDAO;
	
	PessoaFRN PFRN = new PessoaFRN();
	ContatoRN crn = new ContatoRN();
	EnderecoRN end = new EnderecoRN();

	public ClienteRN(){
		this.clienteDAO = DAOFactory.criaClienteDAO();
	}
	
	public void salvar(Cliente cli){
		Integer codigo = cli.getId();
		
		if(codigo==null|| codigo==0){
					
			this.clienteDAO.salvar(cli);
			
			if (cli.getTipo()==0){//se for 0 então é cliente fisico
				cli.getPf().setId(cli);// seta o id_cliente para o cliente fisico
				cli.getCt().setCliente_id(cli);//seta o id_cliente para o contato
				cli.getEd().setCliente_id(cli);
				PFRN.salvar(cli);//salva o cliente fisico				
				crn.salvar(cli);//salva o contato
				end.salvar(cli);//salva endereço
				
			}else{
				
			}
		}else{	
			//Neste caso so atualiza não atribui outro ID CLIENTE
			crn.salvar(cli);
			PFRN.salvar(cli);
			end.salvar(cli);
		}		
	}
	
	public void deleteCliente(Cliente c){
		if(c.getPf()!=null)PFRN.deletePF(c);		
		if(c.getCt()!=null)crn.deleteContato(c);
		if(c.getEd()!=null)end.deleteContato(c);
		
	}
	
	/***
	 * A pesquisa aqui é de carater multiplo
	 * conforme as tre primeiras letras da busca
	 * @return
	 */
	public List<Cliente> listarFisicos() {
		List<Cliente> cli = this.clienteDAO.listar();
		String busca = "cpf01453403922";
		String sel = busca.substring(0,3).toLowerCase();//seleciona os tres primeiros
		busca = busca.substring(3);//seleciona apos o terceiro
		
		
		switch (sel) {
		case "cpf":
			
			break;
		case "cep":	
			
			break;
		case "111"://fone fixo
			
			break;
		case "222"://celular
			
			break;
		case "333"://bairro
			
			break;
		case "444"://cidade
			
			break;
		case "555"://rua
			
			break;
		case "000"://ultimo nome
	
			break;
		default://se nao atende nenhuma busca pelo nome
			break;
		}
		
		for (Cliente cliente : cli) {
			cliente.setPf(this.PFRN.buscarPorCliente(cliente));
			cliente.setCt(crn.buscaPorCliente(cliente));
			cliente.setEd(end.buscaPorCliente(cliente));
			if(cliente.getPf()!=null && cliente.getTipo()==1)
			cli.remove(cliente);
		}
		return cli;
	}
	
	public List<Cliente> listarPj() {
		List<Cliente> cli = this.clienteDAO.listar();
		List<Cliente> cli2 =  new ArrayList<>();
		
		for (Cliente cliente : cli) {
			cliente.setPf(this.PFRN.buscarPorCliente(cliente));
			if(cliente.getPf()!=null && cliente.getTipo()==1)//se houver o cliente e for do tipo pj juridico
			cli2.add(cliente);
		}
		
		return cli2;
	}
	
}
