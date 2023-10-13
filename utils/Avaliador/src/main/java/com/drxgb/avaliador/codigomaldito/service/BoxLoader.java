package com.drxgb.avaliador.codigomaldito.service;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

import com.drxgb.codigomaldito.entity.Toy;


/**
 * Responsável por carregar caixa
 * @author Dr.XGB
 * @version 1.0.0
 */
public final class BoxLoader implements Loader<Scanner, Queue<Toy>>
{
	/*
	 * ===========================================================
	 * 			*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */

	/**
	 * @see com.drxgb.avaliador.codigomaldito.service.Loader#load(java.lang.Object)
	 */
	@Override
	public Queue<Toy> load(Scanner input)
	{
		Queue<Toy> box = new LinkedBlockingQueue<>();
		List<String> toys = Arrays.asList(Toy.values()).stream().map(t -> t.toString()).toList();
		String name;
		
		while (input.hasNextLine())
		{
			name = input.nextLine();
			if (toys.contains(name))
				box.offer(Toy.valueOf(name));
		}		
		
		return box;
	}
}
