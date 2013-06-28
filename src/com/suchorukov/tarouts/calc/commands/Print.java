package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.Environment;

public class Print extends Command {

	{
		mnemonic = "PRINT";
	}

	@Override
    public void execute(Environment env) {
		Double arg = env.stack.pop();
        System.out.println(arg);
    }
}
