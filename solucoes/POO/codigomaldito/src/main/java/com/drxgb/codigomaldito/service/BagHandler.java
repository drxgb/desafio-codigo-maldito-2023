package com.drxgb.codigomaldito.service;

import com.drxgb.codigomaldito.entity.Bag;

/**
 * Serviço responsável por tratar as bolsas e os itens
 * que for solicitado
 * 
 * @param <T> O conteúdo do item da bolsa
 * @author Dr.XGB
 * @version 1.0.0
 */
public abstract class BagHandler<T>
{
	/*
	 * ===========================================================
	 * 			*** ASSOCIAÇÕES ***
	 * ===========================================================
	 */
	
	protected Bag<T> bag;
	protected BagHandler<T> next;
	
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public BagHandler(Bag<T> bag)
	{
		this.bag = bag;
		this.next = null;
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Recebe e trata o item
	 * @param item O item a ser tratado na bolsa
	 */
	public void handle(T item)
	{
		if (next != null)
			next.handle(item);
	}


	/*
	 * ===========================================================
	 * 			*** GETTERS E SETTERS ***
	 * ===========================================================
	 */
	
	public BagHandler<T> getNext()
	{
		return next;
	}


	public void setNext(BagHandler<T> next)
	{
		this.next = next;
	}
	

	public Bag<T> getBag()
	{
		return bag;
	}
}
