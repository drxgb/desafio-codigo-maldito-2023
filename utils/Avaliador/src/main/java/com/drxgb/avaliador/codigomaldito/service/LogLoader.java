package com.drxgb.avaliador.codigomaldito.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.drxgb.avaliador.codigomaldito.factory.ChildFactory;
import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.entity.Toy;

public final class LogLoader implements Loader<Scanner, List<Bag<Toy>>>
{
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private String regex;
	private Map<String, Toy> toyNames;
	
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public LogLoader(String regex)
	{
		this.regex = regex;
	}
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */

	/**
	 * @see com.drxgb.avaliador.codigomaldito.service.Loader#load(java.lang.Object)
	 */
	@Override
	public List<Bag<Toy>> load(Scanner input)
	{
		List<Bag<Toy>> bags = new ArrayList<>();
		ChildFactory factory = new ChildFactory();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		String line;
		String childName;
		String listStr;
		Toy toy;
		List<String> items;
		List<Toy> toys;
		
		while (input.hasNextLine())
		{
			line = input.nextLine();
			matcher = pattern.matcher(line);
			toys = new ArrayList<>();

			if (matcher.find())
			{
				childName = matcher.group(1);
				listStr = matcher.group(2);
				items = (listStr != null && !listStr.isEmpty())
						? Arrays.asList(listStr.split(",\\s*"))
						: Collections.emptyList();
				toy = null;

				for (String item : items)
				{
					item = item.trim();

					if (toyNames != null)
						toy = toyNames.get(item);
					if (toy == null)
						toy = Toy.valueOf(item);
					toys.add(toy);
				}
				bags.add(new Bag<>(factory.makeChild(childName), toys));
			}
		}
		
		return bags;
	}
	
	
	/*
	 * ===========================================================
	 * 			*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public Map<String, Toy> getToyNames()
	{
		return toyNames;
	}

	public void setToyNames(Map<String, Toy> toyNames)
	{
		this.toyNames = toyNames;
	}	
}
