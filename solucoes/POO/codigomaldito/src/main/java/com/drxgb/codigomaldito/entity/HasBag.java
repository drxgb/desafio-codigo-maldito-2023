package com.drxgb.codigomaldito.entity;


/**
 * Contrato de ações para classes que podem possuir uma bolsa
 * 
 * @param <T> O item que pode ser colocado na bolsa
 * @author Dr.XGB
 * @version 1.0.0
 */
public interface HasBag<T>
{
	/**
	 * Verifica se o item pode ser colocado à bolsa
	 * @param item O item a ser inserido
	 * @return Resultado se o item pode ser inserido à bolsa
	 */
	boolean canInsert(T item);
}
