package br.com.roberthalf.contabil.model;

public class LancamentoIdDto {

	private String id;

	public LancamentoIdDto(Lancamento lancamento) {
		this.id = lancamento.getId();
	}

	public String getId() {
		return id;
	}

}