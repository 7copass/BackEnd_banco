package br.com.banco.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.banco.model.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
	 public List<Transferencia> findByDataTransferenciaBetween(LocalDate inicio,LocalDate fim);
	 public List<Transferencia> findByDataTransferenciaBetweenAndNomeOperadorTransacao(LocalDate inicio,LocalDate fim, String nome);
	 public List<Transferencia> findByDataTransferencia(LocalDate inicio);
	 public List<Transferencia> findByNomeOperadorTransacaoContainingIgnoreCase(String nomeOperadorTransacao);
	
}
