package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.Environment;

public class Define extends Command {

	{
		mnemonic = "DEFINE";
	}

	@Override
    public void execute(Environment env) {
		String name = next(env);
		Double value = nextDouble(env);
        env.map.put(name, value);
    }
}
