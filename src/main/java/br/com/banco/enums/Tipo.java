package br.com.banco.enums;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum Tipo {
	DEPOSITO("deposito"),
	SAQUE("saque"),
	TRANSFERENCIA("transferencia");
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		
		return descricao;
	}
}
