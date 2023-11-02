package com.drxgb.codigomaldito.service;

import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.entity.HasBag;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public void handle(T item)
	{
		HasBag<T> owner = (HasBag<T>)bag.getOwner();
		if (owner.canInsert(item))
			bag.getItems().add(item);
		else
			super.handle(item);
	}
}
