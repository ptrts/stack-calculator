package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.CommandProcessor;

public class Exit extends Command {

	{
		mnemonic = "EXIT";
	}

	@Override
	public void execute(CommandProcessor pr) {
		System.exit(0);
	}
}
