package moe.wjk.ir.value;

import moe.wjk.ir.utils.Constant;
import moe.wjk.ir.utils.Type;
import moe.wjk.ir.utils.Value;

public class Str extends Constant {
    public String val;
    public static Str of(String s) {
        Str ret = new Str();
        ret.val = s;
        ret.type = Type.CSTR;
        return ret;
    }

    @Override
    public String toValueString() {
        return type.toString()+" \""+val+"\"";
    }
}
