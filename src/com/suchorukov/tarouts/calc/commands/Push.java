package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.CommandProcessor;
import com.suchorukov.tarouts.calc.MyResource;
import com.suchorukov.tarouts.calc.ParameterSource;

public class Push extends Command {

	@MyResource(value = "PARAMETER_SOURCE")
	public ParameterSource parameterSource;

	@Override
	public String getMnemonic() {
		return "PUSH";
	}

	@Override
	public void execute() {
		Double arg = parameterSource.nextDouble();
		stack.push(arg);
	}
}
