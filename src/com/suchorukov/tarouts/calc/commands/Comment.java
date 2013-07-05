package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.CommandProcessor;

public class Comment extends Command {

	@Override
	public String getMnemonic() {
		return "#";
	}

	@Override
	public void execute() {
	}
}
