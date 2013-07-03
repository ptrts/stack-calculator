package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.CommandProcessor;

public class Sqrt extends Command {

	@Override
	public String getMnemonic() {
		return "SQRT";
	}

	@Override
	public void execute(CommandProcessor pr) {
		Double arg = stack.pop();
		Double result = Math.sqrt(arg);
		stack.push(result);
	}
}
