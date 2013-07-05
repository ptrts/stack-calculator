package com.suchorukov.tarouts.calc;

public abstract class BinaryCommand extends Command {

	protected abstract Double calculate(Double arg1, Double arg2);

	@Override
	public void execute() {
		Double arg2 = stack.pop();
		Double arg1 = stack.pop();
		Double result = calculate(arg1, arg2);
		stack.push(result);
	}
}
