package com.drxgb.client.codigomaldito;

import static com.drxgb.codigomaldito.entity.Toy.ARANHA;
import static com.drxgb.codigomaldito.entity.Toy.BRUXINHA;
import static com.drxgb.codigomaldito.entity.Toy.DENTADURA;
import static com.drxgb.codigomaldito.entity.Toy.FANTASMINHA;
import static com.drxgb.codigomaldito.entity.Toy.SAPO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

import com.drxgb.codigomaldito.Game;
import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.entity.Toy;
import com.drxgb.codigomaldito.factory.InsertionBagHandlerFactory;

public class Main
{
	public static void main(String[] args)
			throws FileNotFoundException, IOException
	{
		String filename = args[0];
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
				game.getBags().forEach(Main::printBag);
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
		
		sb.append(bag.getOwner().getName()).append(": ").append(bag.getItems());
		System.out.println(sb);
	}
}
