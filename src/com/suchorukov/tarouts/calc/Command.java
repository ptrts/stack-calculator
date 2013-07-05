package com.suchorukov.tarouts.calc;

import java.util.Stack;

public abstract class Command {
	@MyResource(value = "STACK")
	public Stack<Double> stack;

	public abstract String getMnemonic();

	public abstract void execute();
}
