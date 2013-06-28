package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.CommandProcessor;

public class Push extends Command {

	{
		mnemonic = "PUSH";
	}

	@Override
    public void execute(CommandProcessor pr) {
		Double arg = pr.nextParameterDouble();
		pr.stack.push(arg);
    }
}
