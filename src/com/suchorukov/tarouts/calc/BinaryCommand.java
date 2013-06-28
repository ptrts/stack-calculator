package com.suchorukov.tarouts.calc;

public abstract class BinaryCommand extends Command {

	protected abstract Double calculate(Double arg1, Double arg2);

	@Override
	public void execute(CommandProcessor pr) {
		Double arg2 = pr.stack.pop();
		Double arg1 = pr.stack.pop();
		Double result = calculate(arg1, arg2);
		pr.stack.push(result);
	}
}
