package com.drxgb.codigomaldito.entity;

/**
 * Representa a criança
 * 
 * @author Dr.XGB
 * @version 1.0.0
 */
public class Child extends Person 
	implements HasBag<Toy>
{
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private Toy favoriteToy;
	
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public Child(String name, Toy favoriteToy)
	{
		super(name);
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


	public Toy getFavoriteToy()
	{
		return favoriteToy;
	}


	public void setFavoriteToy(Toy favoriteToy)
	{
		this.favoriteToy = favoriteToy;
	}	
}
