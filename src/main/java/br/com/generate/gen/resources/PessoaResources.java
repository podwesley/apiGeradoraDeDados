package br.com.generate.gen.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.generate.gen.entity.Pessoa;
import br.com.generate.gen.service.IPessoaService;
import br.com.generate.gen.util.Util;

@RestController
public class PessoaResources {

	@Autowired
	private IPessoaService iPessoaService;

	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
	public Optional<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
		return iPessoaService.buscarPessoaPorId(id);
	}

	@RequestMapping(value = "/pessoa/incluir", method = RequestMethod.POST)
	public void salvarPessoa(@RequestBody Pessoa pessoa) throws InterruptedException {
		iPessoaService.salvarPessoa(pessoa);
	}

	@RequestMapping(value = "/pessoa/{paginas}/{quantidade}" , method = RequestMethod.GET)
	public void paginarPessoas(@PathVariable int paginas, @PathVariable int quantidade) {
		iPessoaService.paginarPessoas(paginas, quantidade);
	}
	@RequestMapping(value = "/pessoas" , method = RequestMethod.POST)
	public void inserirMuitasPessoas(@RequestBody List<Pessoa> pessoas){
		iPessoaService.salvarVarias(pessoas);
	}

	@RequestMapping(value = "/pessoa/nome/{nome}", method = RequestMethod.GET)
	public Pessoa buscarPessoaPorNome(@PathVariable String nome) {
		Pessoa p = new Pessoa();
		p = iPessoaService.buscarPessoaPorNome(nome);
		System.out.println(p.getNome());
		return iPessoaService.buscarPessoaPorNome(nome);
	}

	@RequestMapping(value = "/pessoa{id}", method = RequestMethod.DELETE)
	public void ExcluirPessoa(@PathVariable Long id) {
		iPessoaService.excluirPessoa(id);
	}

	@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
	public Optional<Pessoa> gerarPessoaAleatoria() {
		return iPessoaService.buscarPessoaPorId(Util.generatedLong());
	}

}
