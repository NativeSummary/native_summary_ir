package moe.wjk.ir;

import moe.wjk.ir.utils.User;
import moe.wjk.ir.utils.Value;

import java.io.Serializable;
import java.util.StringJoiner;

public abstract class Instruction extends User implements Serializable {
    public String comments;

    @Override
    public String toString() {
        var b = new StringBuilder();
        var valStr = toValueString();
        if (valStr != null && valStr.length() > 0) {
            b.append(valStr).append(" = ");
        }
        b.append(getOpString());
        var sj = new StringJoiner(", ", " ", "");
        oprands.forEach(use -> sj.add(use.value.toValueString()));
        b.append(sj.toString());
        if (comments != null) {
            b.append("     ; ").append(comments);
        }
        return b.toString();
    }

    public String getOpString() {
        return this.getClass().getName();
    }
}
