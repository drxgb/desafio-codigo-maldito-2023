package com.drxgb.codigomaldito.factory;

import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.service.BagHandler;
import com.drxgb.codigomaldito.service.InsertionBagHandler;


/**
 * Responsável por gerar tratadores de bolsas para inserção
 * @param <T> O tipo do conteúdo contido na bolsa
 * @author Dr.XGB
 * @version 1.0.0
 */
public class InsertionBagHandlerFactory<T> implements BagHandlerFactory<T>
{
	@Override
	public BagHandler<T> makeHandler(Bag<T> bag)
	{
		return new InsertionBagHandler<>(bag);
	}
}
