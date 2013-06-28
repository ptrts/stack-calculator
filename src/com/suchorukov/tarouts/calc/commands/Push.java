package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.Environment;

public class Push extends Command {

	{
		mnemonic = "PUSH";
	}

	@Override
    public void execute(Environment env) {
		Double arg = nextDouble(env);
		env.stack.push(arg);
    }
}
