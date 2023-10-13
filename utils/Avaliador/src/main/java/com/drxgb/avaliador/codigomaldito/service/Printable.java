package com.drxgb.avaliador.codigomaldito.service;

/**
 * Contrato para que uma classe possa imprimir coisas
 * @param <I> Tipo de entrada recebida a ser impressa
 */
public interface Printable<I>
{
	/**
	 * Trata a entrada e imprime o seu resultado
	 * @param input A entrada a ser tratada
	 */
	void print(I input);
}
