package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.CommandProcessor;
import com.suchorukov.tarouts.calc.MyResource;
import com.suchorukov.tarouts.calc.ParameterSource;

import java.util.HashMap;

public class Define extends Command {

	@MyResource(value = "PARAMETER_SOURCE")
	public ParameterSource parameterSource;

	@MyResource(value = "VARIABLES")
	public HashMap<String, Double> variables;

	@Override
	public String getMnemonic() {
		return "DEFINE";
	}

	@Override
	public void execute() {
		String name = parameterSource.nextString();
		Double value = parameterSource.nextDouble();
		variables.put(name, value);
	}
}
