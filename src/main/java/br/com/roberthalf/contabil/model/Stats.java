package br.com.roberthalf.contabil.model;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Stats {

	private Double soma;
	private Double min;
	private Double max;
	private Double media;
	private int qtde;

	public Stats(List<Lancamento> list) {
		this.min = list.stream().min(Comparator.comparing(Lancamento::getValor)).orElseThrow(NoSuchElementException::new).getValor();
		this.max = list.stream().max(Comparator.comparing(Lancamento::getValor)).orElseThrow(NoSuchElementException::new).getValor();
		this.soma = list.stream().mapToDouble(o -> o.getValor()).sum();
		this.qtde = list.size();
		this.media = this.soma/this.qtde;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public Double getSoma() {
		return soma;
	}

	public void setSoma(Double soma) {
		this.soma = soma;
	}

}