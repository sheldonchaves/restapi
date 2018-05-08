package br.com.roberthalf.contabil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberthalf.contabil.model.Lancamento;
import br.com.roberthalf.contabil.model.LancamentoIdDto;
import br.com.roberthalf.contabil.model.Stats;
import br.com.roberthalf.contabil.service.LancamentosService;

@RestController
@RequestMapping("/lancamentos-contabeis")
public class LancamentosController {

	@Autowired
	private LancamentosService lancamentosService;

	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<LancamentoIdDto> create(@RequestBody Lancamento lancamento) {
		
		Lancamento lancamentoCriado = lancamentosService.addLancamento(lancamento);

		return ResponseEntity.status(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(new LancamentoIdDto(lancamentoCriado));
		
	}

	@GetMapping("/all")
	public List<Lancamento> listAll() {
		return lancamentosService.listAll();
	}
	
	@GetMapping("/{id}")
	public Lancamento retrieveLancamento(@PathVariable String id) {
		return lancamentosService.retrieveLancamento(id);
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public List<Lancamento> retrieveLancamentos(@RequestParam("contaContabil") Long contaContabil) {
		return lancamentosService.retrieveLancamentosByConta(contaContabil);
	}
	
	@GetMapping("/_stats")
	public Stats stats() {
		return new Stats(lancamentosService.listAll());
	}

	@RequestMapping(method = RequestMethod.GET, value="/_stats/")
	public Stats statsOfLancamento(@RequestParam("contaContabil") Long contaContabil) {
		return new Stats(lancamentosService.retrieveLancamentosByConta(contaContabil));
	}
	
}
