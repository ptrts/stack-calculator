package com.suchorukov.tarouts.calc;

public abstract class BinaryCommand extends Command {

	protected abstract Double calculate(Double arg1, Double arg2);

	@Override
	public void execute(Environment env) {
		Double arg1 = env.stack.pop();
		Double arg2 = env.stack.pop();
		Double result = calculate(arg1, arg2);
		env.stack.push(result);
	}
}
