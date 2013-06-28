package com.suchorukov.tarouts.calc;

import com.suchorukov.tarouts.calc.commands.*;

import java.io.FileInputStream;

public class Calc {

    public static void main(String[] args) {
		Environment env;

		try {

			if (args.length == 0) {
				env = new Environment(System.in);
			} else {
				env = new Environment(new FileInputStream(args[0]));
			}

			env.registerCommand(new Add());
			env.registerCommand(new Define());
			env.registerCommand(new Div());
			env.registerCommand(new Mul());
			env.registerCommand(new Print());
			env.registerCommand(new Push());
			env.registerCommand(new Sqrt());
			env.registerCommand(new Sub());
			env.registerCommand(new Exit());
			env.registerCommand(new Comment());

			env.calculate();

		} catch (Exception e){
			System.out.println(e.toString());
		}
    }
}
