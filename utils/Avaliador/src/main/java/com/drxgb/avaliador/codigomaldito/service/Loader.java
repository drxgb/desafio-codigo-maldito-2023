package com.drxgb.avaliador.codigomaldito.service;


/**
 * Responsável por carregar dados
 * @param <I> Entrada: conteúdo bruto para carregar
 * @param <O> Saída: Tipo de conteúdo carregado
 * @author Dr.XGB
 * @version 1.0.0
 */
public interface Loader<I, O>
{
	/**
	 * Carreg
	 * @param request
	 * @return
	 */
	O load(I input);
}
