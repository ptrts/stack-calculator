package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.CommandProcessor;

public class Print extends Command {

	@Override
	public String getMnemonic() {
		return "PRINT";
	}

	@Override
	public void execute() {
		Double arg = stack.pop();
		System.out.println(arg);
	}
}
