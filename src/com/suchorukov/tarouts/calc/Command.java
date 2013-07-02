package com.suchorukov.tarouts.calc;

public abstract class Command {
	public abstract String getMnemonic();
	public abstract void execute(CommandProcessor pr);
}
