package com.drxgb.codigomaldito.entity;

/**
 * Representa a criança
 * 
 * @author Dr.XGB
 * @version 1.0.0
 */
public class Child implements HasBag<Toy>
{
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private String name;
	private Toy favoriteToy;
	
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public Child(String name, Toy favoriteToy)
	{
		this.name = name;
		this.favoriteToy = favoriteToy;
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */
	
	public boolean canInsert(Toy item)
	{
		return favoriteToy == item;
	}

	
	/*
	 * ===========================================================
	 * 			*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public String getName()
	{
		return name;
	}


	public Toy getFavoriteToy()
	{
		return favoriteToy;
	}


	public void setFavoriteToy(Toy favoriteToy)
	{
		this.favoriteToy = favoriteToy;
	}	
}
