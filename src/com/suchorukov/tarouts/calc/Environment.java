package com.suchorukov.tarouts.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Pavel
 * Date: 26.06.13
 * Time: 21:02
 * To change this template use File | Settings | File Templates.
 */
public class Environment {
    public Map<String, Float> map;
    public List<Float> stack;
    public Environment() {
        map = new HashMap<>();
        stack = new ArrayList<>();
    }
}
