package moe.wjk.ir;

import moe.wjk.ir.utils.User;
import moe.wjk.ir.utils.Value;

import java.io.Serializable;
import java.util.StringJoiner;

public abstract class Instruction extends User implements Serializable {
    public String preComments; // 指令前一行放注释
    public String comments; // 指令行末的注释
    public String postComments; // 指令后一行注释

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        String valStr = toValueString();
        if (valStr != null && valStr.length() > 0) {
            b.append(valStr).append(" = ");
        }
        b.append(getOpString());
        StringJoiner sj = new StringJoiner(", ", " ", "");
        oprands.forEach(use -> sj.add(use.value.toValueString()));
        b.append(sj);
        if (comments != null) {
            b.append("     ; ").append(comments);
        }
        // 处理行前后注释，便于标记分析结果
        String result = b.toString();
        if (preComments != null) {
            // 开头加上 "; ", 换行替换"\n" -> "\n  ; ", 末尾加上"\n  "
            String reped = preComments.replace("\n", "\n  ; ");
            result = "; " + reped + "\n  " + result;
        }
        if (postComments != null) {
            String reped = postComments.replace("\n", "\n  ; ");
            result = result + "\n  ; " + reped;
        }
        return result;
    }

    public String getOpString() {
        return this.getClass().getName();
    }
}
