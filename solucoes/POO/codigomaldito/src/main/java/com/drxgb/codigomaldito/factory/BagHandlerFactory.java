package com.drxgb.codigomaldito.factory;

import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.service.BagHandler;

/**
 * Responsável por gerar o método de tratamento de bolsas
 * @param <T> O tipo de conteúdo que seráp ortado na bolsa
 * @author Dr.XGB
 * @version 1.0.0
 */
public interface BagHandlerFactory<T>
{
	/**
	 * Cria o tratador de bolsas
	 * @param bag A bolsa a ser inserida no tratador
	 * @return O tratador de bolsas
	 */
	BagHandler<T> makeHandler(Bag<T> bag);
}
