package com.drxgb.codigomaldito.service;

import com.drxgb.codigomaldito.entity.Bag;

/**
 * Responsável por aplicar a inserção dos itens à bolsa
 * 
 * @author Dr.XGB
 * @version 1.0.0
 */
public final class InsertionBagHandler<T> extends BagHandler<T>
{
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public InsertionBagHandler(Bag<T> bag)
	{
		super(bag);
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	@Override
	public void handle(T item)
	{
		if (bag.getOwner().canInsert(item))
			bag.getItems().add(item);
		else
			super.handle(item);
	}
}
