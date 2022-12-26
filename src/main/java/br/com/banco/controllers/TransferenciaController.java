package br.com.banco.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class TransferenciaController {

	@Autowired
	TransferenciaService transferenciaService;

	
	// busca sem filtro
	@GetMapping("/transacoes")
	public List<Transferencia> todasTransferencias() {
		return transferenciaService.listTransferencias();
	}

	// busca por data
	@GetMapping("/busca")
	public List<Transferencia> buscaPorPeriodo(@RequestParam(value = "inicio") Optional<String> inicio,
			@RequestParam(value = "fim") Optional<String> fim,
			@RequestParam (value = "nome") Optional<String> nome) {
		if (inicio.isPresent() && fim.isPresent()) {
			String dataI = inicio.get();
			LocalDate dataInicio = LocalDate.parse(dataI, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String dataF = fim.get();
			LocalDate dataFim = LocalDate.parse(dataF, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			List<Transferencia> list = transferenciaService.buscaPorData(dataInicio, dataFim);
			return list;		
		}  
		
		if(nome.isPresent()) {
			return transferenciaService.buscaNome(nome.get());
		}
		
		String dataI = inicio.get();
		LocalDate dataInicio = LocalDate.parse(dataI, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String dataF = fim.get();
		LocalDate dataFim = LocalDate.parse(dataF, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return transferenciaService.busca(dataInicio, dataFim, nome.get());

		

		

	}
	
	// busca por usuario
	@GetMapping("/busca-nome")
	public List<Transferencia> buscaNome(@RequestParam String nome) {
		return transferenciaService.buscaNome(nome);
	}
	
	
	

}
