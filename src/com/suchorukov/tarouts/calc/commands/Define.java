package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.CommandProcessor;

public class Define extends Command {

	{
		mnemonic = "DEFINE";
	}

	@Override
	public void execute(CommandProcessor pr) {
		String name = pr.nextParameter();
		Double value = pr.nextParameterDouble();
		pr.map.put(name, value);
	}
}
