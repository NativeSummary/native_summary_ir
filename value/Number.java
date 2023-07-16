package moe.wjk.ir.value;

import moe.wjk.ir.utils.Constant;
import moe.wjk.ir.utils.Type;
import moe.wjk.ir.utils.Value;

public class Number extends Constant {
    java.lang.Number val;
    public static Number ofLong(Long l) {
        Number v = new Number();
        v.val = l;
        v.type = Type.LONG;
        return v;
    }

    @Override
    public String toValueString() {
        return type.toString()+" "+val.toString();
    }
}
