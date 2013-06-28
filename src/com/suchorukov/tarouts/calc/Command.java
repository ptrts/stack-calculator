package com.suchorukov.tarouts.calc;

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

    public abstract void execute(Environment env);
}
