package moe.wjk.ir.value;

import moe.wjk.ir.utils.Type;
import moe.wjk.ir.utils.Value;

public class Param extends Value {
    public Param(String n, Type t) {
        name = n;
        type = t;
    }

    @Override
    public String toString() {
        return type.toString() + " " + name;
    }
}
