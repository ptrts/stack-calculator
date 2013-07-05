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

	private Scanner streamScanner;
	private Scanner lineScanner;
	private Map<String, Command> commands;

	private ParameterSource parameterSource = new ParameterSource() {

		private Double decode(String str) {
			Double f = variables.get(str);

			if (f == null) {
				return Double.parseDouble(str);
			} else {
				return f;
			}
		}

		@Override
		public String nextString() {
			return lineScanner.next();
		}

		@Override
		public Double nextDouble() {
			String arg = lineScanner.next();
			return decode(arg);
		}
	};

	private static Command createCommandInstanceByClassName(String className) throws ReflectiveOperationException {
		Class<?> commandClass = Class.forName(className);
		Constructor<?> commandClassConstructor = commandClass.getConstructor();
		Command command = (Command) commandClassConstructor.newInstance();
		return command;
	}

	private void registerCommand(Command command) throws IllegalAccessException {

		Class commandClass = command.getClass();
		Field[] fields = commandClass.getFields();

		for (Field field : fields) {
			MyResource annotation = field.getAnnotation(MyResource.class);
			if (annotation != null) {
				field.setAccessible(true);

				String value = annotation.value();

				switch (value) {
					case "STACK":
						field.set(command, stack);
						break;
					case "VARIABLES":
						field.set(command, variables);
						break;
					case "PARAMETER_SOURCE":
						field.set(command, parameterSource);
						break;
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
		while (streamScanner.hasNextLine()) {
			String line = streamScanner.nextLine();

			lineScanner = new Scanner(line);
			String mnemonic = lineScanner.next();
			mnemonic = mnemonic.toUpperCase();
			Command command = commands.get(mnemonic);
			command.execute();
		}
	}

	public CommandProcessor(InputStream in) {
		variables = new HashMap<>();
		stack = new Stack<>();
		commands = new HashMap<>();
		this.streamScanner = new Scanner(in);
	}
}
