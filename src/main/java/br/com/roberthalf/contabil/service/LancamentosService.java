package br.com.roberthalf.contabil.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.roberthalf.contabil.model.Lancamento;

@Component
public class LancamentosService {

	private List<Lancamento> lancamentos = new ArrayList<>();
	
	public Lancamento addLancamento(Lancamento lancamento) {

		if (lancamento == null) {
			return null;
		}

		lancamento.setId(UUID.randomUUID().toString());
		
		lancamentos.add(lancamento);

		return lancamento;
	}
	
	public Lancamento retrieveLancamento(String id) {
		return lancamentos.stream()
		        .filter(line -> line.getId().equals(id))
		        .findAny()
	            .orElse(null);	
	}

	public List<Lancamento> retrieveLancamentosByConta(Long idconta) {
		return lancamentos.stream()
		        .filter(line -> line.getContaContabil().equals(idconta))
		        .collect(Collectors.toList()); 
	}
	
	public List<Lancamento> listAll() {
		return lancamentos;
	}
	
	
}