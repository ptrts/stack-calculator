package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.Environment;

public class Sqrt extends Command {

	{
		mnemonic = "SQRT";
	}

	@Override
	public void execute(Environment env) {
		Double arg = env.stack.pop();
		Double result = Math.sqrt(arg);
		env.stack.push(result);
	}
}
