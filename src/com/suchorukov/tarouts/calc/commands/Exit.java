package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.Environment;

public class Exit extends Command {

	{
		mnemonic = "EXIT";
	}

	@Override
	public void execute(Environment env) {
		System.exit(0);
	}
}
