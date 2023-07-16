package moe.wjk.ir.value;

import moe.wjk.ir.utils.Constant;
import moe.wjk.ir.utils.Value;

public class Null extends Constant {
    public static Null instance = new Null();

    @Override
    public String toValueString() {
        return "null";
    }
}
