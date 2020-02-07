package br.com.generate.gen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generate.gen.entity.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, String> {

	Optional<Pessoa> findById(Long id);

	Pessoa findByNomeContainingIgnoreCase(String nome);

	void deleteById(Long id);
	
}
