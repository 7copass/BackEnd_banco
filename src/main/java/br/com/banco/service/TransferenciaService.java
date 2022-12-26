package br.com.banco.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.banco.model.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;

@Service
@Transactional
public class TransferenciaService {
	
	@Autowired
	TransferenciaRepository transferenciaRepository;
	
	public List<Transferencia> listTransferencias(){
		return transferenciaRepository.findAll();
	}
	
	public List<Transferencia> buscaNome(String nome){
		return transferenciaRepository.findByNomeOperadorTransacaoContainingIgnoreCase(nome);
	}
	
	public List<Transferencia> buscaUnicaData(LocalDate inicio){
		final LocalDate dataInicio = inicio;
		return transferenciaRepository.findByDataTransferencia(dataInicio);
	}
			
	
	public List<Transferencia> buscaPorData(LocalDate inicio, LocalDate fim) {
		final LocalDate dataInicio = inicio;
		final LocalDate dataFimDate = fim;
		return transferenciaRepository.findByDataTransferenciaBetween(dataInicio, dataFimDate);
	}
	
	public List<Transferencia> busca(LocalDate inicio, LocalDate fim, String nome){
		final LocalDate dataInicio = inicio;
		final LocalDate dataFimDate = fim;
		return transferenciaRepository.findByDataTransferenciaBetweenAndNomeOperadorTransacao(dataInicio, dataFimDate, nome);
	}
}
