package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.BinaryCommand;

public class Add extends BinaryCommand {

	{
		mnemonic = "+";
	}

	@Override
	public Double calculate(Double arg1, Double arg2) {
		return arg1 + arg2;
	}
}
