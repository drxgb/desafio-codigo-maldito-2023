package com.drxgb.codigomaldito.entity;


/**
 * Representa uma pessoa
 * @author Dr.XGB
 * @version 1.0.0
 */
public abstract class Person
{
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private String name;

	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */

	public Person(String name)
	{
		this.name = name;
	}

	
	/*
	 * ===========================================================
	 * 			*** GETTERS ***
	 * ===========================================================
	 */

	public String getName()
	{
		return name;
	}	
}
