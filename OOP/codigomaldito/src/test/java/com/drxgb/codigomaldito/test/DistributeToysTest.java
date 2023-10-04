/**
 * 
 */
package com.drxgb.codigomaldito.test;

import static com.drxgb.codigomaldito.entity.Toy.ARANHA;
import static com.drxgb.codigomaldito.entity.Toy.BRUXINHA;
import static com.drxgb.codigomaldito.entity.Toy.DENTADURA;
import static com.drxgb.codigomaldito.entity.Toy.FANTASMINHA;
import static com.drxgb.codigomaldito.entity.Toy.SAPO;

import java.util.Queue;
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
	void test()
	{
		Queue<Toy> queue = new LinkedBlockingQueue<Toy>();
		
		queue.add(DENTADURA);
		queue.add(ARANHA);
		queue.add(ARANHA);
		queue.add(SAPO);
		queue.add(FANTASMINHA);
		queue.add(BRUXINHA);
		queue.add(SAPO);
		queue.add(BRUXINHA);
		queue.add(FANTASMINHA);
		queue.add(DENTADURA);
		queue.add(SAPO);
		
		assertChildrensToys(queue);
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
		
		System.out.println(b1.getItems());
		System.out.println(b2.getItems());
		System.out.println(b3.getItems());
		System.out.println(b4.getItems());
		System.out.println(b5.getItems());
	}
}