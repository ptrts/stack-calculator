package com.suchorukov.tarouts.calc;

import com.suchorukov.tarouts.calc.commands.*;

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

			pr.registerCommand(new Add());
			pr.registerCommand(new Define());
			pr.registerCommand(new Div());
			pr.registerCommand(new Mul());
			pr.registerCommand(new Print());
			pr.registerCommand(new Push());
			pr.registerCommand(new Sqrt());
			pr.registerCommand(new Sub());
			pr.registerCommand(new Exit());
			pr.registerCommand(new Comment());

			pr.calculate();

		} catch (Exception e){
			System.out.println(e.toString());
		}
    }
}
