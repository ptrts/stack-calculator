package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: Pavel
 * Date: 26.06.13
 * Time: 21:05
 * To change this template use File | Settings | File Templates.
 */
public class Add extends Command {

	public String mnemonic = "ADD";

	@Override
    public void execute(Environment env) {
		env.stack.push(env.stack.pop() + env.stack.pop());
    }
}
