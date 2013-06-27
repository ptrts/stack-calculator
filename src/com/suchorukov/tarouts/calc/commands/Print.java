package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: Pavel
 * Date: 26.06.13
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
public class Print extends Command {

	public String mnemonic = "PRINT";

	@Override
    public void execute(Environment env) {
        System.out.println(env.stack.pop());
    }
}
