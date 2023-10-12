package com.drxgb.codigomaldito;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.entity.Child;
import com.drxgb.codigomaldito.entity.Toy;
import com.drxgb.codigomaldito.factory.BagHandlerFactory;
import com.drxgb.codigomaldito.service.BagHandler;

/**
 * Fachada responsável por executar a brincadeira
 * @author Dr.XGB
 * @version 1.0.0
 */
public class Game implements Runnable
{
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private List<Bag<Toy>> bags;
	private Queue<Toy> box;
	private BagHandlerFactory<Toy> handlerFactory;
	
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public Game()
	{
		bags = new ArrayList<>();
	}


	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Cria o jogador que entrará para a fila
	 * @param name Nome do jogador
	 * @param favoriteToy Brinquedo favorito do jogador
	 */
	public void addPlayer(String name, Toy favoriteToy)
	{
		Bag<Toy> bag = new Bag<>(new Child(name, favoriteToy));
		bags.add(bag);
	}
		
	
	/**
	 * Executa a brincadeira
	 */
	@Override
	public void run()
	{
		if (box == null)
			throw new RuntimeException("A caixa é nula");
		if (handlerFactory == null)
			throw new RuntimeException("O gerador de bolsas não foi definido");
		if (bags.isEmpty())
			throw new RuntimeException("Não há jogadores nesta brincadeira");
		
		BagHandler<Toy> handler = initHandlers();

		while (!box.isEmpty())
		{
			Toy toy = box.poll();			
			handler.handle(toy);
		}
	}
	
	
	/*
	 * ===========================================================
	 * 			*** GETTERS E SETTERS ***
	 * ===========================================================
	 */
	
	public List<Bag<Toy>> getBags()
	{
		return bags;
	}
	
	
	public void setBox(Queue<Toy> box)
	{
		this.box = box;
	}
	
	
	public BagHandlerFactory<Toy> getHandlerFactory()
	{
		return handlerFactory;
	}


	public void setHandlerFactory(BagHandlerFactory<Toy> handlerFactory)
	{
		this.handlerFactory = handlerFactory;
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PRIVADOS ***
	 * ===========================================================
	 */

	/**
	 * Inicializa os tratadores das bolsas responsáveis pela distribuição
	 * dos objetos
	 */
	private BagHandler<Toy> initHandlers()
	{		
		BagHandler<Toy> head;
		BagHandler<Toy> prev;
		BagHandler<Toy> next;
		
		head = null;
		prev = null;
		next = null;
		
		for (Bag<Toy> bag : bags)
		{
			prev = next;
			next = handlerFactory.makeHandler(bag);

			if (prev == null)
				head = next;
			else
				prev.setNext(next);
		}
		
		return head;
	}
}
