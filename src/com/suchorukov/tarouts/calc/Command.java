package com.suchorukov.tarouts.calc;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Pavel
 * Date: 26.06.13
 * Time: 21:03
 * To change this template use File | Settings | File Templates.
 */
public abstract class Command {

	public String mnemonic = null;

    public static Double decode(Environment env, String str) {
        Double f = env.map.get(str);

        if (f == null) {
            return Double.parseDouble(str);
        } else {
            return f;
        }
    }

	public static Double nextDouble(Environment env) {
		String arg = env.scanner.next();
		return decode(env, arg);
	}

	public static String next(Environment env) {
		return env.scanner.next();
	}

    public void execute(Environment env) {

    }
}
