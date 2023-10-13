package com.drxgb.avaliador.codigomaldito.service;

import java.io.PrintStream;
import java.util.List;

import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.entity.Toy;

/**
 * Imprime uma lista no dispositivo de saída
 */
public class BagPrinter implements Printable<List<Bag<Toy>>>
{
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private PrintStream writer;
	
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */

	public BagPrinter(PrintStream writer)
	{
		this.writer = writer;
	}

	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */
	
	/**
	 * @see com.drxgb.avaliador.codigomaldito.service.Printable#print(java.lang.Object)
	 */
	@Override
	public void print(List<Bag<Toy>> bags)
	{
		for (Bag<Toy> bag : bags)
		{
			writer.print(bag.getOwner().getName());
			writer.println(':');
			writer.print("\t");
			writer.println(bag.getItems());
		}
	}
}
