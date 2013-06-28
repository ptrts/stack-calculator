package com.suchorukov.tarouts.calc;

import java.io.InputStream;
import java.util.*;

public class Environment {
    public Map<String, Double> map;
    public Scanner scanner;
	public Stack<Double> stack;

	private Map<String, Command> commands;

	public void registerCommand(Command command) {
		commands.put(command.mnemonic.toUpperCase(), command);
	}

	public void calculate() {
		while (scanner.hasNextLine()) {
			String mnemonic = scanner.next();
			mnemonic = mnemonic.toUpperCase();
			Command command = commands.get(mnemonic);
			command.execute(this);
		}
	}

    public Environment(InputStream in) {
        map = new HashMap<>();
        stack = new Stack();
		commands = new HashMap<>();
		this.scanner = new Scanner(in);
    }
}
