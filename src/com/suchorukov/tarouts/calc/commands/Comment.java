package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.Environment;

public class Comment extends Command {

	{
		mnemonic = "#";
	}

	@Override
	public void execute(Environment env) {
		// Нужно прочитать строчку до конца
	}
}
