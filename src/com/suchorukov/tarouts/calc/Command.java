package com.suchorukov.tarouts.calc;

public abstract class Command {

	public String mnemonic = null;

	public abstract void execute(CommandProcessor pr);
}
