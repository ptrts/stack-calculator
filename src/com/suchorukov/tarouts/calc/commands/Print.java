package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.CommandProcessor;

public class Print extends Command {

	{
		mnemonic = "PRINT";
	}

	@Override
    public void execute(CommandProcessor pr) {
		Double arg = pr.stack.pop();
        System.out.println(arg);
    }
}
