package com.suchorukov.tarouts.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class CommandProcessor {
	public Map<String, Double> variables;
	public Stack<Double> stack;

	private Scanner scanner;
	private Scanner paramScanner;
	private Map<String, Command> commands;

	public static Command createCommandInstanceByClassName(String className) throws ReflectiveOperationException {
		Class<?> commandClass = Class.forName(className);
		Constructor<?> commandClassConstructor = commandClass.getConstructor();
		Command command = (Command) commandClassConstructor.newInstance();
		return command;
	}

	public void registerCommand(Command command) throws IllegalAccessException {

		Class commandClass = command.getClass();
		Field[] fields = commandClass.getFields();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			MyResource annotation = field.getAnnotation(MyResource.class);
			if (annotation != null) {
				String value = annotation.value();
				if ("STACK".equals(value)) {
					field.setAccessible(true);
					field.set(command, stack);
				}
			}
		}

		commands.put(command.getMnemonic().toUpperCase(), command);
	}

	public void loadCommands(URL resource) throws IOException, ReflectiveOperationException {
		InputStream inStream = resource.openStream();
		InputStreamReader inStreamReader = new InputStreamReader(inStream, "UTF-8");
		BufferedReader br = new BufferedReader(inStreamReader);

		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			Scanner scanner = new Scanner(line);
			String className = scanner.next();
			Command command = createCommandInstanceByClassName(className);

			registerCommand(command);
		}
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
		Double f = variables.get(str);

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
		variables = new HashMap<>();
		stack = new Stack();
		commands = new HashMap<>();
		this.scanner = new Scanner(in);
	}
}
