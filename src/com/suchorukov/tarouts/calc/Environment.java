package com.suchorukov.tarouts.calc;

import com.suchorukov.tarouts.calc.commands.*;

import java.io.InputStream;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Pavel
 * Date: 26.06.13
 * Time: 21:02
 * To change this template use File | Settings | File Templates.
 */
public class Environment {
    public Map<String, Double> map;
    public Scanner scanner;
	public Stack<Double> stack;

	private Map<String, Command> commands;

	public void registerCommand(Command command) {
		commands.put(command.mnemonic, command);
	}

    public Environment(InputStream in) {
        map = new HashMap<>();
        stack = new Stack();
		commands = new HashMap<>();
		this.scanner = new Scanner(in);

		registerCommand(new Add());
		registerCommand(new Define());
		registerCommand(new Div());
		registerCommand(new Mul());
		registerCommand(new Print());
		registerCommand(new Push());
		registerCommand(new Sqrt());
		registerCommand(new Sub());
    }
}
