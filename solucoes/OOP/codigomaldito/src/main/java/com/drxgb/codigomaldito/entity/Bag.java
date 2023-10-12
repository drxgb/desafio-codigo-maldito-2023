package com.drxgb.codigomaldito.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a bolsa de uma criança
 * 
 * @param <T> O conteúdo da bolsa
 * @author Dr.XGB
 * @version 1.0.0
 */
public class Bag<T>
{
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private List<T> items;
	
	
	/*
	 * ===========================================================
	 * 			*** ASSOCIAÇÕES ***
	 * ===========================================================
	 */
	
	private Person owner;
	
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public Bag(Person owner, List<T> items)
	{
		this.owner = owner;
		this.items = items;
	}


	public Bag(Person owner)
	{
		this(owner, new ArrayList<>());
	}	
	
	
	/*
	 * ===========================================================
	 * 			*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public Person getOwner()
	{
		return owner;
	}


	public void setOwner(Person owner)
	{
		this.owner = owner;
	}


	public List<T> getItems()
	{
		return items;
	}
}
