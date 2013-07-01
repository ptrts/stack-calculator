package com.suchorukov.tarouts.calc;

import java.io.FileInputStream;

public class Calc {

	public static void main(String[] args) {
		CommandProcessor pr;

		try {

			if (args.length == 0) {
				pr = new CommandProcessor(System.in);
			} else {
				pr = new CommandProcessor(new FileInputStream(args[0]));
			}

			pr.loadCommands(Calc.class.getResource("commands.txt"));

			pr.calculate();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
