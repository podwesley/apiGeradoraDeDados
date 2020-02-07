package br.com.generate.gen.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.generate.gen.entity.Pessoa;
import br.com.generate.gen.repository.PessoaRepository;
import br.com.generate.gen.service.IPessoaService;

@Service
public class PessoaServiceImp implements IPessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Optional<Pessoa> buscarPessoaPorId(Long id) {
		return pessoaRepository.findById(id);
	}

	@Override
	public void salvarPessoa(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	@Override
	public Page<Pessoa> paginarPessoas(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return pessoaRepository.findAll(pages);
	}

	@Override
	public Pessoa buscarPessoaPorNome(String nome) {

		return pessoaRepository.findByNomeContainingIgnoreCase(nome);
	}

	@Override
	public void excluirPessoa(Long id) {
		pessoaRepository.deleteById(id);

	}

	@Override
	public void salvarVarias(List<Pessoa> pessoas) {
		pessoaRepository.saveAll(pessoas);
	}


}
