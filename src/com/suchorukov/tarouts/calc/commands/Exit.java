package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.CommandProcessor;

public class Exit extends Command {

	@Override
	public String getMnemonic() {
		return "EXIT";
	}

	@Override
	public void execute() {
		System.exit(0);
	}
}
