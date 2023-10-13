package com.drxgb.avaliador.codigomaldito.service;


/**
 * Responsável por cronometrar alguma situação
 * @author Dr.XGB
 * @version 1.0.0
 */
public class Timer
{
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private Long begin;
	private long javaBegin;

	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */

	public Timer(Long begin)
	{		
		this.begin = begin;
		this.javaBegin = System.nanoTime();
	}
	
	
	public Timer()
	{
		this(null);
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Recebe a quantidade de milisegundos decorrida
	 * @return Milisegundos decorridos
	 */
	public long getElapsedTime()
	{
		long javaElapsed = System.nanoTime() - javaBegin;
		long total = javaElapsed;
		
		if (begin != null)
			total += begin;
		return total;
	}
	
	
	/**
	 * Recebe a quantidade decorrida em segundos
	 * @return Segundos decorridos
	 */
	public double getElapsedSeconds()
	{
		return (double)getElapsedTime() / 1000000000.0;
	}
}
