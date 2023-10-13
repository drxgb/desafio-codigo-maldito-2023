package com.drxgb.avaliador.codigomaldito.factory;

import com.drxgb.codigomaldito.entity.Child;
import com.drxgb.codigomaldito.entity.Toy;

/**
 * Cria uma criança associando o nomes ao seu brinquedo favorito
 * @author Dr.XGB
 * @version 1.0.0
 */
public class ChildFactory
{
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */

	/**
	 * Cria uma criança de acordo com o seu nome
	 * @param name O nome da criança
	 * @return Uma nova criança
	 */
	public Child makeChild(String name)
	{
		Toy favoriteToy;
		
		switch (name)
		{
		case "Samuel":		favoriteToy = Toy.SAPO;			break;
		case "Franklin":	favoriteToy = Toy.ARANHA;		break;
		case "Hellen":		favoriteToy = Toy.FANTASMINHA;	break;
		case "JC":			favoriteToy = Toy.BRUXINHA;		break;
		case "Daniel":		favoriteToy = Toy.DENTADURA;	break;
		default:
			return null;
		}
		
		return new Child(name, favoriteToy);
	}
}
