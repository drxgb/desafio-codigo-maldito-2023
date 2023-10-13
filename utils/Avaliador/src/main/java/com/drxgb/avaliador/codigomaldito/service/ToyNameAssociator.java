package com.drxgb.avaliador.codigomaldito.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.drxgb.codigomaldito.entity.Toy;

/**
 * Responsável por associar nomes dos brinquedos ao padrão da avaliação
 * @author Dr.XGB
 * @version 1.0.0
 */
public abstract class ToyNameAssociator
{
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ESTÁTICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Lê os nomes dos brinquedos de uma entrada recebida
	 * @param scanner O leitor contendo os nomes
	 * @return Um mapa com a associação dos nomes e o brinquedo
	 */
	public static Map<String, Toy> mapToyNames(Scanner scanner)
	{
		Map<String, Toy> result = new HashMap<>();
		String line;
		String[] names;
		String name;
		Toy toy;
		
		while (scanner.hasNextLine())
		{
			line = scanner.nextLine();
			names = line.split(":");
			name = names[1].trim();
			toy = Toy.valueOf(names[0].trim());
			result.put(name, toy);
		}
		
		return result;
	}
}
