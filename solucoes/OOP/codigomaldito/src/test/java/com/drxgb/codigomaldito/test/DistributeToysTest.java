/**
 * 
 */
package com.drxgb.codigomaldito.test;

import static com.drxgb.codigomaldito.entity.Toy.ARANHA;
import static com.drxgb.codigomaldito.entity.Toy.BRUXINHA;
import static com.drxgb.codigomaldito.entity.Toy.DENTADURA;
import static com.drxgb.codigomaldito.entity.Toy.FANTASMINHA;
import static com.drxgb.codigomaldito.entity.Toy.SAPO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.jupiter.api.Test;

import com.drxgb.codigomaldito.Game;
import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.entity.Toy;
import com.drxgb.codigomaldito.factory.InsertionBagHandlerFactory;

/**
 * Unidade de testes para distribuição dos brinquedos
 * 
 * @author Dr.XGB
 * @version 1.0.0
 */
class DistributeToysTest
{
	@Test
	void test()
			throws IOException, RuntimeException
	{
		String filename = "D:\\Zueiras\\Programacao\\Condadinho\\CodigoMaldito2023\\Solução\\caixas\\caixa15.txt";
		Game game;
		
		try (
			InputStream input = new BufferedInputStream(new FileInputStream(filename));
			Scanner scanner = new Scanner(input);
		)
		{
			game = new Game();
			game.addPlayer("Samuel", SAPO);
			game.addPlayer("Franklin", ARANHA);
			game.addPlayer("Hellen", FANTASMINHA);
			game.addPlayer("JC", BRUXINHA);
			game.addPlayer("Daniel", DENTADURA);
			game.setHandlerFactory(new InsertionBagHandlerFactory<>());
			game.setBox(makeToyBox(scanner));
			game.run();
			game.getBags().forEach(DistributeToysTest::printBag);
		}		
	}
	
	
	private static Queue<Toy> makeToyBox(Scanner scanner)
	{
		Queue<Toy> queue = new LinkedBlockingQueue<Toy>();
		String item;
		Toy toy;
		
		while (scanner.hasNext())
		{
			item = scanner.nextLine();
			toy = Toy.valueOf(item);
			queue.offer(toy);
		}
		
		return queue;
	}
	
	
	private static void printBag(Bag<Toy> bag)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(bag.getOwner().getName()).append(":\n\t").append(bag.getItems());
		System.out.println(sb);
	}
}