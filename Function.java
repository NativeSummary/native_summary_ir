package moe.wjk.ir;

import moe.wjk.ir.utils.Type;
import moe.wjk.ir.value.Param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Function implements Serializable {
    public String clazz;
    public String name;
    public String signature;
    // TODO basicblock and control flow
    // null for declaration
    public List<Instruction> insts = new ArrayList<>();
    // parsed from signature
    public List<Param> params = new ArrayList<>();
    public Type returnType;

    @Override
    public String toString() {
        String declare = insts != null ? "define" : "declare";
        String processedClazz;
        if (clazz.charAt(0) == 'L') {
            processedClazz = clazz.substring(1, clazz.length()-1);
            processedClazz = processedClazz.replace('/', '.');
        } else {
            processedClazz = clazz;
        }

        StringBuilder sb = new StringBuilder(String.format("%s %s @%s.%s", declare, returnType, processedClazz, name));
        StringJoiner sj = new StringJoiner(", ", "(", ")");
        for (Param p: params) {
            sj.add(p.toString());
        }
        sb.append(sj.toString()).append("{\n");
        for (Instruction i: insts) {
            sb.append("  ").append(i.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
