package com.suchorukov.tarouts.calc.commands;

import com.suchorukov.tarouts.calc.Command;
import com.suchorukov.tarouts.calc.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: Pavel
 * Date: 26.06.13
 * Time: 21:31
 * To change this template use File | Settings | File Templates.
 */
public class Push extends Command {
    @Override
    public void execute(Environment env, String arg1) {
        env.stack.add(decode(env, arg1));
    }
}
