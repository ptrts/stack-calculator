package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.CommandProcessor;

public class Sqrt extends Command {

	{
		mnemonic = "SQRT";
	}

	@Override
	public void execute(CommandProcessor pr) {
		Double arg = pr.stack.pop();
		Double result = Math.sqrt(arg);
		pr.stack.push(result);
	}
}
