package com.drxgb.avaliador.codigomaldito.test;

import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.drxgb.avaliador.codigomaldito.service.BagPrinter;
import com.drxgb.avaliador.codigomaldito.service.LogLoader;
import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.entity.Child;
import com.drxgb.codigomaldito.entity.Toy;

/**
 * Realiza testes com a entrada do relatório, capturando os dados importantes
 * @author Dr.XGB
 * @version 1.0.0
 */
class LogRegexTest
{
	@Test
	void test() throws FileNotFoundException, IOException
	{
		String path = "D:\\Zueiras\\Programacao\\Condadinho\\CodigoMaldito2023\\Participantes\\Samuel\\resultados\\resultado1.log";
		String regex = "^([A-Za-z]+): ([A-Za-z]+,?)?";
		LogLoader loader = new LogLoader(regex);
		BagPrinter printer = new BagPrinter(System.out);
		Map<String, Toy> toyNames = new HashMap<>();
		List<Bag<Toy>> bags;
		
		try
		(
			InputStream file = new BufferedInputStream(new FileInputStream(new File(path)));
			Scanner scanner = new Scanner(file);
		)
		{
			toyNames.put("Aranha", Toy.ARANHA);
			toyNames.put("Sapo", Toy.SAPO);
			toyNames.put("Dentadura", Toy.DENTADURA);
			toyNames.put("Fantasma", Toy.FANTASMINHA);
			toyNames.put("Bruxinha", Toy.BRUXINHA);
			loader.setToyNames(toyNames);
			
			bags = loader.load(scanner);
			printer.print(bags);
			
			for (Bag<Toy> bag : bags)
			{
				Child child = (Child)bag.getOwner();
				assertTrue(
						bag.getItems()
							.stream()
							.allMatch(t -> t.equals(child.getFavoriteToy()))
				);
			}
		}
	}
}
