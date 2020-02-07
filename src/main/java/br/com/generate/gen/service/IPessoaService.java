package br.com.generate.gen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.generate.gen.entity.Pessoa;

public interface IPessoaService {
	
	Optional<Pessoa> buscarPessoaPorId(Long id);
	
	void salvarPessoa(Pessoa pessoa);
	
	Page<Pessoa> paginarPessoas(int page, int count);

	Pessoa buscarPessoaPorNome(String nome);

	void excluirPessoa(Long id);

	void salvarVarias(List<Pessoa> pessoas);

}

