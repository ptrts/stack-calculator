package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: Pavel
 * Date: 26.06.13
 * Time: 21:07
 * To change this template use File | Settings | File Templates.
 */
public class Define extends Command {

	public String mnemonic = "DEFINE";

	@Override
    public void execute(Environment env) {
        env.map.put(next(env), nextDouble(env));
    }
}
