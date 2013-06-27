package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.BinaryCommand;
import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: Pavel
 * Date: 26.06.13
 * Time: 21:05
 * To change this template use File | Settings | File Templates.
 */
public class Add extends BinaryCommand {

	public String mnemonic = "+";

	@Override
    public Double calculate(Double arg1, Double arg2) {
		return arg1 + arg2;
    }
}
