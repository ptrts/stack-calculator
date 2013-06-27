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

    public static Float decode(Environment env, String str) {
        Float f = env.map.get(str);

        if (f == null) {
            return Float.parseFloat(str);
        } else {
            return f;
        }
    }

    public void execute(Environment env) {

    }
    public void execute(Environment env, String arg1) {

    }
    public void execute(Environment env, String arg1, String arg2) {

    }

    public void getParameters() {

    }
}
