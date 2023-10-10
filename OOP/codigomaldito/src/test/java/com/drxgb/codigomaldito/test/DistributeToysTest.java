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
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.jupiter.api.Test;

import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.entity.Child;
import com.drxgb.codigomaldito.entity.Toy;
import com.drxgb.codigomaldito.service.BagHandler;
import com.drxgb.codigomaldito.service.InsertionBagHandler;

/**
 * Unidade de testes para distribuição dos brinquedos
 * 
 * @author Dr.XGB
 * @version 1.0.0
 */
class DistributeToysTest
{
	@Test
	void test() throws IOException
	{
		Queue<Toy> queue;
		String filename;
		String path = "D:\\Zueiras\\Programacao\\Condadinho\\CodigoMaldito2023\\Solução\\caixas\\";
		
		for (int i = 0; i < 50; ++i)
		{
			System.out.println("Test #" + (i + 1));
			System.out.println("================");
			filename = makeFilename(path, "caixa", i + 1, ".txt");
			
			try (
				InputStream input = new BufferedInputStream(new FileInputStream(filename));
				Scanner scanner = new Scanner(input);
			)
			{
				queue = makeToyBox(scanner);
				assertChildrensToys(queue);
			}
			
			System.out.println("\n***\n");
		}
		
	}
	
	
	private static String makeFilename(String path, String name, int index, String extension)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(path).append(name).append(index).append(extension);		
		return sb.toString();
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
	
	
	private static void assertChildrensToys(Queue<Toy> box)
	{
		Bag<Toy> b1 = new Bag<>(new Child("Samuel", SAPO));
		Bag<Toy> b2 = new Bag<>(new Child("Franklin", ARANHA));
		Bag<Toy> b3 = new Bag<>(new Child("Hellen", FANTASMINHA));
		Bag<Toy> b4 = new Bag<>(new Child("JC", BRUXINHA));
		Bag<Toy> b5 = new Bag<>(new Child("Daniel", DENTADURA));
		
		BagHandler<Toy> h1 = new InsertionBagHandler<>(b1);
		BagHandler<Toy> h2 = new InsertionBagHandler<>(b2);
		BagHandler<Toy> h3 = new InsertionBagHandler<>(b3);
		BagHandler<Toy> h4 = new InsertionBagHandler<>(b4);
		BagHandler<Toy> h5 = new InsertionBagHandler<>(b5);
		
		h1.setNext(h2);
		h2.setNext(h3);
		h3.setNext(h4);
		h4.setNext(h5);
		
		while (!box.isEmpty())
		{
			Toy toy = box.poll();			
			h1.handle(toy);
		}
		
		Arrays.asList(b1, b2, b3, b4, b5).forEach(DistributeToysTest::printBag);
	}
	
	
	private static void printBag(Bag<Toy> bag)
	{
		StringBuilder sb = new StringBuilder();
		Child child = (Child)bag.getOwner();
		
		sb.append(child.getName()).append(":\t").append(bag.getItems());
		System.out.println(sb);
	}
}