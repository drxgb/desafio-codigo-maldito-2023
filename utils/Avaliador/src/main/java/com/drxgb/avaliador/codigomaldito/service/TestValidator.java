package com.drxgb.avaliador.codigomaldito.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.entity.Toy;

/**
 * Responsável por validar o teste entre duas listas de bolsas
 */
public class TestValidator
{
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */

	private Map<String, List<Toy>> actual;
	private Map<String, List<Toy>> expected;
	
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */

	public TestValidator(List<Bag<Toy>> actual, List<Bag<Toy>> expected)
	{		
		this.actual = new HashMap<>();
		this.expected = new HashMap<>();
		mapToys(actual, expected);
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Verifica se o teste foi validado
	 * @return O resultado da validação
	 */
	public boolean pass()
	{
		List<Toy> expectedItems;
		List<Toy> actualItems;
		
		for (String key : expected.keySet())
		{
			expectedItems = expected.get(key);
			actualItems = actual.get(key);
			
			if (!actualItems.equals(expectedItems))
				return false;
		}
		
		return true;
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PRIVADOS ***
	 * ===========================================================
	 */
	
	private void mapToys(List<Bag<Toy>> actual, List<Bag<Toy>> expected)
	{
		List<Toy> actualItems;
		List<Toy> expectedItems;
		List<Toy> emptyList;
		Optional<Bag<Toy>> optional;
		
		emptyList = Collections.emptyList();
		
		for (Bag<Toy> expectedBag : expected)
		{
			final String name = expectedBag.getOwner().getName();

			expectedItems = expectedBag.getItems();
			optional = actual.stream()
					.filter(bag -> bag.getOwner().getName().equals(name))
					.findFirst();
			
			if (optional.isPresent())
				actualItems = optional.get().getItems();
			else
				actualItems = emptyList;				
			
			this.expected.put(name, expectedItems);
			this.actual.put(name, actualItems);
		}
	}
}
