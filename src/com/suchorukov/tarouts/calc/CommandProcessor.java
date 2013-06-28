package com.suchorukov.tarouts.calc;

import java.io.InputStream;
import java.util.*;

public class CommandProcessor {
    public Map<String, Double> map;
    public Scanner scanner;
	public Stack<Double> stack;
	public Scanner paramScanner;

	private Map<String, Command> commands;

	public void registerCommand(Command command) {
		commands.put(command.mnemonic.toUpperCase(), command);
	}

	public void calculate() {
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			paramScanner = new Scanner(line);
			String mnemonic = paramScanner.next();
			mnemonic = mnemonic.toUpperCase();
			Command command = commands.get(mnemonic);
			command.execute(this);
		}
	}

	private Double decode(String str) {
		Double f = map.get(str);

		if (f == null) {
			return Double.parseDouble(str);
		} else {
			return f;
		}
	}

	public String nextParameter() {
		return paramScanner.next();
	}

	public Double nextParameterDouble() {
		String arg = paramScanner.next();
		return decode(arg);
	}

	public CommandProcessor(InputStream in) {
        map = new HashMap<>();
        stack = new Stack();
		commands = new HashMap<>();
		this.scanner = new Scanner(in);
    }
}
