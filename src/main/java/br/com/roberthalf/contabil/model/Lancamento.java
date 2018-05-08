package br.com.roberthalf.contabil.model;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.roberthalf.contabil.util.Util;

public class Lancamento {

	@JsonIgnore
	private String id;
	
	private Long contaContabil;
	
	private Calendar date;
	
	@JsonIgnore
	private String description;
	
	private Double valor;
	
	public Lancamento() {
        super();
    }
	
	public Lancamento(Long contaContabil, Calendar date, Double valor) {
		this.contaContabil = Long.valueOf(contaContabil);
		this.date = date;
		this.valor = Double.valueOf(valor);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(Long contaContabil) {
		this.contaContabil = contaContabil;
	}

	public String getDate() {
		return Util.calendarToString(date);
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", contaContabil=" + contaContabil + ", date=" + date + ", description="
				+ description + ", valor=" + valor + "]";
	}

}