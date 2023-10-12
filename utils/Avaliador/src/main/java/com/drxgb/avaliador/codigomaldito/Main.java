package com.drxgb.avaliador.codigomaldito;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.drxgb.avaliador.codigomaldito.service.BagPrinter;
import com.drxgb.avaliador.codigomaldito.service.BoxLoader;
import com.drxgb.avaliador.codigomaldito.service.LogLoader;
import com.drxgb.avaliador.codigomaldito.service.TestValidator;
import com.drxgb.avaliador.codigomaldito.service.Timer;
import com.drxgb.avaliador.codigomaldito.service.ToyNameAssociator;
import com.drxgb.codigomaldito.Game;
import com.drxgb.codigomaldito.entity.Bag;
import com.drxgb.codigomaldito.entity.Toy;
import com.drxgb.codigomaldito.factory.InsertionBagHandlerFactory;

/**
 * Aplicação principal
 * @author Dr.XGB
 * @version 1.0.0
 */
public class Main
{
	private static PrintStream output;
	
	
	public static void main(String[] args)
			throws FileNotFoundException, IOException
	{		
		final String BOX_FILE = args[0];
		final String RESULT_LOG = args[1];
		final String TOY_ASSOC = args[2];
		final String DATA_PATTERN = args[3];
		
		Game game;
		Timer timer;
		BoxLoader boxLoader;
		LogLoader logLoader;
		BagPrinter printer;
		TestValidator validator;
		List<Bag<Toy>> actualResult;
		List<Bag<Toy>> expectedResult;
		Long initialTime;
		
		try (
			InputStream boxFile = new BufferedInputStream(new FileInputStream(new File(BOX_FILE)));
			InputStream logFile = new BufferedInputStream(new FileInputStream(new File(RESULT_LOG)));
			InputStream namesFile = new BufferedInputStream(new FileInputStream(new File(TOY_ASSOC)));
			Scanner boxScanner = new Scanner(boxFile);
			Scanner logScanner = new Scanner(logFile);
			Scanner nameScanner = new Scanner(namesFile);
		)
		{
			Locale.setDefault(Locale.US);
			
			output = System.out;
			initialTime = (args.length >= 5) ? Long.parseLong(args[4]) : null;
			timer = new Timer(initialTime);
			boxLoader = new BoxLoader();
			logLoader = new LogLoader(DATA_PATTERN);
			printer = new BagPrinter(output);
			
			game = new Game();
			game.addPlayer("Samuel", Toy.SAPO);
			game.addPlayer("Franklin", Toy.ARANHA);
			game.addPlayer("Hellen", Toy.FANTASMINHA);
			game.addPlayer("JC", Toy.BRUXINHA);
			game.addPlayer("Daniel", Toy.DENTADURA);
			game.setHandlerFactory(new InsertionBagHandlerFactory<>());
			game.setBox(boxLoader.load(boxScanner));
			game.run();
			expectedResult = game.getBags();
			
			// Resultado encontrado
			logLoader.setToyNames(ToyNameAssociator.mapToyNames(nameScanner));
			actualResult = logLoader.load(logScanner);
			printer.print(actualResult);
			
			// Escreve o resultado esperado
			printLine();
			output.println("Expectativa:");
			output.println("------------\n");
			printer.print(expectedResult);
			printLine();
			
			// Resultado final dos testes
			output.print("\nResultado:\t\t");
			validator = new TestValidator(actualResult, expectedResult);
			if (validator.pass())
				output.println("✔️ Passou");
			else
				output.println("❌ Falhou");

			output.print("Tempo decorrido:\t");
			output.print(String.format("%.3f", timer.getElapsedSeconds()));
			output.println("s\n");
			printLine();
		}
	}
	
	
	private static void printLine()
	{
		output.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	}
}
